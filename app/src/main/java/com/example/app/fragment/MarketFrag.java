package com.example.app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.marketDataApi.SecurityAdapter;
import com.example.app.marketDataApi.SecurityData;
import com.example.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



   /* public MarketFrag() {
        // Required empty public constructor
    }*/


    public class MarketFrag extends Fragment {

        private List<SecurityData> securityList;
        private RecyclerView recyclerView;
        private SecurityAdapter adapter;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_market, container, false);
            recyclerView = rootView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            securityList = new ArrayList<>();
            adapter = new SecurityAdapter(securityList);
            recyclerView.setAdapter(adapter);

             // Fetch data using Volley
                fetchDataFromAPI();
            return rootView;
        }

        private void fetchDataFromAPI() {
            // Use Volley to fetch JSON data from the API
            // Replace 'YOUR_API_URL' with the actual API endpoint URL
            String url = "http://127.0.0.1:5000/securityDailyTradeStat/58";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    try {
                        for (int i=0; i < response.length(); i++){
                            JSONObject jsonObject=response.getJSONObject(0);
                            String securityName=jsonObject.getString("securityName");
                            String lastTradedPrice=jsonObject.getString("lastTradedPrice");

                            SecurityData securityData=new SecurityData();
                            securityData.setSecurityName(securityName);
                            securityData.setLastTradedPrice(lastTradedPrice);

                            securityList.add(securityData);

                        }
                        adapter.notifyDataSetChanged();

                        Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();

                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });


                        // Add the request to the Volley request queue
                        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonArrayRequest);
            }


        }





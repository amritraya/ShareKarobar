package com.example.app.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app.Buy_Sell.BuyActivity;
import com.example.app.Buy_Sell.SellActivity;
import com.example.app.Database.StockTransaction;
import com.example.app.Database.StockTransactionHelper;
import com.example.app.R;

import java.util.Collections;
import java.util.List;


public class HomeFrag extends Fragment {
private RecyclerView recyclerView;
private TransactionAdapter adapter;
private List<StockTransaction> transactionList;
private StockTransactionHelper stockTransactionHelper;

    public HomeFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_home, container, false);

        //Database displaying in recycler of homeFragment
        recyclerView= rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        stockTransactionHelper= new StockTransactionHelper(getActivity());
        transactionList= stockTransactionHelper.getAllStockTransactions();
        Collections.reverse(transactionList);
        adapter=new TransactionAdapter(transactionList);
        recyclerView.setAdapter(adapter);

        //buy and sell button initialized
        Button buyButton=rootView.findViewById(R.id.buyButton);
        Button sellButton=rootView.findViewById(R.id.sellButton);

        buyButton.setOnClickListener(view -> openBuyActivity());
        sellButton.setOnClickListener(view -> openSellActivity());

        return rootView;
    }

    //BUY Transaction adding
    private void openBuyActivity(){
        Intent openBuy=new Intent(getActivity(), BuyActivity.class);
        startActivity(openBuy);
    }

    //SELL Transaction adding
    private void openSellActivity(){

        Intent openSell=new Intent(getActivity(), SellActivity.class);
        startActivity(openSell);
    }

}

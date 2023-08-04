package com.example.app.marketDataApi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;

import java.util.List;

public class SecurityAdapter extends RecyclerView.Adapter<SecurityAdapter.SecurityViewHolder> {

    private List<SecurityData> securityList;

    public SecurityAdapter(List<SecurityData> securityList) {
        this.securityList = securityList;
    }

    @NonNull
    @Override
    public SecurityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_security, parent, false);
        return new SecurityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecurityViewHolder holder, int position) {
        SecurityData securityData = securityList.get(position);
        holder.securityNameTextView.setText(securityData.getSecurityName());
        holder.lastTradedPriceTextView.setText(securityData.getLastTradedPrice());
    }

    @Override
    public int getItemCount() {
        return securityList.size();
    }

    public static class SecurityViewHolder extends RecyclerView.ViewHolder {
        TextView securityNameTextView;
        TextView lastTradedPriceTextView;

        public SecurityViewHolder(@NonNull View itemView) {
            super(itemView);
            securityNameTextView = itemView.findViewById(R.id.securityNameTextView);
            lastTradedPriceTextView = itemView.findViewById(R.id.lastTradedPriceTextView);
        }
    }
}

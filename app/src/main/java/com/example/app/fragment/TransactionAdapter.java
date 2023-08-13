package com.example.app.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Database.StockTransaction;
import com.example.app.R;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private List<StockTransaction> transactionList;

    public TransactionAdapter(List<StockTransaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockTransaction transaction = transactionList.get(position);

        holder.securityNameTextView.setText(transaction.getSecurityName());
        holder.quantityTextView.setText(String.valueOf(transaction.getQuantity()));
        holder.priceTextView.setText(String.valueOf(transaction.getPrice()));
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView securityNameTextView, quantityTextView, priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            securityNameTextView = itemView.findViewById(R.id.securityNameTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
        }
    }
}

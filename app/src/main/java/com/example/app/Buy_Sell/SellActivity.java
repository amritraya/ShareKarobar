package com.example.app.Buy_Sell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.Database.StockTransaction;
import com.example.app.Database.StockTransactionHelper;
import com.example.app.R;

public class SellActivity extends AppCompatActivity {
    private EditText securityNameEditText, quantityEditText, priceEditText;
    private Button addTransactionButton;
    private StockTransactionHelper stockTransactionHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        securityNameEditText=findViewById(R.id.securityNameEditText);
        quantityEditText=findViewById(R.id.quantityEditText);
        priceEditText=findViewById(R.id.priceEditText);
        addTransactionButton=findViewById(R.id.addTransactionButton);

        stockTransactionHelper= new StockTransactionHelper(this);

        addTransactionButton.setOnClickListener(v -> addTransactionToDatabase());
    }

    private void addTransactionToDatabase() {
        String securityName= securityNameEditText.getText().toString().trim();
        int quantity= Integer.parseInt(quantityEditText.getText().toString().trim());
        double price= Double.parseDouble(priceEditText.getText().toString().trim());

        //Create new StockTransaction object with the entered data
        StockTransaction transaction= new StockTransaction();
        transaction.setType("sell");
        transaction.setSecurityName(securityName);
        transaction.setQuantity(quantity);
        transaction.setPrice(price);
        
        //Add the transaction to the Database using the StockTransactionHelper
        long transactionId= stockTransactionHelper.addStockTransaction(transaction);
        if (transactionId != -1){
            Toast.makeText(this, "Transaction added Successfully", Toast.LENGTH_SHORT).show();
        }
            else{
            Toast.makeText(this, "Failed to add transaction", Toast.LENGTH_SHORT).show();
        }

    }
}
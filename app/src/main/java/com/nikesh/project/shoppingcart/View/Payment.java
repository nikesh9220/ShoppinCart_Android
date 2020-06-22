package com.nikesh.project.shoppingcart.View;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nikesh.project.shoppingcart.Adapter.CartAdapter;
import com.nikesh.project.shoppingcart.Model.ProductImage;
import com.nikesh.project.shoppingcart.R;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {
    public static TextView grandTotal;
    public static int grandTotalplus;
    private Button paymentButton;
    // create a temp list and add cartitem list
    public static ArrayList<ProductImage> temparraylist;
    RecyclerView cartRecyclerView;
    CartAdapter cartAdapter;

    Context context;
    private Toolbar mToolbar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        grandTotal = findViewById(R.id.paymentTotal);
        paymentButton = findViewById(R.id.payment_button);
       String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Total");
                grandTotal.setText("Total " +newString+ " INR");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("Total");
            grandTotal.setText("Total " +newString+ " INR");
        }
        Log.d("Total",newString);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(Payment.this, "Your Order Placed", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(Payment.this, MainActivity.class);
                //startActivity(intent);
                //bookMyOrder();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Payment.this, CartActivity.class);
        startActivity(intent);
    }
}
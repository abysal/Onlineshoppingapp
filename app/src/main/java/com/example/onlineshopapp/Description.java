package com.example.onlineshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Description extends AppCompatActivity {
    private CircleImageView circleImage;
    TextView tvItemName, tvItemPrice, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        tvItemName = findViewById(R.id.tvItemName);
        tvItemPrice = findViewById(R.id.tvItemPrice);
        tvDescription = findViewById(R.id.tvDescription);
        circleImage = findViewById(R.id.circleImage);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            circleImage.setImageResource(bundle.getInt("image"));
            tvItemName.setText(bundle.getString("name"));
            tvItemPrice.setText(bundle.getString("price"));
            tvDescription.setText(bundle.getString("description"));
        }
    }
}

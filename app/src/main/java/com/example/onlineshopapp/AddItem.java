package com.example.onlineshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddItem extends AppCompatActivity {
    private EditText et_name, et_price, et_des;
    private Spinner spinnerimage;
    private Button buttonview, buttonadd;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        et_name = findViewById(R.id.etName);
        et_price = findViewById(R.id.etPrice);
        et_des = findViewById(R.id.etDescription);
        spinnerimage = findViewById(R.id.spinImg);
        buttonview = findViewById(R.id.btnView);
        buttonadd = findViewById(R.id.btnAdd);
        img = findViewById(R.id.img);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });


        String image[] = {"img1","img2","img3","img4","img5","img6","img7","img8","img9","img10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,image);
        spinnerimage.setAdapter(adapter);

        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinnerString = spinnerimage.getSelectedItem().toString();

                switch (spinnerString){
                    case "img1":
                        img.setImageResource(R.drawable.img1);
                        break;
                    case "img2":
                        img.setImageResource(R.drawable.img2);
                        break;
                    case "img3":
                        img.setImageResource(R.drawable.img3);
                        break;
                    case "img4":
                        img.setImageResource(R.drawable.img4);
                        break;
                    case "img5":
                        img.setImageResource(R.drawable.img5);
                        break;
                    case "img6":
                        img.setImageResource(R.drawable.img6);
                        break;
                    case "img7":
                        img.setImageResource(R.drawable.img7);
                        break;
                    case "img8":
                        img.setImageResource(R.drawable.img8);
                        break;
                    case "img9":
                        img.setImageResource(R.drawable.img9);
                        break;
                    case "img10":
                        img.setImageResource(R.drawable.img10);
                        break;
                }
            }
        });

    }
    private void save(){
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(openFileOutput("items.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(et_name.getText().toString() + "->" + et_price.getText().toString()+ "->" + spinnerimage.getSelectedItem().toString()+ "->" + et_des.getText().toString());
            Toast.makeText(this,"saved to " +getFilesDir(), Toast.LENGTH_LONG).show();
            printStream.close();
        } catch (FileNotFoundException e) {
            Log.d("Dictionary app" , "Error: "+e.toString());
            e.printStackTrace();
        }

    }

}

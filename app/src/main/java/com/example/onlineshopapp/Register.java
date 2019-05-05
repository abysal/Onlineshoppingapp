package com.example.onlineshopapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Fragment implements View.OnClickListener {
    private EditText etUsername, etPassword, etConfirm;
    private Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_register, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etConfirm = view.findViewById(R.id.etConfirm);
        btnRegister = view.findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        if(etPassword.getText().toString().equals(etConfirm.getText().toString())){
            signUp();
        }else{
            Toast.makeText(this.getActivity(),"confirm password not matched",Toast.LENGTH_LONG).show();
        }

    }

    private void signUp(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",etUsername.getText().toString());
        editor.putString("password",etPassword.getText().toString());

        editor.commit();

        Toast.makeText(this.getActivity(),"Successfully Registered",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

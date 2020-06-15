package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText ans;
    Button b;
    Text sk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ans = (EditText) findViewById(R.id.invite);



    }

    public void Share(View v){
        String testValue =  ans.getText().toString();
        byte[] encodeValue = Base64.encode(testValue.getBytes(), Base64.DEFAULT);
        byte[] decodeValue = Base64.decode(encodeValue, Base64.DEFAULT);
        System.out.println(new String(encodeValue));
        System.out.println(new String(decodeValue));

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = new String(encodeValue);
        String shareSub = new String(encodeValue);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));

        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "This is referral code:  " + new String(encodeValue), Snackbar.LENGTH_LONG);
        snackbar.show();
    }



    public void add(View v){
        String testValue =  ans.getText().toString();

        byte[] encodeValue = Base64.encode(testValue.getBytes(), Base64.DEFAULT);
        byte[] decodeValue = Base64.decode(encodeValue, Base64.DEFAULT);
        System.out.println(new String(encodeValue));
        System.out.println(new String(decodeValue));

        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Decoding referral code:  " + new String(decodeValue), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}

package com.example.girish.booksread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.girish.booksread.activities.BarcodeScannerActivity;

public class MainActivity extends AppCompatActivity {

    private Button ScanButton;
    private TextView ISBNTextView;
    public static final int BARCODE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScanButton = (Button) findViewById(R.id.BarcodeScanButton);
        ISBNTextView = (TextView) findViewById(R.id.ISBNeditText);

        ScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarcodeScannerActivity.class);
                startActivityForResult(intent,BARCODE_REQUEST);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if(resultCode== BARCODE_REQUEST){
           ISBNTextView.setText(data.getStringExtra("BARCODE_RESULT"));
       }
        else{
           Toast.makeText(MainActivity.this,"Cannot read bro",Toast.LENGTH_SHORT).show();
       }
    }
}

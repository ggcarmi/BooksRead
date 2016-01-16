package com.example.girish.booksread.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.girish.booksread.MainActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Girish on 16-01-2016.
 */
public class BarcodeScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    /**
     *
     *
     * This activity handles the barcode scanning process and would be created as a subactivity
     * by the main activity, straight from the documentation.
     *
     * @param result
     */


    Intent resultIntent;


    @Override
    public void handleResult(Result result) {

        Log.i("READ",result.getText());
        resultIntent = new Intent();
        resultIntent.putExtra("BARCODE_RESULT",result.getText());
        setResult(MainActivity.BARCODE_REQUEST,resultIntent);
        mScannerView.stopCamera();           // Stop camera on pause
        finish();


    }
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }



}

package com.et.qrcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.et.qrlib.ResultInterface;
import com.et.qrlib.QRCompiler;

public class MainActivity extends AppCompatActivity implements ResultInterface {
    ImageView imageView;
    Button btn_generate, btn_read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        btn_generate = (Button) findViewById(R.id.btn_generate);
        btn_read = (Button) findViewById(R.id.btn_read);

        // QR Code generator
        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "VarunSaravanan2234@#$%^&*(%hbdfkb#$%^";
                Bitmap test = QRCompiler.generater(text, 800, 800);
                imageView.setImageBitmap(test);
            }
        });

        // QR Code reader
        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QRCompiler.reader(MainActivity.this, MainActivity.class);
            }
        });
    }

    @Override
    public void readerResult(String text) {
        Log.d("Result",""+text);
    }
}

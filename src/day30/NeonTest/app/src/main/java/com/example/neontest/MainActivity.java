package com.example.neontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    static {
        System.loadLibrary("FadeInOut");
    }

    public native void runNeon(Bitmap bmpIn, Bitmap bmpOut, Bitmap bitmapResult, int width, int height, int nRate);

    public native void runC(Bitmap bmpIn, Bitmap bmpOut, Bitmap bitmapResult, int width, int height, int nRate);

    int widht, height;
    long spendTime = 0;
    int NeonRate, CRate;

    LinearLayout layout;
    Bitmap bmpOrig, bmpOrig2, bmpNeon, bmpC;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.ImageOut);
        textView = (TextView) findViewById(R.id.TextOut);

        bmpOrig = BitmapFactory.decodeResource(this.getResources(), R.drawable.lenna);
        widht = bmpOrig.getWidth();
        height = bmpOrig.getHeight();
        bmpOrig2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.and);

        bmpNeon = Bitmap.createBitmap(widht, height, Bitmap.Config.ARGB_8888);
        bmpC = Bitmap.createBitmap(widht, height, Bitmap.Config.ARGB_8888);

        textView.setText("Original");
        imageView.setImageBitmap(bmpOrig);
        NeonRate = 0;
        CRate = 0;
    }

    public void showOriginalImage(View v) {
        textView.setText("Original Image");
        imageView.setImageBitmap(bmpOrig);
    }

    public void OpenNeon(View v) {
        if (NeonRate >= 10) NeonRate = 0;
        spendTime = System.currentTimeMillis();
        runNeon(bmpOrig, bmpOrig2, bmpNeon, widht, height, NeonRate);
        spendTime = System.currentTimeMillis() - spendTime;
        textView.setText("Neon, Processing time is " + spendTime + " ms");
        imageView.setImageBitmap(bmpNeon);
        NeonRate++;
    }

    public void OpenC(View v) {
        if (CRate >= 10) CRate = 0;
        spendTime = System.currentTimeMillis();
        runC(bmpOrig, bmpOrig2, bmpC, widht, height, CRate);
        spendTime = System.currentTimeMillis() - spendTime;
        textView.setText(" NativeC, Processing time is " + spendTime + " ms");
        imageView.setImageBitmap(bmpC);
        CRate++;
    }
}

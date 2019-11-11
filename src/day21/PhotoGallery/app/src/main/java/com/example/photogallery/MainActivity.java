package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rC, rJava, rGo;
    Button btnOk;
    ImageView imgLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Image Gallery");

        tv1 = (TextView)findViewById(R.id.Text1);
        tv2 = (TextView)findViewById(R.id.Text2);

        chkAgree = (CheckBox)findViewById(R.id.ChkAgree);

        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);

        rC = (RadioButton)findViewById(R.id.Rc);
        rJava = (RadioButton)findViewById(R.id.Rjava);
        rGo = (RadioButton)findViewById(R.id.Rgo);

        btnOk = (Button)findViewById(R.id.BtnOk);

        imgLang = (ImageView)findViewById(R.id.ImgLang);

        chkAgree.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(
                    CompoundButton buttonView,
                    boolean isChecked) {
                if(chkAgree.isChecked() == true) {
                    tv2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgLang.setVisibility(View.VISIBLE);
                } else {
                    tv2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgLang.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.Rc:
                        imgLang.setImageResource(
                                R.drawable.clang
                        );
                        break;
                    case R.id.Rjava:
                        imgLang.setImageResource(
                                R.drawable.javalang
                        );
                        break;
                    case R.id.Rgo:
                        imgLang.setImageResource(
                                R.drawable.golang
                        );
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Select Language",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

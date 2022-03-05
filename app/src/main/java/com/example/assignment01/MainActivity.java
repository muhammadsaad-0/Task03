package com.example.labtask03;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.labtask03.R;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    Button b1,b2;
    String str1,str2,str3,str4,str5,str6,str7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.textView2);
        t2=(TextView) findViewById(R.id.textView3);
        t3=(TextView) findViewById(R.id.textView7);
        t4=(TextView) findViewById(R.id.textView5);
        t6=(TextView) findViewById(R.id.textView8);
        t7=(TextView) findViewById(R.id.textView9);
        t8=(TextView) findViewById(R.id.textView6);
        t5=(TextView) findViewById(R.id.textView4);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);

        Intent intent=getIntent();
        str1=intent.getStringExtra("Name");
        t1.setText(str1);

        str2=intent.getStringExtra("Description");
        t2.setText(str2);

        b1.setText("contact");

        str4=intent.getStringExtra("Email");
        b2.setText("email");

        str5=intent.getStringExtra("Final Degree");
        t3.setText(str5);

        str6=intent.getStringExtra("Experience");
        t5.setText(str6);

        str7=intent.getStringExtra("Skills");
        t4.setText(str7);

        t6.setText("Degree");
        t7.setText("Skills");
        t8.setText("Experience");

    }

    public void call(View view) {
        Intent intent=getIntent();
        str3=intent.getStringExtra("Number");
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+str3));

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

            requestPermission();
        }
        else{
            startActivity(i);
        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }

    public void mail(View view) {
        String[] s1={str4};
        Intent in=new Intent(Intent.ACTION_SEND);
        in.setData(Uri.parse("email"));
        in.putExtra(Intent.EXTRA_EMAIL,s1);

        in.setType("message/rfc822");
        Intent chooser = Intent.createChooser(in, "Launch Email");
        startActivity(chooser);
    }
}
package com.example.labtask03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.labtask03.MainActivity2;

public class MainActivity2 extends AppCompatActivity {
    TextView name;
    EditText email;
    EditText number;
    EditText des;
    EditText deg;
    EditText skill;
    EditText exp;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name= (TextView) findViewById(R.id.e1);
        email=(EditText) findViewById(R.id.e2);
        number=(EditText) findViewById(R.id.e3);
        des=(EditText) findViewById(R.id.e4);
        deg=(EditText) findViewById(R.id.e5);
        skill=(EditText) findViewById(R.id.e6);
        exp=(EditText) findViewById(R.id.e7);
        but=(Button) findViewById(R.id.b1);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }



    public void demo(View view) {
        Intent intent= new Intent(this, com.example.labtask03.MainActivity.class);
        intent.putExtra("Name",name.getText().toString());
        intent.putExtra("Email",email.getText().toString());
        intent.putExtra("Number",number.getText().toString());
        intent.putExtra("Description",des.getText().toString());
        intent.putExtra("Final Degree",deg.getText().toString());
        intent.putExtra("Skills",skill.getText().toString());
        intent.putExtra("Experience",exp.getText().toString());
        startActivity(intent);

    }
}
package com.example.mycalcv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1. Create variable

    private EditText n1;
    private EditText n2;
    private TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Call component  id's (GHI) into variables

        n1=findViewById(R.id.et_n1);
        n2=findViewById(R.id.et_n2);
        ans=findViewById(R.id.tv_ans);
    }

    public void Calc_Add (View view){

        //3. Get values
        String val1 = n1.getText().toString();
        String val2 =n2.getText().toString();

        int num1 = Integer.parseInt(val1);
        int num2 = Integer.parseInt(val2);

        int oper = num1 + num2;

        String res = String.valueOf(oper);
        ans.setText(res);
    }


}
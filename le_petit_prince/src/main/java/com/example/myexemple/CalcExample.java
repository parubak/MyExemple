package com.example.myexemple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcExample extends AppCompatActivity implements View.OnClickListener {

    private  EditText number1, number2;
    private TextView result, operation;
    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_example);

        number1=(EditText) findViewById(R.id.number1);
        number2=(EditText) findViewById(R.id.number2);
        result=(TextView) findViewById(R.id.result);
        operation=(TextView) findViewById(R.id.operation);
        buttonAdd=(Button) findViewById(R.id.buttonAdd);
        buttonSubtract=(Button) findViewById(R.id.buttonSubtract);
        buttonClean=(Button) findViewById(R.id.buttonClean);
        buttonDivide=(Button) findViewById(R.id.buttonDivide);
        buttonMultiply=(Button) findViewById(R.id.buttonMultiply);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);

    }

    public void butonOnClicked(View view) {
        Toast.makeText(getApplicationContext(),"Yes!",Toast.LENGTH_LONG).show();

    }

  @Override
    public void onClick(View v) {
        float num1=0;
        float num2=0;
        float res=0;

        num1=Float.parseFloat(number1.getText().toString());
        num2=Float.parseFloat(number2.getText().toString());

        switch (v.getId()){
            case R.id.buttonAdd:
                operation.setText("+");
                res=num1+num2;
                break;
            case R.id.buttonSubtract:
                operation.setText("-");
                res=num1-num2;
                break;
            case R.id.buttonMultiply:
                operation.setText("*");
                res=num1*num2;
                break;
            case R.id.buttonDivide:
                operation.setText("/");
                res=num1/num2;
                break;
            case R.id.buttonClean:
                number1.setText("");
                number2.setText("");
                operation.setText("");
                result.setText("");
                break;
        }
        result.setText(res+"");
    }
}
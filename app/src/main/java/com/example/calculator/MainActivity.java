package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText number1, number2;
    Button add, subtract, divide, multiply;

    float result_num;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isEmpty()) {
                    num1 = Integer.parseInt(MainActivity.this.number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    result_num = num1 + num2;
                    result.setText(String.valueOf(result_num));
                }
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isEmpty()) {
                    num1 = Integer.parseInt(MainActivity.this.number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    result_num = num1 - num2;
                    result.setText(String.valueOf(result_num));
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!isEmpty()) {
                    num1 = Integer.parseInt(MainActivity.this.number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    if (num2 == 0) {
                        openDialog("nie dziel cholero przez zero");

                    } else if (num1 == 0) {
                        openDialog("bez liczenia powiem ci, że wynik to 0");
                    } else {
                        result_num = num1 / num2;
                        result.setText(String.valueOf(result_num));
                    }
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isEmpty()) {
                    num1 = Integer.parseInt(MainActivity.this.number1.getText().toString());
                    num2 = Integer.parseInt(number2.getText().toString());
                    result_num = num1 * num2;
                    result.setText(String.valueOf(result_num));
                }
            }
        });
    }

    public void openDialog(String message) {
        DialogBox exampleDialog = new DialogBox();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        exampleDialog.setArguments(bundle);
        exampleDialog.show(getSupportFragmentManager(), "cos1");
    }

    public boolean isEmpty() {
        String pole1 = number1.getText().toString();
        String pole2 = number2.getText().toString();

        if (TextUtils.isEmpty(pole1)) {
            number1.setError("To pole nie może być puste");
            return true;
        } else if (TextUtils.isEmpty(pole2)) {
            number2.setError("To pole nie może być puste!");
            return true;
        }
        return false;
    }
}




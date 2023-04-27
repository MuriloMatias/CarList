package com.example.carlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addCar extends AppCompatActivity {

    EditText carNameLt;
    EditText carBrandLt;
    EditText carColorLt;
    EditText carYearLt;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car_m);

        carNameLt = findViewById(R.id.edtName);
        carBrandLt = findViewById(R.id.edtBrand);
        carColorLt = findViewById(R.id.edtColor);
        carYearLt = findViewById(R.id.edtYear);
        addButton = findViewById(R.id.btwRegister);

        addButton.setOnClickListener(
                view ->{
                    String carName = carNameLt.getText().toString();
                    String carBrand = carBrandLt.getText().toString();
                    String carColor = carColorLt.getText().toString();
                    Integer carYear = Integer.parseInt(carYearLt.getText().toString());

                    Car car = new Car(carName, carBrand, carColor, carYear);
                    Intent intent = new Intent();
                    intent.putExtra("car", car);
                    setResult(RESULT_OK, intent);
                    finish();
                }
        );
    }
}
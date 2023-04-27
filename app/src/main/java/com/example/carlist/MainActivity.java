package com.example.carlist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView uiCList;
    FloatingActionButton addCarFB;
    ArrayList<Car> carList;

    CarAdapter carAdapter;

    ActivityResultLauncher<Intent> addCarActivityLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        Car car = (Car) data.getSerializableExtra("car");
                        carList.add(car);
                        carAdapter.notifyDataSetChanged();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        uiCList = findViewById(R.id.carList);
        addCarFB = findViewById(R.id.addCarF);
        carList = new ArrayList<>();

        carList.add(new Car("Uno", "Fiat", "White", 2022));
        carList.add(new Car("S10", "General Motors", "Black", 2000));

        carAdapter = new CarAdapter(this, carList);
        uiCList.setAdapter(carAdapter);

        Intent intent = new Intent(this, addCar.class);
        addCarFB.setOnClickListener(view ->{
            addCarActivityLaucher.launch(intent);
        });
    }
}
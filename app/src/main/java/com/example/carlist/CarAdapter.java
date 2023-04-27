package com.example.carlist;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Locale;

public class CarAdapter extends ArrayAdapter<Car> {
    public CarAdapter(Context context, ArrayList<Car> carList) {
        super(context, 0, carList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.car_list, parent, false);
        }

        Car car = getItem(position);

        TextView carName = currentItemView.findViewById(R.id.carName);
        carName.setText(car.getName());

        TextView carBrand = currentItemView.findViewById(R.id.carBrand);
        carBrand.setText(car.getBrand());

        TextView carColor = currentItemView.findViewById(R.id.carColor);
        carColor.setText(car.getColor());

        TextView carYear = currentItemView.findViewById(R.id.carYear);
        carYear.setText(String.format(Locale.US, "%d", car.getYear()));

        return currentItemView;
    }
}


package com.example.myspinnerlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    Spinner spinner;
    EditText input;
    Button addSpinner, removeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSpinner =  findViewById(R.id.btn_add_spinner);
        removeSpinner =  findViewById(R.id.btn_remove_spinner);
        input = findViewById(R.id.input);
        spinner = findViewById(R.id.spinner);

        String data[] = {"Fruits"};
        ArrayList list = new ArrayList(Arrays.asList(data));

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);

        addSpinner.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                String inputData = input.getText().toString();
                list.add(inputData);
                adapter.notifyDataSetChanged();
                spinner.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "Item Added to spinner", Toast.LENGTH_SHORT).show();
              }
          });

        removeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputData = input.getText().toString();
                list.remove(inputData);
                adapter.notifyDataSetChanged();
                spinner.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "Item removed from spinner", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
      String text = adapterView.getItemAtPosition(i).toString();
      Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
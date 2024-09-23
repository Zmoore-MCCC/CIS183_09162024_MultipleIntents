package com.example.cis183_09_16_2024_multipleintents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNewPet extends AppCompatActivity {
    Button btn_j_addNew_addPet;
    Intent intent_j_MainActivity;
    EditText et_j_petName;
    EditText et_j_petAge;
    Spinner sp_j_dropDown;
    ArrayAdapter<String> adapter;
    String petType = Pet.PetType.getPetAt(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_pet);

        btn_j_addNew_addPet = findViewById(R.id.btn_v_newPet_addPet);
        et_j_petName = findViewById(R.id.et_v_name);
        et_j_petAge = findViewById(R.id.et_v_age);
        sp_j_dropDown = findViewById(R.id.sp_v_typesDropDown);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Pet.PetType.getAllPetTypes());
        sp_j_dropDown.setAdapter(adapter);

        intent_j_MainActivity = new Intent(AddNewPet.this, MainActivity.class);
        //code to get info passed from mainactivity.java
        //get the intent that called me
        Intent cameFrom = getIntent();
        //get the bundle that was passed to me from "cameFrom" intent
        Bundle infoPassedToMe = cameFrom.getExtras();
        //Get the info in the bundle called "InfoPassed" -> set in MainActivity.java
        String data = infoPassedToMe.getString("InfoPassed");

        Log.d("INFO PASSED FROM MAIN: ", data);

        addPetButtonListener();
        spinnerEventListener();

    }

    private void spinnerEventListener()
    {
        sp_j_dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                petType = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void addPetButtonListener()
    {
        btn_j_addNew_addPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get info from the editText
                String name = et_j_petName.getText().toString();
                int age = Integer.parseInt(et_j_petAge.getText().toString());

                //Create a new pet object to pass to the
                Pet newPet = new Pet();
                newPet.setAge(age);
                newPet.setName(name);
                newPet.setType(petType);

                //pass the new pet back to main
                intent_j_MainActivity.putExtra("petData", newPet);

                //start main activity
                startActivity(intent_j_MainActivity);
            }
        });
    }
}
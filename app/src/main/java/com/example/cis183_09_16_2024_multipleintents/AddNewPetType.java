package com.example.cis183_09_16_2024_multipleintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNewPetType extends AppCompatActivity
{
    EditText et_j_typeName;
    TextView tv_j_error;
    Button btn_j_addType;
    Intent addNewPet;
    Button btn_j_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_pet_type);

        et_j_typeName = findViewById(R.id.et_v_addType_typeName);
        tv_j_error    = findViewById(R.id.tv_v_addType_error);
        btn_j_addType = findViewById(R.id.btn_v_addType_addType);
        btn_j_back    = findViewById(R.id.btn_v_addType_Back);

        addNewPet = new Intent(AddNewPetType.this, AddNewPet.class);

        backButtonClickListener();
        addTypeButtonClickListener();

    }

    private void backButtonClickListener()
    {
        btn_j_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addNewPet);
            }
        });
    }

    private void addTypeButtonClickListener()
    {
        btn_j_addType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int errorCode = checkUserInput();
                if(errorCode == 0)
                {
                    Pet.PetType.addPetType(et_j_typeName.getText().toString());
                    startActivity(addNewPet);
                }
                else if(errorCode == 1)
                {
                    tv_j_error.setText("Error: You need to fillout the textbox");
                    tv_j_error.setVisibility(View.VISIBLE);
                }
                else if(errorCode == 2)
                {
                    tv_j_error.setText("Error: This type already exists");
                    tv_j_error.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    private int checkUserInput()
    {
        //0 - good input
        //1 - not data error
        //2 - type already exists
        String input = et_j_typeName.getText().toString();
        if(input.isEmpty())
        {
            return 1;
        }
        else
        {
            for(int i = 0; i < Pet.PetType.getAllPetTypes().size(); i++)
            {
                if(input.equalsIgnoreCase(Pet.PetType.getPetAt(i)))
                {
                    return 2;
                }
            }
        }

        return 0;
    }
}
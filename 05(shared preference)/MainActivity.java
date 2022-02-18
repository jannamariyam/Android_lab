package com.example.shared_preference;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText fNmame,lName;
    Button submit;
    RadioGroup genderRgroup;
    RadioButton male,female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAndNavigate();
            }
        });

    }

    private void initUI()
    {
        fNmame=findViewById(R.id.editText);
        lName=findViewById(R.id.editText2);
        male=findViewById(R.id.radio_male);
        female=findViewById(R.id.radio_female);
        submit=findViewById(R.id.btn_submit);
        genderRgroup=findViewById(R.id.radioGroup);
    }

    private void registerAndNavigate()
    {
        SharedPreferences sharedPref = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("FNAME",fNmame.getText().toString());
        editor.putString("LNAME",lName.getText().toString());

        String radioValue="";
        switch (genderRgroup.getCheckedRadioButtonId())
        {
            case R.id.radio_male:radioValue="Male";break;
            case R.id.radio_female:radioValue="Female";break;
        }
        editor.putString("GENDER",radioValue);
        editor.apply();

        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);

    }
}
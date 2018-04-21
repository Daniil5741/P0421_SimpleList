package com.example.danya.trainingtoday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main_Add extends AppCompatActivity  implements View.OnClickListener{

    EditText edit_exercise;

    EditText edit_approaches;
String exercise_name="0",approaches_name="";
    Button btn_Exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__add);
        btn_Exercise=(Button)findViewById(R.id.btn_exercise);
        edit_exercise=(EditText) findViewById(R.id.edit_exetcise_Add);
        edit_approaches=(EditText) findViewById(R.id.edit_quantity_Approaches);
      btn_Exercise.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        approaches_name= edit_approaches.getText().toString();
        exercise_name=  edit_exercise.getText().toString();
        intent.putExtra("exercise",exercise_name);
        intent.putExtra("approaches", approaches_name);
        intent.putExtra("version", 1000);
        startActivity(intent);

    }
}

package com.example.a1.datttarroomm;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePeople extends AppCompatActivity {
MyDatabase db;
EditText edit_name,edit_surname,edit_course;
Button button_create;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_people);
        db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "db").allowMainThreadQueries().build();
        edit_name=(EditText) findViewById(R.id.edit_name);
        edit_surname=(EditText) findViewById(R.id.edit_surname);
        edit_course=(EditText) findViewById(R.id.edit_course);
        button_create=(Button) findViewById(R.id.button_create);
button_create.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(edit_name.getText().equals("")|| edit_surname.getText().equals("") || edit_course.getText().equals(""))
        {
            Toast.makeText(CreatePeople.this, "Заполните полей!", Toast.LENGTH_SHORT).show();
        }
        else {
            db.peopleDao().createPeople(new People(edit_name.getText().toString(), edit_surname.getText().toString(), Integer.parseInt(edit_course.getText().toString())));
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
});
    }



}

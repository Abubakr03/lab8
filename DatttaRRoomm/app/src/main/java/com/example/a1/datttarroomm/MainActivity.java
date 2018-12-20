package com.example.a1.datttarroomm;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] people;
     MyDatabase db;
    EditText edit_search;
    Button button_add,button_search;
    ListView list_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "db").allowMainThreadQueries().build();
         list_user=(ListView) findViewById(R.id.list_user);
         showAllUsers();
         edit_search=(EditText) findViewById(R.id.edit_search);
         button_add=(Button) findViewById(R.id.button_add);
         button_search=(Button) findViewById(R.id.button_search);
button_add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),CreatePeople.class));

    }
});
button_search.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showFoundUsers();

    }
});

    }
    public void showAllUsers(){
        if(db.peopleDao().getCountUsers() == 0){
           people = new String[1];people[0] = "База данных пуст!";
        } else {
            List<People> allUsers = db.peopleDao().getAllUsers();
            people = new String[allUsers.size()];
            for(int i = 0; i < allUsers.size(); i++){
                people[i] = allUsers.get(i).getName() + " " + allUsers.get(i).getSurname() + ", " + allUsers.get(i).getCourse();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people);
        list_user.setAdapter(adapter);
    }
    public void showFoundUsers(){
        List<People> foundUsers = db.peopleDao().getUsersByName(edit_search.getText().toString());
        if(foundUsers.size() == 0){
            people = new String[1]; people[0] = "Нет таких пользователь!Введите правильно";
        } else {
            people = new String[foundUsers.size()];
            for(int i = 0; i < foundUsers.size(); i++){
               people[i] = foundUsers.get(i).getName() + " " + foundUsers.get(i).getSurname() + ", " + foundUsers.get(i).getCourse();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people);
        list_user.setAdapter(adapter);
    }
}

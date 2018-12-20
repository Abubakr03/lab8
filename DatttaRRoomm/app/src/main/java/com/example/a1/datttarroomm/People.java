package com.example.a1.datttarroomm;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "dal")
public class People {
   public People(String Name,String Surname,int Course)
   {
       this.Name=Name;
       this.Surname=Surname;
       this.Course=Course;
   }
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "n_Name")
    private String Name;

    @ColumnInfo(name = "n_Surname")
    private String Surname;

    @ColumnInfo(name = "Course")
    private int Course;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int Course) {
        this.Course = Course;
    }
}

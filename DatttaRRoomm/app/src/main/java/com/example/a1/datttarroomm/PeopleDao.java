package com.example.a1.datttarroomm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PeopleDao {
    @Query("SELECT * FROM dal")
    public List<People> getAllUsers();

    @Query("SELECT COUNT(*) FROM dal")
    public int getCountUsers();

    @Query("SELECT * FROM dal WHERE n_Name = :Name")
    public List<People> getUsersByName(String Name);

    @Query("DELETE FROM dal")
    public void deleteAllUsers();

    @Insert
    public  void createPeople (People ... people);

}

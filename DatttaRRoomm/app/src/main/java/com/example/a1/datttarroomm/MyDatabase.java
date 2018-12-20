package com.example.a1.datttarroomm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {People.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract PeopleDao peopleDao();

}

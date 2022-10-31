package com.example.javaandroid.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 3)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDAO userDao();
}

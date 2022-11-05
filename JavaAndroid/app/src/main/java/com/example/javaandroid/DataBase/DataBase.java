package com.example.javaandroid.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.javaandroid.DataBase.DAO.UserDAO;
import com.example.javaandroid.DataBase.Entitys.AccesoEntity;
import com.example.javaandroid.DataBase.Entitys.UserEntity;

@Database(entities = {UserEntity.class, AccesoEntity.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase INSTANCE;

    public abstract UserDAO userDao();

    public static DataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBase.class, "javaAndroid.db")
                            .build();
            }
        }
        return INSTANCE;
    }
}

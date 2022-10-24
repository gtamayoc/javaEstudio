package com.example.javaandroid.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<UserEntity> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<UserEntity> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first " +
            "LIMIT 1")
    UserEntity findByName(String first);

    @Query("SELECT * FROM user WHERE user_name = :user_name")
    List<UserEntity> loadUserByUserName(String user_name);

    @Insert
    void insertAll(UserEntity... users);

    @Delete
    void delete(UserEntity user);


}

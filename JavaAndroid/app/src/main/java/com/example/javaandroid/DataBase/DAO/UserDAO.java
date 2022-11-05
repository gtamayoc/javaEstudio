package com.example.javaandroid.DataBase.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.javaandroid.DataBase.Entitys.AccesoEntity;
import com.example.javaandroid.DataBase.Entitys.UserAndAcceso;
import com.example.javaandroid.DataBase.Entitys.UserEntity;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<UserEntity> getAll();

    @Query("SELECT * FROM user WHERE id_user IN (:userIds)")
    List<UserEntity> loadAllByIds(String[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first " +
            "LIMIT 1")
    UserEntity findByName(String first);

    @Query("SELECT * FROM user WHERE user_name = :user_name")
    List<UserEntity> loadUserByUserName(String user_name);

    @Insert
    void insertAll(UserEntity... users);

    @Insert
    void insertAllAcceso(AccesoEntity... acceso);

    @Delete
    void delete(UserEntity user);

    @Update
    void updateAll(UserEntity user);

    @Transaction
    @Query("SELECT * FROM user" +
            " JOIN acceso ON user.id_user = acceso.id_user" +
            " WHERE user.user_name = :user_name AND user.password = :user_pass")
    List<UserAndAcceso> getUserAndAcceso(String user_name, String user_pass);

    @Query("SELECT * FROM acceso")
    List<AccesoEntity> loadUserByUserName();
}

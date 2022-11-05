package com.example.javaandroid.DataBase.Entitys;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "user", primaryKeys = {"id_user", "user_name"})
public class UserEntity {

    @NonNull
    @ColumnInfo(name = "id_user")
    public String uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @NonNull
    @ColumnInfo(name = "user_name")
    public String userName;

    @ColumnInfo(name = "password")
    public String password;

    @Ignore
    public UserEntity() {
        uid = UUID.randomUUID().toString();
    }

    public UserEntity(@NonNull String uid, String firstName, @NonNull String userName, String password) {
        this.uid = uid;
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.javaandroid.DataBase.Entitys;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "acceso", primaryKeys = {"id_acceso"})
public class AccesoEntity {

    @NonNull
    @ColumnInfo(name = "id_acceso")
    public String aid;

    @NonNull
    @ColumnInfo(name = "id_user")
    public String uid;

    @NonNull
    public String getAid() {
        return aid;
    }

    public void setAid(@NonNull String aid) {
        this.aid = aid;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }
}
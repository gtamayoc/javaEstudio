package com.example.javaandroid.DataBase.Entitys;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserAndAcceso {
    @Embedded
    public UserEntity user;
    @Relation(
            parentColumn = "id_user",
            entityColumn = "id_user"
    )
    public AccesoEntity acceso;
}

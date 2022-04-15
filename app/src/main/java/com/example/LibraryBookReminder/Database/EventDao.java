package com.example.LibraryBookReminder.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertAll(EntityClass entityClass);

    @Query("SELECT * FROM Book_Return")
    List<EntityClass> getAllData();

//    @Query("delete from Book_Return where id=:id")
//    void deleteById(int id);


}

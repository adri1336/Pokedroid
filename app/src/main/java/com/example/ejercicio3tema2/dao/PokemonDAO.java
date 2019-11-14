package com.example.ejercicio3tema2.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ejercicio3tema2.entity.Pokemon;

import java.util.List;

@Dao
public interface PokemonDAO
{
    @Delete
    int delete(Pokemon pokemon);

    @Query("DELETE FROM pokemon;")
    int deleteAll();

    @Update
    int edit(Pokemon pokemon);

    @Insert
    Long insert(Pokemon pokemon);

    @Query("SELECT * FROM pokemon WHERE id = :id;")
    Pokemon get(int id);

    @Query("SELECT * FROM pokemon;")
    List<Pokemon> getAll();

    @Query("SELECT * FROM pokemon;")
    LiveData<List<Pokemon>> getAllLive();
}

package com.example.ejercicio3tema2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ejercicio3tema2.dao.PokemonDAO;
import com.example.ejercicio3tema2.entity.Pokemon;

@Database(entities = {Pokemon.class}, version = 1, exportSchema = false)
public abstract class PokemonDatabase extends RoomDatabase
{
    public abstract PokemonDAO getPokemonDAO();

    private static volatile PokemonDatabase INSTANCE;

    public static PokemonDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null)
        {
            synchronized(PokemonDatabase.class)
            {
                if(INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PokemonDatabase.class, "database.db").build();
            }
        }
        return INSTANCE;
    }
}
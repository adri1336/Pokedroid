package com.example.ejercicio3tema2.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ejercicio3tema2.entity.Pokemon;
import com.example.ejercicio3tema2.model.Repository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel
{
    private Repository repository;
    private LiveData<List<Pokemon>> pokemons;

    public MainActivityViewModel(@NonNull Application application)
    {
        super(application);
        repository = new Repository(application);
        pokemons = repository.getPokemonsLive();
    }

    public LiveData<List<Pokemon>> getPokemons()
    {
        return pokemons;
    }

    public void insert(Pokemon pokemon)
    {
        repository.insertPokemon(pokemon);
    }

    public void deleteAll()
    {
        repository.deletePokemons();
    }
}

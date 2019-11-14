package com.example.ejercicio3tema2.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ejercicio3tema2.dao.PokemonDAO;
import com.example.ejercicio3tema2.database.PokemonDatabase;
import com.example.ejercicio3tema2.entity.Pokemon;


import java.util.List;

public class Repository
{
    private PokemonDAO pokemonDAO;
    private LiveData<List<Pokemon>> pokemonsLive;

    public Repository(Context context)
    {
        PokemonDatabase db = PokemonDatabase.getDatabase(context);
        pokemonDAO = db.getPokemonDAO();
        pokemonsLive = pokemonDAO.getAllLive();
    }

    private void populateDb()
    {
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Gato");
        pokemon.setSpecies_name("Felino");
        insertPokemon(pokemon);
    }

    public LiveData<List<Pokemon>> getPokemonsLive()
    {
        return pokemonsLive;
    }

    public void insertPokemon(Pokemon pokemon)
    {
        new InsertThread().execute(pokemon);
    }

    private class InsertThread extends AsyncTask<Pokemon, Void, Void>
    {
        @Override
        protected Void doInBackground(Pokemon... pokemons)
        {
            pokemonDAO.insert(pokemons[0]);
            return null;
        }
    }

    public void deletePokemons()
    {
        new DeleteAllThread().execute();
    }

    private class DeleteAllThread extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            pokemonDAO.deleteAll();
            return null;
        }
    }
}
package com.example.ejercicio3tema2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.ejercicio3tema2.entity.Pokemon;
import com.example.ejercicio3tema2.model.RecyclerViewListener;
import com.example.ejercicio3tema2.view.MainActivityViewModel;
import com.example.ejercicio3tema2.view.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private MainActivityViewModel mainActivityViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponents();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        recyclerViewAdapter.setPokemons(recyclerViewAdapter.getPokemons());
    }

    private void initComponents()
    {
        RecyclerView rvMain = findViewById(R.id.rvMain);
        recyclerViewAdapter = new RecyclerViewAdapter(this, new RecyclerViewListener()
        {
            @Override
            public void onClick(Pokemon pokemon)
            {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("pokemon", pokemon);
                startActivity(intent);
            }
        });
        rvMain.setAdapter(recyclerViewAdapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getPokemons().observe(this, new Observer<List<Pokemon>>()
        {
            @Override
            public void onChanged(List<Pokemon> pokemons)
            {
                MainActivity.this.recyclerViewAdapter.setPokemons(pokemons);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.action_deleteDB)
        {
            mainActivityViewModel.deleteAll();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

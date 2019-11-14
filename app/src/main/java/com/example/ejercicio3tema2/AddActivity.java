package com.example.ejercicio3tema2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.ejercicio3tema2.entity.Pokemon;
import com.example.ejercicio3tema2.model.Repository;
import com.example.ejercicio3tema2.view.AddActivityViewModel;
import com.google.android.material.textfield.TextInputLayout;


public class AddActivity extends AppCompatActivity
{
    private static final int PHOTO_SELECTED = 1;
    private AddActivityViewModel addActivityViewModel;
    private ImageView ivAddPhoto;
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initComponents();
    }

    private void initComponents()
    {
        repository = new Repository(this);

        addActivityViewModel = ViewModelProviders.of(this).get(AddActivityViewModel.class);

        ivAddPhoto = findViewById(R.id.ivAddPhoto);
        ivAddPhoto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent pickPhoto = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, PHOTO_SELECTED);
            }
        });

        final TextInputLayout tilName = findViewById(R.id.tilName);
        EditText tietName = findViewById(R.id.tietName);
        tietName.setText(addActivityViewModel.getName());
        tietName.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                if(tilName.getError() != null)
                    tilName.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                addActivityViewModel.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        final TextInputLayout tilSpeciesName = findViewById(R.id.tilSpeciesName);
        EditText tietSpeciesName = findViewById(R.id.tietSpeciesName);
        tietSpeciesName.setText(addActivityViewModel.getName());
        tietSpeciesName.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                if(tilSpeciesName.getError() != null)
                tilSpeciesName.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                addActivityViewModel.setSpecies_name(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        final TextInputLayout tilDescription = findViewById(R.id.tilDescription);
        EditText tietDescription = findViewById(R.id.tietDescription);
        tietDescription.setText(addActivityViewModel.getName());
        tietDescription.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                if(tilDescription.getError() != null)
                tilDescription.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                addActivityViewModel.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        final TextView tvHeight = findViewById(R.id.tvHeight);
        SeekBar sbHeight = findViewById(R.id.sbHeight);
        tvHeight.setText(getText(R.string.tvHeight) + " " + addActivityViewModel.getHeight() + "m");
        sbHeight.setProgress(addActivityViewModel.getHeight());
        sbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                addActivityViewModel.setHeight(progress);
                tvHeight.setText(getText(R.string.tvHeight) + " " + addActivityViewModel.getHeight() + "m");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        final TextView tvWeight = findViewById(R.id.tvWeight);
        SeekBar sbWeight = findViewById(R.id.sbWeight);
        tvWeight.setText(getText(R.string.tvWeight) + " " + addActivityViewModel.getWeight() + "kg");
        sbWeight.setProgress(addActivityViewModel.getWeight());
        sbWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                addActivityViewModel.setWeight(progress);
                tvWeight.setText(getText(R.string.tvWeight) + " " + addActivityViewModel.getWeight() + "kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        final TextView tvSpeed = findViewById(R.id.tvSpeed);
        SeekBar sbSpeed = findViewById(R.id.sbSpeed);
        tvSpeed.setText(getText(R.string.tvSpeed) + " " + addActivityViewModel.getSpeed() + "km/h");
        sbSpeed.setProgress(addActivityViewModel.getSpeed());
        sbSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                addActivityViewModel.setSpeed(progress);
                tvSpeed.setText(getText(R.string.tvSpeed) + " " + addActivityViewModel.getSpeed() + "km/h");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        final TextView tvKillerRating = findViewById(R.id.tvKillerRating);
        SeekBar sbKillerRating = findViewById(R.id.sbKillerRating);
        tvKillerRating.setText(getText(R.string.tvKillerRating) + " " + addActivityViewModel.getKiller_rating());
        sbKillerRating.setProgress(addActivityViewModel.getKiller_rating());
        sbKillerRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                addActivityViewModel.setKiller_rating(progress);
                tvKillerRating.setText(getText(R.string.tvKillerRating) + " " + addActivityViewModel.getKiller_rating());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        Button btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(addActivityViewModel.getName() == null || addActivityViewModel.getName().length() == 0) tilName.setError(getString(R.string.tilEmptyError));
                else
                {
                    Pokemon pokemon = new Pokemon();
                    pokemon.setImage(addActivityViewModel.getImage().toString());
                    pokemon.setName(addActivityViewModel.getName());
                    pokemon.setSpecies_name(addActivityViewModel.getSpecies_name());
                    pokemon.setDescription(addActivityViewModel.getDescription());
                    pokemon.setHeight(addActivityViewModel.getHeight());
                    pokemon.setWeight(addActivityViewModel.getWeight());
                    pokemon.setSpeed(addActivityViewModel.getSpeed());
                    pokemon.setKiller_rating(addActivityViewModel.getKiller_rating());

                    repository.insertPokemon(pokemon);

                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_SELECTED && resultCode == RESULT_OK && data != null && data.getData() != null)
        {
            addActivityViewModel.setImage(data.getData());
            Glide.with(this)
                    .load(addActivityViewModel.getImage())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_insert_photo)
                            .fitCenter()
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(ivAddPhoto);
        }
    }
}

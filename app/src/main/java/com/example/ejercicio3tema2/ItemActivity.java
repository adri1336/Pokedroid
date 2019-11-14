package com.example.ejercicio3tema2;

import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.ejercicio3tema2.entity.Pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvSubtitle = findViewById(R.id.tvSubtitle);
        ImageView ivPhoto = findViewById(R.id.ivPhoto);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        tvTitle.setText(pokemon.getName());
        tvSubtitle.setText(pokemon.getSpecies_name());

        Uri uri = Uri.parse(pokemon.getImage());
        Glide.with(this)
            .load(uri)
            .apply(new RequestOptions()
                    .placeholder(R.drawable.ic_insert_photo)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL))
            .into(ivPhoto);

        TextView tvHeightValue = findViewById(R.id.tvHeightValue);
        tvHeightValue.setText(pokemon.getHeight() + "m");

        TextView tvWeightValue = findViewById(R.id.tvWeightValue);
        tvWeightValue.setText(pokemon.getWeight() + "kg");

        TextView tvSpeedValue = findViewById(R.id.tvSpeedValue);
        tvSpeedValue.setText(pokemon.getSpeed() + "km/h");

        TextView tvKillerRatingValue = findViewById(R.id.tvKillerRatingValue);
        tvKillerRatingValue.setText(pokemon.getKiller_rating() + "");

        TextView tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setText(pokemon.getDescription() + "");
    }

}

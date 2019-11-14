package com.example.ejercicio3tema2.view;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddActivityViewModel extends AndroidViewModel
{
    private Uri image;
    private String name, species_name, description;
    private int height, weight, speed, killer_rating;

    public AddActivityViewModel(@NonNull Application application)
    {
        super(application);
        this.height = 5;
        this.weight = 500;
        this.speed = 60;
        this.killer_rating = 5;
    }

    public Uri getImage()
    {
        return image;
    }

    public void setImage(Uri image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSpecies_name()
    {
        return species_name;
    }

    public void setSpecies_name(String species_name)
    {
        this.species_name = species_name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getKiller_rating()
    {
        return killer_rating;
    }

    public void setKiller_rating(int killer_rating)
    {
        this.killer_rating = killer_rating;
    }
}

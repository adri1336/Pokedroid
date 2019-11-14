package com.example.ejercicio3tema2.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "pokemon")
public class Pokemon implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    private String image;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String species_name;

    @ColumnInfo
    private String description;

    @ColumnInfo
    private double height;

    @ColumnInfo
    private double weight;

    @ColumnInfo
    private double speed;

    @ColumnInfo
    private double killer_rating;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
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

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getKiller_rating()
    {
        return killer_rating;
    }

    public void setKiller_rating(double killer_rating)
    {
        this.killer_rating = killer_rating;
    }
}

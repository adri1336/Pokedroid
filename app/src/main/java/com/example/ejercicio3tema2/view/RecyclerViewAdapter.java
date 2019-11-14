package com.example.ejercicio3tema2.view;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.ejercicio3tema2.R;
import com.example.ejercicio3tema2.entity.Pokemon;
import com.example.ejercicio3tema2.model.RecyclerViewListener;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private List<Pokemon> pokemons;
    private Context context;
    private RecyclerViewListener recyclerViewListener;

    public RecyclerViewAdapter(Context context, RecyclerViewListener recyclerViewListener)
    {
        this.context = context;
        this.recyclerViewListener = recyclerViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Pokemon pokemon = pokemons.get(position);

        if(ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
        {
            if(pokemon.getImage() != null && pokemon.getImage().length() > 0)
            {
                Uri uri = Uri.parse(pokemon.getImage());
                Glide.with(context)
                    .load(uri)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_insert_photo)
                            .fitCenter()
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(holder.ivPhoto);
            }
        }

        holder.tvTitle.setText(pokemon.getName());
        holder.tvSubtitle.setText(pokemon.getSpecies_name());
        holder.clItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                recyclerViewListener.onClick(pokemon);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        int count = 0;
        if(pokemons != null) count = pokemons.size();
        return count;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private ConstraintLayout clItem;
        private ImageView ivPhoto;
        private TextView tvTitle, tvSubtitle;

        ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            clItem = itemView.findViewById(R.id.clItem);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
        }
    }

    public void setPokemons(List<Pokemon> pokemons)
    {
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }

    public List<Pokemon> getPokemons()
    {
        return this.pokemons;
    }
}

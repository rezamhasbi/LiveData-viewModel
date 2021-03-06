package com.example.tutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial.R;
import com.example.tutorial.model.movie.MovieDiscoverResultsItem;

import java.util.ArrayList;

public class MovieDiscoverAdapter extends RecyclerView.Adapter<MovieDiscoverAdapter.ViewHolder> {

    private Context context;
    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185";

    public MovieDiscoverAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<MovieDiscoverResultsItem> movieDiscoverItems = new ArrayList<>();
    public void setData(ArrayList<MovieDiscoverResultsItem> items){
        movieDiscoverItems.clear();
        movieDiscoverItems.addAll(items);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MovieDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDiscoverAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+movieDiscoverItems.get(position)
                .getPosterPath())
                .into(holder.ivThumb);

        holder.tvTitle.setText(movieDiscoverItems.get(position).getTitle());
        holder.tvRate.setText(movieDiscoverItems.get(position).getVoteAverage()+"");



    }

    @Override
    public int getItemCount() {
        return movieDiscoverItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        TextView tvTitle,tvRate;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_title);
            tvRate = itemView.findViewById(R.id.itemlist_tv_rate);
            cvItem = itemView.findViewById(R.id.itemlist_cv);

        }
    }
}

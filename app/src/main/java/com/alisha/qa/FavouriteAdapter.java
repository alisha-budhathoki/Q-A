package com.alisha.qa;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.JsonUtils;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>{
    List<FavouriteModel> mList;
    Context context;
    Boolean isLiked = false;


    public FavouriteAdapter(Context context, List<FavouriteModel> mList){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public FavouriteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite, parent, false);
        FavouriteAdapter.MyViewHolder vh = new FavouriteAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final FavouriteAdapter.MyViewHolder holder, final int position) {
        final FavouriteModel favouriteModel =mList.get(position);

        holder.favVideoImage.setImageResource(favouriteModel.getFavouriteImg());
        holder.noFavouriteLikes.setText(favouriteModel.getFavLikes());
        holder.loveReact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("c shcsh");
                if (isLiked == false) {
                    isLiked = true;
                    holder.loveReact.setColorFilter(Color.rgb(255, 0, 0));
                } else {
                    isLiked = false;
                    holder.loveReact.setColorFilter(Color.rgb(0, 0, 0));
                }
            }
        });
//        holder.noFavouriteLikes.setOnStateChangeListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("daksnsj");
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        //        VideoView favouriteVideo;
        Button noFavouriteLikes;
        ImageView favVideoImage, loveReact;

        public MyViewHolder(View itemView) {
            super(itemView);
            favVideoImage = itemView.findViewById(R.id.iv_fvrt);
            noFavouriteLikes = itemView.findViewById(R.id.txt_likes_fvrt);
            loveReact = itemView.findViewById(R.id.ic_fvrtLove);
        }


    }

}

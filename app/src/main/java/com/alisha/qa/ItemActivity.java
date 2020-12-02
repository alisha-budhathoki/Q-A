package com.alisha.qa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {
    private int[] favrtVideoPic = new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    private String[] favNoLikes = new String[]{"2k", "1k", "6k", "2k", "1k"};

    FavouriteAdapter favouriteAdapter;
    RecyclerView recyclerViewFvrt;
    ArrayList<FavouriteModel> mListFvrtModl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        recyclerViewFvrt = findViewById(R.id.recycler_fvrt);
        recyclerViewFvrt.setNestedScrollingEnabled(false);

        mListFvrtModl = seeFavourites();
        favouriteAdapter = new FavouriteAdapter(getApplicationContext(), mListFvrtModl);
        recyclerViewFvrt.setAdapter(favouriteAdapter);
        recyclerViewFvrt.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }

    private ArrayList<FavouriteModel> seeFavourites() {
        ArrayList<FavouriteModel> listFavourites = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FavouriteModel favouriteModel = new FavouriteModel();
            favouriteModel.setFavLikes(favNoLikes[i]);
            favouriteModel.setFavouriteImg(favrtVideoPic[i]);

            listFavourites.add(favouriteModel);
        }
        return listFavourites;

    }
}

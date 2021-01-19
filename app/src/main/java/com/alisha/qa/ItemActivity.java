package com.alisha.qa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {
    private int[] favrtVideoPic = new int[]{R.drawable.bkgrnd, R.drawable.bkgrnd, R.drawable.bkgrnd, R.drawable.bkgrnd, R.drawable.bkgrnd};
    private String[] favNoLikes = new String[]{"2sajkdkk", "1njssdk", "6ksdsa", "2ksdsd", "1k"};

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

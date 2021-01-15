package com.alisha.qa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class OnBoardActivity extends AhoyOnboarderActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOnBoard();

    }

    private void initOnBoard() {
        //Onboarding Cards
        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Welcome to the exam app", "test", R.drawable.test);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("Choose the option for best answer", "trest", R.drawable.testt);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("Good luck with your exam", "test", R.drawable.exam);

        ahoyOnboarderCard1.setBackgroundColor(R.color.white);
        ahoyOnboarderCard2.setBackgroundColor(R.color.white);
        ahoyOnboarderCard3.setBackgroundColor(R.color.white);
        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.black);
            page.setDescriptionColor(R.color.grey_600);
        }

        setFinishButtonTitle("Finish");
        showNavigationControls(true);

        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.solid_one);
        colorList.add(R.color.solid_two);
        colorList.add(R.color.solid_three);

        setColorBackground(colorList);



        setOnboardPages(pages);

        //for first time run only
        SharedPreferences preferences = getSharedPreferences("Activitypref", Context.MODE_PRIVATE);
        if (preferences.getString("myconstant", null) == null){


        }
        else {
            onFinishButtonPressed();
        }

    }


    @Override
    public void onFinishButtonPressed() {
        startActivity(new Intent(OnBoardActivity.this, MainActivity.class));
        finish();

    }
}

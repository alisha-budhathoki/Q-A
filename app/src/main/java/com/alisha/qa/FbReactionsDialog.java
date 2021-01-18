package com.alisha.qa;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.alisha.qa.model.ReactionListener;

public class FbReactionsDialog extends DialogFragment implements View.OnClickListener {
    View view;
    ImageView like_react, love_react, sad_react, angry_react, haha_react;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_fb_reaction, container, false);
        initializeComponents();
        return view;
    }

    private void initializeComponents() {
        if (getView() == null) return;
        like_react = view.findViewById(R.id.likeBtn);
        love_react = view.findViewById(R.id.loveBtn);
        angry_react = view.findViewById(R.id.angryBtn);
        haha_react = view.findViewById(R.id.hahaBtn);
        sad_react = view.findViewById(R.id.sadBtn);

        like_react.setOnClickListener(this);
        love_react.setOnClickListener(this);
        haha_react.setOnClickListener(this);
        sad_react.setOnClickListener(this);
        angry_react.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @Override
    public void onClick(View v) {
        System.out.println("item here clicked");
        switch (v.getId()) {
            case R.id.likeBtn:
                System.out.println("Like reaction selected");
                reactionListener.onReactionSelected(0);
                getDialog().dismiss();
                break;
            case R.id.loveBtn:
                reactionListener.onReactionSelected(1);
                getDialog().dismiss();
                break;
            case R.id.hahaBtn:
                reactionListener.onReactionSelected(2);
                getDialog().dismiss();
                break;
            case R.id.sadBtn:
                reactionListener.onReactionSelected(3);
                getDialog().dismiss();
                break;
            case R.id.angryBtn:
                reactionListener.onReactionSelected(4);
                getDialog().dismiss();
                break;

        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        WindowManager.LayoutParams manager = new WindowManager.LayoutParams();
        manager.width = WindowManager.LayoutParams.MATCH_PARENT;
        manager.height = WindowManager.LayoutParams.WRAP_CONTENT;
        manager.dimAmount = 0.0f;
        dialog.getWindow().getDecorView().setBackground(getResources().getDrawable(R.color.black_transparent));
        dialog.setCanceledOnTouchOutside(true);
        dialog.onBackPressed();
    }

    ReactionListener reactionListener;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            reactionListener = (ReactionListener) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString());
        }
    }
}

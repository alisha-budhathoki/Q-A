package com.alisha.qa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.alisha.qa.model.ReactionListener;

public class ReactionScreen extends AppCompatActivity implements ReactionListener {
    Button fbReaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reaction);

        fbReaction = findViewById(R.id.buttonReaction);
        fbReaction.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                getReactionsDialog();
                return false;
            }
        });
    }
    private DialogFragment getReactionsDialog(){
        FbReactionsDialog fbReactionsDialog = new FbReactionsDialog();
        fbReactionsDialog.show(getSupportFragmentManager(), fbReactionsDialog.getClass().getSimpleName());
        return fbReactionsDialog;
    }

    @Override
    public void onReactionSelected(int reactionType) {
        switch (reactionType){
            case 0:
                fbReaction.setText("Like");
                System.out.println("Like secleted");
                break;
            case 1:
                fbReaction.setText("love");
                System.out.println("LOVE SELECTED");
                break;
            case 2:
                fbReaction.setText("Haha");
                break;
            case 3:
                fbReaction.setText("Sad");
                break;
            case 4:
                fbReaction.setText("Angry");
                break;
        }
    }
}

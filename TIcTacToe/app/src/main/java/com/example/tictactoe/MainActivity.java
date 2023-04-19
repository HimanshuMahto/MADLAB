package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClick=-1;
    static int player=0;
    int[][] winningState ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] gameState ={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageClick=gameState[tag];
        if(!isWinner && imageClick==-1) {
            if(player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                player = 0;
            } else {
                v.setImageResource(R.drawable.circle);
                gameState[tag] = player;
                player = 1;
            }
            for (int[] ints : winningState) {
                if (gameState[ints[0]] == gameState[ints[1]] && gameState[ints[1]] == gameState[ints[2]] && gameState[ints[0]] > -1) {
                    Toast.makeText(this, "Player " + (player == 0 ? 1 : 0) + " wins", Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }
    public void reset(View view) {
        androidx.gridlayout.widget.GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClick=-1;
        player=1;
        Arrays.fill(gameState, -1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package com.priyank.tictactoe;


import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean isW=false;
    int ic=-1;
    int player=1;
    int[][]winners={{0,1,2},{3,4,5},{6,7,8}};
    int []game={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){

        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        ic=game[tag];
        if(isW==false&&ic==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                game[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                game[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winners.length; i++) {
                if (game[winners[i][0]] == game[winners[i][1]] && game[winners[i][1]] == game[winners[i][2]] && game[winners[i][0]] > -1) {
                    Toast.makeText(this, "Winner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isW=true;
                }
            }
        }
    }
    public void  reset(View view) {
        GridLayout grid=findViewById(R.id.grid);
        int total=grid.getChildCount();
        for(int i=0;i<total;i++){
            ImageView v=(ImageView)grid.getChildAt(i);
            v.setImageDrawable(null);
        }
        isW=false;
        ic=-1;
        player=1;
        for(int i=0;i<game.length;i++){
            game[i]=-1;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
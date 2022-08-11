package com.example.tictac_game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
boolean gameactive=true;
int activeplayer=0;
int[] gamestate={2,2,2,2,2,2,2,2,2};
int[][] winpostions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
public static int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playerTap(View view) {
        ImageView img =(ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            gamereset(view);
        }
        if(gamestate[tappedimage]==2)
        {
            counter++;
            if(counter==9)
            {
                gameactive=false;
            }
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer==0)
            {
                img.setImageResource(R.drawable.xx);
                activeplayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn----Tap To Play Again");
            }
            else
            {
                img.setImageResource(R.drawable.oo);
                activeplayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn----Tap To Play Again");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        int flag = 0;
        for (int[] winPosition: winpostions)
        {
            if(gamestate[winPosition[0]] == gamestate[winPosition[1]] && gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]] != 2)
            {
                flag = 1;
                String winnerStr;
                gameactive = false;
                if(gamestate[winPosition[0]] == 0)
                {
                    winnerStr = "X has Won now...";
                }
                else
                {
                    winnerStr = "O has Won now...";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }

        }
        if(counter == 9 && flag == 0)
        {
            TextView status = findViewById(R.id.status);
            status.setText("Match Draw");
        }
    }

    public void gamereset(View view)
    {
        gameactive = true;
        activeplayer = 0;
        for(int i = 0; i< gamestate.length; i++)
        {
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn --- Tap to play again...");
    }
}
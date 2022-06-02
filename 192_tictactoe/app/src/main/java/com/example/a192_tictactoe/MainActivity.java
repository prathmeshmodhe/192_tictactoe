package com.example.a192_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClick=-1;
    int player=1;
    int [][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}}; // this array contains winning conditions
    int [] game={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int [] tour={};
    int one=0;
    int two=0;
    //for(int time=0;time<3;time++)
    //{
        public void load (View view){

            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            if (isWinner != true && imageClick == -1) {
                       if (player == 1) {
                          v.setImageResource(R.drawable.cross);
                          game[tag] = player;
                          Toast.makeText(this, tag + "-" + "cross", Toast.LENGTH_SHORT).show();
                          player = 0;
                        } else {
                           v.setImageResource(R.drawable.zero);
                           game[tag] = player;
                           Toast.makeText(this, tag + "-" + "zero", Toast.LENGTH_SHORT).show();
                           player = 1;
                       }

                     for (int i = 0; i < win.length; i++) {
                            if (game[win[i][0]] == game[win[i][1]] && game[win[i][1]] == game[win[i][2]] && game[win[i][0]] > -1) {
                                 Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 2), Toast.LENGTH_SHORT).show();
                                 if (player == 0) {
                                         one++;
                                  } else {
                                         two++;
                                 }
                               isWinner = true;
                            }
                     }
            }
       }
    //}
/*
    if(one<two){
        Toast.makeText(this, " Tournament Winner is Player 2" , Toast.LENGTH_SHORT).show();
    }
    else{
        Toast.makeText(this, " Tournament Winner is Player 1" , Toast.LENGTH_SHORT).show();
    }
*/
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClick=-1;
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

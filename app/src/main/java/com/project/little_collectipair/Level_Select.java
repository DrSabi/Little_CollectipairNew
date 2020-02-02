package com.project.little_collectipair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageButton;
import android.view.View;

public class Level_Select extends AppCompatActivity {
    private ImageButton b_lvl_1;
    private ImageButton b_lvl_2;
    private ImageButton b_lvl_3;
    private ImageButton b_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.level_select);

        b_lvl_1 = (ImageButton) findViewById(R.id.b_lvl1);
        b_lvl_2 = (ImageButton) findViewById(R.id.b_lvl2);
        b_lvl_3 = (ImageButton) findViewById(R.id.b_lvl3);

        b_back = (ImageButton) findViewById(R.id.b_back);


        View.OnClickListener myhandler1 = new View.OnClickListener() {
            public void onClick(View v) {
                firstLvlClicked();
            }
        };

        View.OnClickListener myhandler2 = new View.OnClickListener() {
            public void onClick(View v) {
                secondLvlClicked();
            }
        };

        View.OnClickListener myhandler3 = new View.OnClickListener() {
            public void onClick(View v) {
                thirdLvlClicked();
            }
        };

        View.OnClickListener myhandler4 = new View.OnClickListener() {
            public void onClick(View v) {
                backButtonClicked();
            }
        };

        b_lvl_1.setOnClickListener(myhandler1);
        b_lvl_2.setOnClickListener(myhandler2);
        b_lvl_3.setOnClickListener(myhandler3);
        b_back.setOnClickListener(myhandler4);
    }

    private void firstLvlClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("LVL_ID", 1);
        startActivity(intent);
    }

    private void secondLvlClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("LVL_ID", 2);
        startActivity(intent);
    }

    private void thirdLvlClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("LVL_ID", 3);
        startActivity(intent);
    }

    private void backButtonClicked() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}

package com.project.little_collectipair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;

public class Level_Select extends AppCompatActivity {
    private Button b_lvl_1;
    private Button b_lvl_2;
    private Button b_lvl_3;
    private Button b_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.level_select);

        b_lvl_1 = (Button) findViewById(R.id.b_lvl1);
        b_lvl_2 = (Button) findViewById(R.id.b_lvl2);
        b_lvl_3 = (Button) findViewById(R.id.b_lvl3);

        b_back = (Button) findViewById(R.id.b_back);


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
        startActivity(intent);
    }

    private void secondLvlClicked() {
        b_lvl_2.setText("AWESOME!");
    }

    private void thirdLvlClicked() {
        b_lvl_3.setText("AWESOME!");
    }

    private void backButtonClicked() {
        b_back.setText("AWESOME!");
    }

}

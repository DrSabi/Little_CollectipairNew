package com.project.little_collectipair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageButton;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);

        nextButton = (ImageButton) findViewById(R.id.b1);
        closeButton = (ImageButton) findViewById(R.id.b2);
        View.OnClickListener myhandler1 = new View.OnClickListener() {
            public void onClick(View v) {
                nextButtonClicked();
            }
        };

        View.OnClickListener myhandler2 = new View.OnClickListener() {
            public void onClick(View v) {
                closeButtonClicked();
            }
        };

        nextButton.setOnClickListener(myhandler1);
        closeButton.setOnClickListener(myhandler2);
    }

    private void nextButtonClicked() {

        Intent intent = new Intent(this, Level_Select.class);
        startActivity(intent);

    }

    private void closeButtonClicked() {
        finish();
    }

}

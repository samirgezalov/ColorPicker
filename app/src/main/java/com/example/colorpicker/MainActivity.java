package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    VerticalSeekBar red;
    VerticalSeekBar green;
    VerticalSeekBar blue;
    LinearLayout mainLayout;
    LinearLayout childLayout;

    TextView redText;
    TextView greenText;
    TextView blueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);

        redText = findViewById(R.id.redText);
        greenText = findViewById(R.id.greenText);
        blueText = findViewById(R.id.blueText);

        mainLayout = findViewById(R.id.mainLayout);
        childLayout = findViewById(R.id.childLayout);

        mainLayout.setBackgroundColor(Color.rgb(0,0,0));
        childLayout.setBackgroundColor
                (Color.rgb(255-red.getProgress(),255-green.getProgress(),255-blue.getProgress()));



        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                redText.setText(red.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub

                mainLayout.setBackgroundColor(
                        Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));


                    childLayout.setBackgroundColor
                            (Color.rgb(255-red.getProgress(),255-green.getProgress(),255-blue.getProgress()));



                redText.setText("R: "+red.getProgress()+"");
                redText.setTextColor(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));

                greenText.setText("G: "+green.getProgress()+"");
                greenText.setTextColor(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));

                blueText.setText("B: "+blue.getProgress()+"");
                blueText.setTextColor(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));



            }
        };

        red.setOnSeekBarChangeListener(listener);
        green.setOnSeekBarChangeListener(listener);
        blue.setOnSeekBarChangeListener(listener);

    }
}

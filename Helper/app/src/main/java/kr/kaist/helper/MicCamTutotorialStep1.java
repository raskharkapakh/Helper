package kr.kaist.helper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MicCamTutotorialStep1 extends AppCompatActivity {

    private int step;
    private TextView progressText;
    private TextView taskText;
    private ImageView instructionImage;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mic_cam_tutotorial_step1);

        step = 1;
        progressText =  findViewById(R.id.progressText);
        taskText =  findViewById(R.id.taskText);
        instructionImage=  findViewById(R.id.instructionImage);
        startButton = findViewById(R.id.buttonStart);



        instructionImage.setImageResource(R.drawable.introcammic);
        progressText.setText("Welcome! In this Tutorial we show you how to disable/enable your camera and microphone");
        taskText.setText("Right now, your microphone is enabled and your camera disabled. If you are ready, press the Button");

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStep2();
            }
        };
        startButton.setOnClickListener(buttonListener);


    }

    private void goToStep2() {
        
    }
}

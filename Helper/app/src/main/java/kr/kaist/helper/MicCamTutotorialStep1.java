package kr.kaist.helper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MicCamTutotorialStep1 extends AppCompatActivity {

    private int step;
    private TextView stepText;
    private TextView instructionText;
    private ImageView instructionImage;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mic_cam_tutotorial_step1);

        step = 1;
        stepText =  findViewById(R.id.stepText);
        instructionText =  findViewById(R.id.instructionText);
        instructionImage=  findViewById(R.id.instructionImage);

        instructionImage.setImageResource(R.drawable.startscreencammic);
        stepText.setText("Welcome! In this Tutorial we show you how to disable/enable your camera and microphone");
        instructionText.setText("Right now, your microphone is enabled and your camera disabled. If you are ready, press the Button");

    }
}

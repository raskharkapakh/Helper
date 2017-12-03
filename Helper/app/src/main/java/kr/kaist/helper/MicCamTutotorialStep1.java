package kr.kaist.helper;

import android.content.Intent;
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
    private Button hiddenMicButton;
    private Button hiddenCamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mic_cam_tutotorial_step1);

        step = 1;
        progressText =  findViewById(R.id.progressText);
        taskText =  findViewById(R.id.taskText);
        instructionImage=  findViewById(R.id.instructionImage);
        startButton = findViewById(R.id.buttonStart);
        hiddenMicButton = findViewById(R.id.MicButton);
        hiddenCamButton = findViewById(R.id.CamButton);




        instructionImage.setImageResource(R.drawable.startscreencammicscaled);
        progressText.setText("Welcome! In this Tutorial we show you how to disable/enable your camera and microphone");
        taskText.setText("Right now, your microphone is enabled and your camera disabled. If you are ready, press the Button");

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(step==4){
                    Intent intent = new Intent(MicCamTutotorialStep1.this, SkypeTutorial.class);
                    startActivity(intent);
                }else{
                goToStep2();
                }
            }
        };
        startButton.setOnClickListener(buttonListener);


    }

    private void goToStep2() {
        /*ViewGroup layout = (ViewGroup) startButton.getParent();
        if(null!=layout) //for safety only  as you are doing onClick
            layout.removeView(startButton);*/
        startButton.setVisibility(View.GONE);
        startButton.setClickable(false);
        instructionImage.setImageResource(R.drawable.mutemictaskscaled);
        progressText.setText("Step 1");
        taskText.setText("Click the microhpone button to disable it.");
        View.OnClickListener micButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStep3();
            }
        };
        hiddenMicButton.setOnClickListener(micButtonListener);

    }

    private void goToStep3() {
        hiddenMicButton.setClickable(false);
        instructionImage.setImageResource(R.drawable.activatecamtaskmicmutedscaled);
        progressText.setText("Step 2");
        taskText.setText("Well done! Now click the camera button to enable it.");
        View.OnClickListener camButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStep4();
            }
        };
        hiddenCamButton.setOnClickListener(camButtonListener);
    }

    private void goToStep4() {
        step = 4;
        hiddenCamButton.setClickable(false);
        startButton.setVisibility(View.VISIBLE);
        startButton.setClickable(true);
        instructionImage.setImageResource(R.drawable.done);
        progressText.setText("Congratulations! You are done!");
        taskText.setText("Click the Button to return to the menu");
        startButton.setText("Menu");


    }
}

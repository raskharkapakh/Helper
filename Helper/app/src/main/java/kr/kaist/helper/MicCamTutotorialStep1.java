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
        progressText.setText("어서오세요! 카메라와 마이크를 끄고 켜보기를 해볼게요");
        taskText.setText("지금은 마이크가 켜져있고 카메라가 꺼져있어요. 준비가 되셨다면 시작버튼을 눌러주세요");

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(step==4){
                    //Intent intent = new Intent(MicCamTutotorialStep1.this, SkypeTutorial.class);
                    //startActivity(intent);
                    finish();
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
        progressText.setText("1단계");
        taskText.setText("음소거 버튼을 눌러서 마이크를 꺼보세요");
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
        progressText.setText("2단계");
        taskText.setText("영상버튼을 눌러서 카메라를 켤 수 있어요");
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
        progressText.setText("");
        taskText.setText("축하드려요! 이렇게 카메라와 마이크를 키고 끌 수 있어요");
        startButton.setText("돌아가기");


    }
}

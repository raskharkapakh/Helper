package kr.kaist.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class CallSomeoneTutorial1 extends AppCompatActivity {
    private int step;
    private TextView stepText;
    private TextView instructionText;
    private ImageView instructionImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_someone_tutorial1);

        step = 1;
        stepText = (TextView) findViewById(R.id.stepText);
        instructionText = (TextView) findViewById(R.id.instructionText);
        instructionImage= (ImageView) findViewById(R.id.instructionImage);
        instructionImage.setImageResource(R.drawable.callsomeone1);
    }

    public void goToStep2(View view) {
        if (step == 1){
            stepText.setText("2단계");
            instructionText.setText("음성 통화를 누르세요");
            instructionImage.setImageResource(R.drawable.callsomeone2);
            step++;
        }
    }

    public void goToStep3(View view) {
        if (step == 2){
            stepText.setText("3단계");
            instructionText.setText("전화하고 싶은 연락처를 누르세요");
            instructionImage.setImageResource(R.drawable.callsomeone3);
            step++;
        }
    }

    public void goToStep4(View view) {
        if (step == 3){
            stepText.setText("4단계");
            instructionText.setText("전화기 버튼을 눌러 전화를 거세요");
            instructionImage.setImageResource(R.drawable.callsomeone4);
            step++;
        }
    }

    public void goToStep4or5(View view){
        if (step == 3) {
            stepText.setText("4단계");
            instructionText.setText("전화기 버튼을 눌러 전화를 거세요");
            instructionImage.setImageResource(R.drawable.callsomeone4);
            step++;
        }
        else if (step == 4) {
            stepText.setText("5단계");
            instructionText.setText("상대방이 받으면 통화가 진행되요. 빨간 전화기를 눌러 전화를 끊을 수 있어요");
            instructionImage.setImageResource(R.drawable.callsomeone5);
            step++;

        }
    }

    public void goToStep6OrBack(View view){
        if (step == 5){
            stepText.setText("");
            instructionText.setText("축하드려요! 이렇게 전화를 거실 수 있어요");
            instructionImage.setImageResource(R.drawable.done);
            Button back = (Button) findViewById(R.id.step6andBack);
            back.setText("돌아가기");
            step++;
        }
        else if (step == 6){
            //Intent intent = new Intent(this, SkypeTutorial.class);
            //startActivity(intent);
            finish();
        }

    }
}

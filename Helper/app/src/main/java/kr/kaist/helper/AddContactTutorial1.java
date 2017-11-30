package kr.kaist.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class AddContactTutorial1 extends AppCompatActivity {
    private int step;
    private TextView stepText;
    private TextView instructionText;
    private ImageView instructionImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_tutorial1);

        step = 1;
        stepText = (TextView) findViewById(R.id.stepText);
        instructionText = (TextView) findViewById(R.id.instructionText);
        instructionImage= (ImageView) findViewById(R.id.instructionImage);

        instructionImage.setImageResource(R.drawable.addcontact1);
    }

    public void goToStep2or5(View view){
        if (step == 1) {
            stepText.setText("2단계");
            instructionText.setText("+버튼을 누르세요");
            instructionImage.setImageResource(R.drawable.addcontact2);
            step++;
        }
        else if (step == 4){
            stepText.setText("5단계");
            instructionText.setText("연락처를 찾았다면 누르세요");
            instructionImage.setImageResource(R.drawable.addcontact5);
            step++;
        }
    }

    public void goToStep3(View view){
        if (step == 2) {
            stepText.setText("3단계");
            instructionText.setText("사람 찾기 버튼을 누르세요");
            instructionImage.setImageResource(R.drawable.addcontact3);
            step++;
        }
    }

    public void goToStep4(View view){
        if (step == 3) {
            stepText.setText("4단계");
            instructionText.setText("검색칸을 누르고 이름을 검색해보세요");
            instructionImage.setImageResource(R.drawable.addcontact4);
            step++;
        }
    }

    public void goToStep5(View view){
        if (step == 4) {
            stepText.setText("5단계");
            instructionText.setText("연락처를 찾았다면 누르세요"); //make sure that it is what the korean text says
            instructionImage.setImageResource(R.drawable.addcontact5);
            step++;
        }
    }

    public void goToStep6(View view){
        if (step == 5) {
            stepText.setText("6단계");
            instructionText.setText("연락처에 추가 버튼을 누르세요");
            instructionImage.setImageResource(R.drawable.addcontact6);
            step++;
        }
    }

    public void goToStep7(View view){
        if (step == 6){
            stepText.setText("");
            instructionText.setText("축하드립니다! 연락처 등록을 성공하셨어요!");
            instructionImage.setImageResource(R.drawable.done);
            Button back = (Button) findViewById(R.id.back);
            back.setText("돌아가기");
            step++;
        }
    }
    public void goToSkypeTutorialScreen(View view){
        if (step == 7){
            //Intent intent = new Intent(this, SkypeTutorial.class);
            //startActivity(intent);
            finish();
        }

    }

}

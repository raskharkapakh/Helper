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
        getSupportActionBar().hide();

        step = 1;
        stepText = (TextView) findViewById(R.id.stepText);
        instructionText = (TextView) findViewById(R.id.instructionText);
        instructionImage= (ImageView) findViewById(R.id.instructionImage);
        instructionImage.setImageResource(R.drawable.callsomeone1);
    }

    public void goToStep2(View view) {
        if (step == 1){
            stepText.setText("Step 2");
            instructionText.setText("Click on the 'phone' icon");
            instructionImage.setImageResource(R.drawable.callsomeone2);
            step++;
        }
    }

    public void goToStep3(View view) {
        if (step == 2){
            stepText.setText("Step 3");
            instructionText.setText("Click on the contact you want to call");
            instructionImage.setImageResource(R.drawable.callsomeone3);
            step++;
        }
    }

    public void goToStep4(View view) {
        if (step == 3){
            stepText.setText("Step 4");
            instructionText.setText("Click on the 'call' icon");
            instructionImage.setImageResource(R.drawable.callsomeone4);
            step++;
        }
    }

    public void goToStep4or5(View view){
        if (step == 3) {
            stepText.setText("Step 4");
            instructionText.setText("Click on the 'call' icon");
            instructionImage.setImageResource(R.drawable.callsomeone4);
            step++;
        }
        else if (step == 4) {
            stepText.setText("Step 5");
            instructionText.setText("Click on the red 'phone' icon to hangout");
            instructionImage.setImageResource(R.drawable.callsomeone5);
            step++;

        }
    }

    public void goToStep6OrBack(View view){
        if (step == 5){
            stepText.setText("");
            instructionText.setText("Congratulations, you are done !");
            instructionImage.setImageResource(R.drawable.done);
            Button back = (Button) findViewById(R.id.step6andBack);
            back.setText("back to tutorials");
            step++;
        }
        else if (step == 6){
            Intent intent = new Intent(this, SkypeTutorial.class);
            startActivity(intent);
        }

    }
}

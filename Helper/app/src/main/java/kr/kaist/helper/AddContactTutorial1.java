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
        getSupportActionBar().hide();


        step = 1;
        stepText = (TextView) findViewById(R.id.stepText);
        instructionText = (TextView) findViewById(R.id.instructionText);
        instructionImage= (ImageView) findViewById(R.id.instructionImage);

        instructionImage.setImageResource(R.drawable.addcontact1);
    }

    public void goToStep2or5(View view){
        if (step == 1) {
            stepText.setText("Step 2");
            instructionText.setText("Click the '+' in the circle");
            instructionImage.setImageResource(R.drawable.addcontact2);
            step++;
        }
        else if (step == 4){
            stepText.setText("Step 5");
            instructionText.setText("Click on the contact when you have found it");
            instructionImage.setImageResource(R.drawable.addcontact5);
            step++;
        }
        //testing purpose
        /*else if (step == 2){
            stepText.setText("Step 1");
            instructionText.setText("Instruction 1");
            instructionImage.setImageResource(R.drawable.addcontact1);
            step--;
        }*/
    }

    public void goToStep3(View view){
        if (step == 2) {
            stepText.setText("Step 3");
            instructionText.setText("Click on the 'add contact' icon");
            instructionImage.setImageResource(R.drawable.addcontact3);
            step++;
        }
    }

    public void goToStep4(View view){
        if (step == 3) {
            stepText.setText("Step 4");
            instructionText.setText("Click on the search bar and type a name to add");
            instructionImage.setImageResource(R.drawable.addcontact4);
            step++;
        }
    }

    public void goToStep5(View view){
        if (step == 4) {
            stepText.setText("Step 5");
            instructionText.setText("Click on the contact when you have found it"); //make sure that it is what the korean text says
            instructionImage.setImageResource(R.drawable.addcontact5);
            step++;
        }
    }

    public void goToStep6(View view){
        if (step == 5) {
            stepText.setText("Step 6");
            instructionText.setText("Send a request to the contact");
            instructionImage.setImageResource(R.drawable.addcontact6);
            step++;
        }
    }

    public void goToStep7(View view){
        if (step == 6){
            stepText.setText("");
            instructionText.setText("Congratulations, you are done !");
            instructionImage.setImageResource(R.drawable.done);
            Button back = (Button) findViewById(R.id.back);
            back.setText("back to tutorials");
            step++;
        }
    }
    public void goToSkypeTutorialScreen(View view){
        if (step == 7){
            Intent intent = new Intent(this, SkypeTutorial.class);
            startActivity(intent);
        }

    }

}

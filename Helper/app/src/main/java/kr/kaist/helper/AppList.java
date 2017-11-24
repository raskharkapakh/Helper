package kr.kaist.helper;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class AppList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        Button skypeButton = findViewById(R.id.skypeButton);

        skypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder skypeAlertBuilder = new AlertDialog.Builder(AppList.this);
                //skypeAlert.setMessage("Learn or use Skype ?");
                skypeAlertBuilder.setCancelable(true);
                skypeAlertBuilder.setPositiveButton("Learn Skype", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        OpenSkypeTutorial();
                    }
                });
                skypeAlertBuilder.setNegativeButton("Use Skype", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        OpenApp("com.skype.android");
                    }
                });
                AlertDialog skypeAlert = skypeAlertBuilder.create();
                skypeAlert.setMessage("Do you want to learn how to use Skype or launch an instance of Skype ?");
                skypeAlert.setTitle("Learn or use Skype ?");
                skypeAlert.show();
            }
        });
    }

    public void OpenSkypeTutorial() {
        Intent intent = new Intent(this, SkypeTutorial.class);
        startActivity(intent);
    }

    public boolean OpenApp(String appName) {
        //TODO
        return true;
    }
}

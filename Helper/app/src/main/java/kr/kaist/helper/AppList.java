package kr.kaist.helper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

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
                        OpenApp("Skype");
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
        /**
         * Opens the Skype app if it is installed,
         * refers to the market to download it otherwise
         */
        //Note: I am not sure about the Context thing yet, and whether one has to pass a Context.
        //So far we would not need a HashMap since we only have 1 app, but this makes it easier to change it lateron
        HashMap<String,String> packageMap = new HashMap<>();
        packageMap.put("Skype","com.skype.raider");
        if (isSkypeClientInstalled()) {

            PackageManager packageManager = getPackageManager();
            Intent skypeIntent = packageManager.getLaunchIntentForPackage(packageMap.get(appName));
            startActivity(skypeIntent);

        } else {
            goToMarket();
        }
        return true;
    }

    /**
     * Install the Skype client through the market: URI scheme.
     */
    public void goToMarket() {
        Uri marketUri = Uri.parse("market://details?id=com.skype.raider");
        Intent myIntent = new Intent(Intent.ACTION_VIEW, marketUri);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(myIntent);

        return;
    }

    /**
     * Determine whether the Skype for Android client is installed on this device.
     */
    public boolean isSkypeClientInstalled() {
        PackageManager myPackageMgr = getPackageManager();
        try {
            myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            return (false);
        }
        return (true);
    }


}

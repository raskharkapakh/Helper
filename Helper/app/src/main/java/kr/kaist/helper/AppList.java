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
import android.content.Context;

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
                HashMap<String,String> packageMap = new HashMap<>();
                packageMap.put("Skype","com.skype.raider");
                if (isSkypeClientInstalled()) {
                    AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(AppList.this);
                    //skypeAlert.setMessage("Learn or use Skype ?");
                    AlertBuilder.setCancelable(true);
                    AlertBuilder.setPositiveButton("배우기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            OpenSkypeTutorial();
                        }
                    });
                    AlertBuilder.setNegativeButton("실행하기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            OpenApp("Skype");
                        }
                    });
                    AlertDialog Alert = AlertBuilder.create();
                    Alert.setMessage("스카이프를 배우고싶으신가요? 실행하고 싶으신가요?");
                    Alert.setTitle("스카이프 실행");
                    Alert.show();
                }
                else {
                    AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(AppList.this);
                    //skypeAlert.setMessage("Learn or use Skype ?");
                    AlertBuilder.setCancelable(true);
                    AlertBuilder.setPositiveButton("다운로드", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            goToMarket("market://details?id=com.skype.raider");
                        }
                    });
                    AlertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog Alert = AlertBuilder.create();
                    Alert.setMessage("스카이프를 다운로드 하시겠습니까?");
                    Alert.setTitle("다운로드");
                    Alert.show();
                }
            }
        });

        Button kakaoButton = findViewById(R.id.kakaoTaxiButton);

        kakaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadOrOpen("com.kakao.taxi");
            }
        });

        Button tossButton = findViewById(R.id.tossButton);

        tossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadOrOpen("viva.republica.toss");
            }
        });

        Button youtubeButton = findViewById(R.id.youtubeButton);

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadOrOpen("com.google.android.youtube");
            }
        });
    }

    public void downloadOrOpen(final String pName){
        if(!isAppInstalled(pName)) {
            AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(AppList.this);
            AlertBuilder.setCancelable(true);
            AlertBuilder.setPositiveButton("다운로드", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    goToMarket("market://details?id="+pName);
                }
            });
            AlertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog Alert = AlertBuilder.create();
            if(pName == "com.kakao.taxi")
                Alert.setMessage("카카오택시를 다운로드 하시겠습니까?");
            else if(pName == "viva.republica.toss")
                Alert.setMessage("토스를 다운로드 하시겠습니까?");
            else if(pName == "com.google.android.youtube")
                Alert.setMessage("유튜브를 다운로드 하시겠습니까?");

            Alert.setTitle("다운로드");
            Alert.show();
        }
        else{
            PackageManager packageManager = getPackageManager();
            Intent tIntent = packageManager.getLaunchIntentForPackage(pName);
            startActivity(tIntent);
        }
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
            goToMarket("market://details?id=com.skype.raider");
        }
        return true;
    }

    /**
     * Install the Skype client through the market: URI scheme.
     */
    public void goToMarket(String a) {
        Uri marketUri = Uri.parse(a);
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

    public boolean isAppInstalled(String packageName) {
        PackageManager myPackageMgr = getPackageManager();
        try {
            myPackageMgr.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            return (false);
        }
        return (true);
    }


}

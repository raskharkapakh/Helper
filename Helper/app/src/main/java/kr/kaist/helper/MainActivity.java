package kr.kaist.helper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private boolean dataSavingON;//boolean value use to store if the data is on
    private ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainImage = (ImageView) findViewById(R.id.imageView5);
        mainImage.setImageResource(R.drawable.main);
        dataSavingON = true; //TODO: get from system whether data saving is on or not
    }

    public void openAppList(View view) {
        Intent intent = new Intent(this, AppList.class);
        startActivity(intent);
    }

    public void DataOnOff(View view) {
        dataSavingON = !dataSavingON;
        Button button = (Button)view;
        if (dataSavingON) button.setText(" Data saving: ON");
        else button.setText(" Data saving: OFF");
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }


    public void exit(View view) {
        System.exit(0);
    }
}

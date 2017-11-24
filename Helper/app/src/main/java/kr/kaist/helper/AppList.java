package kr.kaist.helper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class AppList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
    }

    public void openGuide(View view) {
        Intent intent = new Intent(this,Guide_list.class);
        startActivity(intent);
    }
}

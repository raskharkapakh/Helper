package kr.kaist.helper;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.app.Service;
import android.view.LayoutInflater;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.View;
import android.view.Gravity;
import android.view.WindowManager;
import android.content.Context;



public class Guide_list extends AppCompatActivity {
    public View mView;
    public WindowManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!android.provider.Settings.canDrawOverlays(this)) {
            Intent myIntent = new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            myIntent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(myIntent, 101);
        }
        setContentView(R.layout.activity_guide_list);
    }

    public void openService(View view) {

        Intent svc = new Intent(this, TopService.class);
        startService(svc);
        /*
        mManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.floating, null);
        WindowManager.LayoutParams mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT,
                30, 30, // X, Y 좌표
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        mParams.gravity = Gravity.TOP | Gravity.LEFT;
        mManager.addView(mView, mParams);*/
    }

    public void stopService(View view) {

        Intent svc = new Intent(this, TopService.class);
        stopService(svc);
        /*
        if (mView != null) {
            mManager.removeView(mView);
            mView = null;
        }*/
    }
}

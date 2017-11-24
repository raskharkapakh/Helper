package kr.kaist.helper;

import android.app.Service;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.content.Context;
import android.view.Gravity;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by Yongseok Kwon on 2017-11-19.
 */

public class TopService extends Service{
    public View mView;
    public WindowManager mManager;
    WindowManager.LayoutParams mParams;
    boolean enter = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service Start!", Toast.LENGTH_LONG).show();
        initWindowManager();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initWindowManager();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        if (mManager != null) {
            if(mView != null) mManager.removeView(mView);
        }
        super.onDestroy();
    }

    public void initWindowManager() {
        final String appPackageName = "com.skype.raider";
        boolean installed = isAppInstalled(this, appPackageName);
        if(installed) {
            enter = true;
            Intent LaunchIntent = getPackageManager()
                    .getLaunchIntentForPackage(appPackageName);
            startActivity(LaunchIntent);
        }
        else{
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        }

        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.floating, null);
        mView.setOnTouchListener(mViewTouchListener);
        //mView = new floatingview(this);
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }
        mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT,
                0, 0, // X, Y 좌표
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,// | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        mParams.gravity = Gravity.TOP | Gravity.LEFT;
        mManager = (WindowManager) getSystemService(this.WINDOW_SERVICE);
        mManager.addView(mView, mParams);

    }

    public static boolean isAppInstalled(Context context, String packageName) {
        Log.d("aaa","aaa");
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private float mTouchX, mTouchY;
    private int mViewX, mViewY;

    private OnTouchListener mViewTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mTouchX = event.getRawX();
                    mTouchY = event.getRawY();
                    mViewX = mParams.x;
                    mViewY = mParams.y;
                    Log.d("TouchEvent Click","X : "+String.valueOf(event.getRawX())+" Y : "+String.valueOf(event.getRawY()));
                    break;

                case MotionEvent.ACTION_UP:
                    break;

                case MotionEvent.ACTION_MOVE:
                    Log.d("TouchEvent Move","X : "+String.valueOf(event.getRawX())+" Y : "+String.valueOf(event.getRawY()));
                    int x = (int) (event.getRawX() - mTouchX);
                    int y = (int) (event.getRawY() - mTouchY);

                    mParams.x = mViewX + x;
                    mParams.y = mViewY + y;

                    mManager.updateViewLayout(mView, mParams);

                    break;
            }

            return enter;
        }
    };
}


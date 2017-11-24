package kr.kaist.helper;

import android.view.ViewGroup;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by Yongseok Kwon on 2017-11-21.
 */

public class floatingview extends ViewGroup{
    private Paint mLoadPaint;

    public floatingview(Context context) {
        super(context);
        //Toast.makeText(getContext(),"HUDView", Toast.LENGTH_LONG).show();

        mLoadPaint = new Paint();
        mLoadPaint.setAntiAlias(true);
        mLoadPaint.setTextSize(10);
        mLoadPaint.setARGB(255, 255, 0, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Hello World", 5, 15, mLoadPaint);
    }

    @Override
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        //Toast.makeText(getContext(),"onTouchEvent", Toast.LENGTH_LONG).show();
        return true;
    }
}

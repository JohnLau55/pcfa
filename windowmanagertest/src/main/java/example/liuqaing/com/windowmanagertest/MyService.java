package example.liuqaing.com.windowmanagertest;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MyService extends Service {

    private Button btnView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams params;
    private boolean isAdded;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createWindowView();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private void createWindowView() {
        btnView = new Button(getApplicationContext());
        btnView.setBackgroundResource(R.mipmap.ic_launcher);
        windowManager = (WindowManager) getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        params = new WindowManager.LayoutParams();

        // 设置Window Type
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        // 设置悬浮框不可触摸
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 悬浮窗不可触摸，不接受任何事件,同时不影响后面的事件响应
        params.format = PixelFormat.RGBA_8888;
        // 设置悬浮框的宽高
        params.width = 200;
        params.height = 200;
        params.gravity = Gravity.LEFT;
        params.x = 200;
        params.y = 0;
        // 设置悬浮框的Touch监听
        btnView.setOnTouchListener(new View.OnTouchListener() {
            //保存悬浮框最后位置的变量
            int lastX, lastY;
            int paramX, paramY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        paramX = params.x;
                        paramY = params.y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) event.getRawX() - lastX;
                        int dy = (int) event.getRawY() - lastY;
                        params.x = paramX + dx;
                        params.y = paramY + dy;
                        // 更新悬浮窗位置
                        windowManager.updateViewLayout(btnView, params);
                        break;
                }
                return true;
            }
        });
        windowManager.addView(btnView, params);
        isAdded = true;
    }
}

package example.liuqaing.com.advertice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.lang.*;

import static example.liuqaing.com.advertice.MainActivity.handler;

/**
 * Created by liuqiang on 2021/5/3.
 */

public class LoopThread extends Thread {
    public static final String TAG = LoopThread.class.getName();


    @Override
    public void run() {
        super.run();

//        Looper.prepare();

//        handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                Log.d(TAG,String.valueOf(msg.what));
//            }
//        };


        Message message = handler.obtainMessage();
        message.what = 0x1;
        handler.sendMessage(message);

//        Looper.loop();

    }
}

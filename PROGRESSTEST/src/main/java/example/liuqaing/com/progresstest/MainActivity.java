package example.liuqaing.com.progresstest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    final int TIME = 100;
    private int currentStatus = 0;
    final int TIMER_MSG = 0X111;


    private ProgressBar progressBar;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(TIME - currentStatus > 0){
                Log.d(TAG ,"enter if");
                Log.d(TAG,Thread.currentThread().getName());
                currentStatus++;
                progressBar.setProgress(TIME - currentStatus);
                handler.sendEmptyMessageDelayed(TIMER_MSG,2000);
            }else{
                Toast.makeText(MainActivity.this,"游戏结束",Toast.LENGTH_SHORT).show();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        Log.d(TAG,"cur thread:"+Thread.currentThread().getName());
        handler.sendEmptyMessage(TIMER_MSG);





    }



}

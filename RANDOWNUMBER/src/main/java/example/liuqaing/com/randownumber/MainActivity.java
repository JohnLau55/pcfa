package example.liuqaing.com.randownumber;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getName();

    BinderService binderService;

    int[] tvid = {
        R.id.textView1,
        R.id.textView2,
        R.id.textView3,
        R.id.textView4,
        R.id.textView5,
        R.id.textView6,
        R.id.textView7,
    };


    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG,"onServiceConnected()");

            binderService = ((BinderService.MyBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG,"onServiceDisconnected()");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate()");

        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick()");

                List name = binderService.getRandowNumber();
                for (int i = 0; i < name.size(); i++) {
                    TextView textView = (TextView) findViewById(tvid[i]);
                    String s = name.get(i).toString();
                    textView.setText(s);
                }
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");

        Intent intent = new Intent(this, BinderService.class);
        bindService(intent,conn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop()");
        super.onStop();
        unbindService(conn);

    }
}

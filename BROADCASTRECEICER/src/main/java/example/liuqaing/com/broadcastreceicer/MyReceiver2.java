package example.liuqaing.com.broadcastreceicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {


    public static final String ACTION1 = "haha";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(ACTION1)){
            Toast.makeText(context,"haha",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"haha222",Toast.LENGTH_SHORT).show();
        }


    }
}

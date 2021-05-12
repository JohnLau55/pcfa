package example.liuqaing.com.randownumber;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static example.liuqaing.com.randownumber.MainActivity.TAG;

public class BinderService extends Service {


    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.d(TAG,"onBind()");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"onUnbind()");
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder{
        public BinderService getService(){
            return BinderService.this;
        }
    }

    public List getRandowNumber(){

        List list = new ArrayList();
        String name = "";
        for (int i = 0; i < 7; i++) {
            int number = new Random().nextInt(33) + 1;
            if(number < 10){
                name = "0" + String.valueOf(number);
            }else{
                name = String.valueOf(number);
            }
            list.add(name);
        }


        return list;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy()");

        super.onDestroy();
    }
}

package example.liuqaing.com.servicetest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG = MyService.class.getName();


    MediaPlayer mediaPlayer;
    static boolean isPlay;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"created");
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.music);

    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {

        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            isPlay = mediaPlayer.isPlaying();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"destroyed");
        super.onDestroy();
        mediaPlayer.stop();
        isPlay = mediaPlayer.isPlaying();
        mediaPlayer.release();
    }
}

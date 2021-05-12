package example.liuqaing.com.sensortest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    
    public static final String TAG = MainActivity.class.getName();
    
    
    EditText textLIGHT;
    EditText textGRAVITY;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        textGRAVITY = (EditText) findViewById(R.id.textGRAVITY);
        textLIGHT = (EditText) findViewById(R.id.textLIGHT);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_GAME);

    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this);
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: ");
        float[] values = event.values;
        int type = event.sensor.getType();
        switch (type){
            case Sensor.TYPE_GRAVITY:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("x轴：");
                stringBuilder.append(values[0]);
                stringBuilder.append("y轴：");
                stringBuilder.append(values[1]);
                stringBuilder.append("z轴：");
                stringBuilder.append(values[2]);
                textGRAVITY.setText(stringBuilder.toString());
                break;
            case Sensor.TYPE_LIGHT:
                stringBuilder = new StringBuilder();
                stringBuilder.append("光强：");
                stringBuilder.append(values[0]);
                textLIGHT.setText(stringBuilder.toString());
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d(TAG, "onAccuracyChanged: ");
    }
}

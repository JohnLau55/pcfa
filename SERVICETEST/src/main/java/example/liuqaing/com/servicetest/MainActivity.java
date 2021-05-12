package example.liuqaing.com.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageButton button = (ImageButton)findViewById(R.id.btn_play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MyService.isPlay){
                    startService(new Intent(MainActivity.this, MyService.class));
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.play,null));
                }else {
                    stopService(new Intent(MainActivity.this , MyService.class));
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.stop,null));

                }
            }
        });

    }
}

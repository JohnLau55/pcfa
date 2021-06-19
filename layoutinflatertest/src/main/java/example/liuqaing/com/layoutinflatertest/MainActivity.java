package example.liuqaing.com.layoutinflatertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LayoutInflater inflater = LayoutInflater.from(this);

        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);

        Button button = (Button) findViewById(R.id.btnLoad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.inflate, null, false).findViewById(R.id.ly_inflate);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);
                relativeLayout.addView(linearLayout,lp);
            }
        });
    }
}

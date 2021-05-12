package example.liuqaing.com;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("吉布斯");
                alertDialog.setIcon(R.mipmap.ic_launcher);
                alertDialog.setMessage("change the world");

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "点击否按钮", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "点击是按钮", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.show();

            }
        });


        //显示带列表的对话框
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] items = new String[]{
                        "你有是吗",
                        "还有谁",
                        "男的啊",
                };

                final boolean[] checkItems = {true ,false,false};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("choose you like");
                builder.setIcon(R.mipmap.ic_launcher);


                builder.setMultiChoiceItems(items, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkItems[which] = isChecked;
                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0; i < checkItems.length; i++) {
                            if(checkItems[i]){
                                result += items[i]+"、" ;
                            }
                        }

                        if(!"".equals(result)){
                            result = result.substring(0,result.length()-1);
                            Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
                        }

                    }
                });


                builder.create().show();


            }
        });
    }


}

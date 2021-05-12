package example.liuqaing.com.sharedprefference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String mr = "mr";
    private String mrsoft = "mrsoft";

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernameET = (EditText) findViewById(R.id.username);
        final EditText passwordET = (EditText) findViewById(R.id.password);
        ImageButton login = (ImageButton) findViewById(R.id.login);
        SharedPreferences sp = getSharedPreferences("liuqiang", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        //判断SharedPreferences文件中，用户名、密码是否存在

        if (sp.getString("username", username) != null &&
                sp.getString("password", password) != null) {

            //存在就判断用户名、密码与后台是否相同，相同直接登录
            if (sp.getString("username", username).equals(mr) &&
                    sp.getString("password", password).equals(mrsoft)) {
                //通过Intent跳转登录后界面
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);    //启动跳转界面
            }
        } else {
            //实现SharedPreferences文件不存在时，手动登录并存储用户名与密码
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    username = usernameET.getText().toString();            //获得输入的用户名
                    password = passwordET.getText().toString();            //获得输入的密码
                    //如果输入用户名、密码与后台相同时，登录并存储
                    if (username.equals(mr) && password.equals(mrsoft)) {
                        Toast.makeText(MainActivity.this, "用户名、密码正确",
                                Toast.LENGTH_SHORT).show();
                        //通过Intent跳转登录后界面
                        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                        startActivity(intent);                              //启动跳转界面
                        editor.putString("username", username);           //存储用户名
                        editor.putString("password", password);           //存储密码
                        editor.commit();                                    //提交信息
                        Toast.makeText(MainActivity.this, "已保存用户名密码",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "用户名或密码错误",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }

}

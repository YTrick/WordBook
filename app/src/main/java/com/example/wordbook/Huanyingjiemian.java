package com.example.wordbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Huanyingjiemian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉导航栏
        getSupportActionBar().hide();
        //去掉最上面的时间、电量
       /* this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        setContentView(R.layout.activity_huanyingjiemian);

        final Intent it = new Intent(Huanyingjiemian.this, LoginActivity.class); //你要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override

            public void run() {

                SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
                String username = sp.getString("username","");
                String password = sp.getString("password","");
                boolean checkboxBoolean = sp.getBoolean("checkboxBoolean",false);

                System.out.println("username = "+username);
                System.out.println("password = "+password);
                System.out.println("checkboxBoolean = "+checkboxBoolean);

                if(checkboxBoolean){

                    Intent intent = new Intent(Huanyingjiemian.this, MainActivity.class);
                    startActivity(intent);
                    Huanyingjiemian.this.finish();

                    Looper.prepare();
                   // Toast.makeText( getApplicationContext(), "账号："+username+"登录成功！", Toast.LENGTH_SHORT).show();
                    Looper.loop();

                }
                else {

                    startActivity(it); //执行
                    finish();
                }
            }

        };

        timer.schedule(task, 2000); //10秒后
    }
}
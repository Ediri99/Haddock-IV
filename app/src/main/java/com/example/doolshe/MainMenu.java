package com.example.doolshe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {
     Button signin, signup;
     ImageView bgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        setContentView(R.layout.activity_main_menu);

        signin = (Button) findViewById(R.id.signIn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(MainMenu.this,ChooseLogin.class);
        startActivity(intent);
    }
       /* final Animation Zoomin = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        final Animation Zoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout);

        bgimage=findViewById(R.id.back_2);
        bgimage.setAnimation(Zoomin);
        bgimage.setAnimation(Zoomout);

        Zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(Zoomin);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(Zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainMenu.this,ChooseLogin.class);
                login.putExtra("Home","Login");
                startActivity(login);
                finish();
            }
        });*/
        /*signin=(Button) findViewById(R.id.signIn);
        signup=(Button) findViewById(R.id.signUp);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainMenu.this,chooseOne.class);
                login.putExtra("Home","Phone");
            }
        });*/

}
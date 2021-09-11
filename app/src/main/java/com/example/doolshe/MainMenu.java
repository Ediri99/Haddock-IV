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

        final Animation zoomin = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        final Animation zoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout);

        bgimage=findViewById(R.id.backgroundMainMenu);
        bgimage.setAnimation(zoomin);
        bgimage.setAnimation(zoomout);

        zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(zoomin);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        signin = (Button) findViewById(R.id.signIn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(MainMenu.this,ChooseLogin.class);
                /*openLoginChoices();*/
                startActivity(loginintent);
                /*finish();*/
            }
        });

        signup = (Button) findViewById(R.id.signUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(MainMenu.this,ChooseRegistration.class);
                /*openRegistrationChoices();*/
                /*signup.putExtra("Home","SignUp");*/
                startActivity(registerintent);
                /*finish();*/
            }
        });
    }


    /*public void openLoginChoices(){
        Intent loginintent = new Intent(MainMenu.this,ChooseLogin.class);
        startActivity(loginintent);
    }

    public void openRegistrationChoices(){
        Intent registerintent = new Intent(MainMenu.this,ChooseRegistration.class);
        startActivity(registerintent);
    }*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();

    }
}
       /* */
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


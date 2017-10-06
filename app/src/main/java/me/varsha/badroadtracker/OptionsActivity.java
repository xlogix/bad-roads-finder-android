package me.varsha.badroadtracker;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

  Button b1, b2;
  RelativeLayout mRelativeLayout;
  boolean doubleBackToExitPressedOnce = false;

  @Override public void onBackPressed() {
    if (doubleBackToExitPressedOnce) {
      super.onBackPressed();
    } else {
      this.doubleBackToExitPressedOnce = true;
      Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
      new Handler().postDelayed(new Runnable() {
        @Override public void run() {
          doubleBackToExitPressedOnce = false;
        }
      }, 2000);
    }
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_options);

    // Find the layout ID
    mRelativeLayout = findViewById(R.id.relativeLayout);

    // Setup animation
    AnimationDrawable animationDrawable = (AnimationDrawable) mRelativeLayout.getBackground();
    animationDrawable.setEnterFadeDuration(2500);
    animationDrawable.setExitFadeDuration(2500);
    animationDrawable.start();

    b1 = (Button) findViewById(R.id.button1);
    b2 = (Button) findViewById(R.id.button2);

    b1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(OptionsActivity.this, MapsActivity.class);
        startActivity(intent);
      }
    });

    b2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(OptionsActivity.this, ComplaintsActivity.class);
        startActivity(intent);
      }
    });
  }
}

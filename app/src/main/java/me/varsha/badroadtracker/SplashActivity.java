package me.varsha.badroadtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by abhishek on 06/10/17.
 */

public class SplashActivity extends Activity {
  private static final String TAG = SplashActivity.class.getSimpleName();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    // Splash screen timer
    final int SPLASH_TIME_OUT = 1000;

    new Handler().postDelayed(new Runnable() {
      /*
       * Showing splash screen with a timer. This will be useful when you
       * want to show case your app logo / company
       */
      public void run() {
        Log.d(TAG, "Pass to options activity");
        startActivity(new Intent(SplashActivity.this, OptionsActivity.class));
        finish();
      }
    }, SPLASH_TIME_OUT);
  }
}

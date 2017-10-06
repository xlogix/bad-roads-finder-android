package me.varsha.badroadtracker;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComplaintsActivity extends AppCompatActivity {
  private static final String TAG = ComplaintsActivity.class.getSimpleName();

  private EditText mFeedBack;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_complaint);

    mFeedBack = (EditText) findViewById(R.id.feedback);

    Button sendFeedback = (Button) findViewById(R.id.send_feedback);
    sendFeedback.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        Toast.makeText(ComplaintsActivity.this, "Thank You!", Toast.LENGTH_LONG).show();
        finish();
      }
    });
  }
}

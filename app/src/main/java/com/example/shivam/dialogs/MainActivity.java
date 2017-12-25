package com.example.shivam.dialogs;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
public class MainActivity extends AppCompatActivity {
    Button mButton;
    TextView mTextView;
    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button);
        mTextView=(TextView)findViewById(R.id.txtTime);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(180000,1000) {
                    @Override
                    public void onTick(long l) {
                       mTextView.setText(" "+""+String.format(FORMAT,
                               TimeUnit.MILLISECONDS.toHours(l),
                               TimeUnit.MILLISECONDS.toMinutes(l) - TimeUnit.HOURS.toMinutes(
                                       TimeUnit.MILLISECONDS.toHours(l)),
                               TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(
                                       TimeUnit.MILLISECONDS.toMinutes(l))));
                    }

                    @Override
                    public void onFinish() {
                    mTextView.setText("Activity Finished");
                    }
                }.start();
            }
        });
    }
}

package com.example.joketeller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeTellerActivity extends AppCompatActivity {


    public static final String JOKE_KEY = "joke-key";

    public static Intent newIntent(Context context, String joke){
        Intent intent = new Intent(context, JokeTellerActivity.class);
        intent.putExtra(JOKE_KEY, joke);
        return intent;
    }

    TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);

        mJokeTextView = (TextView) findViewById(R.id.joke_tv);

        if(getIntent() != null && getIntent().hasExtra(JOKE_KEY)){
            mJokeTextView.setText(getIntent().getStringExtra(JOKE_KEY));
        }
    }
}

package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.joketeller.JokeTellerActivity;


public class MainActivity extends AppCompatActivity {

    ProgressDialog mDialog;
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getJoke().observe(this, new android.arch.lifecycle.Observer<String>() {
            @Override
            public void onChanged(@Nullable String joke) {
                if(!isChangingConfigurations()) {
                    if (mDialog != null) {
                        mDialog.cancel();
                    }
                    startActivity(JokeTellerActivity.newIntent(MainActivity.this, joke));
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mDialog = ProgressDialog.show(MainActivity.this, "",
                getString(R.string.loading), true);

        mViewModel.loadJoke();
    }
}

package com.deepbay.dayuyoupin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.syh.epoch.app.Epoch;

public class MainActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toast.makeText(Epoch.getApplicationContext(),"init",Toast.LENGTH_SHORT).show();
  }
}

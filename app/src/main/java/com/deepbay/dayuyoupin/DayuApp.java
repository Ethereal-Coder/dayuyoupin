package com.deepbay.dayuyoupin;

import android.app.Application;
import com.syh.epoch.app.Epoch;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:
 */

public class DayuApp extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Epoch.init(this)
        .configure();
  }
}

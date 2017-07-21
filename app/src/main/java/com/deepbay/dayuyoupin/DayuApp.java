package com.deepbay.dayuyoupin;

import android.app.Application;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.syh.epoch.app.Epoch;
import com.syh.epoch.ec.icon.FontEcModule;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:
 */

public class DayuApp extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Epoch.init(this)
        .withIcon(new FontAwesomeModule())
        .withIcon(new FontEcModule())
        .configure();
  }
}

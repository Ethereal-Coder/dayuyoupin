package com.syh.epoch.app;

import android.content.Context;
import android.os.Handler;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:
 */

public class Epoch {
  public static Configurator init(Context context){
    Configurator.getInstance().getEpochConfigs().put(ConfigKeys.APPLICATION_CONTEXT,context.getApplicationContext());
    return Configurator.getInstance();
  }
  public static Configurator getConfigurator(){
    return Configurator.getInstance();
  }
  public static <T> T getConfiguration(Object key) {
    return getConfigurator().getConfiguration(key);
  }

  public static Context getApplicationContext(){
    return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
  }

  public static Handler getHandle(){
    return getConfiguration(ConfigKeys.HANDLER);
  }
}

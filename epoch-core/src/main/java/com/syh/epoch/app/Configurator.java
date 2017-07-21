package com.syh.epoch.app;

import android.os.Handler;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:
 */

public final class Configurator {
  private static final HashMap<Object,Object> EPOCH_CONFIGS = new HashMap<>();
  private static final Handler HANDLER = new Handler();
  private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

  private Configurator() {
    EPOCH_CONFIGS.put(ConfigKeys.CONFIG_READY,false);
    EPOCH_CONFIGS.put(ConfigKeys.HANDLER,HANDLER);
  }


  private static class Holder{
    private static final Configurator INSTANCE = new Configurator();
  }

  static Configurator getInstance(){
    return Holder.INSTANCE;
  }

  public final void configure(){
    initIcons();
    EPOCH_CONFIGS.put(ConfigKeys.CONFIG_READY,true);
  }

  final HashMap<Object,Object> getEpochConfigs(){
    return EPOCH_CONFIGS;
  }

  private void initIcons(){
    if (ICONS.size()>0){
      final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
      for (int i = 1; i < ICONS.size(); i++) {
        initializer.with(ICONS.get(i));
      }
    }
  }

  public final Configurator withIcon(IconFontDescriptor descriptor){
    ICONS.add(descriptor);
    return this;
  }

  private void checkConfiguration() {
    final boolean isReady = (boolean) EPOCH_CONFIGS.get(ConfigKeys.CONFIG_READY);
    if (!isReady) {
      throw new RuntimeException("Configuration is not ready,call configure");
    }
  }

  @SuppressWarnings("unchecked")
  final <T> T getConfiguration(Object key) {
    checkConfiguration();
    final Object value = EPOCH_CONFIGS.get(key);
    if (value == null) {
      throw new NullPointerException(key.toString() + " IS NULL");
    }
    return (T) EPOCH_CONFIGS.get(key);
  }
}

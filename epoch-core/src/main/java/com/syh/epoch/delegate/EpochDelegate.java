package com.syh.epoch.delegate;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:
 */

public abstract class EpochDelegate extends PermissionCheckerDelegete {
  @SuppressWarnings("unchecked")
  public <T extends EpochDelegate> T getParentDelegate() {
    return (T) getParentFragment();
  }
}

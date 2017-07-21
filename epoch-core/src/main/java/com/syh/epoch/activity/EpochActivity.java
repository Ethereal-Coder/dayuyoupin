package com.syh.epoch.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import com.syh.epoch.R;
import com.syh.epoch.delegate.EpochDelegate;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by 孙应恒 on 2017/7/21.
 * Description:
 */

public abstract class EpochActivity extends AppCompatActivity implements ISupportActivity {
  private final SupportActivityDelegate DELEGATE = new SupportActivityDelegate(this);

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DELEGATE.onCreate(savedInstanceState);
    initContainer(savedInstanceState);
  }

  private void initContainer(@Nullable Bundle savedInstanceState) {
    final ContentFrameLayout container = new ContentFrameLayout(this);
    container.setId(R.id.delegate_container);
    setContentView(container);
    if (savedInstanceState == null) {
      DELEGATE.loadRootFragment(R.id.delegate_container, setRootDelegate());
    }
  }

  public abstract EpochDelegate setRootDelegate();

  @Override protected void onDestroy() {
    DELEGATE.onDestroy();
    super.onDestroy();
    System.gc();
    System.runFinalization();
  }

  @Override public SupportActivityDelegate getSupportDelegate() {
    return DELEGATE;
  }

  @Override public ExtraTransaction extraTransaction() {
    return DELEGATE.extraTransaction();
  }

  @Override public FragmentAnimator getFragmentAnimator() {
    return DELEGATE.getFragmentAnimator();
  }

  @Override public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
    DELEGATE.setFragmentAnimator(fragmentAnimator);
  }

  @Override public FragmentAnimator onCreateFragmentAnimator() {
    return DELEGATE.onCreateFragmentAnimator();
  }

  @Override public void onBackPressedSupport() {
    DELEGATE.onBackPressedSupport();
  }

  @Override public void onBackPressed() {
    DELEGATE.onBackPressed();
  }
}

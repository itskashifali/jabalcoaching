package com.jabalcoaching;


import com.facebook.react.ReactActivity;
import androidx.annotation.Nullable;
import com.google.android.gms.cast.framework.CastContext;
import org.devio.rn.splashscreen.SplashScreen; // import this
import android.os.Bundle; // import this

import android.content.Intent; // <--- import 
import android.content.res.Configuration;

public class MainActivity extends ReactActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    SplashScreen.show(this);  // here

    super.onCreate(savedInstanceState);

    // lazy load Google Cast context
    CastContext.getSharedInstance(this);
  }
  @Override
    public void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    }
  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Intent intent = new Intent("onConfigurationChanged");
    intent.putExtra("newConfig", newConfig);
    this.sendBroadcast(intent);
}
  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "jabalcoaching";
  }
}

package com.tomoima.concurrentsample;

import android.app.Application;

import com.tomoima.concurrentsample.modules.AppComponent;
import com.tomoima.concurrentsample.modules.AppModule;
import com.tomoima.concurrentsample.modules.DaggerAppComponent;

/**
 * Created by tomoaki on 3/22/16.
 */
public class ThisApplication extends Application {

    private AppComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}

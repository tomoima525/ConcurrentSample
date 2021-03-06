package com.tomoima.concurrentsample.modules;

import com.tomoima.concurrentsample.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tomoaki on 3/21/16.
 */

@Singleton
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {
    void inject(MainActivity activity);
}

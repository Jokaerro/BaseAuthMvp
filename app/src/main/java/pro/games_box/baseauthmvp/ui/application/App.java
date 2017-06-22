package pro.games_box.baseauthmvp.ui.application;

import android.app.Application;

import pro.games_box.baseauthmvp.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Tesla on 22.06.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getResources().getString(R.string.neue_regular))
                .setFontAttrId(R.attr.fontPath)
                .build());

    }
}

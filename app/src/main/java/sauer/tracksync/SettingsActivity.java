package sauer.tracksync;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class SettingsActivity extends Activity {
    public static final String SMS_NUMBER = "sms_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}

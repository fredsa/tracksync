package sauer.tracksync;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

import java.util.Date;

public class TrackIntentService extends IntentService {

    private static final String TAG = TrackIntentService.class.getSimpleName();

    public TrackIntentService() {
        super(TrackIntentService.class.getSimpleName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w(TAG, "onCreate() called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.w(TAG, "onStartCommand() called: " + intent);
        Log.w(TAG, "  extra: " + intent.getStringExtra(TrackSyncConstants.INTENT_ACTION));
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.w(TAG, "onHandleIntent() called: " + intent);
        String intentAction = intent.getStringExtra(TrackSyncConstants.INTENT_ACTION);
        Log.w(TAG, "  extra: " + intentAction);
        if (intentAction.equals(Intent.ACTION_USER_PRESENT)) {
            Date now = new Date();
            String message = "  PHONE UNLOCKED AT: " + now;
            Log.w(TAG, message);

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            String smsNumber = sharedPref.getString(SettingsActivity.SMS_NUMBER, null);
            Log.w(TAG, "  SMS NUMBER: " + smsNumber);
            sendSms(smsNumber, message);
        }
    }

    private void sendSms(String smsNumber, String message) {
        SmsManager.getDefault().sendTextMessage(smsNumber, null, message, null, null);
    }
}

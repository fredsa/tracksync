package sauer.tracksync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = BootBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.w(TAG, "Received intent: " + intent);
        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {

        } else if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {

        }
        Intent startServiceIntent = new Intent(context, TrackIntentService.class);
        startServiceIntent.putExtra(TrackSyncConstants.INTENT_ACTION, intent.getAction());
        context.startService(startServiceIntent);
    }
}

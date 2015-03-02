package sauer.tracksync;

import android.content.Context;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyEditTextPreference extends EditTextPreference {

    public MyEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                updateSummary();
                return true;
            }
        });
    }

    private void updateSummary() {
        this.setSummary(this.getText());
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        updateSummary();
        return super.onCreateView(parent);
    }
}


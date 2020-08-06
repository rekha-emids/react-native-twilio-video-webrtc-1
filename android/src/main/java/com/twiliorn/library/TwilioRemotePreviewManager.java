/**
 * Component for Twilio Video participant views.
 * <p>
 * Authors:
 * Jonathan Chang <slycoder@gmail.com>
 */

package com.twiliorn.library;

import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class TwilioRemotePreviewManager extends SimpleViewManager<TwilioRemotePreview> {

    public static final String REACT_CLASS = "RNTwilioRemotePreview";
    public String myTrackSid = "";

    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @ReactProp(name = "trackSid")
    public void setTrackId(TwilioRemotePreview view, @Nullable String trackSid) {

        Log.i("CustomTwilioVideoView", "Initialize Twilio REMOTE");
        Log.i("CustomTwilioVideoView", trackSid);
        myTrackSid = trackSid;
        CustomTwilioVideoView.registerPrimaryVideoView(view.getSurfaceViewRenderer(), trackSid);
    }


    @Override
    protected TwilioRemotePreview createViewInstance(ThemedReactContext reactContext) {
        return new TwilioRemotePreview(reactContext, myTrackSid);
    }
}
package com.capanovi;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.content.Intent;

import org.apache.cordova.CordovaArgs;
import org.json.JSONException;


public class TTSSettingsOpener extends CordovaPlugin{
    private static final String TTS_SETTINGS_PACKAGE = "com.android.settings.TTS_SETTINGS";

    public TTSSettingsOpener(){
    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView){
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException{
        if (action.equals("open"))
            return chooseFile(callbackContext);

        return false;
    }

    public boolean chooseFile(CallbackContext callbackContext){
        Intent intent = new Intent();
        intent.setAction(TTS_SETTINGS_PACKAGE);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.cordova.getActivity().startActivity(intent);

        callbackContext.success();
        return true;
    }
}

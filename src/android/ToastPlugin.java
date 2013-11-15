package com.happy.plugins;

import android.util.Log;
import android.widget.Toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

public class ToastPlugin extends CordovaPlugin {

    private static final String TAG = "ToastPlugin";
    private static final String LONG_TOAST_ACTION = "show_long";
    private static final String CANCEL_ACTION = "cancel";
    private static final int TOAST_MESSAGE_INDEX = 0;

    private Toast toast = null;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        Log.d(TAG, action);

        if (action.equals(CANCEL_ACTION)) {

            cancelToast();

        } else {

            String message;
            try {
                message = args.getString(TOAST_MESSAGE_INDEX);
            } catch (JSONException e) {
               e.printStackTrace();
               Log.e(TAG, "Required parameter 'Toast Message' missing");
			   callbackContext.error("Required parameter 'Toast Message' missing");
			   return false;            	                
            }

            if (action.equals(LONG_TOAST_ACTION)) {
                showToast(message, Toast.LENGTH_LONG);
            } else {
                showToast(message, Toast.LENGTH_SHORT);
            }
        }
		callbackContext.success();
		return true;     

    }

    private void cancelToast() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toast != null) toast.cancel();
            }
        });
    }

    private void showToast(final String message, final int length) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                toast = Toast.makeText(cordova.getActivity(), message, length);
                toast.show();
            }
        });
    }

}
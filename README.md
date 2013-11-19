Toasty - PhoneGap Toast Notification Plugin
===========================================
Modified by vanrat 
Added Cordova 3.x supports



Shows an Android Toast Notification

* window.plugins.toastPlugin.showShort(message);
* window.plugins.toastPlugin.showLong(message);

Cancel an Android Toast Notification

* window.plugins.toastPlugin.cancel();

Supported Platforms
--------------------
* Android

Adding Toasty to your project
------------------------------
using cordova-cli

   * cordova plugin install https://github.com/vanrat/ToastNotificationPlugin

Once the the plugin is installed, toast will be available on the document object. There is no need to modify your javascript imports.
    
    window.plugins.toastPlugin.showShort('this is test message');
    window.plugins.toastPlugin.showLong('this is test message');
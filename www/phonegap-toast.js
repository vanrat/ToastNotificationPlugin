/*global cordova, module*/
/*
module.exports = {
    showShort: function (message, win, fail) {
        cordova.exec(win, fail, "Toasty", "show_short", [message]);
    },

    showLong: function (message, win, fail) {
        cordova.exec(win, fail, "Toasty", "show_long", [message]);
    },

    cancel: function (win, fail) {
        cordova.exec(win, fail, "Toasty", "cancel", []);
    }
};
*/

cordova.define("ToastPlugin", function(require, exports, module) {
    var exec = require('cordova/exec');
    
    var ToastPlugin = function() {};

    ToastPlugin.prototype.showShort = function(message, win, fail) {
        return exec(
                function (args) { if(win !== undefined) { win(args); } }, 
                function (args) { if(fail !== undefined) { fail(args); } }, 
                "ToastPlugin", 
                "show_short", 
                [message]); 
    };
    ToastPlugin.prototype.showLong = function(message, win, fail) {
        return exec(
                function (args) { if(win !== undefined) { win(args); } }, 
                function (args) { if(fail !== undefined) { fail(args); } }, 
                "ToastPlugin", 
                "show_long", 
                [message]); 
    };
    ToastPlugin.prototype.cancel = function(win, fail) {
        return exec(
                function (args) { if(win !== undefined) { win(args); } }, 
                function (args) { if(fail !== undefined) { fail(args); } }, 
                "ToastPlugin", 
                "cancel", 
                []); 
    };


    var toastPlugin = new ToastPlugin();
    module.exports = toastPlugin;
});

if (!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.ToastPlugin) {
    window.plugins.ToastPlugin = cordova.require("ToastPlugin");
}
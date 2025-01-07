package com.esd.NativeSettings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.json.JSONArray

class NativeSettings : CordovaPlugin() {

    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        val context: Context = cordova.activity.applicationContext
    
        var intent: Intent = when (val requestedAction = args.getString(0)) {
            "accessibility" -> Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            "account" -> Intent(Settings.ACTION_ADD_ACCOUNT)
            "airplane_mode" -> Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
            "apn" -> Intent(Settings.ACTION_APN_SETTINGS)
            "application_details" -> Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${cordova.activity.packageName}"))
            "application_development" -> Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
            "application" -> Intent(Settings.ACTION_APPLICATION_SETTINGS)
            "battery_optimization" -> Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
            "biometric" -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Intent(Settings.ACTION_FINGERPRINT_ENROLL)
                } else {
                    Intent(Settings.ACTION_SETTINGS)
                }
            }
            "bluetooth" -> Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
            "captioning" -> Intent(Settings.ACTION_CAPTIONING_SETTINGS)
            "cast" -> Intent(Settings.ACTION_CAST_SETTINGS)
            "data_roaming" -> Intent(Settings.ACTION_DATA_ROAMING_SETTINGS)
            "date" -> Intent(Settings.ACTION_DATE_SETTINGS)
            "about" -> Intent(Settings.ACTION_DEVICE_INFO_SETTINGS)
            "display" -> Intent(Settings.ACTION_DISPLAY_SETTINGS)
            "dream" -> Intent(Settings.ACTION_DREAM_SETTINGS)
            "home" -> Intent(Settings.ACTION_HOME_SETTINGS)
            "keyboard" -> Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
            "keyboard_subtype" -> Intent(Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS)
            "storage" -> Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS)
            "locale" -> Intent(Settings.ACTION_LOCALE_SETTINGS)
            "location" -> Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            "manage_all_applications" -> Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS)
            "manage_applications" -> Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS)
            "memory_card" -> Intent(Settings.ACTION_MEMORY_CARD_SETTINGS)
            "network" -> Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
            "nfcsharing" -> Intent(Settings.ACTION_NFCSHARING_SETTINGS)
            "nfc_payment" -> Intent(Settings.ACTION_NFC_PAYMENT_SETTINGS)
            "nfc_settings" -> Intent(Settings.ACTION_NFC_SETTINGS)
            "notification_id" -> {
                  Intent().apply {
                    var action = "" 
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1) {
                        action = "android.settings.APP_NOTIFICATION_SETTINGS"
                        putExtra("android.provider.extra.APP_PACKAGE", context.packageName)
                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        action = "android.settings.APP_NOTIFICATION_SETTINGS"
                        putExtra("app_package", context.packageName)
                        putExtra("app_uid", context.applicationInfo.uid)
                    } else {
                        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        addCategory(Intent.CATEGORY_DEFAULT)
                        data = Uri.parse("package:${context.packageName}")
                    }
                    this.action = action
                }
            }
            "print" -> Intent(Settings.ACTION_PRINT_SETTINGS)
            "privacy" -> Intent(Settings.ACTION_PRIVACY_SETTINGS)
            "quick_launch" -> Intent(Settings.ACTION_QUICK_LAUNCH_SETTINGS)
            "search" -> Intent(Settings.ACTION_SEARCH_SETTINGS)
            "security" -> Intent(Settings.ACTION_SECURITY_SETTINGS)
            "settings" -> Intent(Settings.ACTION_SETTINGS)
            "show_regulatory_info" -> Intent(Settings.ACTION_SHOW_REGULATORY_INFO)
            "sound" -> Intent(Settings.ACTION_SOUND_SETTINGS)
            "store" -> Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${cordova.activity.packageName}"))
            "sync" -> Intent(Settings.ACTION_SYNC_SETTINGS)
            "usage" -> Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
            "user_dictionary" -> Intent(Settings.ACTION_USER_DICTIONARY_SETTINGS)
            "voice_input" -> Intent(Settings.ACTION_VOICE_INPUT_SETTINGS)
            "wifi_ip" -> Intent(Settings.ACTION_WIFI_IP_SETTINGS)
            "wifi" -> Intent(Settings.ACTION_WIFI_SETTINGS)
            "wireless" -> Intent(Settings.ACTION_WIRELESS_SETTINGS)
            else -> {
                callbackContext.error("Invalid setting name")
                return false
            }
        }

        cordova.activity.startActivity(intent)

        callbackContext.success()

        return true
    }
}
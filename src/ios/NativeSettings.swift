import UIKit

@objc(NativeSettings) class NativeSettings: CDVPlugin {
    
    @objc(open:)
    func open(command: CDVInvokedUrlCommand) {
        let key = command.arguments[0] as? String ?? ""
        let prefix = "App-Prefs:"
        let isOldVersion = UIDevice.current.systemVersion.compare("11.3", options: .numeric) == .orderedAscending
        let settingsPrefix = isOldVersion ? "app-settings:" : prefix
        
        var urlString: String? = nil
        
        switch key {
        case "application_details":
            urlString = UIApplicationOpenSettingsURLString
        case "settings":
            urlString = settingsPrefix
        case "about":
            urlString = "\(settingsPrefix)General&path=About"
        case "accessibility":
            urlString = "\(settingsPrefix)General&path=ACCESSIBILITY"
        case "account":
            urlString = "\(settingsPrefix)ACCOUNT_SETTINGS"
        case "autolock":
            urlString = "\(settingsPrefix)DISPLAY&path=AUTOLOCK"
        case "display":
            urlString = "\(settingsPrefix)Brightness"
        case "bluetooth":
            urlString = "\(settingsPrefix)Bluetooth"
        case "castle":
            urlString = "\(settingsPrefix)CASTLE"
        case "cellular_usage":
            urlString = "\(settingsPrefix)General&path=USAGE/CELLULAR_USAGE"
        case "configuration_list":
            urlString = "\(settingsPrefix)General&path=ManagedConfigurationList"
        case "date":
            urlString = "\(settingsPrefix)General&path=DATE_AND_TIME"
        case "facetime":
            urlString = "\(settingsPrefix)FACETIME"
        case "settings":
            urlString = "\(settingsPrefix)General"
        case "tethering":
            urlString = "\(settingsPrefix)INTERNET_TETHERING"
        case "music":
            urlString = "\(settingsPrefix)MUSIC"
        case "music_equalizer":
            urlString = "\(settingsPrefix)MUSIC&path=EQ"
        case "music_volume":
            urlString = "\(settingsPrefix)MUSIC&path=VolumeLimit"
        case "keyboard":
            urlString = "\(settingsPrefix)General&path=Keyboard"
        case "locale":
            urlString = "\(settingsPrefix)General&path=INTERNATIONAL"
        case "location":
            urlString = "\(settingsPrefix)LOCATION_SERVICES"
        case "locations":
            urlString = "\(settingsPrefix)Privacy&path=LOCATION"
        case "tracking":
            urlString = "\(settingsPrefix)Privacy&path=USER_TRACKING"
        case "network":
            urlString = "\(settingsPrefix)General&path=Network"
        case "nike_ipod":
            urlString = "\(settingsPrefix)NIKE_PLUS_IPOD"
        case "notes":
            urlString = "\(settingsPrefix)NOTES"
        case "notification_id":
            urlString = "\(settingsPrefix)NOTIFICATIONS_ID"
        case "passbook":
            urlString = "\(settingsPrefix)PASSBOOK"
        case "phone":
            urlString = "\(settingsPrefix)Phone"
        case "photos":
            urlString = "\(settingsPrefix)Photos"
        case "reset":
            urlString = "\(settingsPrefix)General&path=Reset"
        case "ringtone":
            urlString = "\(settingsPrefix)Sounds&path=Ringtone"
        case "browser":
            urlString = "\(settingsPrefix)Safari"
        case "search":
            urlString = "\(settingsPrefix)SIRI"
        case "sound":
            urlString = "\(settingsPrefix)Sounds"
        case "software_update":
            urlString = "\(settingsPrefix)General&path=SOFTWARE_UPDATE_LINK"
        case "storage":
            urlString = "\(settingsPrefix)CASTLE&path=STORAGE_AND_BACKUP"
        case "store":
            urlString = "\(settingsPrefix)STORE"
        case "usage":
            urlString = "\(settingsPrefix)General&path=USAGE"
        case "video":
            urlString = "\(settingsPrefix)VIDEO"
        case "vpn":
            urlString = "\(settingsPrefix)General&path=Network/VPN"
        case "wallpaper":
            urlString = "\(settingsPrefix)Wallpaper"
        case "wifi":
            urlString = "\(settingsPrefix)WIFI"
        case "touch":
            urlString = "\(settingsPrefix)TOUCHID_PASSCODE"
        case "battery":
            urlString = "\(settingsPrefix)BATTERY_USAGE"
        case "privacy":
            urlString = "\(settingsPrefix)Privacy"
        case "do_not_disturb":
            urlString = "\(settingsPrefix)General&path=DO_NOT_DISTURB"
        case "keyboards":
            urlString = "\(settingsPrefix)General&path=Keyboard/KEYBOARDS"
        case "mobile_data":
            urlString = "\(settingsPrefix)MOBILE_DATA_SETTINGS_ID"
        default:
            self.sendPluginResultError("Invalid setting name", callbackId: command.callbackId)
            return
        }
        
        guard let url = URL(string: urlString!), UIApplication.shared.canOpenURL(url) else {
            self.sendPluginResultError("Cannot open", callbackId: command.callbackId)
            return
        }
        
        UIApplication.shared.open(url) { success in
            if success {
                self.sendPluginResultSuccess("Opened", callbackId: command.callbackId)
            } else {
                self.sendPluginResultError("Failed to open", callbackId: command.callbackId)
            }
        }
    }
    
    private func sendPluginResultSuccess(_ message: String, callbackId: String) {
        let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: message)
        self.commandDelegate.send(pluginResult, callbackId: callbackId)
    }
    
    private func sendPluginResultError(_ message: String, callbackId: String) {
        let pluginResult = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAs: message)
        self.commandDelegate.send(pluginResult, callbackId: callbackId)
    }
}

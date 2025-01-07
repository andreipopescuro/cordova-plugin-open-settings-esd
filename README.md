# `cordova-plugin-open-settings-esd`

### This is a simple cordova plugin inspired from https://github.com/guyromb/Cordova-open-native-settings rewritten in Kotlin and Swift that lets you open device settings

- [Platforms](#platforms)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Methods](#methods)
- [Examples](#examples)
- [Settings Options android](#settings-options-android)
- [Settings Options iOS](#settings-options-ios)

## Platforms

> ## iOS

> ## android

## Dependencies

- `cordova-plugin-add-swift-support@2.0.2` that uses `Swift 4`

- `cordova 12`

- `cordova-ios 7`

- `cordova-android 13`

## Installation

```
cordova plugin add cordova-plugin-open-settings-esd
```

## Methods

- open
  > Opens device settings

## Examples

```js
cordova.plugins.NativeSettings.open("wifi", successCallback, errorCallback);
```

```js
cordova.plugins.NativeSettings.open("battery", successCallback, errorCallback);
```

## Settings Options android

| Setting constant          | Description                                                                                            |
| ------------------------- | ------------------------------------------------------------------------------------------------------ |
| "accessibility"           | Show settings for accessibility modules                                                                |
| "account"                 | Show add account screen for creating a new account                                                     |
| "airplane_mode"           | Show settings to allow entering/exiting airplane mode                                                  |
| "apn"                     | Show settings to allow configuration of APNs                                                           |
| "application_details"     | Show screen of details about a particular application                                                  |
| "application_development" | Show settings to allow configuration of application development-related settings                       |
| "application"             | Show settings to allow configuration of application-related settings                                   |
| "battery_optimization"    | Show screen for controlling which apps can ignore battery optimizations                                |
| "biometric"               | Show screen for configuring biometric based device security                                            |
| "bluetooth"               | Show settings to allow configuration of Bluetooth                                                      |
| "captioning"              | Show settings for video captioning                                                                     |
| "cast"                    | Show settings to allow configuration of cast endpoints                                                 |
| "data_roaming"            | Show settings for selection of 2G/3G                                                                   |
| "date"                    | Show settings to allow configuration of date and time                                                  |
| "display"                 | Show settings to allow configuration of display                                                        |
| "dream"                   | Show Daydream settings                                                                                 |
| "home"                    | Show Home selection settings                                                                           |
| "keyboard"                | Show settings to configure input methods, in particular allowing the user to enable input methods      |
| "keyboard_subtype"        | Show settings to enable/disable input method subtypes                                                  |
| "locale"                  | Show settings to allow configuration of locale                                                         |
| "location"                | Show settings to allow configuration of current location sources                                       |
| "manage_all_applications" | Show settings to manage all applications                                                               |
| "manage_applications"     | Show settings to manage installed applications                                                         |
| "memory_card"             | Show settings for memory card storage                                                                  |
| "network"                 | Show settings for selecting the network operator                                                       |
| "nfcsharing"              | Show NFC Sharing settings                                                                              |
| "nfc_payment"             | Show NFC Tap & Pay settings                                                                            |
| "nfc_settings"            | Show NFC settings                                                                                      |
| "notification_id"         | Settings > Notifications                                                                               |
| "print"                   | Show the top level print settings                                                                      |
| "privacy"                 | Show settings to allow configuration of privacy options                                                |
| "quick_launch"            | Show settings to allow configuration of quick launch shortcuts                                         |
| "search"                  | Show settings for global search                                                                        |
| "security"                | Show settings to allow configuration of security and location privacy                                  |
| "settings"                | Show system settings                                                                                   |
| "show_regulatory_info"    | Show the regulatory information screen for the device                                                  |
| "sound"                   | Show settings to a llow configuration of sound and volume                                              |
| "storage"                 | Show settings for internal storage                                                                     |
| "store"                   | Open the Play Store page of the current application                                                    |
| "sync"                    | Show settings to allow configuration of sync settings                                                  |
| "usage"                   | Show settings to control access to usage information                                                   |
| "user_dictionary"         | Show settings to manage the user input dictionary                                                      |
| "voice_input"             | Show settings to configure input methods, in particular allowing the user to enable input methods      |
| "wifi_ip"                 | Show settings to allow configuration of a static IP address for Wi-Fi                                  |
| "wifi"                    | Show settings to allow configuration of Wi-Fi                                                          |
| "wireless"                | Show settings to allow configuration of wireless controls such as Wi-Fi, Bluetooth and Mobile networks |

## Settings Options iOS

| Setting constant      | Description                                                                         |
| --------------------- | ----------------------------------------------------------------------------------- |
| "about"               | Settings > General > About                                                          |
| "accessibility"       | Settings > General > Accessibility                                                  |
| "account"             | Settings > _Your name_                                                              |
| "airplane_mode"       | Settings > Airplane Mode                                                            |
| "application_details" | Settings                                                                            |
| "autolock"            | Settings > General > Auto-Lock (before iOS 10)                                      |
| "battery"             | Settings > Battery                                                                  |
| "bluetooth"           | Settings > General > Bluetooth (before iOS 9)<br>Settings > Bluetooth (after iOS 9) |
| "browser"             | Settings > Safari                                                                   |
| "castle"              | Settings > iCloud                                                                   |
| "cellular_usage"      | Settings > General > Cellular Usage                                                 |
| "configuration_list"  | Settings > General > Profile                                                        |
| "date"                | Settings > General > Date & Time                                                    |
| "display"             | Settings > Display & Brightness                                                     |
| "do_not_disturb"      | Settings > Do Not Disturb                                                           |
| "facetime"            | Settings > Facetime                                                                 |
| "keyboard"            | Settings > General > Keyboard                                                       |
| "keyboards"           | Settings > General > Keyboard > Keyboards                                           |
| "locale"              | Settings > General > Language & Region                                              |
| "location"            | Settings > Location Services (in older versions of iOS)                             |
| "locations"           | Settings > Privacy > Location Services (in newer versions of iOS)                   |
| "tracking"            | Settings > Privacy > Tracking (iOS 14+)                                             |
| "mobile_data"         | Settings > Mobile Data (after iOS 10)                                               |
| "music"               | Settings > iTunes                                                                   |
| "music_equalizer"     | Settings > Music > EQ                                                               |
| "music_volume"        | Settings > Music > Volume Limit                                                     |
| "network"             | Settings > General > Network                                                        |
| "nike_ipod"           | Settings > Nike + iPod                                                              |
| "notes"               | Settings > Notes                                                                    |
| "notification_id"     | Settings > Notifications                                                            |
| "passbook"            | Settings > Passbook & Apple Pay                                                     |
| "phone"               | Settings > Phone                                                                    |
| "photos"              | Settings > Photo & Camera                                                           |
| "privacy"             | Settings > Privacy                                                                  |
| "reset"               | Settings > General > Reset                                                          |
| "ringtone"            | Settings > Sounds > Ringtone                                                        |
| "search"              | Settings > General > Assistant (before iOS 10)<br>Settings > Siri (after iOS 10)    |
| "settings"            | Settings > General                                                                  |
| "sound"               | Settings > Sounds                                                                   |
| "software_update"     | Settings > General > Software Update                                                |
| "storage"             | Settings > iCloud > Storage & Backup                                                |
| "store"               | Settings > iTunes & App Store                                                       |
| "tethering"           | Settings > Personal Hotspot                                                         |
| "touch"               | Settings > Touch ID & Passcode                                                      |
| "twitter"             | Settings > Twitter                                                                  |
| "usage"               | Settings > General > Storage & iCloud Usage                                         |
| "video"               | Settings > Video                                                                    |
| "vpn"                 | Settings > General > VPN                                                            |
| "wallpaper"           | Settings > Wallpaper                                                                |
| "wifi"                | Settings > WIFI                                                                     |

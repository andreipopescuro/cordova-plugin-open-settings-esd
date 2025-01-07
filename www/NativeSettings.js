const exec = require("cordova/exec");

exports.open = function (name, success, error) {
  if (typeof name !== "string")
    return error("Invalid argument! Expected type string.");
  exec(success, error, "NativeSettings", "open", [name]);
};

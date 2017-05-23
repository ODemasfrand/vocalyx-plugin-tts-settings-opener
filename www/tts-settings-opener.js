var exec = require('cordova/exec');

var TTSSettingsOpener = {};

TTSSettingsOpener.open = function(){
	return new Promise(function(resolve, reject){
		exec(resolve, reject, 'TTSSettingsOpener', 'open', []);
	});
};

module.exports = TTSSettingsOpener;

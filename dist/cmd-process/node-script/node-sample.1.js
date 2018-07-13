var fs = require('fs');
var path = require('path');

setTimeout(function myFunc(arg) {
	fs.writeFile(path.join(__dirname, 'node-sample.1.txt'), new Date().toISOString(), 'utf8', function(err) {
		if (err) throw err;
		console.log('Saved.');
	});
}, 3000, 'funky');
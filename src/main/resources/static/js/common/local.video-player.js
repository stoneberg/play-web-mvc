(function localFileVideoPlayer() {
	'use strict';
	const URL = window.URL || window.webkitURL;
	const playSelectedFile = function (e) {
		const file = this.files[0];
		const type = file.type;
		const videoNode = document.querySelector('video');
		let canPlay = videoNode.canPlayType(type);
		if (!canPlay) {
			canPlay = 'no';
		}
		const isError = canPlay === 'no';
		if (isError) {
			window.alert('Can\'t play type "' + type + '"');
			return;
		}
		const fileURL = URL.createObjectURL(file);
		videoNode.src = fileURL;
	};
	const inputNode = document.querySelector('input');
	inputNode.addEventListener('change', playSelectedFile, false);
})();

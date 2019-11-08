const init = function() {
	document.getElementById('submitstore').addEventListener('click',addstore);
	console.log("Welcome To Store Addition...");
}


const addstore = function(ev) {
	ev.preventDefault();
	document.getElementById('store-form').submit();

}



document.addEventListener('DOMContentLoaded',init);
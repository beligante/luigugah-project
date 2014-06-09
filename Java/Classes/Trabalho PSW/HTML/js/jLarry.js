var jLarry = function(selector){

	return new jLarry.fn.init(selector);
}

jLarry.fn = {
	var element,
	var init = function(selector){
		this.element = document.getElementById(selector);
		
		this.element = (element == null) ? document.getElementsByName(selector) : element;
		
		this.element = (element == null) ? document.getElementsByTagName(selector) : element;
		
		return this;
	}
}

window.$ = jLarry;
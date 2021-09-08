/**
 * 
 */
 function fn1(){
	alert('fn1');
}

let d3 = document.getElementById("d3");
d3.onmouseenter = function(){
	alert("익명함수");
	fn1();
};
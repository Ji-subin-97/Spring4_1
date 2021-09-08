/**
 * 
 */
 let fn2 = function(){
	alert("2222");
	fn1();
}
 
/*let d3 = document.getElementById("d3");
d3.onmouseenter = function(){
	alert("익명함수");
	fn1();
};*/

/*let d3 = document.getElementById("d3");
//d3.onmouseenter = fn2;
d3.addEventListener("mouseenter", function(){
	fn1();
});*/

let d3 = document.getElementById("d3");
//d3.onmouseenter = fn2;
d3.addEventListener("mouseenter", fn2);

 function fn1(){
	alert('fn1');
}
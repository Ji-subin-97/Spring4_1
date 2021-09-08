/**
 * 
 */
 
 let fn1 = function(){
	alert("okay");
/*	alert(title.value);
	alert(writer.value);*/
	
	alert(title.getAttribute("value"));
	alert(writer.getAttribute("value"));
}
 
 const submit = document.getElementById("submit");
 submit.addEventListener("click", fn1);
 
 const title = document.getElementById("title");
 const writer = document.getElementById("writer");
 
 

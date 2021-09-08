/**
 * 
 */
 
 let fn1 = function(){
	
	let t = title.value;
 	let w = writer.value;
 	
	alert("okay");
	if(t == "" || w ==""){
		alert("false");
	}else{
		alert("true");
	}

	
/*	alert(title.getAttribute("value"));
	alert(writer.getAttribute("value"));*/
}
 
 const submit = document.getElementById("submit");
 submit.addEventListener("click", fn1);
 
 const title = document.getElementById("title");
 const writer = document.getElementById("writer");
 

 
 
 

/**
 * 
 */
 
 let frm_submit = function(){
	frm.submit();
}
 
 let fn1 = function(){
	
	let t = title.value;
 	let w = writer.value;
 	let check = false;
	if(t == "" || w == ""){
	}else{
		check = true;
	}
	
	if(check == true){
		alert(check);
		frm_submit;
	}else{
		t_check.innerHTML="필수 입력"
	}
	
	
/*	alert(title.getAttribute("value"));
	alert(writer.getAttribute("value"));*/
}

 const submit = document.getElementById("submit");
 submit.addEventListener("click", fn1);
 
 const title = document.getElementById("title");
 const writer = document.getElementById("writer");
 const t_check = document.getElementById("title_check");
 const frm = document.getElementById("frm");

 
 
 

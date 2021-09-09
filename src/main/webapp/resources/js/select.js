/**
 * 
 */
 
 const c1 = document.getElementsByClassName("c1");
 const aa = document.getElementById("aa");
 
 for(let ch of c1){
	ch.addEventListener('click', function(){
		alert(ch.checked);
	});
	
};




/**
 * 
 */
 
 const btn = document.getElementById("btn");
 const c1 = document.getElementsByClassName("c1");
 
 let ar= [4,5,6];
 
 btn.addEventListener('click', function(){
	
/*	for(let i=0;i<ar.length;i++){
		console.log(ar[i]);
	}*/
	
	for(let i in ar){
		console.log(ar[i]);
	}
});
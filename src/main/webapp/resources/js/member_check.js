const checks = document.getElementsByClassName("checks");
const all = document.getElementById("all");
const btn = document.getElementById("btn");


all.addEventListener('click', function(){
	
	if(all.checked){
		for(let c of checks){
		c.checked = true;
		}
	}else{
		for(let c of checks){
		c.checked = false;
		}
	}	
});

//--------------------------------------------
for(let c of checks){
	c.addEventListener('click', function(){
		let result = true;
		
		for(c of checks){
			if(!c.checked){
				result = false;
				break;
			}
		}
		
		all.checked = result;
	});
}

//-----------------------------------------
btn.addEventListener('click', function(){
	if(all.checked==true){
		location.href = "./join";
	}else{
		alert("필수 약관에 동의 해야 합니다.");
	}
});


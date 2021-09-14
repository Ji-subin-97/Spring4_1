/**
 *
 
 	최대 5개까지 만 추가 가능
  
 */
 	let file = '<div class="input-group mb-3">';
  	file = file + '<input type="file" class="form-control">';
  	file = file + '<button class="btn btn-outline-secondary del" type="button"><span>X</span></button>';
	file = file + '</div>';
 	
 	let count = 0;
 	
 	$("#add_file").click(function(){
		
		if(count<5){
			count++;
			$("#fileAddResult").append(file);
		}else{
			alert("최대 5개");
		}
		
	});
	
/*	$(".del").click(function(){
		
		alert("!");
		$("#fileAddResult").remove(file);
		
	});*/
	
	$("#fileAddResult").on('click', '.del', function(){
		console.log(this);
	});

	
 
 
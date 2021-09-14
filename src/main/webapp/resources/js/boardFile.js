/**
 *
 
 	최대 5개까지 만 추가 가능
  
 */
 	
 	
 	let count = 0;
 	let index = 0;
 	
 	$("#add_file").click(function(){
		
		index++;
		
		let file = '<div id="del'+ index +'"class="input-group mb-3">';
	  	file = file + '<input type="file" class="form-control">';
	  	file = file + '<button data-btn-id="'+ index +'" class="btn btn-outline-secondary del" type="button">X</button>';
		file = file + '</div>';
		
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
		
		let num = $(this).attr("data-btn-id");;
		count--;
		$("#del"+ num).remove();
		
	});

	
 
 
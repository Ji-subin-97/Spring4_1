
//id, pw, name, email, phone 비어있으면 알림창


$('#id').blur(function () {
	let id = $('#id').val();
	
	$.get('./idCheckAjax?id='+id, function(data){
		
		if(data.trim()!=1){
			$('#idResult').html('사용불가능한 ID입니다.');
		}else{
			$('#idResult').html('사용가능한 ID입니다.');
		}
		
	});
});

$("#btn").click(function(){
	let result = true;
	let t;
	
	$(".put").each(function(s1, s2){
		
		if($(s2).val() == ""){
			result = false;
			t=s2;
		}
	});
	
	if(result){
		alert("submit");
		$("#frm").submit();
	}else{
		alert("필수 입력");
		$(t).focus();
	}
});

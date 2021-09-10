/**
 * 
 */
 
function checkForm(){
	
	if(!document.frm.id.value.trim()){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		document.frm.id.value = "";
		return false;
	}
	
	if(!document.frm.pw.value){
		alert("비밀번호를 입력해주세요.");
		document.frm.pw.focus();
		return false;
	}
	
	if(!document.frm.pw_check.value){
		alert("비밀번호가 일치하는지 확인해주세요.");
		document.frm.pw_check.focus();
		return false;
	}
	
	if(!document.frm.name.value){
		alert("이름을 입력해주세요.");
		document.frm.name.focus();
		return false;
	}
	
	if(!document.frm.email.value){
		alert("이메일을 입력해주세요.")
		document.frm.email.focus();
		return false;
	}
	
	if(!document.frm.ph.value){
		alert("휴대폰번호를 입력해주세요.")
		document.frm.ph.focus();
		return false;
	}
}


const put = document.getElementsByClassName("put");
const btn = document.getElementById('btn')
const pw = document.getElementsByClassName("pw");

btn.addEventListener('click', function(){
	//비어있는것들 검사
	let ce = checkEmpty(put);
	
});

function checkEmpty(puts){
	let result = true;
	for(r of puts){
		if(r.value.trim()==""){
			result = false;
			break;
		}
	}
}

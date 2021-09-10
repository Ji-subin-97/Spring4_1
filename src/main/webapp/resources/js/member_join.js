/**
 * 
 */
 /*const put = document.getElementsByClassName("put");
const btn = document.getElementById('btn')
const pws = document.getElementsByClassName("pw");
const frm = document.getElementById("frm");*/
const ids = document.getElementById("ids");
const idResult = document.getElementById("idResult");
const pwResult = document.getElementById("pwResult");

ids.addEventListener('blur', function(){
	
	if(document.frm.id.value.trim().length<6){
		ids.focus();
	}else{
	
	}
	
});

document.frm.pw_check.addEventListener('blur', function(){
	
	if(document.frm.pw.value != document.frm.pw_check.value){
		pwResult.innerHTML="비밀번호가 일치하지 않습니다.";
	}
});

/*ids.addEventListener('blur', function(){
	
	ids.value = "";
});*/

/*btn.addEventListener('click', function(){
	//비어있는것들 검사
	let ce = checkEmpty(put);
	//두개값이 같은지 검사
	let ce2 = checkEqual(pws[0].value, pws[1].value);
	
	let cl= checkLength();
	
	if(ce&&ce2&&c1){
		frm.submit();
	}else{
		alert("필수 입력");
	}
	
});

function checkLength(){
	let l = pws[0].value.trim().length;
	
	if(l>=6){
		return true;
	}else{
		return false;
	}
}

function checkEqual(check1, check2){
	return check1 == check2;
}

function checkEmpty(puts){
	let result = true;
	for(r of puts){
		if(r.value.trim()==""){
			result = false;
			break;
		}
	}
	
	return result;
}
*/
 
function checkForm(){
	
	if(!document.frm.id.value.trim()){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		document.frm.id.value = "";
		return false;
	}
	
	if(document.frm.id.value.trim().length<6){
		alert("아이디는 6글자 이상이여야 합니다.");
		document.frm.id.focus();
		return false;
	}
	
	if(!document.frm.pw.value){
		alert("비밀번호를 입력해주세요.");
		document.frm.pw.focus();
		return false;
	}
	
	if(document.frm.pw.value.length<6){
		alert("비밀번호는 6자리 이상이여야합니다.");
		document.frm.pw.focus();
		return false;
	}
	
	if(document.frm.pw.value != document.frm.pw_check.value){
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

//-------------------------------------------------------


const form = document.querySelector('#form');

const userName = form.username;
const email = form.email;
const password = form.password;
const rePassword = form.repassword;

const errorMessage = document.querySelector('#error_message');
const button = document.querySelector('#button');

const errorMessageArray = new Array();
let i = 0;
//------------------------------------------------

userName.onblur = checkUnique;
email.onblur = checkUnique;

let request;
let curFld ;
function checkUnique(){
	if(this.value.length!=0){
		curFld = this;

		request = new XMLHttpRequest();

		request.open('GET','unique_check.do?ukey='+this.value,true);
		request.onreadystatechange = uniqueResult;
		request.send();

		console.log(request);
	}
}

let flag1=true,flag2=true;
function uniqueResult(){
	if(request.readyState==4&&request.status==200){
		const resp = request.responseText;
		
		if(resp=='true'){
			errorMessage.style.display = 'block';
			let fld;
			if(curFld.id=="username"){
				fld = "username";
				flag1 = false;
			}else{
				fld = "email";
				flag2 = false;
			}
			errorMessage.innerHTML = `Account with this ${fld} data already exists`;
			//errorMessage.innerHTML = "Account with the given data already exists";
		}else{
			if(curFld.id=="username"){
				flag1 = true;
			}else{
				flag2 = true;
			}
		}
	}
}
//-------------------------------
userName.addEventListener('focus',()=>{
	userName.className = 'fields';
});

email.addEventListener('focus',()=>{
	email.className = 'fields';
});

rePassword.addEventListener('focus',()=>{
	rePassword.className = 'fields';
	password.className = 'fields';
});

password.addEventListener('focus',()=>{
	password.className = 'fields';
	rePassword.className = 'fields';
});

//--------------------------------
form.addEventListener('submit',(x)=>{
	x.preventDefault();
			
	let flag = true;

	const userNamePattern = /^[a-zA-Z][a-zA-Z0-9]{5,19}$/;

	if(!userNamePattern.test(userName.value)){
		flag = false;
		userName.className = 'error'
		errorMessageArray[i++] = 'only alphabet and numeric symbols are allowed';
	}
	
	const emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

	if(!emailPattern.test(email.value)){
		flag = false;
		email.className = 'error';
		errorMessageArray[i++] = 'invaid email entered';
	}

	/*const mobilePattern = /^[0-9]{10,10}$/;
	
	if(!mobilePattern.test(mobile.value)){
		flag = false;
		email.className = 'error';
		errorMessageArray[i++] = 'invaid mobile number';
	}*/

	if(password.value!=rePassword.value){
		flag = false;
		password.className = 'error';
		rePassword.className = 'error';
		errorMessageArray[i++] = 'password and repassword must match';
	}

	if(flag&&flag1&&flag2){
		form.submit();
	}else{
		errorMessage.style.display = 'block';

		errorMessageArray.forEach(errorMsg=>{
			let para = document.createElement('p');

			para.innerHTML = errorMsg;
			
			errorMessage.append(para);
		});
	}
});


button.addEventListener('mouseover',()=>{
	i = 0;	
	errorMessageArray.length = 0;
	
	errorMessage.style.display = 'none';
});

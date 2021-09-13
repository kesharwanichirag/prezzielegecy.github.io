const form = document.querySelector("#form");
const otpContainer = document.querySelector("#otp_container");
const otpBox = document.querySelector("#otp_box");
const close = document.querySelector("#close");
const loader = document.querySelector("#loader");
const resend_otp = document.querySelector("#resend_otp");

close.addEventListener('click',(e)=>{
	otpContainer.style.display = "none";
	otpBox.style.display = "none";
});

const sendOTP = async()=>{
	const mobile = form.mobile.value.trim();
	const data = await fetch("otp.do?mobile="+mobile);

	return data;
};

const updateUI = ()=>{
	otpBox.style.display = "block";
	loader.style.display = "none";
};

form.addEventListener('submit',(e)=>{
	if(form.otp.value.trim().length==5){
	}else{
		e.preventDefault();
		sendOTP()
			.then((data)=>{
				updateUI();
			}).catch((er)=>{
	
			});
			otpContainer.style.display= "block";
			loader.style.display = "block";
	}
});

resend_otp.addEventListener("click",(e)=>{
	sendOTP()
			.then((data)=>{
				console.log(data);
				updateUI();
			}).catch((er)=>{
	
			});
			otpContainer.style.display= "block";
			loader.style.display = "block";
			otpBox.style.display = "none";
});
const close = document.querySelector("#close");
const login_box = document.querySelector("#login_box");

//======================== show login =======================
window.addEventListener("load",(e)=>{
		setTimeout(()=>{
			login_box.style.display ="block";
		},300000000);
});
//======================== close login ======================

close.addEventListener('click',(e)=>{
	login_box.style.display = "none";
});

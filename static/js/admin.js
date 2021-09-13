const block_user = document.querySelector("#block_user");
const alert_box = document.querySelector("#alert_box");
const no = document.querySelector("#no");

block_user.addEventListener("click",(e)=>{
	alert_box.style.display = "block";
});

no.addEventListener("click",(e)=>{
	alert_box.style.display = "none";
});

//--------------------------------------------------------------

const unblock_user = document.querySelector("#unblock_user");
const alert_box2 = document.querySelector("#alert_box2");
const no2 = document.querySelector("#no2");

unblock_user.addEventListener("click",(e)=>{
	alert_box2.style.display = "block";
});

no2.addEventListener("click",(e)=>{
	alert_box2.style.display = "none";
});
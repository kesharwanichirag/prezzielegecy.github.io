const remove_profile = document.querySelector("#remove_profile");
const alert_box = document.querySelector("#alert_box");
const yes = document.querySelector("#yes");
const no = document.querySelector("#no");

remove_profile.addEventListener("click",(e)=>{
	alert_box.style.display = "block";
});

no.addEventListener("click",(e)=>{
	alert_box.style.display = "none";
});

const profile_pic = document.querySelector("#profile_pic");
const img_click_view = document.querySelector("#img_click_view");
const close = document.querySelector("#close");

profile_pic.addEventListener("click",(e)=>{
	img_click_view.style.display = "block";
});

close.addEventListener("click",(e)=>{
	img_click_view.style.display = "none";
});
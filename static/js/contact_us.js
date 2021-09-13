const feedback_link_box = document.querySelector("#feedback_link_box");
const alert_box = document.querySelector("#alert_box");
const close = document.querySelector("#close");

feedback_link_box.addEventListener("click",(e)=>{
	alert_box.style.display = "block";
});

close.addEventListener("click",(e)=>{
	alert_box.style.display = "none";
});
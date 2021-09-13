const add_new_add = document.querySelector("#add_new_add");
const all_add = document.querySelector("#all_add");

const add_box = document.querySelector("#add_box");
const form_box = document.querySelector("#form_box");

add_new_add.addEventListener("click",()=>{
	add_box.style.display = "block";
	form_box.style.display = "none";
	add_new_add.className = "active add_btns";
	all_add.className = "inactive add_btns";
});

all_add.addEventListener("click",()=>{
	add_box.style.display = "none";
	form_box.style.display = "block";
	all_add.className = "active add_btns";
	add_new_add.className = "inactive add_btns";
});
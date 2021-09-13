const search = document.querySelector('#search');
const search_button = document.querySelector("#search_button");

search_button.addEventListener('click',()=>{
	let key = search.value;	
	window.location = `search_result.jsp?search=${key}`;
});
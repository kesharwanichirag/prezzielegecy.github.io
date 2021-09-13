const search_icon = document.querySelector("#search_icon");
const search_bar = document.querySelector("#search_box");
const cross_icon1 = document.querySelector("#cross_icon1");
const menu_bar = document.querySelector("#menu_bar");
//-------------------------search ------------------------

search_icon.addEventListener('click',(e)=>{
	search_bar.style.width = "528px";
	search_icon.style.display = "none";
	cross_icon1.style.display = "block";
});

cross_icon1.addEventListener('click',(e)=>{
	search_bar.style.width = "0px";
	cross_icon1.style.display = "none";
	search_icon.style.display = "block";
});


//-----------------bar----------------


function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}


//====================categories===================
function openCat() {
  document.getElementById("cat_nav").style.width = "880px";
}

function closeCat() {
  document.getElementById("cat_nav").style.width = "0";
}

//-------------------------voice------------------------------
function startDictation(){
		const search = document.getElementById('search');

        if (window.hasOwnProperty('webkitSpeechRecognition')) {

          var recognition = new webkitSpeechRecognition();

          recognition.continuous = false;
          recognition.interimResults = false;
          recognition.lang = "en-US";
          recognition.start();

          recognition.onresult = function (e) {
            search.value = e.results[0][0].transcript;
            recognition.stop();
            document.getElementById('search_box').submit();
          };
          recognition.onerror = function(e) {
            recognition.stop();
          }
        }
      }



//------------------------categories------------------------
const cartcount = document.querySelector("#cart_count");

const proqt = document.querySelectorAll('.pro_qt')
const proqts = Array.from(proqt);
const addcart = document.querySelectorAll(".addcart_");
const add_to_cartbtns = Array.from(addcart);


const addCart = async(productId,quantity)=>{
	const url = "add_to_cart.do?";
	const query = `product_id=${productId}&quantity=${quantity}`;
	const resp = await fetch(url+query);
	const data = resp.json();

	return data;
};

add_to_cartbtns.forEach((adbtn,index)=>{
	adbtn.qnt = proqts[index];
	adbtn.addEventListener("click",(e)=>{
		let productId = e.target.getAttribute("data-actb");
		addCart(productId,e.target.qnt.value)
			.then((data)=>{
				cartcount.innerHTML = data.productCount;
				msg.style.display = "block";
				
				setTimeout(()=>{ 
					msg.style.display = "none";
				}, 2000);

			}).catch((err)=>{
				
			});
	});
});
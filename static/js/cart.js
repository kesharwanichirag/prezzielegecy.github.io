let pro_qt = Array.from(document.querySelectorAll(".pro_qt"));

const loader = document.querySelector("#loader");
const loaderContainer = document.querySelector("#loader_container");

const deleteing = document.querySelector("#deleteing");
const deleting_container = document.querySelector("#deleting_container");

const prods_crt = Array.from(document.querySelectorAll(".prods_crt"));
const cart_box = document.querySelector("#cart_box");

const ttl_amount = document.querySelector("#tt_amount");
let price = Array.from(document.querySelectorAll(".price_"));
const pro_amt = Array.from(document.querySelectorAll(".total_amt"));

const cart_count = document.querySelector("#cart_count");

const empty_cart = document.querySelector("#empty_cart");

const subtotal_box = document.querySelector("#subtotal_box");
const pay_ =  document.querySelector("#pay_");

const show_other_products = document.querySelector("#show_other_products");
//=======================checkout====================

pay_.addEventListener("click",()=>{
	window.location = "all_addresses.do";
});

//=======================single product amount ====================
const t = new Array();
let arr = 0;
const clc = ()=>{
	arr = 0;
	price.forEach((pri,index)=>{
		pri.pro_q = pro_qt[index];
		t [index]= parseInt(pri.pro_q.value)*parseInt(pri.innerHTML);
		pro_amt[index].innerHTML  = t[index];
	});

};

clc();
//==================== total amount ========================
let total = 0;
let item_count = 0;

const clcTotal = ()=>{
	total = 0;
	item_count = 0;
	pro_qt.forEach((qts,index)=>{
		item_count += parseInt(qts.value);
		total += parseInt(price[index].innerHTML) * parseInt(qts.value);
	});
	ttl_amount.innerHTML = total;
	cart_count.innerHTML = item_count;
	
	if(item_count==0){
		empty_cart.style.display = "block";
		show_other_products.style.display = "block";
		subtotal_box.style.display = "none";
	}else{
		empty_cart.style.display = "none";
		subtotal_box.style.display = "block";
	}
};

clcTotal();
//======================= update ===========================
const updateCart = async(proId,prqt)=>{
	const url = "update_cart.do?";
	const query = `product_id=${proId}&quantity=${prqt}`;
	const resp = await fetch(url+query);
	const data = await resp.json();
	
	return data;
};

const updateUI = ()=>{
	loader.style.display = "none";
	loader_container.style.display = "none";
};

pro_qt.forEach((qts,index)=>{
	total += parseFloat(price[index].innerHTML) * parseFloat(qts.value);
	total.toFixed(3);
	qts.addEventListener('change',(e)=>{
		let proId = e.target.getAttribute("data-proqt");
		let prqt = e.target.value;
		updateCart(proId,prqt)
			.then((data)=>{
				if(data.done=="true"){
					clc();
					clcTotal();
					updateUI();
				}
			}).catch((err)=>{

			});
			loaderContainer.style.display = "block";
			loader.style.display = "block";
	});
});

//========================= deleting record =========================
const remove_prod = Array.from(document.querySelectorAll(".remove_prod"));

const deleteCartRecord = async(proId)=>{
	const url = "delete_cart_record.do?";
	const param = `product_id=${proId}`;
	const resp = await fetch(url+param);
	const data = resp.json();
	return data;
};

const deletingUI = ()=>{
	setTimeout(()=>{ 
					deleteing.style.display = "none";
					deleting_container.style.display = "none";
				}, 500);
	deleteing.style.display = "none";
	deleting_container.style.display = "none";
};

remove_prod.forEach((del,index)=>{
	del.container = prods_crt[index];
	del.addEventListener('click',(e)=>{
		let proId = e.target.getAttribute("data-del");
		deleteCartRecord(proId)
			.then((data)=>{
				if(data.done=="true"){
					cart_box.removeChild(e.target.container);
					
					pro_qt = Array.from(document.querySelectorAll(".pro_qt"));
					price = Array.from(document.querySelectorAll(".price_"));
					
					clcTotal();
					//deletingUI();
				}
				//deleting_container.style.display = "block";
				//deleteing.style.display = "block";
			}).catch((err)=>{
				
			});
	});	
});

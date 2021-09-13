const form_1 = document.querySelector('#seller_form_1');
const form_2 = document.querySelector('#seller_form_2');
const form_3 = document.querySelector('#seller_form_3');
const form_4 = document.querySelector('#seller_form_4');
const form_5 = document.querySelector('#seller_form_5');
const form_6 = document.querySelector('#seller_form_6');
const form_7 = document.querySelector('#seller_form_7');
const form_8 = document.querySelector('#seller_form_8');
const form_9 = document.querySelector('#seller_form_9');
const form_10 = document.querySelector('#seller_form_10');

const product_id = document.querySelector('#product_id');
const product_name_headings = document.querySelectorAll(".product_name_headings");

const add_products_step1 = document.querySelector('#add_products_step1');
const add_products_step2 = document.querySelector('#add_products_step2');
const add_products_step3 = document.querySelector('#add_products_step3');
const add_products_step4 = document.querySelector('#add_products_step4');
const add_products_step5 = document.querySelector('#add_products_step5');
const add_products_step6 = document.querySelector('#add_products_step6');
const add_products_step7 = document.querySelector('#add_products_step7');
const add_products_step8 = document.querySelector('#add_products_step8');
const add_products_step9 = document.querySelector('#add_products_step9');
const add_products_step10 = document.querySelector('#add_products_step10');

const steps_ul = document.querySelectorAll('#steps_ul li');

const stepslist = Array.from(steps_ul);

//--------------------add more image--------------------------
const add_more_pic = document.querySelector('#add_more_button_img');
const product_image_record = document.querySelector('#product_image_record');

let r = 1;

add_more_pic.addEventListener('click',()=>{
	const nr = 	product_image_record.insertRow(r++);
	
	const c1 = nr.insertCell(0);
	const c2 = nr.insertCell(1);

	c1.innerHTML =	`&#9733;`;
	c2.innerHTML =	`<input type='file' class='product_images' name='product_images'+${r}>`;
});

//--------------------add more product points-----------------
const add_more_button = document.querySelector('#add_more_button');
const product_point_record = document.querySelector('#product_point_record');

let row = 1;

add_more_button.addEventListener('click',()=>{
	const nr = product_point_record.insertRow(row++);

	const c1 = nr.insertCell(0);
	const c2 = nr.insertCell(1);
	const c3 = nr.insertCell(2);
	
	c1.innerHTML = `&#9733;`;
	c2.innerHTML = "<input type='text' class='point_header' placeholder='Enter Points'>";
	c3.innerHTML = "<textarea class='point_value' placeholder='Enter Points Details'></textarea>";
});

//------------------------9: product points---------------------------------------
const saveProductPoints = async(request) =>{
	const response = await fetch(request);
	const data = response.json();

	return data;
}

form_9.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	const prod_ttls = Array.from(document.querySelectorAll('.point_header'));
	const prod_vals = Array.from(document.querySelectorAll('.point_value'));
	console.log(prod_ttls);
	console.log(prod_vals);
	const url = "save_product_points.do?";

	let query = "";
	let i = 0;
	prod_ttls.forEach((point_header)=>{
		if(i==0)
			query += `prod_ttl=${encodeURIComponent(point_header.value)}`;
		else
			query += `&prod_ttl=${encodeURIComponent(point_header.value)}`;
		i++;
	});
	prod_vals.forEach((point_value)=>{
		query += `&prod_val=${point_value.value}`;
	});
	
	saveProductPoints(url+query)
		.then((data)=>{
			if(data.resp==1){
				add_products_step9.className = 'hide add_products_steps'; 
				add_products_step10.className = 'show add_products_steps';
				stepslist[8].className = 'done';
				stepslist[9].className = 'open';
			}else{
				console.log("---------");
			}
		}).catch((err)=>{
			console.log(err);
		});
});
//--------------------8: save product_warranty -------------------------------
const saveProductWarranty = async ()=>{
	const url = "save_product_warranty.do?";
	const query = `product_warranty=${encodeURIComponent(form_8.product_warranty.value)}`;
	
	const response = await fetch(url+query);
	const data = await response.json();
	
	return data;
};

form_8.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveProductWarranty().then((data)=>{
		if(data.resp===1){
			add_products_step8.className = 'hide add_products_steps'; 
			add_products_step9.className = 'show add_products_steps';
			stepslist[7].className = 'done';
			stepslist[8].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});


//--------------------7: save product_returning_policy -------------------------------
const saveProductReturningPolicy = async ()=>{
	const url = "save_product_returning_policy.do?";
	const query = `product_returning_policy=${encodeURIComponent(form_7.product_returning_policy.value)}`;
	
	const response = await fetch(url+query);
	const data = await response.json();
	
	return data;
};

form_7.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveProductReturningPolicy().then((data)=>{
		if(data.resp===1){
			add_products_step7.className = 'hide add_products_steps'; 
			add_products_step8.className = 'show add_products_steps';
			stepslist[6].className = 'done';
			stepslist[7].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});


//--------------------6: save product_payment_details -------------------------------
const saveProductPaymentDetails = async ()=>{
	const url = "save_product_payment_details.do?";
	const query = `product_payment_details=${encodeURIComponent(form_6.product_payment_details.value)}`;
	
	const response = await fetch(url+query);
	const data = await response.json();
	
	return data;
};

form_6.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveProductPaymentDetails().then((data)=>{
		if(data.resp===1){
			add_products_step6.className = 'hide add_products_steps'; 
			add_products_step7.className = 'show add_products_steps';
			stepslist[5].className = 'done';
			stepslist[6].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});

//--------------------5: save product shipping_details -------------------------------
const saveProductShippingDetails = async ()=>{
	const url = "save_product_shipping_details.do?";
	const query = `product_shipping_details=${encodeURIComponent(form_5.product_shipping_details.value)}`;
	
	const response = await fetch(url+query);
	const data = await response.json();
	
	return data;
};

form_5.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveProductShippingDetails().then((data)=>{
		if(data.resp===1){
			add_products_step5.className = 'hide add_products_steps'; 
			add_products_step6.className = 'show add_products_steps';
			stepslist[4].className = 'done';
			stepslist[5].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});



//--------------------4: save product disclamer -------------------------------
const saveProductDisclamer = async ()=>{
	const url = "save_product_disclamer.do?";
	const query = `product_disclamer=${encodeURIComponent(form_4.product_disclamer.value)}`;
	
	const response = await fetch(url+query);
	const data = await response.json();

	return data;
};

form_4.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveProductDisclamer().then((data)=>{
		if(data.resp===1){
			add_products_step4.className = 'hide add_products_steps'; 
			add_products_step5.className = 'show add_products_steps';
			stepslist[3].className = 'done';
			stepslist[4].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});


//--------------------3: save product specification -------------------------------
const saveProductSpecification = async ()=>{
	const url = "save_product_specification.do?";
	const query = `product_specification=${encodeURIComponent(form_3.product_specification.value)}`;
	
	const response = await fetch(url+query);
	const data = await response.json();

	return data;
};

form_3.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveProductSpecification().then((data)=>{
		if(data.resp===1){
			add_products_step3.className = 'hide add_products_steps'; 
			add_products_step4.className = 'show add_products_steps';
			stepslist[2].className = 'done';
			stepslist[3].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});

//--------------------2: save Description -------------------------------
const saveDescription = async ()=>{
	const url = "save_product_description.do?";
	const query = `product_description=${encodeURIComponent(form_2.product_description.value)}&product_id=${product_id.value}`;
	
	const response = await fetch(url+query);
	const data = await response.json();

	return data;
};

form_2.addEventListener('submit',(e)=>{
	e.preventDefault();
	
	saveDescription().then((data)=>{
		if(data.resp===1){
			add_products_step2.className = 'hide add_products_steps'; 
			add_products_step3.className = 'show add_products_steps';
			stepslist[1].className = 'done';
			stepslist[2].className = 'open';
		}else if(data.resp===0){

		}else{
			window.location = "login.do";
		}
	}).catch((err)=>{
		console.log(err);
	});
});
//--------------------1: save products ----------------------------------
const saveProduct = async ()=>{
	const URL = "new_product.do?";
	const query = `category_id=${form_1.category_id.value}&product_name=${encodeURIComponent(form_1.product_name.value)}&product_quantity=${form_1.product_quantity.value}&product_price=${form_1.product_price.value}&product_discount=${form_1.product_discount.value}`;
	
	const response = await fetch(URL+query,{method:"post"});
	const data = await response.json();
	console.log(data.productName);
	return data;
};

form_1.addEventListener('submit',(e)=>{
	e.preventDefault();
		
	saveProduct().then((data)=>{
		if(data.resp==0){
			window.location = "login.do";
		}else{
			if(data.productId){
				product_id.value = data.productId;
				add_products_step1.className = 'hide add_products_steps'; 
				add_products_step2.className = 'show add_products_steps';
				stepslist[0].className = 'done';
				stepslist[1].className = 'open';
				product_name_headings.forEach((w)=>{
					w.innerHTML = data.productName;
				}); 
			}
		}
	}).catch((err)=>{
		console.log(err);
	});		
});
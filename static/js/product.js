const product_id = document.querySelector("#product_id");
const small_images_box = document.querySelector("#small_image_box");
const big_image_box = document.querySelector("#big_image_box");

const getAllProductPics = async()=>{	
	const url = "get_product_pics.do?";
	const query = `product_id=${product_id.value}`;

	const response = await fetch(url+query);
	const data = response.json();

	return data;
};

const showProductPics =(pics)=>{
	small_images_box.innerHTML = "";
	let i = 0;
	
	pics.forEach((pic)=>{
		if(i==0){
			big_image_box.innerHTML = `<img src="show_product_pic.do?product_pic=${pic.productPic}" id="show_image">`;	
		}
		small_images_box.innerHTML += `<img src="show_product_pic.do?product_pic=${pic.productPic}" class="pro_show_img">`;		
	});
	const small_images = document.querySelectorAll(".pro_show_img");
	const show_image = document.querySelector("#show_image");
	const small_image = Array.from(small_images);

	small_image.forEach((pic)=>{
		pic.addEventListener('click',(e)=>{
			show_image.src = e.target.src;	
		});	
	});

};
//---------------------------------------------------------
const getAllProductPoints = async()=>{
	const url = "get_product_points.do?";
	const param = `product_id=${product_id.value}`;

	const resp = await fetch(url+param);
	const data = resp.json();

	return data;
};

const product_points_table = document.querySelector("#product_points_table"); 
let w = 0;
const showProductPoints = (points)=>{
	console.log(points);
	points.forEach((point)=>{
		let row = product_points_table.insertRow(w++);

		let c1 = row.insertCell(0);
		let c2 = row.insertCell(1);

		c1.className = "lft_";
		c2.className = "rht_";

		c1.innerHTML = `<span class="point_head">
							${point.pointHeader}
						</span>`;
		c2.innerHTML = `<span class="points">
							${point.pointValue}
						</span>`;
	});
};

window.addEventListener('load',(e)=>{
	getAllProductPics()
		.then((data)=>{	
			showProductPics(data);
		}).catch((err)=>{
			console.log(err);
		});	

	getAllProductPoints()
		.then((data)=>{
			showProductPoints(data);
		}).catch((err)=>{
			
		});
});


//-------------------------------------------------------
const all_datas = document.querySelectorAll(".other");

const all_box = Array.from(all_datas);

const other_details = document.querySelectorAll(".other_details");
const tabs = Array.from(other_details);

let arr = 0;

tabs.forEach((tab)=>{
	tab.dtl_bx = all_box[arr++];
	tab.addEventListener('click',(e)=>{
		tabs.forEach((tb)=>{
			tb.className = "other_details other_details_no";
		});	
		all_box.forEach((box)=>{
			box.className = "other other_hide";	
		});

		let t = e.target;
		if(t.classList.contains("other_details_no")){
			t.className = "other_details other_details_selected";
			t.dtl_bx.className = "other other_show";
		}else{
			t.className = "other_details other_details_no";
			t.dtl_bx.className = "other other_hide";
		}
	});
});
//--------------------------------------------------

/*const box1 = document.querySelector("#box_1");
const box2 = document.querySelector("#box_2");

const dtls_container__box = document.querySelector("#dtls_container__box");
const rev_container__box = document.querySelector("#rev_container__box");

box1.addEventListener('click',(e)=>{
	box1.className = "__dtls active";
	box2.className = "__dtls dactive";
	dtls_container__box.style.display = "block";
	rev_container__box.style.display = "none";
});

box2.addEventListener('click',(e)=>{
	box2.className = "__dtls active";
	box1.className = "__dtls dactive";
	dtls_container__box.style.display = "none";
	rev_container__box.style.display = "block";
});*/


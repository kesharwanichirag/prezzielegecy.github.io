//------------------- All Products -------------------------
const search_key = document.querySelector("#search_key");
const block1 = document.querySelector("#block1");
const not_found = document.querySelector("#not_found");
const cart_count = document.querySelector("#cart_count");

const AllProducts = async()=>{
	const url = "search.do?";
	const query = `search=${search_key.value}`;
	const resp = await fetch(url+query);
	const data = resp.json();

	return data;
}

const addToCart = async(productId,quantity)=>{
	const url = "add_to_cart.do?";
	const query = `product_id=${productId}&quantity=${quantity}`;
	const resp = await fetch(url+query);
	const data = resp.json();

	return data;
};
	
const showProducts = (products)=>{
	if(products.length>0){
		block1.innerHTML = "";
		not_found.style.display = "none";
		products.forEach((product)=>{
			block1.innerHTML += `
								<div class="prods_1">
									<div class="lft_view">
										<img src="product_image.do?product_id=${product.productId}" class="view_images_">
									</div>
									<div class="rht_view">
										
										<span class="addcart_ but_add" data-actb="${product.productId}">Add To Cart</span>
										
										<span class="buynow_ but_add">Buy Now</span>
										<select class="pro_qt">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
										</select>
										<span class="prd_name_bx">
											<a href="user_product_view.do
												?product_id=${product.productId}">
												${product.productName}
											</a>
										</span>
										<br>
										<span class="rating_box">
											<span id="rate">4.0 &#9733;</span>
											<span class="rev">Ratings:100</span>
											<span class="rev">|</span>
											<span class="rev">Reviews:500</span>
										</span>
										<br>
										<span class="labl_">
											Price -
										</span>
										<span class="price_">
											&#x20B9; ${product.price*(100-product.discount)/100}
										</span>
										<s class="mrp_">
											(MRP: &#x20B9; ${product.price})
										</s>
										<span class="discount_">
											${product.discount}% off
										</span>
									</div>
								</div>`;
		});
		
		const addcart_ = document.querySelectorAll(".addcart_");
		const add_to_cart_btns = Array.from(addcart_);
		
		const pro_qt = document.querySelectorAll('.pro_qt')
		const pro_qts = Array.from(pro_qt);
		
		add_to_cart_btns.forEach((adbtn,index)=>{
			adbtn.qnt = pro_qts[index];
			adbtn.addEventListener("click",(e)=>{
				let productId = e.target.getAttribute("data-actb");
				addToCart(productId,e.target.qnt.value)
					.then((data)=>{
						cart_count.innerHTML = data.productCount;
						msg.style.display = "block";
						
						setTimeout(()=>{ 
							msg.style.display = "none";
						}, 2000);

					}).catch((err)=>{
						
					});
			});
		});
	}else{
		not_found.style.display = "block";
	}
};


window.addEventListener("load",(e)=>{
	AllProducts().
		then((data)=>{
			showProducts(data)
		}).catch((err)=>{
			console.log(err);
		});		
});

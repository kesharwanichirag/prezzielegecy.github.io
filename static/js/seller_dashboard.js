//------------------- All Products -------------------------
const allprodsbtn = document.querySelector('#allprods');
const sel_id = document.querySelector("#sel_id");

const AllProducts = async()=>{
	const url = "all_products.do?";
	const query = `seller_id=${sel_id.value}`;

	const resp = await fetch(url+query);
	const data = resp.json();

	return data;
}

const block1 = document.querySelector("#block1");
const not_found = document.querySelector("#not_found");
	
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
										<span class="delete_">DELETE PRODUCT</span>
												
										<span class="prd_name_bx">
											<a href="product_view.do?product_id=${product.productId}">
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
										<label id="lb_l">
											Price:
										</label>
										<span class="price_">
											&#x20B9; ${product.price*(100-product.discount)/100}
										</span>
										<s class="mrp_">
											(MRP: &#x20B9; ${product.price})
										</s>
										<span class="discount_">
											Discount: ${product.discount}%
										</span>
										<br>
										<span class="quantity_">
											Quantity:
										</span>
										<span class="quantity_t_">
											${product.quantity}
										</span>
										<span class="quantity_">
											Available:
										</span>
										<span class="quantity_t_">
											${product.quantity}
										</span>
										<span class="sold_">
											Sold:
										</span>
										<span class="sold_t_">
											${product.sold}
										</span>
									</div>
								</div>`;
		});	
	}else{
		not_found.style.display = "block";
	}
};

AllProducts().
		then((data)=>{
			showProducts(data);
		}).catch((err)=>{
			console.log(err);
		});
const addcart_ = document.querySelector("#add_to_cart");
const pro_qt = document.querySelector("#pro_qt");
const rev_btn = document.querySelector("#rev_btn");
const user_rate_box_form = document.querySelector("#user_rate_box_form");
const close = document.querySelector("#close")
const give_rev_box = document.querySelector("#give_rev_box");
const text_area_field = document.querySelector("#text_area_field");
const button = document.querySelector("#button");
const _rate_ = document.querySelector("#_rate_");
const rate_s = document.querySelector("#rate_s");
const show_rate_part = document.querySelector("#show_rate_part");
const rev = document.querySelector("#rev");

//################## show rate average #######################
/*const avgRatings = async()=>{
	const url = "average_rating_product.do?";
	const param = `product_id=${product_id.value}`;

	const resp = await fetch(url+param);
	const data = resp.json();

	return data;
};*/
/*	
const showAllRatingsUser = (rate)=>{
	_rate_.innerHTML = "";
	_rate_.innerHTML += `
						${rate.userRating}	
						`;
	
};*/
//####################count of rating#######################


const countRatings = async()=>{
	const url = "count_rating_product.do?";
	const param = `product_id=${product_id.value}`;
	const resp = await fetch(url+param);
	const data = resp.json();

	return data;
};

const countRatingsUser = (ratings)=>{
	let rate = ratings.length;
	show_rate_part.innerHTML = `Reviews/Ratings:${rate}`;
	rev.innerHTML = `Reviews/Ratings:${rate}`;	
};

/*
const AverageUser = (ratings)=>{
	
	rev.innerHTML = `Reviews/Ratings:${rate}`;
	rate_s.innerHTML = `${sum/ratings.length}`;
};
*/
//################# add to cart ###################################
const addToCart = async(productId,quantity)=>{
	const url = "add_to_cart.do?";
	const query = `product_id=${productId}&quantity=${quantity}`;
	const resp = await fetch(url+query);
	const data = resp.json();

	return data;
};

addcart_.addEventListener("click",(e)=>{
	let productId = e.target.getAttribute("data-actb");
	addToCart(productId,pro_qt.value)
		.then((data)=>{
			cart_count.innerHTML = data.productCount;
			msg.style.display = "block";
			
			setTimeout(()=>{ 
				msg.style.display = "none";
			}, 2000);

		}).catch((err)=>{
			
		});
});

//########################### get reviews ##########################
const view_all_reviews_in_box = document.querySelector("#view_all_reviews_in_box");

const getReviews = async()=>{
	const url = "show_rating_product.do?";
	const param = `product_id=${product_id.value}`;

	const resp = await fetch(url+param);
	const data = resp.json();

	return data;
};

const showAllReviews = (ratings)=>{
	view_all_reviews_in_box.innerHTML = "";
	ratings.forEach((rate)=>{
		view_all_reviews_in_box.innerHTML += 
												`<div class="view_user_ratings">
													<div class="rate show_rating_user">${rate.userRating}&#9733;</div>
													<span id="key_message">${rate.keyMessage}</span>											
													<br>
													<span class="by_">by</span>
													<span class="user_name">___</span>
													<span class="on">on</span>
													<span class="rate_date"> Date:${rate.date}</span>
													<div class="show_user_review">
														${rate.userReview}
													</div>
													<div>
													<i class="fa fa-thumbs-o-up like" aria-hidden="true"></i>
													<i class="like_count">5</i>
													<i class="fa fa-thumbs-o-down dislike" aria-hidden="true"></i>
													<i class="like_count">0</i>
													</div>
												</div>`;
	});
};
rev_btn.addEventListener('click',(e)=>{
	user_rate_box_form.style.display = "block";
});

close.addEventListener('click',(e)=>{
	text_area_field.innerHTML = " ";
	user_rate_box_form.style.display = "none";
});

//############################### save review #################################
const saveReview = async ()=>{
	const URL = "rate_product.do?";
	const query = `product_id=${user_rate_box_form.product_id.value}&rating=${user_rate_box_form.rating.value}&review=${user_rate_box_form.review.value}&key_message=${user_rate_box_form.key_message.value}`;
	
	const response = await fetch(URL+query,{method:"post"});
	const data = await response.json();
	return data;
};

user_rate_box_form.addEventListener('submit',(e)=>{
	e.preventDefault();	
	saveReview().then((data)=>{
		if(data.resp==0){
			window.location = "login.do";
		}else{
			if(data.productId){
				product_id.value = data.productId;
			}
		}
	}).catch((err)=>{
		console.log(err);
	});		
});

//#######################################################################

user_rate_box_form.addEventListener('submit',(e)=>{
	setTimeout((time)=>{
		text_area_field.value = "";
	},'500');
	user_rate_box_form.style.display = "none";
	getReviews().
		then((data)=>{
			showAllReviews(data);
		}).catch((err)=>{
			
		});
	
	countRatings().
		then((data)=>{
			countRatingsUser(data);
		}).catch((err)=>{
			
		});
});

window.addEventListener("load",(e)=>{
	getReviews().
		then((data)=>{
			showAllReviews(data);
		}).catch((err)=>{
			
		});

	countRatings().
		then((data)=>{
			countRatingsUser(data);
			//AverageUser(data);
		}).catch((err)=>{
		
		});
});

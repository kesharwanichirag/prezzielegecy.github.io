const city = document.querySelector('#city');
const city_id = document.querySelector('#city_id');
const srch_res = document.querySelector('#srch_res');

city.addEventListener('keyup',()=>{
	let skey = city.value;
	if(skey.length>2){
		getCities('search_city.do?skey='+skey)
			.then((data)=>{
				srch_res.innerHTML = '';

				for(i=0;i<data.length;i++){
					let dv = document.createElement('div');
					dv.innerHTML = data[i].city;
					dv.cityId = data[i].cityId;
					dv.addEventListener('click',(e)=>{
						city.value = e.target.innerHTML;
						city_id.value = e.target.cityId;
						srch_res.style.display = 'none';
					});
					srch_res.append(dv);
				}
				
				srch_res.style.display = 'block';
			})
			.catch((err)=>{
				console.log('Error:',err);
			});
	}
});

const getCities = async (url)=>{
	const response = await fetch(url);	
	
	if(response.status!=200){
		throw new Error('No Records Found....');
	}
	
	const data = await response.json();

	return data;
};
let urlEncodedForm = data => {
	/*
		data : urlEncoded 로 포메팅하고 싶은 데이터
		속성명 : parameter Name
		값 : parameter value  */
	
	let arr = [];
	
	/* for-in : data 객체에 담겨있는 속성명을 탐색해서 반환  */
	for(key in data){
		let param = encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
		arr.push(param);
	}
	
	return arr.join('&');
};
let urlEncodeForm = data => {
	/*	data : urlEncode 방식으로 작성하고 싶은 데이터
		parameter Name : 속성명
		parameter value : 값  */
	let arr = [];
	/* data의 속성명들이 key에 담긴다. */
	for(key in data){
		let param = encodeURIComponent(key) + '=' +encodeURIComponent(data[key]);
		arr.push(param);
	}
	
	return arr.join('&');
}
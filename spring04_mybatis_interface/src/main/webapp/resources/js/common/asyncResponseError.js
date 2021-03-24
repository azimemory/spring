class AsyncResponseError extends Error{
	response;
	constructor(response){
		super();
		this.response = response;
	}
	
	alertMessage(){
		let scripts = document.scripts;
		
		this.response.then(text =>{
			document.querySelector('html').innerHTML = text;	
			//해당 페이지의 마지막 스크립트 태그에 담겨있는 자바스크립트 코드를 실행
			new Function(scripts[scripts.length-1].innerHTML)();		
		})
	}
}
/**
 * 
 */
const searchclick = function(){

	const category = document.querySelector('select[name="category"]').value;
	const keyword = document.querySelector('input[name="keyword"]').value;
	const from = document.querySelector('input[name="from"]').value;
	const to = document.querySelector('input[name="to"]').value;
	
	let isValid = true;
	if(keyword.value.length == 0 && category.value.length ==0 
			&& from.value.length==0 && to.value.length ==0){
				isValid=false
				alert('검색어를 입력하세요')}
	
	
	const jsObj = {};
	if (category.length !== 0) {
	    jsObj.category = category;
	} else if (keyword.length !== 0) {
	    jsObj.keyword = keyword;
	} else if (from.length !== 0) {
	    jsObj.from = from;
	} else if (to.length !== 0) {
	    jsObj.to = to;
	}
		
    console.log('자바스크립트 객체 : ',jsObj)
    
    const jsonData = JSON.stringify(jsObj)
    console.log('json 문자열 : ',jsonData)
   
   const xhr = new XMLHttpRequest()      //비동기 통신 객체 생성
    xhr.open('PUT','api/product')         //전송 보낼 준비 (url과 method)
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(jsonData)    
            //요청 전송.POST는 페이로드가 있습니다.
    xhr.onload=function(){         //요청에 대한 응답받았을 때 onload 이벤트 생깁니다. onload 핸들러 함수
        if(xhr.status === 200 || xhr.status ===201){        // readyState 가 DONE
             console.log("PUT 응답 :",xhr.response)      //response 는 응답받은 내용을 저장한 프로퍼티
           	const arr = JSON.parse(xhr.response);		 //응답받은 json 문자열을 자바스크립트의 객체의 배열로 변환 (역직렬화)
			 console.log("get api/product", arr);
			 
			 
			 //json 문자열 응답을 자바스크립트 배열객체로 변환하여 요소 하나씩을 ele 변수에 대입한 후 화면에 값을 태그 요소에 출력하는 코드
			 const list = document.querySelector('#list');
			 list.innerHTML='';
			 arr.forEach((ele,index)=>{
				 const li = document.createElement('li');
				 const ul = document.createElement('ul');
				 ul.className='row';
				 ul.innerHTML=
				 `<li>${index+1}</li>
				  <li>${ele.pcode}</li>
				  <li>${ele.category}</li>
				  <li>${ele.pname}</li>
				  <li style =\"text-align:right;\">${ele.price.toLocaleString('ko-KR')}</li>`
				 li.appendChild(ul);
				 list.appendChild(li);
			 })
		 } else {
			 console.log('오류1', xhr.status);
			 console.log('오류2', xhr.response);
		 }
	 }
}

 document.querySelector('#search').addEventListener('click',searchclick);
 
 
 
 
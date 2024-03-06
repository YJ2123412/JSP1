/**
 * 비동기 통신을 지원하는 자바스크립트 XHR 사용하기(GET)
 */

 const selectAll = function(){
	 const xhr = new XMLHttpRequest();					//비동기 통신 객체 생성
	 xhr.open('GET','api/buy/list')					//전송 보낼 준비(url과 method)
	 xhr.send();										//요청 전송
	 xhr.onload=function(){								//요청에 대한 응답받았을때 onload이벤트가 생김, onload 핸들러 함수
		 if(xhr.status === 200 || xhr.status ===201){	// readyState가 Done
			 console.log("요청응답: ", xhr.response);		//response는 응답받은 내용을 저장한 프로퍼티
			 const arr = JSON.parse(xhr.response);		 //응답받은 json 문자열을 자바스크립트의 객체의 배열로 변환 (역직렬화)
			 console.log("get api/buy/list", arr);
			 
			 //json 문자열 응답을 자바스크립트 배열객체로 변환하여 요소 하나씩을 ele 변수에 대입한 후 화면에 값을 태그 요소에 출력하는 코드
			 const list = document.querySelector('#list');
			 arr.forEach((ele,buy_Idx)=>{
				 const li = document.createElement('li');
				 const ul = document.createElement('ul');
				 ul.className='row' ;
				 ul.innerHTML=
				 `<li>${ele.buy_Idx}</li>
				  <li>${ele.customid}</li>
				  <li>${ele.pcode}</li>
				  <li>${ele.quantity}</li>
				  <li>${ele.buy_Date}</li>`
				 li.appendChild(ul);
				 list.appendChild(li);
			 })
		 } else {
			 console.log('오류1', xhr.status);
			 console.log('오류2', xhr.response);
		 }
	 }
 }
/*  document.querySelector('#selectAll').addEventListener('click',selectAll);
	 $("#selectAll").empty();
*/
  
 /*처음 화면이 표시될때 실행하기*/
 selectAll()
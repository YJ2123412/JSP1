/*상품 조회 검색어 입력을 확인하기 위한 내용*/


const category = document.querySelector('select[name="category"]');
const keyword = document.querySelector('input[name="keyword"]');
const from = document.querySelector('input[name="from"]');
const to = document.querySelector('input[name="to"]');

/*console.log(temp);*/
//카테고리 조회시에만 temp값이 null이 아님
	/*if(temp!=null) category.value=temp;
	
		document.querySelector('#search').addEventListener('click',()=>{
			let isValid = true;
			if(keyword.value.length == 0 && category.value.length ==0 
			&& from.value.length==0 && to.value.length ==0){
				isValid=false
				alert('검색어를 입력하세요');}
		
			if(isValid){
				document.forms[0].submit();}
	})*/
	
	document.querySelector('#selectAll').addEventListener('click',()=>{
				document.forms[0].submit();
	})



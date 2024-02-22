/**
 * 
 */

 
 document.getElementById('search').addEventListener('click',function(){
	 //input 에 입력한 값 가져오기
	 const name = document.getElementById('name').value;
	 const age = document.querySelector('#age').value;
	 
	 console.log('입력값: ',name,age)
	 
	 //url 6번 파일로 파라미터 포함하여 넘기기 웹브라우저의 주소변경 : location 객체의 'href' 속성값은 'url' 주소 - 파일지정과 별개
	 //location.href="6_selectBy.jsp"; 
	 //location.href="6_selectBy.jsp?name=김사나&age=23"; 
	 location.href=`6_selectBy.jsp?name=${name}&age=${age}`; 
	 
		if((name !=null && name.length()!=0)&&(temp!=null && temp.length() !=0)){
			
			out.print("<h4>name</h4>");
			out.print(name);
			
			out.print("<h4>age</h4>");
			out.print(age);
		} else{
			out.print("파라미터 값을 모두 입력하세요");
		}
 })
 
 
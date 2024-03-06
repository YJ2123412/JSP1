<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/modal.css">
</head>
<body>
<%@ include file="header.jsp" %>
   <h3>상품 관리</h3>
   <hr>
   <form style="display: flex; justify-content: space-around; align-items: center;">
      <select name="category">
         <option value="">카테고리 선택</option>
         <c:forEach items="${cateList}" var="category">
            <option value="${category.code}" >
                <c:out value="${category.name}" />(<c:out value="${category.code}" />)
            </option>
         </c:forEach>
      </select>
      <input type="text" name="keyword" value="${keyword}" placeholder="상품명 검색어 입력" />
      <span style="padding-left: 10px;">가격대별</span>
      <input type="text" name="from" placeholder="from" />~
      <input type="text" name="to" placeholder="to" />
      	<button type ="button" id="search">조회</button>
      <button id="selectAll" type="button" >전체보기</button>
   </form>
   <hr>
   <button id="new">새상품 등록</button>
   <ul id="list">
    
   </ul>
   <!-- The Modal -->
    <div class="modal">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <h4 class="modal-title">새 상품 등록</h4>
             </div>
             <div class="modal-body">
                   <ul >
                      <li>
                         <input type="text" id="pcode" placeholder="상품코드를 입력하세요.">
                      </li>
                      <li>
                         <select id="category">
                            <option value="">카테고리 선택</option>
                            <c:forEach items="${cateList}" var="cate">
                               <option value="${cate.code}" >
                                  <c:out value="${cate.name}" />(<c:out value="${cate.code}" />)
                               </option>
                            </c:forEach>
                         </select>
                      </li>
                      <li>
                         <input type="text" id="pname" placeholder="상품명을 입력하세요.">
                      </li>
                      <li>
                         <input type="number" id="price" placeholder="가격을 입력하세요.">
                      </li>
                      <li>
                         <button id="post">저장</button>&nbsp;&nbsp;&nbsp;<button id="clear">다시쓰기</button>
                      </li>
                   </ul>
             </div>
             <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <!--  <button type="button" class="btn btn-primary">Save changes</button>-->
             </div>
          </div>
       </div>
    </div>
    <!-- 모달 끝 -->
    <!--스크립트 상에서 위에서 먼저 js 선언 하면 아래에 있는 js에서도 사용 가능  -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   	<script type="text/javascript">
      const modal = new bootstrap.Modal(document.querySelector('.modal'));
      //modal.show();
      const temp = '${category}';
  	 </script>
  	 <!-- 위의 변수 temp는 search.js와 공유합니다. -->
  	 <script type="text/javascript" src="assets/js/productApi_list.js"></script>
  	 <script type="text/javascript" src="assets/js/productApi_post.js"></script>
<!--   	 <script type="text/javascript" src="assets/js/search.js"></script> -->
  	 <script type="text/javascript" src="assets/js/productApi_search.js"></script>
</body>
</html>
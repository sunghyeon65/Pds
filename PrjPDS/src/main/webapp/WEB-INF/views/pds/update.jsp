<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<title>${ menuname } 자료실 내용보기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/common.css" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


<style>
   input  { height: 32px;  }
   
   #table  th                      {  width  : 15%;  }  
   #table  td                      {  width  : 35%;  }  
   #table  tr:nth-of-type(4)       {  height : 300px;  vertical-align: top; }  
   #table  tr:nth-of-type(5)       {  height : 200px;  vertical-align: top; }  
   #table  tr:nth-of-type(6)  td   {  text-align: center;  }  
     
   input[type="text"]              { width: 100%; }  
   textarea                        { width: 100%; height: 300px; } 
   
   h2                              { text-align: center; margin: 20px; }
     
</style>

<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<script>
   
   $( function() {
	   let num = 1;
	   $('#btnAddFile').on('click', function() {		   
		   let tag = '<input type="file" name="upfile' + num + '" class="upfile" /><br>';
		   $('#tdfile').append( tag );
		   num++;
	   })
   })

</script>

</head>
<body>
  <main>
  
  <!-- 메뉴 목록 -->
  <%@include file="/WEB-INF/include/pdsmenus.jsp" %>
  
  <form  action="/Pds/Update" method="POST"
         enctype="multipart/form-data">
  
     <h2>${ menuname } 자료실 내용 보기</h2>
 
  <table id="table">
   
   <tr>
   	<th>글번호</th>
   	<td>${ vo.idx }</td>
   	<th>조회수</th>
   	<td>${ vo.readcount }</td>
   </tr>
   <tr>
   	<th>작성자</th>
   	<td>${ vo.writer }</td>
   	<th>작성일</th>
   	<td>${ vo.regdate }</td>
   </tr>
   <tr>
    <th>제목</th>
    <td colspan="3">
       <input type="text" name="title" value="${ vo.title }" />
    </td>
   </tr>   
   <tr>
    <th>내용</th>
    <td colspan="3">
       <textarea name="cont">${ vo.cont }</textarea>
    </td>
   </tr>  
   <tr>
    <th>파일</th>
    <td id="tdfile" colspan="3">
      
      <c:forEach var="file" items="${ fileList }">
        <div>
          <a id   = "aDelete" 
             href = "/Pds/deleteFile?file_num=${ file.file_num }&sfile=${ file.sfilename }">
            🗑
          </a>
          <a href="/Pds/download/external/${ file.sfilename }">
            ${ file.filename } 
          </a>        
        </div>
      </c:forEach>
      <br>
      
      <!-- 새 파일 추가 -->
      <input type ="button" class="form-control" id="btnAddFile" value="파일추가(100M 까지)" /><br>
      <input type="file"  class="form-control" name="upfile" /><br>
      
    </td>
   </tr>
   <tr>
    <td colspan="4">
     <a class="btn btn-primary btn-sm" href="#" role="button" >수정</a>
     <a class="btn btn-primary btn-sm" href="/" role="button">Home</a>
    </td>
   </tr>
    
  </table>
  </form>
  
  </main>
</body>
</html>



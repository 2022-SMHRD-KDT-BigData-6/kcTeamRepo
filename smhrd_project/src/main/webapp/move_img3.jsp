<%@page import="com.model.userid_training_listDAO"%>
<%@page import="com.model.user_infoVO"%>
<%@page import="com.model.userid_training_listVO"%>
<%@page import="com.model.today_user_trainingVO"%>
<%@page import="java.util.List"%>
<%@page import="com.model.reco_for_training_infoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
   userid_training_listDAO dao1 = new userid_training_listDAO();
   userid_training_listVO usertvo = new userid_training_listVO();
   
   String user_id =((user_infoVO)session.getAttribute("uvo")).getUser_id();
   String date = (String)session.getAttribute("data");
   usertvo.setUser_id(user_id);
   usertvo.setTraining_date(date);
    
    List<userid_training_listVO> vo = dao1.select_training_byId(usertvo); 
   
 request.setAttribute("vo", vo);
   %>
<%
   
   reco_for_training_infoDAO dao = new reco_for_training_infoDAO();
   
   List<today_user_trainingVO> list = dao.reco_today_training_parts(user_id);
   

   for (int j = 1; j <= list.get(2).getCnt(); j++) {
      out.print("<img src=\"./copy_img/" + vo.get(2).getTraining_name() + "-" + j + ".jpg\" class= slide2 width = \"310px\" height=\"210px\" margin = auto;>");
   }

   %>
   <script>
      var index = 0; //이미지에 접근하는 인덱스
      window.onload = function() {
         slide2Show();
      }

      function slide2Show() {
         var i;
         var x = document.getElementsByClassName("slide2"); //slide2에 대한 dom 참조
         for (i = 0; i < x.length; i++) {
            x[i].style.display = "none"; //처음에 전부 display를 none으로 한다.
         }
         index++;
         if (index > x.length) {
            index = 1; //인덱스가 초과되면 1로 변경
         }   
         x[index - 1].style.display = "block"; //해당 인덱스는 block으로
         setTimeout(slide2Show, 1000); //함수를 1초마다 호출
      }
   </script>
</body>
</html>
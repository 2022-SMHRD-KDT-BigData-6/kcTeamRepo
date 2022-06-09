<%@page import="java.util.List"%>
<%@page import="com.model.detail_training_rutin_infoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<detail_training_rutin_infoVO> vo = (List<detail_training_rutin_infoVO>)(request.getAttribute("vo"));%>

<td>
<%for(int i = 0; i < vo.size(); i++){%>
	<%=vo.get(i).getIndex_no()%>
	<%=vo.get(i).getRutin_index()%>
	<%=vo.get(i).getSet_val()%>
	<%=vo.get(i).getSecncnt_val()%>
	<%=vo.get(i).getTraining_index()%>
	<%=vo.get(i).getFavor_check()%>
	
<%} %>

</td>
</body>
</html>
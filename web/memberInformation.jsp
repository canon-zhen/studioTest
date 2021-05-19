<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>工作室管理系统</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/common2.css">


</head>
<body>
<div id="app">
	<!-- 快捷导航模块start -->
	<section class="shortcut">
		<div class="header_inner">
			<div class="fl">
				<ul>
					<li>
						<a class="navbar_brand" href="#">
							<img src="img/logo2.jpg" alt="logo" width="80" height="50" />
						</a>
					</li>
					<li>
						<h1>
							<b>工作室管理系统</b>
						</h1>
					</li>
				</ul>
			</div>
			<div class="fr">
				<ul class="navbar-nav">
					<li>
						<a href="#">当前身份：</a>
						<c:if test="${student.workHname ==null}">
							<a href="#" style="color:  #f44336">无</a>
						</c:if>
						<c:if test="${student.workHname != null}">
							<a href="#" style="color:  #f44336">${student.workHname}工作室成员</a>
						</c:if>
					</li>
					<li>
						<a href="#">
							<img src="img/geren(1).png" alt="">
							欢迎您,<a href="#" style="color:  #f44336">${student.sname}</a>
						</a>
					</li>
					<li>
						<a href="login.jsp">
							<img src="img/tuichu%20(3)(1).png" alt="">
							安全退出
						</a>
					</li>
				</ul>
			</div>
		</div>
	</section>
	<!-- 快捷导航模块end -->
	<!-- tab栏start -->
	<div class="tab">
		<ul class="tab_inner">
			<li class="items"><%-- dropbtnx --%>
				<a class="dropbtn"  href="student_index.jsp">工作室信息</a>
				<div class="dropdown-content">
					<a href="workHomeInformation.jsp">基本信息</a>
					<a href="memberInformation.jsp">成员信息</a>
				</div>

			</li>
			<li class="items">
				<a href="queryAllAchievementServlet?role=0" class="dropbtn">工作室成就</a>
			</li>
			<li class="items">
				<a href="student_join_drop.jsp" class="dropbtn">加入/退出工作室</a>
			</li>
			<li class="items">
				<a href="workhome_Docontent.jsp" class="dropbtn">工作内容</a>
			</li>
		</ul>

	</div>
	<!-- tab栏end -->
	<!-- 中间主体部分start -->
	<div class="content">
		<div class="content_left">
			<ul>
				<li>
					<img src="img/zaixiangoutong.png" alt="">
					<a href="#">在线沟通</a>
				</li>
				<li>
					<img src="img/gonggao.png" alt="">
					<a href="#">公告</a>
				</li>
				<li>
					<img src="img/dengpao.png" alt="">
					<a href="#">常见问题</a>
				</li>
				<li>
					<img src="img/lianxiwomen.png" alt="">
					<a href="#">联系我们</a>
				</li>
				<li>
					<img src="img/gongju.png" alt="">
					<a href="#">帮助</a>
				</li>
			</ul>
		</div>
		<div class="main_content">
			<div class="infor_table">
				<div class="success_topx">
					<h2>查询：</h2>
					<div class="search_bar">
						<form method="post" action="${pageContext.request.contextPath}/queryMemberInforServlet?role=0">
							<input type="text" name="wname">
							<button type="submit"></button>
						</form>
					</div>
				</div>
				<table>
					<thead>
					<tr>
						<th>编号</th>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>班级</th>
						<th>电话</th>
						<th>工作室</th>
						<th>用户名</th>
					</tr>
					</thead>
					<tbody>
					<c:if test="${empty students}">
						<tr>
							<td rowspan="9" colspan="9">
								<a style="color: #ff7676">搜索工作室成员信息</a>
							</td>
						</tr>

					</c:if>
					<c:if test="${not empty students}">
						<c:forEach var="student" items="${students}" varStatus="s" >
							<tr>
								<td>${student.sid}</td>
								<td>${student.studentId}</td>
								<td>${student.sname}</td>
								<td>${student.sgender}</td>
								<td>${student.sage}</td>
								<td>${student.sclass}</td>
								<td>${student.sphone}</td>
								<td>${student.workHname}</td>
								<td>${student.username}</td>
							</tr>
						</c:forEach>
					</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 中间主体部分end-->
	<!-- footer部分start -->
	<div class="footer">
		<a href="#">联系我们</a> | <a href="#">合作机构</a>
	</div>
	<!-- footer部分end -->

</div>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script>
	var app=new Vue({
		el:"#app",
		data:{
			inforList: [
				{id:1,studentId:20192108,sname:"蔡振",sgender:"男",sage:19,sclass:"软件1913班",sphone:34753808,workHname:"半月",username:"caizhen",password:114},
				{id:2,studentId:20192123,sname:"刘莲",sgender:"女",sage:21,sclass:"软件1913班",sphone:19902934,workHname:"π",username:"liulian",password:109},
				{id:3,studentId:20192108,sname:"蔡振",sgender:"男",sage:19,sclass:"软件1913班",sphone:34753808,workHname:"半月",username:"caizhen",password:114},
				{id:4,studentId:20192123,sname:"刘莲",sgender:"女",sage:21,sclass:"软件1913班",sphone:19902934,workHname:"π",username:"liulian",password:109},
				{id:5,studentId:20192108,sname:"蔡振",sgender:"男",sage:19,sclass:"软件1913班",sphone:34753808,workHname:"半月",username:"caizhen",password:114},
				{id:6,studentId:20192108,sname:"蔡振",sgender:"男",sage:19,sclass:"软件1913班",sphone:34753808,workHname:"半月",username:"caizhen",password:114},

			]
		}
	})
</script>
</body>
</html>

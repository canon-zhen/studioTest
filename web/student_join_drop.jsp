<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>工作室管理系统</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/common3.css">

    <script>
        window.onload=function () {
            document.getElementById("tuichu").onclick=function () {
                if (${student.workHname ==null}){
                    alert("您未加入工作室");
                }else{
                    if (confirm("确定退出工作室？")){
                        location.href="dropServlet?studentId=${student.studentId}";
                    }
                }
            }
            //使用$.ajax()发送异步请求
            $.ajax({
                url:"ajaxServlet1111" , // 请求路径
                type:"POST" , //请求方式
                //data: "username=jack&age=23",//请求参数
                data:{"username":"jack","age":23},
                success:function (data) {
                    alert(data);
                },//响应成功后的回调函数
                error:function () {
                    alert("出错啦...")
                },//表示如果请求响应出现错误，会执行的回调函数

                dataType:"text"//设置接受到的响应数据的格式
            });
        }

    </script>
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
            <div class="action">
                <h1>工作室人员管理</h1>
                <div class="shezhi">当前身份：
                    <c:if test="${student.workHname ==null}">
                        <a href="#" style="color:  #f44336">无</a>
                    </c:if>
                    <c:if test="${student.workHname != null}">
                        <a href="#" style="color:  #f44336">${student.workHname}工作室成员</a>
                    </c:if>&nbsp;&nbsp;
                    <a href="" id="tuichu" >点击退出工作室</a></div>
            </div>
            <div class="widget">
                <form class="widget_next" action="joinServlet">
                     
                    <label>
                        <span>工作室 :</span>
                        <input type="text" name="workHname" class="error" placeholder="请输入您想加入的工作室名字" />
                        <!-- <div class="error-msg"></div> -->
                    </label>
                    <label>
                        <span>学号 :</span>
                        <input  type="text" name="studentId" class="error" placeholder="请输入您的学号" />
                        <!-- <div class="error-msg"></div> -->
                    </label>
                    <label>
                        <span>姓名 :</span>
                        <input  type="text" name="sname" class="error" placeholder="请输入您的姓名" />
                        <!-- <div class="error-msg"></div> -->
                    </label>
                    <label>
                        <span>电话 :</span>
                        <input  type="text" name="sphone" class="error" placeholder="请输入您的电话" />
                        <!-- <div class="error-msg"></div> -->
                    </label>
                    <label>
                        <span>班级 :</span>
                        <input  type="text" name="sclass" class="error" placeholder="请输入您的班级" />
                        <!-- <div class="error-msg"></div> -->
                    </label>
                    <label>
                        <span>加入理由 :</span>
                        <textarea id="message" name="message" placeholder="请陈述你的理由"></textarea>
                        <!-- <div class="error-msg"></div> -->
                    </label>
                    <lable>
                        <span>操作：</span>
                        <input type="submit" class="button" value="加入"/>
                    </lable>
                </form>


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

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>工作室管理系统</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/common4.css">


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
                            <b>管理员工作室管理系统</b>
                        </h1>
                    </li>
                </ul>
            </div>
            <div class="fr">
                <ul class="navbar-nav">
                    <li>
                        <a href="#">当前身份：</a>
                        <a href="#" style="color:  #f44336">${admins.role}</a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="img/geren(1).png" alt="">
                            欢迎您,<a style="color: #f44336">${admins.name}</a>
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
                <a class="dropbtn"  href="admin_index.jsp">工作室信息</a>
                <div class="dropdown-content">
                    <a href="wk_workHomeInformation.jsp">基本信息</a>
                    <a href="wk_memberInformation.jsp">成员信息</a>
                </div>

            </li>
            <li class="items">
                <a href="queryAllAchievementServlet?role=1" class="dropbtn">工作室成就查询</a>
            </li>
            <li class="items">
                <a href="wk_student_join_drop.jsp" class="dropbtn">工作室操作</a>
                <div class="dropdown-content">
                    <a href="#">添加工作室</a>
                    <a href="#">删除工作室</a>
                </div>
            </li>
            <li class="items">
                <a href="wk_workhome_Docontent.jsp" class="dropbtn">工作内容</a>
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
            <div class="todo_header">
                <h2>TO DO LIST</h2>
                <input type="text" id="myInput" v-model="inputValue">
                <span @click="add" class="addBtn">Add</span>
            </div>
            <div class="todo_inner">
                <ul id="myUL">
                    <li class="do" v-for="(item,index) in todoList">
                        <div class="view">
									<span class="index">
										{{index+1}}.
									</span>
                            <label>
                                {{item}}
                            </label>
                            <button class="destroy" @click="remove(index)">×</button>
                        </div>
                    </li>
                </ul>
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
    var app = new Vue({
        el: "#app",
        data: {
            todoList: [
                "软创比赛作品",
                "互联网＋作品",
                "江农大学工小程序",
                "蓝桥杯比赛准备",
                "视觉大赛准备",
                "全国大学生软件设计大赛作品"
            ],
            inputValue:"Title...",
        },
        methods:{
            add: function(){
                this.todoList.push(this.inputValue);
            },
            remove:function(index) {
                this.todoList.splice(index,1);
            },
            clear:function(){
                this.todoList=[];
            }
        }
    })
</script>
</body>
</html>

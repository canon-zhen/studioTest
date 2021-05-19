<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <link rel="stylesheet" type="text/css" href="css/registerCommon.css">
        <link rel="stylesheet" href="css/register.css">
		<!--导入jquery-->
		<script src="js/jquery-2.1.0.min.js"></script>
		<script src="js/html5.js"></script>
		<script>
			/*
				表单校验
			*/
			//校验用户名
			function checkUsername() {
				//获取用户名字值
				var username = $("#username").val();
				//定义正则
				var reg_username=/^\w{3,20}$/
				//判断，给出提示信息
				var flag = reg_username.test(username);
				if (flag){
					//true,成功
					$("#username").css("border","");
				}else{
					//false,用户名非法，加一个红色边框警示
					$("#username").css("border","1px solid red");
				}
				return flag;
			}
			//校验密码
			function checkPassword() {
				//获取用户名字值
				var password = $("#password").val();
				//定义正则
				var reg_password=/^\w{8,20}$/
				//判断，给出提示信息
				var flag = reg_password.test(password);
				if (flag){
					//true,成功
					$("#password").css("border","");
				}else{
					//false,密码非法，加一个红色边框警示
					$("#password").css("border","1px solid red");
				}
				return flag;
			}
			//校验邮箱
			function checkEmail() {
				//获取邮箱
				var email = $("#email").val();
				//定义正则
				var reg_email=/^\w+@\w+\.\w+$/;
				//判断
				var flag = reg_email.test(email);
				if (flag){
					//成功
					$("#email").css("border","")
				}else{
					//失败
					$("#email").css("border","3px solid red")
				}
				return flag;
			}

			//当表单提交是，调用所有校验方法
			$(function (){
				$("#registerForm").submit(function () {
					return checkUsername()&&checkPassword();
					//如果方法返回值为true，则表单提交

					//异步提交
					/*if (checkUsername()&&checkPassword()&&checkEmail()){
						//校验通过，发送ajax请求，提交表单数据
						$.post("/studioTest_war_exploded/RegisterServlet",$(this).serialize(),function (data) {

						})
					}*/
				})

				//当失去焦点时，调用校验方法
				$("#username").blur(checkUsername);
				$("#password").blur(checkPassword);
				//$("#email").blur(checkEmail);
			});


		</script>



    </head>
<body>

	<!--引入头部-->
	<div id="header"></div>
        <!-- 头部 end -->
    	<div class="rg_layout">
    		<div class="rg_form clearfix" style="background: url(img/demo-1-bg.jpg) no-repeat center; ">
    			<div class="rg_form_left">
    				<p>学生注册</p>
    				<p>STUDENT REGISTER</p>
    			</div>
    			<div class="rg_form_center">
					
					<!--注册表单--><%----%>
    				<form id="registerForm" action="${pageContext.request.contextPath}/RegisterServlet" method="post" >
						<!--提交处理请求的标识符-->
						<input type="hidden" name="action" value="register">
    					<table style="margin-top: 15px;" >
    						<tr>
    							<td class="td_left">
    								<label for="username"><p style="color: #EEEEEE">用户名</p></label>
    							</td>
    							<td class="td_right">
    								<input name="username" type="text" id="username"  placeholder="请输入账号" >
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="password"><p style="color: #EEEEEE">密码</p></label>
    							</td>
    							<td class="td_right">
    								<input name="password" type="password" id="password" placeholder="请输入密码" >
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="name"><p style="color: #EEEEEE">姓名</p></label>
    							</td>
    							<td class="td_right">
    								<input name="sname"  type="text" id="name" placeholder="请输入真实姓名">
    							</td>
    						</tr>
							<tr>
								<td class="td_left">
									<label for="class"><p style="color: #EEEEEE">班级</p></label>
								</td>
								<td class="td_right">
									<input name="sclass" type="text" id="class" placeholder="请输入班级">
								</td>
							</tr>
							<tr>
								<td class="td_left">
									<label for="sId"><p style="color: #EEEEEE">学号</p></label>
								</td>
								<td class="td_right">
									<input name="studentId" type="text" id="sId" placeholder="请输入学号">
								</td>
							</tr>
							<tr>
								<td class="td_left">
									<label for="sex"><p style="color: #EEEEEE">性别</p></label>
								</td>
								<td class="td_right gender">
									<input name="sgender" type="radio" id="sex"  value="男" checked>
									<img src="img/nan.jpg" width="24px" height="24px">
                                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input name="sgender" type="radio"  value="女">
									<img src="img/nv.jpg" height="24px" width="24px">
								</td>
							</tr>
							<tr>
								<td class="td_left">
									<label for="sage"><p style="color: #EEEEEE">年龄</p></label>
								</td>
								<td class="td_right">
									<input name="sage" type="text" id="sage" placeholder="请输入年龄">
								</td>
							</tr>
    						<tr>
    							<td class="td_left">
    								<label for="telephone"><p style="color: #EEEEEE">手机号</p></label>
    							</td>
    							<td class="td_right">
    								<input name="sphone" type="text" id="telephone" placeholder="请输入您的手机号">
    							</td>
    						</tr>

    						<tr>
    							<td class="td_left">
    								<label for="check"><p style="color: #EEEEEE">验证码</p></label>
    							</td>
    							<td class="td_right check">
    								<input name="check" type="text" id="check"  class="check" placeholder="请输入验证码" style="width: 150px">
    								<img src="checkCodeServlet" height="32px" alt="" onclick="changeCheckCode(this)">
									<script type="text/javascript">
										//图片点击事件
										function changeCheckCode(img) {
											img.src="checkCodeServlet?"+new Date().getTime();
                                        }
									</script>
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left"> 
    							</td>
    							<td class="td_right check"> 
    								<input type="submit" name="submit" class="submit"  value="注册">
									<span id="msg" style="color: red"><strong>${register_msg}</strong></span>

    							</td>
    						</tr>

    					</table>
    				</form>
    			</div>
    			<div class="rg_form_right">
    				<p>
    					<a>已有账号？</a>
    					<a href="login.jsp">立即登录</a>
    				</p>
    			</div>
    		</div>
    	</div>

    </body>
</html>
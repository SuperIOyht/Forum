<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String mod = (String)request.getAttribute("mod");
    String userInfo = (String)request.getAttribute("userInfo");
    String result = (String)request.getAttribute("result");
    Boolean isAdmin = (Boolean)request.getAttribute("isAdmin");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的</title>
<style type="text/css">
.avt img {
    padding: 2px;
    width: 48px;
    height: 48px;
    background: #FBFBFB;
    border: 1px solid;
    border-color: #EFEFEF #CDCDCD #CDCDCD #EFEFEF;
}
ul{
	padding:0px;
}
#ct {
    min-height: 800px;
    margin: 0 auto;
    width: 960px;	
}
.ct2_a, .ct3_a {
    border: 1px solid #CCC;
    background: url(img/vlineb.png) repeat-y 0 0;
}
.ct2_a .mn {
    display: inline;
    margin-right: 10px;
    padding-top: 10px;
    width: 800px;
}
.ct2_a .mn {
    float: right;
    width: 810px;
}
.mn {
    overflow: hidden;
}
.appl {
    float: left;
    overflow: hidden;
    margin-bottom: 10px;
    padding: 6px 10px;
    width: 117px;
}
.tbn {
    margin: -6px -10px 0;
}
.tbn .mt {
    padding: 10px;
}
.bbda {
    border-bottom: 1px dashed #CDCDCD;
}
.mt {
    padding: 10px 0;
    font-size: 16px;
}
.tbn ul {
    margin: 0;
}
.tbn li {
    margin: 0 10px;
    height: 33px;
    border-bottom: 1px dashed #CCC;
}
.appl li {
    display: block;
    height: 28px;
    line-height: 28px;
    white-space: nowrap;
    word-wrap: normal;
    font-size: 14px;
    text-overflow: ellipsis;
    overflow: hidden;
}
ul li, .xl li {
    list-style: none;
}
.tbn li.a {
    margin: -1px 0 0;
    padding: 0 10px 0 9px;
    border-top: 1px solid #CDCDCD;
    border-bottom-style: solid;
    background: #FDF5E6;
}
.tbn li {
    margin: 0 10px;
    height: 33px;
    border-bottom: 1px dashed #CCC;
}
#head_area {
	border-bottom: 0 solid #BFB8A5;
	margin: 0 auto;
	width: 960px;
	min-height: 70px;
}

#head_area h2 {
	padding: 0 20px 8px 0;
	float: left;
}

#userInfo {
	padding-top: 10px;
	padding-right: 60px;
	_padding-right: 54px;
	line-height: 2.3;
}

#userInfo p {
	text-align: right;
}

.username {
	margin: 1px;
}

.pipe {
	margin: 0 5px 0 0;
	color: #CCC;
}
body, input, button, select, textarea {
	font: 12px/1.5 Tahoma, Helvetica, 'Microsoft YaHei', 'STXiHei', 'SimSun',
		sans-serif;
	color: #444;
}
body {
	background: #FAEBD7;
}
a{
	color: #333;
	text-decoration: none;
}
#um .avt {
    display: inline;
    margin-right: -60px;
}
.y {
    float: right;
}
.y {
    position: relative;
}
.y a {
    margin-left: 10px;
}
.userInfo{
    padding-top: 10px;
    padding-right: 60px;
    _padding-right: 54px;
    line-height: 2.3;
    zoom: 1;
}
.nowicon {
    padding: 2px;
    width: 100px;
    height: 100px;
    background: #FBFBFB;
    border: 1px solid;
    border-color: #EFEFEF #CDCDCD #CDCDCD #EFEFEF;
    }
.ct2_a .mn {
    display: inline;
    margin-right: 10px;
    padding-top: 10px;
    width: 1035px;
}
.ct2_a .mn {
    float: right;
    width: 810px;
}
.mn {
    overflow: hidden;
}
.tfm {
    width: 100%;
}
caption, th {
    text-align: left;
    font-weight: 400;
}
.tfm td {
    vertical-align: top;
    padding: 7px 0;
}
.th table{
	width: 100%;
    table-layout: fixed;
    border-collapse: separate;
}
</style>
</head>
<body>
	<div id="head_area">
			<h2>
				<a href="GetPost.do" title="论坛"><img src="img/logo.png" border="0"></a>
			</h2>
					<%=userInfo%>
		</div>
	
	<div id="ct" class="ct2_a wp cl">
		<div class="mn">
				<div class="bm bw0">
							<%=result%>
							</div>
							</div>
                        <div class="appl">
                            <div class="tbn">
                                <h2 class="mt bbda">管理</h2>
                                <ul>
                                	<li><a href="Manage.do?mod=icon">我的头像</a></li>
                                    <li><a href="Manage.do?mod=allPost">我的帖子</a></li>
                                    <li><a href="Manage.do?mod=allCom">我的评论</a></li>
                                    <%if(isAdmin){
                                    	%>
                                    <li><a href="Manage.do?mod=checkPost">审核帖子</li>
                                    <li><a href="Manage.do?mod=checkCom">审核评论</li>  
                                    	<%
                                    }
                                    %>
                                </ul>
                            </div>
                        </div>
                    </div>	
</body>
</html>
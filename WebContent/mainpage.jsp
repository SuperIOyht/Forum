<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	try {
		Integer totalNum = (Integer) request.getAttribute("totalNum");
		Integer totalPage = (Integer) request.getAttribute("totalPage");
		String allPost = (String) request.getAttribute("result");
		Integer thisPage = (Integer) request.getAttribute("thisPage");
		String userInfo = (String) request.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>论坛首页</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<style type="text/css">
body {
	background: #FAEBD7;
}

h2 {
	font-size: 1em;
	margin: auto;
}

a img {
	border: none;
}

a {
	color: #333;
	text-decoration: none;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

th {
	text-align: left;
	font-weight: 400;
}

body, input, button, select, textarea {
	font: 12px/1.5 Tahoma, Helvetica, 'Microsoft YaHei', 'STXiHei', 'SimSun',
		sans-serif;
	color: #444;
}

em, cite, i {
	font-style: normal;
}

.tl td em, .tl td em a {
	color: #999;
}

.tl td em {
	font-size: 11px;
	font-family: Arial, Psimsun, sans-serif;
	-webkit-text-size-adjust: none;
}

#head_area {
	border-bottom: 0 solid #BFB8A5;
	margin: auto;
	width: 960px;
	min-height: 70px;
}

#head_area h2 {
	padding: 0 20px 8px 0;
	float: left;
}

#scbar_hot {
	float: right;
	padding-top: 12px;
	padding-left: 8px;
	height: 45px;
	overflow: hidden;
}

#scbar_hot a {
	float: left;
	margin-right: 8px;
	white-space: nowrap;
	width: 80px;
	height: 30px;
	border-radius: 5px;
	font-size: 12px;
	color: #fff;
	background: #09ade5;
	line-height: 30px;
	text-align: center;
	text-decoration: none;
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

.body {
	border: 1px solid #CDCDCD;
	background: #FDF5E6;
	margin-bottom: 10px;
	min-height: 300px;
	margin: auto;
	width: 960px;
}

.tl .th {
	margin-top: 1px;
	padding: 0 10px;
	border-bottom: 1px solid #CDCDCD;
	background: #FDF5E6
}

.tl .th table {
	border: none;
}

.tl table {
	width: 100%;
	table-layout: fixed;
	border-collapse: separate;
}

tbody {
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
}

.tl .th td, .tl .th th {
	height: 20px;
	border: none;
	vertical-align: baseline;
}

.tl th, .tl td.fn {
	padding-right: 1.5em;
	zoom: 1;
}

.tl .tf {
	padding: 3px 0;
}

.showmenu {
	padding-right: 16px;
}

.tl .by {
	width: 105px;
	line-height: 14px;
}

.tl th, .tl td {
	padding: 5px 0;
	border-bottom: 1px solid #BFB8A5;
}

.tl .num {
	width: 60px;
	line-height: 14px;
}

.tl .by {
	width: 105px;
	line-height: 14px;
}

.postindex {
	padding-top: 0;
	padding: 10px;
}

.xst {
	font-family: Tahoma, Helvetica, 'Microsoft YaHei', 'STXiHei', 'SimSun',
		sans-serif;
	font-size: 14px;
}

.tl .by {
	width: 105px;
	line-height: 14px;
}

.tl .num {
	width: 60px;
	line-height: 14px;
}

.tl cite, .tl .num em {
	display: block;
}

.bm_h {
	padding: 0 10px;
	height: 31px;
	border-top: 1px solid #FFF;
	border-bottom: 1px solid #BFB8A5;
	background: #FDF5E6;
	line-height: 31px;
	white-space: nowrap;
	overflow: hidden;
}

#autopbn {
	display: block;
	margin-bottom: 10px;
	border: 1px solid rgb(194, 213, 227);
	border-radius: 3px;
	text-align: center;
}

#f_pst .bm_c {
	padding: 20px;
}

.pbt {
	margin-bottom: 10px;
}

#f_pst .px {
	padding: 2px;
}

.postarea {
	width: auto;
	border: 1px solid;
	border-color: #999 #CCC #CCC #999;
	margin-right: 170px;
	padding: 4px;
	background: #FDF5E6;
	zoom: 1;
}

.pt {
	width: 100%;
	margin-right: 0;
	padding: 0 !important;
	border: none;
	background: #FDF5E6 none;
}

textarea {
	-webkit-writing-mode: horizontal-tb !important;
	text-rendering: auto;
	color: -internal-light-dark-color(black, white);
	letter-spacing: normal;
	word-spacing: normal;
	text-transform: none;
	text-indent: 0px;
	text-shadow: none;
	display: inline-block;
	text-align: start;
	-webkit-appearance: textarea;
	background-color: -internal-light-dark-color(white, black);
	-webkit-rtl-ordering: logical;
	flex-direction: column;
	resize: auto;
	cursor: text;
	white-space: pre-wrap;
	overflow-wrap: break-word;
	margin: 0em;
	font: 400 13.3333px Arial;
	border-width: 1px;
	border-style: solid;
	border-color: rgb(169, 169, 169);
	border-image: initial;
	padding: 2px;
}

.ptm {
	padding-top: 10px !important;
}

.pnpost .pn {
	height: 26px;
}

.pn {
	vertical-align: middle;
	overflow: hidden;
	margin-right: 3px;
	padding: 0;
	height: 23px;
	border: 1px solid #999;
	background: #E5E5E5 url(img/pn.png) repeat-x 0 0;
	cursor: pointer;
	-moz-box-shadow: 0 1px 0 #E5E5E5;
	-webkit-box-shadow: 0 1px 0 #E5E5E5;
	box-shadow: 0 1px 0 #E5E5E5;
}

.pnc, a.pnc {
	border-color: #235994;
	background-color: #06C;
	background-position: 0 -48px;
	color: #FFF !important;
}

.pn strong {
	font-weight: 700;
}

.pn strong {
	padding: 0 10px;
	line-height: 21px;
}

<!--
tiaozhuanlan --><!--tiaozhuanlan --><!--tiaozhuanlan -->.bw0 {
	background: transparent;
}

.bm {
	margin-bottom: 10px;
}

.bw0 {
	border: none !important;
}

.pg {
	line-height: 26px;
}

.pg {
	float: right;
}

.pg a.prev {
	background-image: url(img/arw_l.gif);
	background-position: 50% 50%;
}

.pg a {
	float: left;
	display: inline;
	margin-left: 4px;
	padding: 0 8px;
	height: 26px;
	border: 1px solid;
	border-color: #BFB8A5;
	background-color: #FDF5E6;
	background-repeat: no-repeat;
	color: #333;
	overflow: hidden;
	text-decoration: none;
}

.pg strong, .pg label {
	float: left;
	display: inline;
	margin-left: 4px;
	padding: 0 8px;
	height: 26px;
	border: 1px solid;
	border-color: #BFB8A5;
	background-color: #FDF5E6;
	background-repeat: no-repeat;
	color: #333;
	overflow: hidden;
	text-decoration: none;
}

.pg strong {
	background-color: #EEE8AA;
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
.avt img {
    padding: 2px;
    width: 48px;
    height: 48px;
    background: #FBFBFB;
    border: 1px solid;
    border-color: #EFEFEF #CDCDCD #CDCDCD #EFEFEF;
}
.userInfo{
    padding-top: 10px;
    padding-right: 60px;
    _padding-right: 54px;
    line-height: 2.3;
    zoom: 1;
}
<!--
tiaozhuanlan


 


-->
<!--
tiaozhuanlan


 


-->
<!--
tiaozhuanlan


 


-->
</style>
</head>
<body>
	<div class="index">
		<div id="head_area">
			<h2>
				<a href="GetPost.do" title="论坛"><img src="img/logo.png"
					border="0"></a>
			</h2>
			<!-- <div id="scbar_hot">
				<a href=""  class="xi2">注册</a>
				<a href="" class="xi2">登录</a>
			</div>
			<div id="userInfo">
				<p>
					用户登录或用户信息
					<strong class="username"><a href="" target="_blank"
						title="访问我的空间">SuPeRIO645</a></strong> <span class="pipe">|</span> <a
						href="home.php?mod=spacecp">我的</a>
				</p>
			</div> -->
			<%=userInfo%>
		</div>
		<div class="body">
			<div id="threadlist" class="tl" style="position: relative;">
				<div class="th">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<th colspan="2">
									<div class="tf">
										<a id="filter_special" href="GetPost.do">全部主题</a>&nbsp;| 当前共<span
											style="color: #00bf12"><%=totalNum%></span>条主题帖&nbsp;| 当前为第<span
											style="color: #00bf12"><%=thisPage%></span>页
									</div>
								</th>
								<td class="by">作者</td>
								<td class="num">回复</td>

							</tr>
						</tbody>
					</table>
				</div>
				<div class="postindex">
					<table summary="forum_110" cellspacing="0" cellpadding="0"
						id="threadlisttableid">
						<%=allPost%>
						<!-- 贴子 -->
						<!-- 贴子 -->
						<!-- 贴子 -->
						<!-- 贴子 -->
						<!-- <tbody id="stickthread_280357">
							<tr>
								帖子标题	
								<th class="common"><a
									href="forum.php?mod=viewthread&amp;tid=280357&amp;extra=page%3D1"
									onclick="atarget(this)" class="s xst">玩家新春贺词征集活动 </a></th>
								帖子标题
									
								<td class="by">
									发帖人
									<cite> <span
										c="1"
										mid="card_9027">ubisoft官方</span>
									</cite>
									发帖人
									发帖时间 
									<em><span>2019-12-13
											17:32</span>
									</em>
									发帖时间
								</td>
								评论数
								<td class="num">
									<span class="xi2">29</span>
								</td>
								评论数
							</tr>
						</tbody> -->
						<!-- 贴子 -->
						<!-- 贴子 -->
						<!-- 贴子 -->
						<!-- 贴子 -->
					</table>
				</div>
			</div>
			<div>
				<a class="bm_h" href="GetPost.do?page=<%=thisPage + 1%>"
					rel="GetPost.do?page=<%=thisPage + 1%>" curpage="1" id="autopbn"
					totalpage="126" picstyle="0" forumdefstyle="">下一页 »</a>
			</div>
			<div class="bm bw0 pgs cl">
				<span id="fd_page_bottom"><div class="pg">
						<a href="GetPost.do" class="first">1 ...</a><a
							href="GetPost.do?page=<%=thisPage - 1%>" class="prev">&nbsp;&nbsp;</a>
						<%
							for (int i = thisPage - 4; i < thisPage + 4; i++) {
									if (i > 0 && i < thisPage) {
						%><a href="GetPost.do?page=<%=i%>"><%=i%></a>
						<%
							}
									if (i > thisPage && i <= totalPage) {
						%><a href="GetPost.do?page=<%=i%>"><%=i%></a>
						<%
							}
									if (i == thisPage) {
						%><strong><%=i%></strong>
						<%
							}
								}
						%>
						<a href="GetPost.do?page=<%=totalPage%>" class="last">... <%=totalPage%></a><label><input
							type="text" name="custompage" class="px" size="2"
							title="输入页码，按回车快速跳转" value="1"
							onkeydown="if(event.keyCode==13) {window.location='GetPost.do?page='+this.value;;}"><span>
								/ <%=totalPage%> 页
						</span></label><a href="GetPost.do?page=<%=thisPage + 1%>" class="nxt">下一页</a>
					</div></span>
			</div>
			<div id="f_pst" class="bm">
				<div class="bm_h">
					<h2>在此发帖</h2>
				</div>
				<div class="bm_c">
					<form method="post" id="fastpostform" action="AddPost.do"
						onsubmit="return fastpostvalidate()">
						<div class="pbt cl">
							<span>输入标题：</span> <input type="text" id="subject" name="subject"
								class="px" value=""
								onkeyup="var str = document.getElementById('subject').value;
									var leftlen = 50 - str.length;
								document.getElementById('remain').innerHTML='还剩'+leftlen+'个字符';"
								tabindex="11" style="width: 25em"> <span id="remain">最多50个字符</span>
						</div>
						<div class="postarea">
							<span>输入正文：</span>
							<textarea rows="6" cols="80" name="message" id="fastpostmessage"
								tabindex="12" class="pt"></textarea>
						</div>
						<p class="ptm pnpost">
							<button type="submit" name="username" id="fastpostsubmit"
								value="" tabindex="13" class="pn pnc">
								<strong>发表帖子</strong>
							</button>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function getCookie(cname) {
			var name = cname + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i].trim();
				if (c.indexOf(name) == 0)
					return c.substring(name.length, c.length);
			}
			return "";
		}
		var username = getCookie("name");
		document.getElementById("fastpostsubmit").value = username;
		function fastpostvalidate() {
			var title = document.getElementById("subject").value;
			var content = document.getElementById("fastpostmessage").value;
			var username = getCookie("name");
			if (username == ""){
				alert("请先登录");
				return false;
			}
			else if(title == ""){
				alert("标题不能为空！");
				return false;
			}else if(content == ""){
				alert("内容不能为空！");
				return false;
			}
			else {
				return true;
			}
		}
	</script>
</body>
</html>
<%
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
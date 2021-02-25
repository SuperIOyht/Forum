<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.zjut.finalwork.model.postBean"%>
<%@page import="edu.zjut.finalwork.model.userBean"%>
<%@page import="edu.zjut.finalwork.model.commentBean"%>
<%@page import="edu.zjut.finalwork.dao.userDAO"%>
<%@page import="java.util.*"%>
<%
	try {
		Integer totalNum = (Integer) request.getAttribute("totalNum");
		Integer totalPage = (Integer) request.getAttribute("totalPage");
		Integer thisPage = (Integer) request.getAttribute("thisPage");
		postBean post = (postBean) request.getAttribute("post");
		List<commentBean> comments = (ArrayList) request.getAttribute("comments");
		userDAO userDao = new userDAO();
		userBean postUser = userDao.getUserByName(post.getAuthor());
		String userInfo = (String) request.getAttribute("userInfo");
		Boolean isAdmin = (Boolean)request.getAttribute("isAdmin"); 
		Boolean isChecking = (Boolean)request.getAttribute("isChecking");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
	color: #333;
	text-decoration: none;
}

h2 {
	font-size: 1em;
	margin: auto;
}

.wp {
	margin: 0 auto;
	width: 960px;
}

body, input, button, select, textarea {
	font: 12px/1.5 Tahoma, Helvetica, 'Microsoft YaHei', 'STXiHei', 'SimSun',
		sans-serif;
	color: #444;
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

.body {
	border: 1px solid #CDCDCD;
	background: #FDF5E6;
	margin-bottom: 10px;
	width: auto;
	min-height: 300px;
	margin: 0 auto;
	width: 960px;
}

body {
	background: #FAEBD7;
}

.bm {
	border: 1px solid #CDCDCD;
	background: #FDF5E6;
}

.bm, .bn {
	margin-bottom: 10px;
}

.body {
	border: 1px solid #CDCDCD;
	background: #FDF5E6;
	margin-bottom: 10px;
	width: auto;
	min-height: 300px;
	margin: 0 auto;
	width: 960px;
}

#ct {
	border-color: #BFB8A5;
}

.wp {
	margin: auto;
	width: auto;
}

#ct {
	min-height: 300px;
}

table {
	empty-cells: show;
	border-collapse: collapse;
}

tbody {
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

.pl table {
	table-layout: fixed;
	width: 100%;
}

.plc {
	padding: 0 20px;
}

.plc, .pls {
	vertical-align: top;
}

.vwthd {
	padding-right: 80px !important;
}

.ptm {
	padding-top: 10px !important;
}

.pbn {
	padding-bottom: 5px !important;
}

.ts {
	display: inline;
	font: 700 16px 'Microsoft Yahei', 'Hei', Tahoma, 'SimHei', sans-serif;
}

.pl table {
	table-layout: fixed;
	width: 100%;
}

.pls .favatar {
	background: transparent;
	height: auto;
	border-width: 0px;
	overflow: visible;
}

.pls {
	width: 160px;
	background: #f3ffa1;
	overflow: hidden;
	border-right: 1px solid #fff3b4;
}

.plc, .pls {
	vertical-align: top;
}

.pi {
	overflow: hidden;
	margin-bottom: 10px;
	padding: 10px 0;
	height: 16px;
	border-bottom: 1px dashed #CDCDCD;
}

.plc {
	padding: 0 20px;
}

.pct {
	padding-bottom: 1em;
}

.pcb {
	clear: left;
	margin-right: 130px;
	min-height: 100px;
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

.userInfo {
	padding-top: 10px;
	padding-right: 60px;
	_padding-right: 54px;
	line-height: 2.3;
	zoom: 1;
}

.pls {
	width: 160px;
	background: #f7ffbb;
	overflow: hidden;
	border-right: 1px solid #C2D5E3;
}

.plc, .pls {
	vertical-align: top;
}

.pbn {
	padding-bottom: 5px !important;
}

.ptn {
	padding-top: 5px !important;
}

.hm {
	text-align: center;
}

.ptn {
	padding-top: 5px !important;
}

.xg1, .xg1 a {
	color: #999 !important;
}

.xi1, .onerror {
	color: #F26C4F;
}

table {
	empty-cells: show;
	border-collapse: collapse;
}

.pl table {
	table-layout: fixed;
	width: 100%;
}

.ad .pls {
	background: #f7ffbb;
	padding: 0;
	height: 4px;
}

.pls {
	width: 160px;
	background: #fdf5e6;
	overflow: hidden;
	border-right: 1px solid #f7ffbb;
}

.plc, .pls {
	vertical-align: top;
}

.ad .plc {
	background: #f7ffbb;
	padding: 0;
	overflow: hidden;
}

.pls .avatar {
	margin: 10px 15px;
}

.pls .avatar img {
	padding: 5px 5px 8px;
	width: 120px;
}

.avtm img {
	width: 120px;
	height: auto;
}

sup {
	vertical-align: super;
	font-size: smaller;
}

em, cite, i {
	font-style: normal;
}

strong {
	font-weight: bold;
}

.pi strong {
	float: right;
	margin-top: -6px;
	padding: 4px 6px;
	border: 1px solid #FFF;
	font-weight: 400;
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

.bw0 {
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

.userInfo {
	padding-top: 10px;
	padding-right: 60px;
	_padding-right: 54px;
	line-height: 2.3;
	zoom: 1;
}
.pob em {
    float: left;
}
.po p {
    float: right;
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
</style>
<meta charset="UTF-8">
<title><%=post.getTitle()%></title>
</head>
<body>
	<div class="index">
		<div id="head_area">
			<h2>
				<a href="GetPost.do" title="论坛"><img src="img/logo.png"
					border="0"></a>
			</h2>
			<!-- <div id="userInfo">
				<p>
					用户登录或用户信息
					<strong class="username"><a
						href="home.php?mod=space&amp;uid=1150407" target="_blank"
						title="访问我的空间">SuPeRIO645</a></strong> <span class="pipe">|</span> <a
						href="home.php?mod=spacecp">我的</a>
				</p>
			</div> -->
			<%=userInfo%>
		</div>
		<div class="body">
			<div id="ct" class="wp cl">
				<div id="postlist" class="pl bm">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td class="pls ptn pbn">
									<div class="hm ptn">
										<span class="pipe">|</span><span class="xg1">回复:</span> <span
											class="xi1"><%=post.getFloor()%></span>
									</div>
								</td>
								<td class="plc ptm pbn vwthd">
									<div class="y">
										<%if(isAdmin){
											%><a
											href="AddPostCheck.do?postId=<%= post.getId()%>"
											title="审核">加入审核</a><%
										} %>
										
									</div>
									<h1 class="ts">
										<span id="thread_subject"><%=post.getTitle()%></span>
									</h1>
								</td>
							</tr>
						</tbody>
						<table cellspacing="0" cellpadding="0" class="ad">
							<tbody>
								<tr>
									<td class="pls"></td>
									<td class="plc"></td>
								</tr>
							</tbody>
						</table>
					</table>
					<!-- 楼主 -->
					<!-- 楼主 -->
					<!-- 楼主 -->
					<!-- 楼主 -->
					<%if(thisPage == 1){%>
					<div id="<%=post.getId()%>">
						<table id="<%=post.getId()%>" class="plhin" cellspacing="0"
							cellpadding="0">
							<tbody>
								<tr>
									<td class="pls" rowspan="2">
										<div class="pls favatar">
											<div class="pi">
												<div class="authi">
													<!-- name -->
													<!-- name -->
													<!-- name -->
													<!-- name -->
													<span
														style="font: 700 16px 'Microsoft Yahei', 'Hei', Tahoma, 'SimHei', sans-serif;">楼主：</span><span
														id="author" style="font-weight: 700;"><%=post.getAuthor()%></span>
													<!-- name -->
													<!-- name -->
													<!-- name -->
													<!-- name -->
												</div>
											</div>
											<div>
												<div class="avatar">
													<a href="" class="avtm"><img
														src="<%=postUser.getIcon()%>"></a>
												</div>
											</div>
										</div>
									</td>
									<td class="plc">
										<div class="pi">
											<strong> <em>楼主</em> <sup>#</sup>
											</strong>
											<div class="pti">
												<div class="pdbt"></div>
												<div class="authi">
													<em id="<%=post.getId()%>">发表于 <%=post.getReleaseDate()%>
													</em> <span class="pipe">|</span>
												</div>
											</div>
										</div>
										<div class="pcb" style="font-size: 14px;">
											<%=post.getContent()%>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
					<% } %>
					<%
						for (int i = 0; i < comments.size(); i++) {
					%>
					<table cellspacing="0" cellpadding="0" class="ad">
						<tbody>
							<tr>
								<td class="pls"></td>
								<td class="plc"></td>
							</tr>
						</tbody>
					</table>
					<div id="<%=comments.get(i).getId()%>">
						<table id="" class="plhin" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td class="pls">
										<div class="pls favatar">
											<div class="pi">
												<div class="authi">
													<!-- name -->
													<!-- name -->
													<!-- name -->
													<!-- name -->
													<span
														style="font: 700 16px 'Microsoft Yahei', 'Hei', Tahoma, 'SimHei', sans-serif;">层主：</span><span
														id="author" style="font-weight: 700;"><%=comments.get(i).getAuthor()%></span>
													<!-- name -->
													<!-- name -->
													<!-- name -->
													<!-- name -->
												</div>
											</div>
											<div>
												<div class="avatar">
													<a href="" class="avtm"><img
														src="<%=userDao.getIcon(comments.get(i).getAuthor())%>"></a>
												</div>
											</div>
										</div>
									</td>
									<td class="plc">
										<div class="pi">
											<strong> <em><%=i + 1 + (thisPage-1) * 10%></em> <sup>#</sup>
											</strong>
											<div class="pti">
												<div class="pdbt"></div>
												<div class="authi">
													<em id="<%=comments.get(i).getId()%>">发表于 <%=comments.get(i).getReleaseDate()%>
													</em> <span class="pipe">|</span>
												</div>
											</div>
										</div>
										<div class="pcb" style="font-size: 14px;">
											<%
												if (comments.get(i).isChecking()) {
											%>
											该评论正在审核！
											<%
												} else {
											%>
											<%=comments.get(i).getContent()%>
											<%
												}
											%>
										</div>
									</td>
								</tr>
								<tr>
									<td class="pls"></td>
									<td class="plc" style="overflow: visible;">
										<div class="po hin">
											<div class="pob cl">
												<p>
												<%if(isAdmin){
											%><a
											href="AddComCheck.do?comId=<%=comments.get(i).getId()%>&postId=<%=post.getId()%>"
											title="审核">加入审核</a><%
										} %>
												</p>

											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<%
						}
					%>
					<!-- 楼主 -->
					<!-- 楼主 -->
					<!-- 楼主 -->
					<!-- 楼主 -->
				</div>
				<div>
					<a class="bm_h" href="GetForumIndex.do?postId=<%=post.getId()%>&page=<%=thisPage + 1%>"
						rel="forumIndex.do?page=<%=thisPage + 1%>" curpage="1"
						id="autopbn" totalpage="126" picstyle="0" forumdefstyle="">下一页
						»</a>
				</div>
				<div class="bm bw0 pgs cl">
					<span id="fd_page_bottom"><div class="pg">
							<a href="GetForumIndex.do?postId=<%=post.getId()%>" class="first">1 ...</a><a
								href="GetForumIndex.do?postId=<%=post.getId() %>&page=<%=thisPage - 1%>" class="prev">&nbsp;&nbsp;</a>
							<%
								for (int i = thisPage - 4; i < thisPage + 4; i++) {
										if (i > 0 && i < thisPage) {
							%><a href="GetForumIndex.do?postId=<%=post.getId() %>&page=<%=i%>"><%=i%></a>
							<%
								}
										if (i > thisPage && i <= totalPage) {
							%><a href="GetForumIndex.do?postId=<%=post.getId() %>&page=<%=i%>"><%=i%></a>
							<%
								}
										if (i == thisPage) {
							%><strong><%=i%></strong>
							<%
								}
									}
							%>
							<a href="GetForumIndex.do?postId=<%=post.getId() %>&page=<%=totalPage%>" class="last">... <%=totalPage%></a><label><input
								type="text" name="custompage" class="px" size="2"
								title="输入页码，按回车快速跳转" value="1"
								onkeydown="if(event.keyCode==13) {window.location='GetForumIndex.do?postId=<%=post.getId()%>&page='+this.value;;}"><span>
									/ <%=totalPage%> 页
							</span></label><a href="GetForumIndex.do?postId=<%=post.getId() %>&page=<%=thisPage + 1%>" class="nxt">下一页</a>
						</div></span>
				</div>
				<div id="f_pst" class="bm">
					<div class="bm_h">
						<h2>在此回复</h2>
					</div>
					<div class="bm_c">
						<form method="post" id="fastpostform" action="AddComment.do"
							onsubmit="return fastpostvalidate()">
							<!-- <div class="pbt cl">
							<span>输入标题：</span> <input type="text" id="subject" name="subject"
								class="px" value=""
								onkeyup="var str = document.getElementById('subject').value;
									var leftlen = 50 - str.length;
								document.getElementById('remain').innerHTML='还剩'+leftlen+'个字符';"
								tabindex="11" style="width: 25em"> <span id="remain">最多50个字符</span>
						</div> -->
							<div class="postarea">
								<span>输入正文：</span> <input name="postId" type="hidden"
									value="<%=post.getId()%>">
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
	</div>
	<%if(isChecking && !isAdmin){
	%>
	<script>alert("此贴正在审核");window.location.href='GetPost.do';</script>
	<%
} %>
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
			var content = document.getElementById("fastpostmessage").value;
			var username = getCookie("name");
			if (username == "") {
				alert("请先登录");
				return false;
			} else if (content == "") {
				alert("内容不能为空！");
				return false;
			} else {
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
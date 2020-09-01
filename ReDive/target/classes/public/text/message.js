function shiyon(){
	var html = "";
	html += "参考资料";
	var htmltext = "";
	htmltext += "<a>https://github.com/esterTion/redive_master_db_diff</a><br><br>";
	htmltext += "<a>https://redive.estertion.win/</a><br><br>";
	htmltext += "<a>https://redive.estertion.win/api.htm</a><br><br>";
	document.getElementById("cankao").innerHTML = html;
	document.getElementById("cankaourl").innerHTML = htmltext;
	html = "";
	html += "UI源码";
	htmltext = "";
	htmltext += "<span>Zui开发平台</span><a>https://www.openzui.com/#/</a><br><br>";
	htmltext += "<span>LayUi开发平台</span><a>https://www.layui.com/doc/</a><br><br>";
	htmltext += "<span>工会机器人助手</span><a>https://yobot.win/?tdsourcetag=s_pctim_aiomsg</a><br><br>";
	document.getElementById("ui").innerHTML = html;
	document.getElementById("uiurl").innerHTML = htmltext;
	html = "";
	html += "免责声明";
	htmltext = "";
	htmltext += "本网站为游戏<a href='https://game.bilibili.com/pcr/pinzhuan/'>公主连接</a>公会战以及工会管理辅助程序，作用为辅助会长/使用者的第三方平台<br>";
	htmltext += "禁止使用者将该网站作为非法传销/盈利/危害公共安全途径使用，如发现该情况，作者有权利收回/网络安全部门介入<br>";
	htmltext += "本网站为个人组织义务搭建且维护，对外免费开放，合适时间将进行开源化处理，开源流程符合软件开源守则，在任何平台，非官方以收费为使用前提的消息切勿相信<br>";
	document.getElementById("mz").innerHTML = html;
	document.getElementById("mztext").innerHTML = htmltext;
	html = "";
	html += "<br><br><br><br><br><br><br>看板娘这么可爱确定不调戏一下？----->";
	document.getElementById("kb").innerHTML = html;
	$('#shiyon').modal('show', 'fit')
}

function yiwu(){
	$('#myModal').modal('show', 'fit')
}

function zuozhe(){
	var html = "";
	html += "1131940794";
	document.getElementById("qq").innerHTML = html;
	$('#zuozhe').modal('show', 'fit')
}
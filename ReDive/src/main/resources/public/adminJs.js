
//iframe样式设置
 function onlickCss(){
     setIframeHeight(document.getElementById('iframe'));
 }
//绑定自适应宽高
function setIframeHeight(iframe) {
    iframe.onload=function(){
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        var iframeHeight=iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        iframe.height = iframeHeight+10;
    }
};

//信息传入
$(document).ready(function(){
    $.ajax({
        url : 'Menu.act',
        type : 'POST',
        dataType : 'JSON',
        data : {
        },
        success : function(msg) {
            var uids = sessionStorage.getItem('userFront');//将信息传入
            var uname = sessionStorage.getItem('userName');//将信息传入
            //document.getElementById("uid").value = uids;
            document.getElementById("adminName").innerHTML = uname;
            var arr = msg.datas.menus;
            parseTree(arr);
        },
        error : function(msg) {
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg('登入超时',{icon:6,time:1000,width: '200px',height:'200px',end:function(){
                        location.href = "page.act?page=login";
                    }});
            });
        }
    });
});

//注意：导航 依赖 element 模块，否则无法进行功能性操作
function parseTree(objArr) {
    layui.use('element', function () {
        var $ = layui.jquery
            , element = layui.element;
        //先添加所有的主材单
        $.each(objArr, function (i, obj) {
            if(obj.pMenuId==0) {
                var content = '<li class="layui-nav-item">';
                //一级标题
                content += '<a href="javascript:;" >' + obj.menuName + '</a>';
                //这里是添加所有的子菜单
                content += loadchild(obj);
                content += '</li>';
                $(".layui-nav-tree").append(content);
            }
        });
        element.init();

        //组装子菜单的方法
        function loadchild(obj){
            if(obj==null){
                return;
            }

            var content='';
            if(obj.menuList!=null && obj.menuList.length>0){
                content+='<dl class="layui-nav-child">';
            }else{
                content+='<dl>';
            }
            if(obj.menuList!=null && obj.menuList.length>0){
                $.each(obj.menuList,function(i,note){
                    content+='<dd>';
                    content+='<a onclick="changePage(&quot;'+ note.menuUrl +'&quot;)">'+note.menuName+'</a>';
                    if(note.menuList==null){
                        return;
                    }
                    content+=loadchild(note);
                    content+='</dd>';
                });

                content+='</dl>';
            }
            return content;
        }
    });

}

//公告
$(document).ready(function(){
    //cookie循环
    function getCookie(cname){
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i].trim();
            if (c.indexOf(name)==0) { return c.substring(name.length,c.length); }
        }
        return "";
    }
    var user = getCookie("gongao");
    //循环结束
    if(user!="have"){
        document.cookie = "gongao=have;max-age=10000;"
        $.ajax({
            url : 'chaxunzuixingongao.act',
            type : 'POST',
            dataType : 'JSON',
            data : {},
            success : function(msg) {
                //会长公告
                document.getElementById("hzgg").innerHTML = msg.datas.newgongao[0].gonGaoText;
                //作者公告
                document.getElementById("zzgg").innerHTML = msg.datas.newgongao[1].gonGaoText;
            },
            error : function(msg) {

            }
        });
        $('#tiaochugongao').modal({
            keyboard : false,
            show     : true,
            backdrop : static,
            keyboard : true
        })
        $('#tiaochugongao').modal('show', 'fit');
    }
});

//iframe跳转
function changePage(page) {
    $('#iframes').attr('src',
        "page.act?page=" + page + "&aaa=" + Math.random())
};

//退出
function logout() {
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer,
            form = layui.form;
        layer.open({
            content: '是否退出系统',
            yes: function(index, layero){
                //do something
                layer.close(index); //如果设定了yes回调，需进行手工关闭
                $.ajax({
                    url : 'tuichu.act',
                    type : 'POST',
                    dataType : 'JSON',
                    success : function(msg) {
                        layui.use('layer', function(){
                            var layer = layui.layer;
                            layer.msg(msg.msg,{icon:6,time:1000,width: '200px',height:'200px',end:function(){
                                    location.href = "page.act?page=login";
                                }});
                        });
                    },
                    error:function(msg) {

                    }
                });
            }
        });
    });
}
function xiugainame(){
    $('#wodename').modal('show', 'fit');
}// 或者在初始化时指定弹出方向
$('[data-toggle="popover"]').popover({
    placement: 'bottom'
});

function wdnmd(){
    $('#errortalkme').modal({
        keyboard : true,
        show     : true,
        backdrop : 'static'
    })
}

function xiugaiPassword(){
    $('#wodepass').modal('show', 'fit');
}

function gonhuilook(){
    var uid = sessionStorage.getItem('userFront');//将信息传入
    $.ajax({
        url:"gonhuilook.act",
        type:'post',
        dataType:'JSON',
        data:{uuid:uid},
        success:function(msg){
            if(msg.id==1){
                document.getElementById("gonhuilooks").value = msg.msg;
            }else if(msg.id==2){
                document.getElementById("gonhuilooks").value = '暂未加入工会';
            }
        },error:function(msg){

        }
    });
    $('#gonhuilook').modal('show', 'fit');
}

var types = "";
function OnInput(event){
    if($('#newnames').val()==''){
        document.getElementById("lab").innerHTML = "空";
        return;
    }else{
        document.getElementById("lab").innerHTML = "可用";
    }
    /* $.ajax({
        url:"quedinregist.act",
        type:'post',
        dataType:'JSON',
        data:{uuid:$('#newnames').val()},
        success:function(msg){
            if(msg.id==1){
                document.getElementById("lab").innerHTML = msg.msg;
                types = 1;
                return;
            }else if(msg.id==2){
                document.getElementById("lab").innerHTML = msg.msg;
                types = 0;
                return;
            }
        },error:function(msg){

        }
    }); */
}
//修改名称
function baocunname(){
    var names = $('#newnames').val();
    if(names == null || names == '' || typeof names == "undefined" || names == undefined){
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.alert('名字不能为空!');
        });
        return;
    }else {
        $.ajax({
            url: 'updatename.act',
            type: 'POST',
            dataType: 'JSON',
            data: {newnames: names},
            success: function (msg) {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.msg(msg.msg, {
                        icon: 6, time: 1000, end: function () {
                            sessionStorage.setItem('userName', msg.datas.userFront.userName);//将信息传入
                            window.parent.location.reload();
                        }
                    });
                });
            },
            error: function (msg) {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.msg('奇怪的错误增加了!');
                });
            }
        });
    }
}
//修改密码
function baocunpass(){
    var old = $('#oldpass').val();
    var news = $('#newpass').val();
    var doubles = $('#doublepass').val();
    var uid = sessionStorage.getItem('userFront');//将信息传入
    if(old == '' || news == '' || doubles == ''){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg('有选项为空!');
        });
        return;
    }
    if(doubles!=news){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg('密码修改失败,确认密码不一致');
        });
        return;
    }
    else if(old==news){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.alert('密码修改完成,新密码是:<b><font color="red">'+news+'<b></font>，请妥善保管!');
        });
    }else{
        $.ajax({
            url : 'updatepass.act',
            type : 'POST',
            dataType : 'JSON',
            data : {doubles:doubles,uid:uid},
            success : function(msg) {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    if(msg.id==1){
                        layer.msg(msg.msg);
                    }else{
                        layer.msg(msg.msg,{icon:6,time:2000,end:function(){
                            location.reload();
                        }});
                    }
                });
            },
            error : function(msg) {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg('奇怪的错误增加了!');
                });
            }
        });
    }
}

function baocunerr(){
    var names = $('#newnames').val();
    if(names == null || names == '' || typeof names == "undefined" || names == undefined){
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.alert('名字不能为空!');
        });
        return;
    }else {
        $.ajax({
            url: 'updatename.act',
            type: 'POST',
            dataType: 'JSON',
            data: {newnames: names},
            success: function (msg) {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.msg(msg.msg, {
                        icon: 6, time: 1000, end: function () {
                            sessionStorage.setItem('userName', msg.datas.userFront.userName);//将信息传入
                            window.parent.location.reload();
                        }
                    });
                });
            },
            error: function (msg) {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.msg('奇怪的错误增加了!');
                });
            }
        });
    }
}

//退出工会
function gonhuiout(){
    layui.use('layer', function(){var layer = layui.layer;
        layer.confirm('确定要<font color="red">退出工会</font>吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var uid = sessionStorage.getItem('userFront');//将信息传入
            $.ajax({
                url : 'delyonhugonhuiid.act',
                type : 'POST',
                dataType : 'JSON',
                data : {uid:uid},
                success : function(msg) {
                    //退出
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg(msg.msg,{icon:6,time:1000,end:function(){
                                $.ajax({
                                    url : 'tuichu.act',
                                    type : 'POST',
                                    dataType : 'JSON',
                                    success : function(msg) {
                                        layui.use('layer', function(){
                                            var layer = layui.layer;
                                            layer.msg(msg.msg,{icon:6,time:1000,width: '200px',height:'200px',end:function(){
                                                //回滚主页面
                                                top.location.href = "page.act?page=login";
                                            }});
                                        });
                                    },
                                    error:function(msg) {
                                        //回滚主页面
                                        top.location.href = "page.act?page=login";
                                    }
                                });
                            }});
                    });
                },
                error : function(msg) {
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg('奇怪的错误增加了!');
                    });
                }
            });
        }, function(){
           return;
        });
    });
}
var layer = layui.layer;

function zhaohuiid(){
    if($('#tel').val()==''){
        layui.use('layer', function(){
            layer.msg('请输入账户!');
        });
        return;
    }else if($('#keys').val()=='' || $('#email').val()==''){
        layui.use('layer', function(){
            layer.msg('请输入验证码/邮箱!');
        });
        return;
    }/* else if(checkCode != $('#keys').val()){
			layui.use('layer', function(){
				  layer.msg('验证码错误，请重新校对!');
				});
			return;
		} */
    if(checkCode == $('#keys').val()){
        keytypes = 2;
    }
    $.ajax({
        url:"youxiangzhanhu.act",
        type:"post",
        dataType:"JSON",
        data:{tel:$('#tel').val(),mails:$("#email").val()},
        success:function (text) {
            console.log(text.id);
            if(text.id==1){
                layui.use('layer', function(){
                    layer.msg(text.msg);
                });
                return;
            }else if(text.id==2){
                if(document.getElementById("zhon").style.display=="" /* && keytypes==2 */){
                    document.getElementById("zhon").style.display="none";//隐藏
                    document.getElementById("zhon2").style.display="";//打开
                    document.getElementById("zhanghaoyc").value = $('#tel').val();
                }else{
                    document.getElementById("zhon2").style.display="none";//隐藏
                    document.getElementById("zhon").style.display="";//打开
                }
            }
        }
    });
}
var keytypes = 1;
//验证码
var checkCode = "";

// $("#sendCheckCode").click(function () {
function sendCheckCode(){
    var email = $("#email").val();
    if (email == null || email == ""){
        layui.use('layer', function(){
            layer.msg('请输入邮箱!');
        });
        return;
    }
    layui.use('layer', function(){
        layer.msg('邮件发送中,请等待半分钟左右...');
    });
    countDown();
    $.ajax({
        url:"/getCheckCode?email="+email,
        type:"get",
        success:function (text) {
            if (text != null && text != ""){
                layui.use('layer', function(){
                    layer.msg('发送成功');
                });
                checkCode = text;
            } else{
                layui.use('layer', function(){
                    layer.msg('获取失败，请重试!');
                });
            }
        }
    });
}

var maxTime = 60;
function countDown(){
    if (maxTime == 0){
        checkCode = "";
        $("#sendCheckCode").removeClass("layui-btn-disabled");
        $("#sendCheckCode").removeAttr("disabled")
        $("#sendCheckCode").html("获取验证码");
        maxTime = 60;
    }else{
        $("#sendCheckCode").attr("disabled","disabled");
        $("#sendCheckCode").addClass("layui-btn-disabled");
        $("#sendCheckCode").html(maxTime+"秒后重新获取");
        maxTime = maxTime-1;
        setTimeout(countDown,1000);
    }
}

$('#oks').click(function(){
    if($('#pass').val()=="" || $('#passto').val()==""){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg('请输入新密码');
        });
        return;
    }else if($('#pass').val()!=$('#passto').val()){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg('两次密码不一致');
        });
        return;
    }else{
        $.ajax({
            url:"backpass.act",
            type:'post',
            dataType:'JSON',
            data:{tel:$('#zhanghaoyc').val(),pass:$('#pass').val(),mails:$("#email").val()},
            success:function(msg){
                if(msg.id==2){
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg(msg.msg,{icon:6,time:1000,end:function(){
                                window.location.href = "page.act?page="+ msg.location;
                            }});
                    });
                }else if(msg.id!=2){
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg(msg.msg);
                    });
                    return;
                }
            },error:function(msg){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg('请联系管理员');
                });
            }
        });
    }});
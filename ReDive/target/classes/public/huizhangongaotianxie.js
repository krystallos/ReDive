function ookss(){
    var gongaogonhui = sessionStorage.getItem('userGonHui');//将信息传入
    var gongaotype = $("input[name='primaryRadioGroup1']:checked").attr("id");
    if(typeof(gongaotype) == "undefined" || $('#biaoti').val()=="" || $('#content').val()==""){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg("有选项为空");
            return;
        });
    }else{
        $.ajax({
            url : 'huizhanggongaotianxie.act',
            type : 'POST',
            dataType : 'JSON',
            data : {gongaotype:gongaotype,gongaobiaoti:$('#biaoti').val(),gongaotext:$('#content').val(),gongaogonhui:gongaogonhui},
            success : function(msg) {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(msg.msg);
                });
            },
            error : function(msg) {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg('奇怪的错误增加了!');
                });
                location.reload()
            }
        });
    }
}
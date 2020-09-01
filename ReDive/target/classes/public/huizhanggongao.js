$(document).ready(function(){
    var userGonhui = sessionStorage.getItem('userGonHui');//将信息传入
    console.log(userGonhui)
    $.ajax({
        url : 'glygongao.act',
        type : 'POST',
        dataType : 'JSON',
        data : {gongaoid:2,gongaogonhui:userGonhui},
        success : function(msg) {
            html = '';
            for(var i = 0;i<msg.datas.glygongao.length;i++){
                var bname = msg.datas.glygongao[i];
                html += '<p>';
                html += '<a href="#collapseExample'+i+'" data-toggle="collapse" data-parent="#accordion" class="btn btn-link collapsed">'+bname.gonGaoName+'</a>'
                html += '<span>更新日期:</span><span>'+bname.gonGaoCtime+'</span></p>';
                html += '<div class="collapse" id="collapseExample'+i+'">';
                if(bname.gonGaoDengJi==1){
                    html += '<div class="bg-danger with-padding">';
                }else if(bname.gonGaoDengJi==2){
                    html += '<div class="bg-primary with-padding">';
                }else {
                    html += '<div class="bg-success with-padding">';
                }
                html += '<p>'+bname.gonGaoText+'</p>';
                html += '</div></div><hr>';
            }
            $("#accordion").html(html);
        },
        error : function(msg) {
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg('奇怪的错误增加了!');
            });
            location.reload()
        }
    });
});
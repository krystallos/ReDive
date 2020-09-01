function inittable(){
		$("#acc").val("");
		$("#name").val("");
		$("#phone").val("");				
		$("#address").val("");
		$.ajax({
			url:"getUserMassage.client",
			type:"post",
			data:{
			},
			dataType:"json",
			success:function(respData){
					$("#sexOne").attr("class","","checked",false);
					$("#sexTwo").attr("class","","checked",false);
					$("#acc").val(respData.user.userAcc);
					$("#name").val(respData.user.userName);
					$("#phone").val(respData.user.userPhone);				
					$("#address").val(respData.user.userAddress);
					$("#submit").attr("userId",respData.user.userId);
						if(respData.user.userSex==1){
							$("#sexOne").attr("class","current","checked",true);
						}else{
							$("#sexTwo").attr("class","current","checked",true);
						}
			},
			error:function(){
			}
		});
}

function submitA() {
//	if($("#submit").attr("parsent")!=100){
//		layer.msg("未上传文件或文件未上传完成，请重试");
//		return;
//	}
	$.ajax({
		url:"updateMyMassage.client",
		type:"post",
		data:{
			fileName:$("#submit").attr("fileName"),
			name1:$("#submit").attr("name"),
			userId:$("#submit").attr("userId"),
			acc:$("#acc").val(),
			name:$("#name").val(),
			phone:$("#phone").val(),
			address:$("#address").val(),
			sex:$("input[type='radio']:checked").val(),
		},
		dataType:"json",
		success:function(respData){
			if(respData.file=="false"){
				layer.msg("上传头像重复！")
			}
			if(respData.result>0){
				layer.msg("修改成功");
				window.location.href = "mymassage_lzh.html";
			}else{
				layer.msg("修改失败");
				window.location.href = "mymassage_lzh.html";
			}
		},
		error:function(){
		}
	});
}


function getphoto() {
	$.ajax({
		url:"getString.client",
		type:"post",
		data:{
			
		},
		success:function(respData){
			$("#photo").attr("src",respData);
		},
		error:function(){
		}
	});
}

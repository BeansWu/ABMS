/* 获取用户信息 -暂放*/
function getUser() {
	var user = {
			id:"1",
			name:"吴忠恩"
	}
	return user;
}

function findAll(){
	var userId = getUser().id;
	$.get("../../budget/findAll", {"userId":userId}, function(data) {
		alert(data[0].name);
		budget_app_admin.init(data);
	});
	alert('已发送请求');
}
findAll();

var budget_app_admin = new Vue({
	el:'#budget_app_admin',
	data:{
		budgetApps:[]
	},
	methods:{
		init:function(data){
			this.budgetApps=data;
		},
		modify:function(index){
			//alert(this.budgetApps[index].number);
			var budgetApp = this.budgetApps[index];
			$.ajax({
				type: "POST",
				url: "../../budget/modify",
				dataType: "json",
				contentType: "application/json",
				data: JSON.stringify(budgetApp),
				success: function(data) {
					switch(data["result"]) {
						case"success":alert("提交成功");break;
						case"failure":alert("提交失败");break;
						default:alert("未知错误");
					}
					window.location.href="../../views/common/budget_app_add.html";
				}
			})
		}
	}
})

// function findAll(){
// 	$.get("../../purchase/findAll", function(data) {
// 		purchase_vue.init(data);
// 	})
// }
// findAll();
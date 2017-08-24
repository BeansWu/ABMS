/* 获取用户信息 -暂放*/
function getUser() {
	var user = {
			id:"1",
			name:"吴忠恩"
	}
	return user;
}

var budget_app_admin = new Vue({
	el:'#budget_app_admin',
	data:{
		budgetApps:[]
	},
	methods:{
		init:function(data){
			var that = this;
			$.ajax({
				type:"get",
				url:"../../budget/findAll",
				data:"userId="+1,
				dataType:"json",
				async:false,
				success:function(data){
					that.budgetApps = data;
				}
			});

		},
		modify:function(id){
			$.ajax({
				type:"get",
				url:"../../budget/modify",
				data:"budgetId="+id,
				dataType:"json",
				async:false,
				success:function(data){
					var budgetApp = data["budgetApp"];
					$.session.set("budgetApp", JSON.stringify(budgetApp));
					var purchases = data["purchases"];
					$.session.set("purchases", JSON.stringify(purchases));
					window.location = "budget_app_info.html";
					
				}
			});
		}
	}
});

budget_app_admin.init();



/* 自动预算项目号 */
function autoInitNumber () {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var budget_app_number = "".concat(year).concat(month).concat(day).concat(hour).concat(minute).concat(second);
	return budget_app_number;
}

/* 获取用户信息 -暂放*/
function getUser() {
	var user = {
			id:"1",
			name:"吴忠恩"
	}
	return user;
}

/* 添加或保存预算项目  */
function saveOrUpdate(budgetApp) {

	$.ajax({
		type: "POST",
		url: "../../budget/saveOrUpdate",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(budgetApp),
		success: function(data) {
			switch(data["result"]) {
				case"success":alert("提交成功");break;
				case"failure":alert("提交失败");break;
				default:alert("未知错误");
			}
		}
	})
}


/* 预算项目 */
var budget_app_add = new Vue({
	el : "#budget_app_add",
	data : {
		budgetApp : {
			id:"",
			number:"",
			name:"",
			requiredTime:"",
			user:"",
			fillDate:"",
			reason:""		
		},
		selected:-1,
		newPurchase:{
			budgetApp:{
				id:1,
				fillDate:new Date('2017-01-01 00:00:00'),
				name:'研究生活经费',
				number:'45217790',
				requiredTime:'2018',
				auditState:0,
				reason:''
			},
			purchaseItem:{
				id:1,
				code:'新采集',
				name:'货物'
			},
			count:0,
			unit:'新采集',
			price:0,
			isPurchase:true,
			isService:false,
			isAsset:false,
			isFaceMiddle:false
			
		},
		purchases:[]
	},
	methods : {
		initBudgetApp : function () {	//初始化预算项目（某些自动生成）
			this.budgetApp.id = "";
			this.budgetApp.number = autoInitNumber();
			this.budgetApp.name = "",
			this.budgetApp.requireTime = "",
			this.budgetApp.user = getUser().name;
			this.budgetApp.fillDate = new Date().toLocaleDateString();
			this.budgetApp.reason = "";
		},
		save : function() { 			//保存预算项目及其采购明细
			alert('保存');
			saveOrUpdate({
				user:getUser(),
				number:this.budgetApp.number,
				name:this.budgetApp.name,
				requiredTime:this.budgetApp.requireTime,
				fillDate:new Date(this.budgetApp.fillDate),
				reason:this.budgetApp.reason,
				auditState:0
			});
			this.saveAllPurchase();
		},
		
		initPurchase:function (data) {	//初始化采购明细  用在修改预算项目的时候
			this.purchases=data["purchases"];
		},
		
		modifyPurchase:function () {

			if(this.selected>-1){
				Vue.set(this.purchases,this.selected,this.newPurchase);
			} else {
				this.purchases.push(this.newPurchase);
				this.purchases = JSON.parse(JSON.stringify(this.purchases));
				
			}
			
			this.closeModal();
			this.selected=-1;
		},
		
		closeModal:function(){		//关闭模态框
			$("#edit").modal("hide");
		},
		
		addPurchase:function () {	
			this.newPurchase = {	
				budgetApp:{			//应有一个获取budgetApp的方法
					id:1,
					fillDate:new Date('2017-01-01 00:00:00'),
					name:'研究生活经费',
					number:'45217790',
					requiredTime:'2018',
					auditState:0,
					reason:''
				},
				purchaseItem:{		//应有一个获取purchaseItem的方法
					id:1,
					code:'新采集',
					name:'货物'
				},
				count:0,
				unit:'新采集',
				price:0,
				isPurchase:true,
				isService:false,
				isAsset:false,
				isFaceMiddle:false			
			}
		},
		
		deletePurchase:function (index) {		//删除本行数据
			this.purchases.splice(index,1);
		},
		
		editPurchase:function (index) {			//修改本行数据
			this.selected = index;
			this.newPurchase = this.purchases[index];

		},
		
		saveAllPurchase:function () {			//保存所有采购项目明细
			alert("您点击了保存采购明细");
			$.ajax({
				type: "POST",
				url: "../../purchase/saveAll",
				dataType: "json",
				contentType: "application/json",
				data: JSON.stringify(this.purchases),
				success: function(data) {
					switch(data["result"]) {
						case"success":alert("提交成功");break;
						case"failure":alert("提交失败");break;
						default:alert("未知错误");
					}
				}
			})
		}
		
	}	
});



budget_app_add.initBudgetApp();




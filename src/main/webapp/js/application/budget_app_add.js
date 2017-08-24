
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



//只能勾选叶子节点
function zTreeBeforeClick(treeId, treeNode, clickFlag) {
	return !treeNode.isParent;
};

function findAll(){						
	$.get("../../purchaseItem/findAll", function(data){

		var purchaseItems = data;
		var zNodes = [];
		purchaseItems.forEach(function(item, index, list){
			var purchaseItem = {
				id:item.id,
				pId:item.parentItem==null?0:item.parentItem.id,
				name:item.code+' '+item.name
			};
			zNodes.push(purchaseItem);
		});
		budget_app_add.initTree(zNodes);
	});

};
findAll();


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
			budgetApp:{},
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
			isFaceMiddle:false,
			auditState:'SUBMITTED'
		},
		purchases:[],
		//以下是品目树相关参数
		keyword:{},
		zNodes:[],
		hiddenNodes:[],
		zTreeObj:{},
		setting : {
			view: {
				showIcon: false		//不显示图标
			},
			check:{
				enable:true,
				chkStyle: "radio",
				radioType: "all"	//分组范围为全局 即只能选一个
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback:{
				beforeCheck:zTreeBeforeClick
			}
		}

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
			this.saveBudgetApp();
			this.saveAllPurchase();
		},
		
		/* 添加或保存预算项目  */
		saveBudgetApp: function() {
			var that = this;
			var budget = {
				user:getUser(),
				number:this.budgetApp.number,
				name:this.budgetApp.name,
				requiredTime:this.budgetApp.requireTime,
				fillDate:new Date(this.budgetApp.fillDate),
				reason:this.budgetApp.reason
			};
			$.ajax({
				type: "POST",
				url: "../../budget/saveOrUpdate",
				dataType: "json",
				contentType: "application/json",
				async:false,
				data: JSON.stringify(budget),
				success: function(data) {
					alert(data.id);
					that.purchases.forEach(function(purchase, index, purchases){
						purchase.budgetApp = data;
						alert(purchase.budgetApp.id);
					});
				}
			});
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
			
			this.closeModal1();
			this.selected=-1;
		},
		
		closeModal1:function(){		//关闭模态框
			$("#edit").modal("hide");
		},
		
		addPurchase:function () {	
			this.newPurchase = {	
				budgetApp:{			//应有一个获取budgetApp的方法
					
				},
				purchaseItem:{		//应有一个获取purchaseItem的方法
					id:1,
					code:'新采集',
					name:'货物'
				},
				count:0,
				unit:'新采集',
				price:0,
				isPurchase:false,
				isService:false,
				isAsset:false,
				isFaceMiddle:false,
				auditState:'SUBMITTED'
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
			alert(this.purchases[0].budgetApp.id);
			$.ajax({
				type: "POST",
				url: "../../purchase/saveAll",
				dataType: "json",
				contentType: "application/json",
				async:false,
				data: JSON.stringify(this.purchases),
				success: function(data) {
					switch(data["result"]) {
						case"success":alert("提交成功");break;
						case"failure":alert("提交失败");break;
						default:alert("未知错误");
					}
				}
			})
		},
		
		/* 以下是品目树相关方法 */
		
		initTree:function(data){
			this.zNodes = data;
			this.zTreeObj = $.fn.zTree.init($("#itemTree"), this.setting, this.zNodes);
		},
		
		filter:function(){
			//展开所有
			this.unfold();

			// 显示上次搜索后被隐藏的结点
			this.zTreeObj.showNodes(this.hiddenNodes);

			//查找不符合条件的叶子结点
			function filterFunction(node){
				if(node.isParent||node.name.indexOf(this.keyword)!=-1)
					return false;
				return true;
			};

			// 获取不符合条件的叶子结点
			this.hiddenNodes = zTreeObj.getNodesByFilter(filterFunction);

			//隐藏不符合条件的叶子结点
			this.zTreeObj.hideNodes(this.hiddenNodes);
		},
		
		showTree: function() {
			$('#tree').modal();
		},
		
		getChecked:function(){
			
			var id = this.zTreeObj.getCheckedNodes()[0].id;
			$.get("../../purchaseItem/findById", {id:id}, function(data){

				budget_app_add.newPurchase.purchaseItem = data;
			});

			$('#tree').modal("hide");
		},
		
		closeModal2:function(){
			$('#tree').modal("hide");
		},
		
		foldUp:function(){
			this.zTreeObj.expandAll(false);
		},
		
		unfold:function(){
			this.zTreeObj.expandAll(true);
		}
		
	}	
});



budget_app_add.initBudgetApp();





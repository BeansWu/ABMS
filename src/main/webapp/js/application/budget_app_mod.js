

jQuery(function($){
	var map={
		UNSUBMITTED:'未提交',
		SUBMITTED:'已提交',
		MGR_AUDITED:'经办人已通过',
		MGR_REJECT:'经办人已驳回',
		LD_AUDITED:'分管领导已通过',
		LD_REJECT:'分管领导已驳回',
		ASSET_AUDITED:'资产处已通过',
		ASSET_REJECT:'资产处已驳回',
		FIN_AUDITED:'财务处已通过',
		FIN_REJECT:'财务处已驳回'
		
	};

	//根据审核状态 开放权限
	$("#tb_purchase").find('tr')
	.each(function(){
			var auditState = $(this).children('td').eq(8).html();
			if(auditState != "UNSUBMITTED")
				$(this).find('button').addClass('disabled');
			$(this).children('td').eq(8).html(map[auditState]);
	});
});



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
		budget_app_mod.initTree(zNodes);
	});

};
findAll();


/* 预算项目 */
var budget_app_mod = new Vue({
	el : "#budget_app_mod",
	data : {
		budgetApp : {
	
		},
		selected:-1,
		newPurchase:{
			budgetApp:this.budgetApp,
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
			auditState:'UNSUBMITTED'
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
		init : function () {
			this.budgetApp = JSON.parse($.session.get('budgetApp'));
			this.purchases = JSON.parse($.session.get('purchases'));
		},
		
		save : function () {
			$.ajax({
				type: "POST",
				url: "../../purchase/saveOrUpdate",
				dataType: "json",
				contentType: "application/json",
				async:false,
				data: JSON.stringify(this.newPurchase),
				success: function(data) {
				}
			});
			this.closeModal1();
			this.refresh();
			var index = this.purchases.length;
			this.purchases[index-1].auditState = "未提交";  //此处由于网页渲染问题（网页还未渲染完成） 不能通过更改html来完成

		},
	
		del: function (index) {
			var purchase = this.purchases[index];
			$.ajax({
				type: "POST",
				url: "../../purchase/del",
				dataType: "json",
				contentType: "application/json",
				async:false,
				data: JSON.stringify(purchase),
				success: function(data) {
				}
			});
			this.refresh();
			
		},
		
		submit: function (index) {
			var purchase = this.purchases[index];
			purchase.auditState = "SUBMITTED";
			$.ajax({
				type: "POST",
				url: "../../purchase/saveOrUpdate",
				dataType: "json",
				contentType: "application/json",
				async:false,
				data: JSON.stringify(purchase),
				success: function(data) {
				}
			});
			this.refresh();
			$("#tb_purchase").find('tbody').children('tr').eq(index+1).children('td').eq(8).html("已提交");
			$("#tb_purchase").find('tbody').children('tr').eq(index+1).find('button').addClass('disabled');

		},
		
		refresh: function () {
			var id = this.budgetApp.id;
			var that = this;
			$.ajax({
				type:"get",
				url:"../../budget/modify",
				data:"budgetId="+id,
				dataType:"json",
				async:false,
				success:function(data){	
					that.purchases = data["purchases"];	
					
				}
			});
//			alert(that.purchases.length);
			
			
		},
			
		closeModal1:function(){		//关闭模态框
			$("#edit").modal("hide");
		},
		
		addPurchase:function () {	
			this.newPurchase = {	
				budgetApp:this.budgetApp,
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
				auditState:'UNSUBMITTED'
			}
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

				budget_app_mod.newPurchase.purchaseItem = data;
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



budget_app_mod.init();





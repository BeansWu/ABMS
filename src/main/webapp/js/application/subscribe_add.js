

var subscribe_add = new Vue({
	el:'#app',
	data:{
		option:{},
		options:[],
		dialogFormVisible: false,
		formLabelWidth:'68px',
		selected:[],
		purchases:[],
		subscribe:{
			id:'',
			name:'',
			requiredTime:'',
			unit:'',
			price:'',
			count:'',
			isImports:false,
			user:{
				id:1,
				account:'test01',
				gender:1,
				name:'wze',
			},
			purchase:{
				
			},
			paramAndRequire:'',
			auditState:'SUBMITTED'
		},
		subscribes:[]
	},
	methods:{
		handleChange(value) {
			console.log(value);
			var index = this.options[value[0]-1].children[value[1]-1].value;
			this.subscribe.purchase = this.purchases[index];
		},
		
		initSubscribes:function(){
			var that = this;
			$.ajax({
				type:"get",
				url:"../../subscribe/findAll",
				data:"userId="+1,
				dataType:"json",
				async:false,
				success:function(data){
					that.subscribes = data;
				}
			});
		},
		
		initOptions:function(){
			this.first();
			this.second();
		},
	
		
		first:function(){
			var that = this;
			$.ajax({
				type:"get",
				url:"../../budget/findAll",
				data:"userId="+1,
				dataType:"json",
				async:false,
				success:function(data){
					data.forEach(function(budgetApp,index,budgetApps){
						that.option={
							value:budgetApp.id,
							label:budgetApp.number+" "+budgetApp.name,
							children:[]
						};
						that.options.push(that.option);
					});
				}
			})

		},
		
		second:function(){
			var that = this;
			$.ajax({
				type:"get",
				url:"../../purchase/findAll",
				dataType:"json",
				async:false,
				success:function(data){
					that.purchases = data;
					that.options.forEach(function(option, index, options){
						var budgetId = option.value; 
						data.forEach(function(purchase, index, purchases){
							if(purchase.budgetApp.id == budgetId){
								var sub = {
									value:purchase.id,
									label:purchase.purchaseItem.code+" "+purchase.purchaseItem.name+" "+
											purchase.count*purchase.price+"万"
								};
								option.children.push(sub);
							}
						})
					})
				}
			})
		},
		
		save:function(){
			alert(this.subscribe.paramAndRequire);
			$.ajax({
				type: "POST",
				url: "../../subscribe/saveOrUpdate",
				dataType: "json",
				contentType: "application/json",
				data: JSON.stringify(this.subscribe),
				success: function(data) {
					switch(data["result"]) {
						case"success":alert("提交成功");break;
						case"failure":alert("提交失败");break;
						default:alert("未知错误");
					}
				}
			})
			this.dialogFormVisible = false;
		}
	}
	
});
subscribe_add.initOptions();
subscribe_add.initSubscribes();

jQuery(function($){
	var oTable = $('#sample-table').dataTable( {
		"bFilter":true,
		"language":{
			"url":"../../components/jquery/language/Chinese.json"
		},
		"bJQueryUI":true,
		"bLengthChange":false,  //改变页面显示数据数量，不改变
		"bPaginate":false,      //翻页功能，不翻页
		"bInfo":false,			//页脚信息，不显示
		"aoColumns":[			//第一个用来选中 后面的都可用来排序
			null,null,null,null,
			null,null,null,
			{"bSortable":false}
		]
	});

	$('table th input:checkbox').on('click',function(){
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox')
		.each(function(){
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		})
	});
	
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
	$("#sample-table").find('tr')
	.each(function(){
			var auditState = $(this).children('td').eq(6).html();
			if(!submitable(auditState))
				$(this).find('button').addClass('disabled');
			$(this).children('td').eq(6).html(map[auditState]);
	});
	
	function submitable(auditState){
		if(auditState == 'UNSUBMITTED'|| auditState == 'MGR_REJECT' || auditState == 'LD_REJECT'
			|| auditState == 'ASSET_REJECT' || auditState == 'FIN_REJECT')
			return true;
		return false;
	}
})
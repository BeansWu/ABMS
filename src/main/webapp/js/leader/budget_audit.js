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
			{"bSortable":false},
			null,null,null,null,null,null,null,
			{"bSortable":false}
		]
	});
	
	//全选
	$('table th input:checkbox').on('click',function(){
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox')
		.each(function(){
			if(this.disabled!=true){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			}	
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
	$("#sample-table").find('tr > td:first-child input:checkbox')
	.each(function(){
			var auditState = $(this).closest('tr').children('td').eq(7).html();
			if(auditState!='MGR_AUDITED')
				this.disabled=true;
			$(this).closest('tr').children('td').eq(7).html(map[auditState]);
	});
})
	




var budget_audit = new Vue({
	el:'#budget_audit',
	data:{
		modifyPurchases:[],
		purchases:[]
	},
	methods:{
		init:function(data){
			var that = this;
			$.ajax({
				type:"get",
				url:"../../purchase/findAll",
				dataType:"json",
				async:false,
				success:function(data){
					that.purchases = data;
				}
			});

		},
		
		getChecked:function(){
			var that = this;
			
			$("#sample-table").find('tr > td:first-child input:checkbox')
			.each(function(){
				if(this.checked == true){
					var id = $(this).closest('tr').find('td:last-child').html();
					that.modifyPurchases.push(that.findById(id));
				}					
			});
		},
		
		findById:function(id){
			var data;
			this.purchases.forEach(function(purchase,index,purchases){
				if(purchase.id == id)
					data = purchase;
			});
			return data;
		},
		
		allow:function(){		
			this.getChecked();
			this.modifyPurchases.forEach(function(purchase,index,purchases){
				purchase.auditState="LD_AUDITED";
			});
			this.modify();
			
		},
		
		reject:function(){
			this.getChecked();
			this.modifyPurchases.forEach(function(purchase,index,purchases){
				purchase.auditState="LD_REJECT";
			});
			this.modify();
		},
		
		modify:function(){
			$.ajax({
				type: "POST",
				url: "../../purchase/modifyAll",
				dataType: "json",
				contentType: "application/json",
				data: JSON.stringify(this.modifyPurchases),
				success: function(data) {
					switch(data["result"]) {
						case"success":alert("提交成功");break;
						case"failure":alert("提交失败");break;
						default:alert("未知错误");
					}
				}
			});
			this.refresh();
		},
		
		refresh:function(){
			location.reload(true);
		}
	}
});

budget_audit.init();








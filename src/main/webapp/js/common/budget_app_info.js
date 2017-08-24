

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






/* 预算项目 */
var budget_app_mod = new Vue({
	el : "#budget_app_mod",
	data : {
		budgetApp : {
		},

		purchases:[],

	},
	methods : {
		init : function () {
			this.budgetApp = JSON.parse($.session.get('budgetApp'));
			this.purchases = JSON.parse($.session.get('purchases'));
		},

	}	
});



budget_app_mod.init();





var app = new Vue({
	el:'#app',
	data:{
		purchaseItems:''
	},
	methods:{
		init:function(data){			
			this.purchaseItems=data["purchaseItems"];
			alert(this.purchaseItems[0].name);
			alert(data["purchaseItems"][0].id);
		}
	}
})

function search() {
	$.get("../../purchase/search", function(data) {
		app.init(data);
		alert(data);
	})
}

search();
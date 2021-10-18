var options = {

	url: function(nomeProduto) {
		return "/produtos/?nomeProduto=" + nomeProduto;
	},

	getValue: "nome",
	minCharNumber: 3,
	requestDelay: 300,
	ajaxSettings: {
		contentType: "application/json"
	}
};

$(".js-nomeDoProduto").easyAutocomplete(options);

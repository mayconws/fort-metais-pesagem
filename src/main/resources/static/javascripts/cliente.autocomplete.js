var options = {

	url: function(nomeOuCnpj) {
		return "/clientes/?nomeOuCnpj=" + nomeOuCnpj;
	},

	getValue: "nome",
	minCharNumber: 3,
	requestDelay: 300,
	ajaxSettings: {
		contentType: "application/json"
	}
};

$(".js-nomeOuCnpjInput").easyAutocomplete(options);

/* Gráfico de Ordem de Serviço */
var SistemaOS = SistemaOS || {};

SistemaOS.GraficoOSPorMes = (function() {
	
	function GraficoOSPorMes() {
		this.ctx = $('#graficoOS')[0].getContext('2d');
	}
	
	GraficoOSPorMes.prototype.iniciar = function() {
		$.ajax({
			url: 'ordens/totalPorMes',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(movimentacaoMes) {
		var meses = [];
		var valores = [1,20];
		movimentacaoMes.forEach(function(obj) {
			meses.unshift(obj.mes);
			valores.unshift(obj.total);
		});	
	
		var graficoOSPorMes = new Chart(this.ctx, {
		    type: 'bar',
		    data: {
		    	labels: meses,
		    	datasets: [{
		    		label: 'Quantidade de O.S no mês',
		    		backgroundColor: "#4e73df",
	                pointBorderColor: "#4e73df",
	                pointBackgroundColor: "#fff",
	                data: valores
		    	}]
		    },
		});
	}
	
	return GraficoOSPorMes;
	
}());

/* Gráfico de Atendimentos */
SistemaOS.GraficoSuportePorMes = (function() {
	
	function GraficoSuportePorMes() {
		this.ctx = $('#graficoSuporte')[0].getContext('2d');
	}
	
	GraficoSuportePorMes.prototype.iniciar = function() {
		$.ajax({
			url: 'suportes/totalPorMes',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(controleMes) {
		var meses = [];
		var valores = [1,800];
		controleMes.forEach(function(obj) {
			meses.unshift(obj.mes);
			valores.unshift(obj.total);
		});	
	
		var graficoSuportePorMes = new Chart(this.ctx, {
		    type: 'line',
		    data: {
		    	labels: meses,
		    	datasets: [{
		    		label: 'Quantidade de Suporte no mês',
		    		backgroundColor: "#36b9cc",
	                pointBorderColor: "#4e73df",
	                pointBackgroundColor: "#fff",
	                data: valores
		    	}]
		    },
		});
	}
	
	return GraficoSuportePorMes;
	
}());

$(function() {
	
	var graficoOSPorMes = new SistemaOS.GraficoOSPorMes();
	graficoOSPorMes.iniciar();
	
	var graficoSuportePorMes = new SistemaOS.GraficoSuportePorMes();
	graficoSuportePorMes.iniciar();
	
	
});
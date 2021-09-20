/* Gráfico de Pesagem */
var ctx = document.getElementById('graficoPesagem').getContext('2d');
var graficoOS = new Chart(ctx, {
	type: 'line',
	data: {
		labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho'],
		datasets: [{
			label: 'Total de Pesagens',
			data: [12, 30, 3, 5, 2, 3],
			backgroundColor: "#36b9cc",
			pointBorderColor: "#36b9cc",
			pointBackgroundColor: "#2d9faf",
		}]
	},
	options: {
		scales: {
			y: {
				beginAtZero: true
			}
		}
	}
});

/* Gráfico de  Pesagem por Produto*/
var ctx = document.getElementById('graficoPorProduto').getContext('2d');
var graficoOS = new Chart(ctx, {
	type: 'bar',
	data: {
		labels: ['Produto 1', 'Produto 2', 'Produto 3', 'Produto 4', 'Produto 5', 'Produto 6'],
		datasets: [{
			label: 'Produtos',
			data: [12, 30, 5, 3, 8, 12],
			backgroundColor: "#5578e0",
			pointBorderColor: "#5578e0",
			pointBackgroundColor: "#5578e0",
		}]
	},
	options: {
		scales: {
			y: {
				beginAtZero: true
			}
		}
	}
});
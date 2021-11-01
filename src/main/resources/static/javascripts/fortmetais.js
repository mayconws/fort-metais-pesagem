/* Mascara de telefone com 9 digitos */
var SPMaskBehavior = function(val) {
	return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
},
	spOptions = {
		onKeyPress: function(val, e, field, options) {
			field.mask(SPMaskBehavior.apply({}, arguments), options);
		}
	};

$('.telefone').mask(SPMaskBehavior, spOptions);

/* Mascara CEP */
$(document).ready(function() {
	$('.cep').mask('00000-000');
	;
});

/* Mascara CPF */
$(document).ready(function() {
	$('.cpf').mask('000.000.000-00');
	;
});


/* Mascara Valor Decimal */
$(".valor").mask('#.##0,00', {
  reverse: true
});

$('#vd_ga, #pvm_ga').on('blur', calculateValue);

function calculateValue() {
  var vd_ga = $('#vd_ga').val().replace(',', '.');
  var pvm_ga = $('#pvm_ga').val();

  $('#vm_ga').val(convertToCurrency(vd_ga * pvm_ga));
  $('#eam_ga').val(convertToCurrency(vd_ga * pvm_ga));
}

function convertToCurrency(value) {
  return value.toLocaleString("pt-BR", {
    style: "currency",
    currency: "BRL",
    minimumFractionDigits: 2
  })
}
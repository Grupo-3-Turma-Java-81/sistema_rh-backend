package com.generation.sistema_rh_backend.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import com.generation.sistema_rh_backend.model.Pagamento;

@Service
public class PagamentoService {

	
	public BigDecimal calculo_salarioBruto(Pagamento pagamento) {			
			
		return pagamento.getSalarioBaseHora().multiply(pagamento.getHorasTotais());
	}
	
	public BigDecimal calculo_bonus(Pagamento pagamento) {
		
		return calculo_salarioBruto(pagamento).multiply(new BigDecimal("0.10"));
	}

	public BigDecimal calculo_desconto(Pagamento pagamento) {		
		
		return calculo_salarioBruto(pagamento).multiply(new BigDecimal("0.02"));
	}
	
	public BigDecimal calculo_salarioFinal(Pagamento pagamento) {
		
		return calculo_salarioBruto(pagamento).add(calculo_bonus(pagamento).subtract(calculo_desconto(pagamento))); 
	}

}

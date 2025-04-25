package com.generation.sistema_rh_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.sistema_rh_backend.model.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

	public List<Pagamento> findByMesReferenciaContainingIgnoreCase(String mesReferencia);

}

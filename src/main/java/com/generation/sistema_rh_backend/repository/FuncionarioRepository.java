package com.generation.sistema_rh_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.sistema_rh_backend.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public List<Funcionario> findByNomeContainingIgnoreCase(@Param("nome") String nome);

}

package com.github.gadini.gs.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.gadini.gs.gs.model.Safra;

@Repository
public interface SafraRepository extends JpaRepository<Safra, Long>{
	<T> T findByNome(String nome);
}
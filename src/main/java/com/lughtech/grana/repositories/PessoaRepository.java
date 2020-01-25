package com.lughtech.grana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lughtech.grana.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}

package com.project.project.Resopitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.project.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}

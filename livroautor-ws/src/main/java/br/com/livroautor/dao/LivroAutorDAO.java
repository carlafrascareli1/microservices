package br.com.livroautor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livroautor.model.LivroAutor;

@Repository
public interface LivroAutorDAO extends JpaRepository<LivroAutor, Integer>{

}

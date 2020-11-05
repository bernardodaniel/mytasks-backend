package br.com.mytasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytasks.model.TarefaCategoria;

public interface TarefaCategoriaRepository 
	extends JpaRepository<TarefaCategoria, Integer> {

}

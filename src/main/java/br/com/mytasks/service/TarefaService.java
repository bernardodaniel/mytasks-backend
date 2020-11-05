package br.com.mytasks.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mytasks.model.Tarefa;
import br.com.mytasks.model.TarefaStatus;
import br.com.mytasks.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	public Tarefa concluirTarefaPorId(Integer id) {
		Tarefa tarefa = repository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		if (TarefaStatus.CANCELADA.equals(tarefa.getStatus()))
			throw new IllegalStateException();
		
		tarefa.setStatus(TarefaStatus.CONCLUIDA);
		return repository.save(tarefa);
	}
	
}

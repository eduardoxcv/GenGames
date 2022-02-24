package br.org.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gengames.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public List<Category> findAllByTipoContainingIgnoreCase(String tipoConsole);

}

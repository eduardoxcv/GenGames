package br.org.generation.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gengames.model.Category;

import br.org.generation.lojagames.repository.CategoryRepository;

	@RestController
	@RequestMapping("/tipoConsole")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class CategoryController {
		
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@GetMapping	
	public ResponseEntity<List<Category>> getAll(){
	
			return ResponseEntity.ok(categoryRepository.findAll());
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable Long id){
		
		return categoryRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tipoConsole/{tipoConsole}")
	public ResponseEntity<List<Category>> getByTipoConsole(@PathVariable String tipoConsole){
		
		return ResponseEntity.ok(categoryRepository.findAllByTipoContainingIgnoreCase(tipoConsole));	
	}
	
	
	@PostMapping
	public ResponseEntity<Category> postCategory(@Valid @RequestBody Category tipoConsole){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(tipoConsole));
	}
	
	@PutMapping
	public ResponseEntity<Category> putCategoria(@Valid @RequestBody Category tipoConsole) {
					
		return categoryRepository.findById(Category.getId)
				.map(resposta ->
				{
					return ResponseEntity.ok().body(categoriaRepository.save(tipoConsole));
				})
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
		
		return categoryRepository.findById(id)
				.map(resposta -> {
					categoryRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


	
}

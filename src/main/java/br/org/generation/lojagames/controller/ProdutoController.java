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

import com.generation.gengames.model.Produt;

import br.org.generation.lojagames.repository.CategoryRepository;
import br.org.generation.lojagames.repository.ProdutRepository;

@RestController	
	@RequestMapping("/produtos")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class ProdutoController {
		
		@Autowired
		private ProdutRepository produtRepository;
		
		@Autowired
		private CategoryRepository categoryRepository;

		@GetMapping
		public ResponseEntity<List<Produt>> getAll(){
			return ResponseEntity.ok(produtRepository.findAll());
		}
		@GetMapping("/{id}")
		public ResponseEntity<Produt> getById(@PathVariable Long id){
			return produtRepository.findById(id)
				.map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Produt>> getByNome(@PathVariable String nome){
			return ResponseEntity.ok(produtRepository.findAllByNomeContainingIgnoreCase(nome));
		}	
		
		@PostMapping
		public ResponseEntity<Produt> postProdut(@Valid @RequestBody Produt produt){
			return categoryRepository.findById(produt.getId()
					.map((resposta -> {
						return ResponseEntity.status(HttpStatus.CREATED).body(ProdutRepository.save(produt));
					}
					.orElse(ResponseEntity.badRequest().build());
		}
		
		@PutMapping
		public ResponseEntity<Produt> putProdut(@Valid @RequestBody Produt produt) {
						
			if (produtRepository.existsById(produt.getId())){

				return categoryRepository.findById(produt.getId()
						.map(resposta -> {
							return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
						})
						.orElse(ResponseEntity.badRequest().build(); 
			}		
			
			return ResponseEntity.notFound().build();

		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
			
			return produtRepository.findById(id)
					.map(resposta -> {
						produtRepository.deleteById(id);
						return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					})
					.orElse(ResponseEntity.notFound().build());
		}
		/*

		// Consulta pelo preço maior do que o preço digitado emm ordem crescente
		
		@GetMapping("/preco_maior/{preco}")
		public ResponseEntity<List<Produto>> getPrecoMaiorQue(@PathVariable BigDecimal preco){ 
			return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanOrderByPreco(preco));
		}
		
		// Consulta pelo preço menor do que o preço digitado em ordem decrescente
		
		@GetMapping("/preco_menor/{preco}")
		public ResponseEntity<List<Produto>> getPrecoMenorQue(@PathVariable BigDecimal preco){ 
			return ResponseEntity.ok(produtoRepository.findByPrecoLessThanOrderByPrecoDesc(preco));
		}*/
		
	}
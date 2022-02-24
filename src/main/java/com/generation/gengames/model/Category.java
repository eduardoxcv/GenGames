package com.generation.gengames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Category {

	
	@Entity
	@Table(name = "tb_categorias") 
	public class Postagem {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long id; 
		
		@NotNull(message = "O modelo de console é obrigatório") 
		@Size(min = 10)
		private String tipoConsole;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipoConsole() {
			return tipoConsole;
		}

		public void setTipoConsole(String tipoConsole) {
			this.tipoConsole = tipoConsole;
		} 


		
	}
}

package com.generation.gengames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produtos") // esse é o nome da minha tabela
public class Produt {
		
		@Id // aqui vou conseguir o id dos produtos
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull (message = "Entrar com o nome do jogo") private String nome; // onde vai entrar o nome do jogo 
		
		@NotNull 
		@Size (min = 10,max = 1000)
		private String descricao; // descrição do jogo 
		
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		@NotNull(message = "Entre com o valor")
		private BigDecimal Valor; // valor do jogo 
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Category tipoConsole; // aqui eu vou buscar as infos do console na outra model (category)

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public BigDecimal getValor() {
			return Valor;
		}

		public void setValor(BigDecimal valor) {
			Valor = valor;
		}

		public Category getTipoConsole() {
			return tipoConsole;
		}

		public void setTipoConsole(Category tipoConsole) {
			this.tipoConsole = tipoConsole;
		}
		
		
	




}

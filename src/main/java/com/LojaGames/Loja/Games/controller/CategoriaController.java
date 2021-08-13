package com.LojaGames.Loja.Games.controller;

import java.util.List;
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
import com.LojaGames.Loja.Games.model.Categoria;
import com.LojaGames.Loja.Games.repository.CategoriaRepository;

@RestController
@RequestMapping("/loja")//Caminho URI
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>BuscarTodos(){//Traz todos da tabela
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>BuscarPorId(@PathVariable(value = "id")Long id){//Traz somente Id solicitado
		return ResponseEntity.status(200).body(repository.findById(id).get());	
	}
	@GetMapping("/descricao/{descricao}")//Irá buscar dentro da minha Categoria terror o game de terror que o usuario quer
	public ResponseEntity<List<Categoria>>BuscarPoDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@PostMapping("/criar")//Salvar dentro do meu banco de dados
	public ResponseEntity<Categoria>CriarCategoria(@RequestBody Categoria novacategoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novacategoria));
	}
	@PutMapping("/salvar")//Atualização
	public ResponseEntity<Categoria>SalvarCategoria(@RequestBody Categoria Categoria){//@RequestBody = pega pela body
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Categoria));
	}
	@DeleteMapping("/{id}")
	public void DeletarId(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
//
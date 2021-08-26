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
import com.LojaGames.Loja.Games.model.Produto;
import com.LojaGames.Loja.Games.repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>>BuscarTodos(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto>BuscarPorId(@PathVariable(value = "id")Long id){
		return ResponseEntity.status(200).body(repository.findById(id).get());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>>BuscarPorNome(@PathVariable String nome){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomeContainingIgnoreCase(nome));	
	}
	@PostMapping("/criar")
	public ResponseEntity<Produto>CriarProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping("/salvar")
	public ResponseEntity<Produto>SalvarProduto(@RequestBody Produto Produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Produto));
	}
	@DeleteMapping("/{id}")
	public void DeletarId(@PathVariable Long id) {
		repository.deleteById(id);
   }
}
//
package com.LojaGames.Loja.Games.repository;

import org.springframework.stereotype.Repository;
import com.LojaGames.Loja.Games.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

	public List<Categoria>findAllByDescricaoContainingIgnoreCase(String descricao);
}
//
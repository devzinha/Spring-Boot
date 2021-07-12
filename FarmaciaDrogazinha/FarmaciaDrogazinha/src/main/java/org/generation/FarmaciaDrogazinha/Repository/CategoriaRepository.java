package org.generation.FarmaciaDrogazinha.Repository;

import java.util.List;

import org.generation.FarmaciaDrogazinha.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
	
	public static List<Categoria> findAllByTipoContainingIgnoreCase (String tipo) {
		// TODO Auto-generated method stub
		return null;
	}


}

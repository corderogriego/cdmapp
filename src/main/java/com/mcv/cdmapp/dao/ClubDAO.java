package com.mcv.cdmapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcv.cdmapp.model.Club;

public interface ClubDAO extends JpaRepository<Club, Integer>{
	
	//SQL nativo
	@Query(value = "select c.nombre, sum(r.puntos) from corredor c join resultado r \n" + 
			"on c.id_corredor=r.id_corredor \n" + 
			"group by c.nombre\n" + 
			"having sum(r.puntos) = (select max(dd)\n" + 
			"from (select c.nombre,sum(r.puntos) dd from corredor c join resultado r \n" + 
			"on c.id_corredor=r.id_corredor group by c.nombre) ss);", nativeQuery = true)
	List<String> findClubNameByMaxPoints();
	
	//Nombre de métodos	
	List<Club> findByName(String name);
	
	Optional<Club> findById(Integer idClub);
	
}

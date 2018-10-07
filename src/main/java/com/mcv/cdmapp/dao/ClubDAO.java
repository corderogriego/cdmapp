package com.mcv.cdmapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Club;

@Repository
public interface ClubDAO extends JpaRepository<Club, Integer>{
	
//	//JPQL
//	@Query(value = "select c from Club c join Runner r "
//			+ "join Result re "
//			+ "where re.race = ?1 "
//			+ "order by re.seconds asc ")
	@Query(value = "select c.* from club c join runner r on c.id_club = r.club_id_club\n" + 
			"join result re on r.id_runner= re.id_runner \n" + 
			"where re.id_race = ?1 order by seconds limit ?2 "
			,nativeQuery = true )
	List<Club> findClubNameByMaxPoints(Integer idRace, Integer limit);
	
	//Nombre de métodos	
	Page<Club> findByNameContaining(String name, Pageable pageable);
	
	Optional<Club> findById(Integer idClub);
	
}

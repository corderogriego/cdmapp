package com.mcv.cdmapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcv.cdmapp.dto.DtoMaxPoints;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.model.Race;

public interface ClubDAO extends JpaRepository<Club, Integer>{
	
//	//JPQL
//	@Query(value = "select c.name, sum(re.points) from Club c join c.runners r join r.results re "
//			+ "group by c.name having sum(re.points) = "
//			+ "(select max(dd) from "
//			+ "(select c.name,sum(r.points) as dd from "
//			+ "Club c join c.runners r join r.results re)")
	

//	//SQL nativo
//	@Query(value = "select c.name, sum(r.points) from runner c join result r \n" + 
//			"on c.id_runner=r.id_runner \n" + 
//			"group by c.name\n" + 
//			"having sum(r.points) = (select max(dd)\n" + 
//			"from (select c.name,sum(r.points) dd from runner c join result r \n" + 
//			"on c.id_runner=r.id_runner group by c.name) ss);", nativeQuery = true)
//	//JPQL
//	@Query(value = "select new com.mcv.cdmapp.dto.DtoMaxPoints (c.name, sum(re.points)) "
//			+ "from Club c join c.runners r join r.results re "
//			+ "where re.race = ?1"
//			+ "group by c.name" )
	
//	select c.* from club c join runner r on c.id_club = r.club_id_club
//			join result re on r.id_runner= re.id_runner 
//			where re.id_race=5 order by seconds;
	
	
//	//JPQL
//	@Query(value = "select c from Club c join Runner r "
//			+ "join Result re "
//			+ "where re.race = ?1 "
//			+ "order by re.seconds asc ")
	@Query(value = "select c.* from club c join runner r on c.id_club = r.club_id_club\n" + 
			"join result re on r.id_runner= re.id_runner \n" + 
			"where re.id_race = ?1 order by seconds limit ?2 ",nativeQuery = true )
	List<Club> findClubNameByMaxPoints(Integer idRace, Integer limit);
	
	//Nombre de métodos	
	Page<Club> findByNameContaining(String name, Pageable pageable);
	
	Optional<Club> findById(Integer idClub);
	
}

package pruebatecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebatecnica.dto.Game;

public interface IGameDAO extends JpaRepository<Game,Integer>{

	public Game findByTitle(String title);
	
}

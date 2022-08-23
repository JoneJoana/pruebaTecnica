package pruebatecnica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebatecnica.dto.Game;
import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;

public interface IPartyDAO extends JpaRepository<Party,Integer>{
	
	public List<Party> findByGame(Game game);
	
	public Party findByName(String name);
	
	public List<Party> findByOwner(Player player);
	
}

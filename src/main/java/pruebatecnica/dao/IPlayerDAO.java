package pruebatecnica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebatecnica.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player,Integer>{

	public Player findByUsername(String username);
	
	public Player findByNickname(String nickname);
	
	//devuelve lista de players amigos de ese player 
	//public List<Player> getFriends(Player player);
	
	//public List<Party> getParties(Player player);	
	
}
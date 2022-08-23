package pruebatecnica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player,Integer>{

	public Player findByUsername(String username);
	
	public Player findByNickname(String nickname);
	
	//devuelve lista de players de los que ese player es amigo 
	public List<Player> findByFriendsWith(Player player);	
	
	public List<Player> findByParties(Party party);
	
}
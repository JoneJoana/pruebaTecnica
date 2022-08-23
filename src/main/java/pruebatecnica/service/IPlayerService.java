package pruebatecnica.service;

import java.util.List;

import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;


public interface IPlayerService {
	
	// Metodos del CRUD
	public List<Player> listPlayers(); 

	public Player savePlayer(Player player); 

	public Player findByID(int id); 

	public void deletePlayer(int id);
	
	public Player findByUsername(String username);
	
	public Player findByNickname(String nickname);
	
	//devuelve lista de players amigos de ese player 
	public List<Player> getFriends(Player player);
	
	public List<Party> getParties(Player player);

}

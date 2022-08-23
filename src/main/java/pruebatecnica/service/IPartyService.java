package pruebatecnica.service;

import java.util.List;

import pruebatecnica.dto.Game;
import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;

public interface IPartyService {
	
	// Metodos del CRUD
	public List<Party> listParties(); 

	public Party saveParty(Party party); 

	public Party findByID(int id); 
	
	public Party findByName(String name);

	public void deleteParty(int id);
	
	public List<Party> findByGame(Game game);	
	
	public List<Party> findByOwner(Player player);

}

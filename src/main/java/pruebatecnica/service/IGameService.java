package pruebatecnica.service;

import java.util.List;

import pruebatecnica.dto.Game;

public interface IGameService {
	
	// Metodos del CRUD
	public List<Game> listGames(); 

	public Game saveGame(Game game); 

	public Game findById(int id); 

	public void deleteGame(int id);
	
	public Game findByTitle(String title);
	
}

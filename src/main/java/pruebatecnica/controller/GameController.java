package pruebatecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pruebatecnica.dto.Game;
import pruebatecnica.service.IGameService;

@RestController
@RequestMapping("/api")
public class GameController {
	
	@Autowired
	private IGameService gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> getGames() {
		return gameServiceImpl.listGames();
	}
	
	@GetMapping("/games/{id}")
	public Game findById(@PathVariable(name = "id") int id) {
		return gameServiceImpl.findById(id);
	}
	
	@GetMapping("/games/title/{title}")
	public Game findByTitle(@PathVariable(name = "title") String title) {
		return gameServiceImpl.findByTitle(title);
	}
	
	@DeleteMapping("/games/{id}")
	public void deleteGame(@PathVariable(name = "id") int id) {
		gameServiceImpl.deleteGame(id);
	}

	@PostMapping("/games") // crear
	public String saveGame(@RequestBody Game game) {
		// validar datos que entran por body, que no se repita el nombre
		boolean exists = false;

		for (Game iterateGame : gameServiceImpl.listGames()) {
			if (iterateGame.getTitle().equals(game.getTitle())) {
				exists = true;
			}
		}
		if (!exists) {
			gameServiceImpl.saveGame(game);
			return "Juego guardado!";
		}
		return "El juego ya existe!";
	}

	@PutMapping("/games/{id}")
	public Game updateGame(@PathVariable(name = "id") int id, @RequestBody Game game) {
		Game gameSelected = gameServiceImpl.findById(id);

		gameSelected.setTitle(game.getTitle());

		return gameServiceImpl.saveGame(gameSelected);
	}
}

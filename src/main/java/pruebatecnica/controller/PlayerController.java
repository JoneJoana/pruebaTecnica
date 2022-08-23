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

import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;
import pruebatecnica.service.IPlayerService;

@RestController
@RequestMapping("/api")
public class PlayerController {
	
	@Autowired
	IPlayerService playerServiceImpl;
	
	@GetMapping("/player")
	public List<Player> listPlayers() {
		return playerServiceImpl.listPlayers();
	}
	
	@GetMapping("/player/{id}")
	public Player findById(@PathVariable(name = "id") int id) {
		return playerServiceImpl.findByID(id);
	}
	
	@DeleteMapping("/player/{id}")
	public void deletePlayer(@PathVariable(name = "id") int id) {
		playerServiceImpl.deletePlayer(id);
	}
	
	@GetMapping("/player/username/{username}")
	public Player findByUsername(@PathVariable(name = "username") String username) {
		return playerServiceImpl.findByUsername(username);
	}
	
	@GetMapping("/player/nickname/{nickname}")
	public Player findByNickname(@PathVariable(name = "nickname") String nickname) {
		return playerServiceImpl.findByNickname(nickname);
	}
	
	@GetMapping("/player/party/{party}")
	public List<Player> findByParty(@PathVariable(name = "party") Party party) {
		return playerServiceImpl.findByParties(party);
	}
	
//	@GetMapping("/player/friends/{id}")
//	public List<Player> getFriends(@PathVariable(name = "id") Player player) {
//		return playerServiceImpl.getFriends(player);
//	}
		
	@PostMapping("/player") // crear
	public String savePlayer(@RequestBody Player player) {
		// validar datos que entran por body, que no se repita el nombre
		boolean exists = false;

		for (Player iteratePlayer : playerServiceImpl.listPlayers()) {
			if (iteratePlayer.getNickname().equals(player.getNickname()) || iteratePlayer.getEmail().equals(player.getEmail())) {
				exists = true;
			}
		}
		if (!exists) {
			playerServiceImpl.savePlayer(player);
			return "Jugador guardado!";
		}
		return "El jugador ya existe!";
	}

	@PutMapping("/player/{id}")
	public Player updatePlayer(@PathVariable(name = "id") int id, @RequestBody Player player) {
		Player playerSelected = playerServiceImpl.findByID(id);

		//TODO ya que se tendria que hacer la misma comprobacion que en el post, 
		//se podria poner en la deficinicon de savePlayer() 
		playerSelected.setEmail(player.getEmail());
		playerSelected.setNickname(player.getNickname());

		return playerServiceImpl.savePlayer(playerSelected);
	}	

}

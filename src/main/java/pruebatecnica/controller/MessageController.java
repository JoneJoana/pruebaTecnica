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

import pruebatecnica.dto.Message;
import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;
import pruebatecnica.service.IMessageService;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	IMessageService messageServiceImpl;
	
	@GetMapping("/message")
	public List<Message> listMessages() {
		return messageServiceImpl.listMessages();
	}
	
	@GetMapping("/message/{id}")
	public Message findById(@PathVariable(name = "id") int id) {
		return messageServiceImpl.findById(id);
	}
	
	@GetMapping("/message/player/{idplayer}")
	public List<Message> findPlayerFrom(@PathVariable(name = "idplayer") int idPlayer) {
		return messageServiceImpl.findByPlayerFrom(idPlayer);
	}
	
	@GetMapping("/message/party/{party}")
	public List<Message> findfindByParty(@PathVariable(name = "party") Party party) {
		return messageServiceImpl.findByParty(party);
	}
	
	@DeleteMapping("/message/{id}")
	public void deleteMessage(@PathVariable(name = "id") int id) {
		messageServiceImpl.deleteMessage(id);
	}

	@PostMapping("/message") // crear
	public Message saveMessage(@RequestBody Message message) {		
		return messageServiceImpl.saveMessage(message);
	}

	@PutMapping("/message/{id}")
	public Message updateMessage(@PathVariable(name = "id") int id, @RequestBody Message message) {
		Message messageSelected = messageServiceImpl.findById(id);
		messageSelected.setMessage(message.getMessage());
		return messageServiceImpl.saveMessage(messageSelected);
	}

}

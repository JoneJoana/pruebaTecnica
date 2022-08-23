package pruebatecnica.service;

import java.util.List;

import pruebatecnica.dto.Message;
import pruebatecnica.dto.Player;

public interface IMessageService {
	
	// Metodos del CRUD
	public List<Message> listMessages(); 

	public Message saveMessage(Message message); 

	public Message findById(int id); 

	public void deleteMessage(int id);
	
	public List<Message> findByFrom(Player player); 
	
	//public List<Message> findByParty(Party party);

}

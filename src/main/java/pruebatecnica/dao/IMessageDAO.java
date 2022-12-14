package pruebatecnica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebatecnica.dto.Message;
import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;

public interface IMessageDAO extends JpaRepository<Message,Integer>{
	
	public List<Message> findPlayerFrom(Player player); 
	
	public List<Message> findByParty(Party party);
		
}

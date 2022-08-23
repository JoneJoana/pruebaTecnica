package pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebatecnica.dao.IMessageDAO;
import pruebatecnica.dto.Message;
import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;

@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	IMessageDAO iMessageDao;
	
	@Override
	public List<Message> listMessages() {
		return iMessageDao.findAll();
	}

	@Override
	public Message saveMessage(Message message) {
		return iMessageDao.save(message);
	}

	@Override
	public Message findById(int id) {
		return iMessageDao.findById(id).orElse(null);
	}

	@Override
	public void deleteMessage(int id) {
		iMessageDao.deleteById(id);
	}

	@Override
	public List<Message> findByPlayerFrom(Player player) {
		return iMessageDao.findByPlayerFrom(player);
	}

	@Override
	public List<Message> findByParty(Party party) {
		return iMessageDao.findByParty(party);
	}

}

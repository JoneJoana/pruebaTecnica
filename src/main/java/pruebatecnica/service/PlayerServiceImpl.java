package pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebatecnica.dao.IPlayerDAO;
import pruebatecnica.dto.Player;

@Service
public class PlayerServiceImpl implements IPlayerService{

	@Autowired
	IPlayerDAO iPlayerDao;
	
	@Override
	public List<Player> listPlayers() {
		return iPlayerDao.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		return iPlayerDao.save(player);
	}

	@Override
	public Player findByID(int id) {
		return iPlayerDao.findById(id).orElse(null);
	}

	@Override
	public void deletePlayer(int id) {
		iPlayerDao.deleteById(id);
	}

	@Override
	public Player findByUsername(String username) {
		return iPlayerDao.findByUsername(username);
	}

	@Override
	public Player findByNickname(String nickname) {
		return iPlayerDao.findByNickname(nickname);
	}

//	@Override
//	public List<Player> getFriends(Player player) {
//		return iPlayerDao.getFriends(player);
//	}

//	@Override
//	public List<Party> getParties(Player player) {
//		return iPlayerDao.getParties(player);
//	}

}

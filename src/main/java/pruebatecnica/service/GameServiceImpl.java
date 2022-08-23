package pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebatecnica.dao.IGameDAO;
import pruebatecnica.dto.Game;

@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameDAO iGameDao;
	
	@Override
	public List<Game> listGames() {
		return iGameDao.findAll();
	}

	@Override
	public Game saveGame(Game game) {
		return iGameDao.save(game);
	}

	@Override
	public Game findById(int id) {
		return iGameDao.findById(id).orElse(null);
	}

	@Override
	public void deleteGame(int id) {
		iGameDao.deleteById(id);
	}

	@Override
	public Game findByTitle(String title) {
		return iGameDao.findByTitle(title);
	}

}

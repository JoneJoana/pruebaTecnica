package pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebatecnica.dao.IPartyDAO;
import pruebatecnica.dto.Game;
import pruebatecnica.dto.Party;
import pruebatecnica.dto.Player;

@Service
public class PartyServiceImpl implements IPartyService{

	@Autowired
	IPartyDAO iPartyDao;
	
	@Override
	public List<Party> listParties() {
		return iPartyDao.findAll();
	}

	@Override
	public Party saveParty(Party party) {
		return iPartyDao.save(party);
	}

	@Override
	public Party findByID(int id) {
		return iPartyDao.findById(id).orElse(null);
	}

	@Override
	public Party findByName(String name) {
		return iPartyDao.findByName(name);
	}

	@Override
	public void deleteParty(int id) {
		iPartyDao.deleteById(id);
	}

	@Override
	public List<Party> findByGame(Game game) {
		return iPartyDao.findByGame(game);
	}

	@Override
	public List<Party> findByOwner(Player player) {
		return iPartyDao.findByOwner(player);
	}

}

package pruebatecnica.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="game")
public class Game {
	
	//id, title, list of parties
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "game")//la columna de party que hace ref a game
//	private List<Party> parties;

	//constructors
	public Game() {}
	
	public Game(int id, String title) {
		this.id = id;
		this.title = title;
	}

	//getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public List<Party> getParties() {
//		return parties;
//	}
//
//	public void setParties(List<Party> parties) {
//		this.parties = parties;
//	}
		
}

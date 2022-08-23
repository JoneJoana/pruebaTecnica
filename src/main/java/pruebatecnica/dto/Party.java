package pruebatecnica.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="party")
public class Party {
 
	//id, name, owner
	//findByGame(Game): List<Party>
	//tendra un owner i unos miembros (tabla intermedia en player)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
    @JoinColumn(name="owner")
	private Player owner;
	
	@ManyToOne
    @JoinColumn(name="game")
	private Game game;
	
	@JsonIgnore	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "party")
    private List<Message> messages;
	
	//creacion tabla intermedia entre player(members) i parties
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "member_parties", 
			joinColumns = { @JoinColumn(name = "party") },
			inverseJoinColumns = { @JoinColumn(name = "player") })
	private List<Player> players;
	
		
	//constructors
	public Party() {}
	
	public Party(int id, String name, Player owner, Game game) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.game = game;
	}

	//getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}	
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public List<Player> getMemberParties() {
		return players;
	}

	public void setMemberParties(List<Player> players) {
		this.players = players;
	}
	
}

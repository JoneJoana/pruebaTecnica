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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="player")
public class Player {
	
	//id,username,email,nickname
	
	//List<Player> friends;
	//List<Message> messages;
	
	//creacion tabla intermedia con party List<Party> parties;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String nickname;
	
//	//relacion recursiva?
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")//la columna de player que hace ref a (otro)player
//    private List<Player> friends;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerFrom")//la columna de message que hace ref a player
    private List<Message> messages;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")//la columna de party que hace ref a player owner
    private List<Party> ownedParties;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "players")//la columna de party que hace ref a player 
    private List<Party> parties;

	//Constructor
	public Player() {}
	
	public Player(int id, String username, String email, String nickname) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.nickname = nickname;
	}
	
	//Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

//	public List<Player> getFriends() {
//		return friends;
//	}
//
//	public void setFriends(List<Player> friends) {
//		this.friends = friends;
//	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Party> getOwnedParties() {
		return ownedParties;
	}

	public void setOwnedParties(List<Party> ownedParties) {
		this.ownedParties = ownedParties;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}
	
}

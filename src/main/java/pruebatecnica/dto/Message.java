package pruebatecnica.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class Message {
	
	//from de tipo Player,message,date
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne	
	@JoinColumn(name = "player")
	private Player from;
	
	private String message;	

	@Temporal(TemporalType.DATE)
	private Date dateSend;
	
	@ManyToOne	
	@JoinColumn(name = "party")
	private Party party;

	
	public Message() {}
	
	public Message(int id, Player from, String message, Date dateSend) {
		this.id = id;
		this.from = from;
		this.message = message;
		this.dateSend = dateSend;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getFrom() {
		return from;
	}

	public void setFrom(Player from) {
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateSend() {
		return dateSend;
	}

	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}
	
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	
}

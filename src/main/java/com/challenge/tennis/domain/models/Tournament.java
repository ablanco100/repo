package com.challenge.tennis.domain.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Tournament {
    @Id
	private String id;
    private String name;
    private String type;
    private int numberOfPlayers;
    private Date date;
    private String winner;

    public Tournament() {
    }
    
    public Tournament(String id, String name, String type, int numberOfPlayers, Date date, String winner) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.numberOfPlayers = numberOfPlayers;
		this.date = date;
		this.winner = winner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}

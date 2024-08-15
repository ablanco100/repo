package com.challenge.tennis.domain.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Player {
    @Id
	private String id;
    private String name;
    private int ranking;
    private String branch;
    private List<Attribute> attributes;

    public Player() {
    }
    
    public Player(String id, String name, int ranking, String branch, List<Attribute> attributes) {
		super();
		this.id = id;
		this.name = name;
		this.ranking = ranking;
		this.branch = branch;
		this.attributes = attributes;
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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}

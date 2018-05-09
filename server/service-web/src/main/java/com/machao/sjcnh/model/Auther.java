package com.machao.sjcnh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="t_auther")
public class Auther {

	@GeneratedValue
	@Id
	private int id;

	@Column(nullable=false)
	private Type type;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=true)
	private String shortDescription;
	
	public enum Type {
		Poetry, Lyrics
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public String toString() {
		return "Auther [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description
				+ ", shortDescription=" + shortDescription + "]";
	}
}

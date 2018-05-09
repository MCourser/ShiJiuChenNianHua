package com.machao.sjcnh.model;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_lyrics")
public class Lyrics {
	private static final String separator = "---";

	@GeneratedValue
	@Id
	private int id;

	@Column(nullable=false)
	private String rhythmic;

	@Column(nullable=false)
	private String paragraphs;
	
	@JoinColumn(name="auther_id", referencedColumnName="id", nullable=false)
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Auther auther;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRhythmic() {
		return rhythmic;
	}

	public void setRhythmic(String rhythmic) {
		this.rhythmic = rhythmic;
	}

	public String[] getParagraphs() {
		return paragraphs.split(separator);
	}

	public void setParagraphs(String[] paragraphs) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<paragraphs.length; i++) {
			sb.append(paragraphs[i]).append(separator);
		}
		this.paragraphs = sb.toString();
	}

	public Auther getAuther() {
		return auther;
	}

	public void setAuther(Auther auther) {
		this.auther = auther;
	}

	@Override
	public String toString() {
		return "Lyrics [id=" + id + ", rhythmic=" + rhythmic + ", auther=" + auther + ", getParagraphs()="
				+ Arrays.toString(getParagraphs()) + "]";
	}
}

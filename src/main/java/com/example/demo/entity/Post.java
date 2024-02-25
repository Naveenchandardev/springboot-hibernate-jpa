package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //to make this class as jpa entity
@Table(name ="posts")
public class Post {
	@Id //to make id is a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="description")
	private String description;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pc_fip", referencedColumnName="id")
	List<Comment> comment = new ArrayList<>();
	
	public Post() {
		
	}
	
	public Post(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

}

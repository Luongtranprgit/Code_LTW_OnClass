package com.example.bookory.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="slug")
	private String slug;
	@Column(name="description")
	private String description;
	@Column(name="author")
	private String author;
	@Column(name="category")
	private String category;
	@Column(name="release")
	private String release;
	@Column(name="pages")
	private int pages;
	@Column(name="price")
	private float price;
	@Column(name="stars")
	private float stars;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public int getPages() {
		return pages;
	}
	public float getPrice() {
		return price;
	}
	public String getSlug() {
		return slug;
	}
	public float getStars() {
		return stars;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public String getTitle() {
		return title;
	}
	public String getRelease() {
		return release;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public void setStars(float stars) {
		this.stars = stars;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

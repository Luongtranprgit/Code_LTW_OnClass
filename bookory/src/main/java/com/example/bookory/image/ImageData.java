package com.example.bookory.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BOOKCOVER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	@Column(name="ftype")
	private String ftype;
	@Column(name="fname")
	private String fname;
	@Column(name="filepath")
	private String filepath;
	@Column(name="slug")
	private String slug;
	public ImageData() {
		// TODO Auto-generated constructor stub
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getId() {
		return id;
	}
	
	public String getFilepath() {
		return filepath;
	}
	public String getFname() {
		return fname;
	}
	public String getFtype() {
		return ftype;
	}
	public String getSlug() {
		return slug;
	}
}

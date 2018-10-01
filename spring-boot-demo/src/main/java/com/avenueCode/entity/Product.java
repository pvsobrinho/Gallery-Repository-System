package com.avenueCode.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="product")
public class Product implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
    private int id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Product childProduct;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="picture_id")
	private Picture picture;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Product getChildProduct() {
		return childProduct;
	}
	public void setChildProduct(Product childProduct) {
		this.childProduct = childProduct;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public int getProductId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
} 
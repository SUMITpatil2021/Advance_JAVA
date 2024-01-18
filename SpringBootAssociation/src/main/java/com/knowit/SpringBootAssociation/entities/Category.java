package com.knowit.SpringBootAssociation.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="category")
@NoArgsConstructor

@Getter
@Setter
@ToString
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int c_id;
	
	@Column
	String c_name;
	
	@Column
	String c_description;
	
	@JsonIgnoreProperties("category")
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	Set<Product>products; 
	
	
	
	public void setProducts(Set<Product>products)
	{
		for(Product p:products)
			p.setCategory(this);
		this.products=products;
	}



	public Category(String c_name, String c_description, Set<Product> products) {
		super();
		this.c_name = c_name;
		this.c_description = c_description;
		for(Product p :products)
			p.setCategory(this);
		this.products = products;
	}
}

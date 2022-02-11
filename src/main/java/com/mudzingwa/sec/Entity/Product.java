package com.mudzingwa.sec.Entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private Integer pid;
	@Column(name="pname")
	private String pname;
	@Column(name="brand")
	private String brand;
	@ElementCollection
	@CollectionTable(name="color",joinColumns =@JoinColumn(name="pid"))
	@Column(name="color")
	private List<String>color;

}

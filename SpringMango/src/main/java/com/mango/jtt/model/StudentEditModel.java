package com.mango.jtt.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.mango.jtt.system.entity.Messager;

public class StudentEditModel extends Messager {

	@NotNull
	@NotBlank
	private Integer id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String address;
	private String friendName;

	private Integer weight;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	
}

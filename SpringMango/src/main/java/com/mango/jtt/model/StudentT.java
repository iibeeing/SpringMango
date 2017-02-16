package com.mango.jtt.model;

public class StudentT {
	private Integer id;

	private String name;

	private Integer classno;

	private Integer gradeno;

	private String address;

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
		this.name = name == null ? null : name.trim();
	}

	public Integer getClassno() {
		return classno;
	}

	public void setClassno(Integer classno) {
		this.classno = classno;
	}

	public Integer getGradeno() {
		return gradeno;
	}

	public void setGradeno(Integer gradeno) {
		this.gradeno = gradeno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	@Override
	public String toString() {
		return String
				.format("StudentT [id=%s, name=%s, classno=%s, gradeno=%s, address=%s]",
						id, name, classno, gradeno, address);
	}

}
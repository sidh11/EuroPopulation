package com.Ep.bean;

public class EP {
	private int id;
	private String Cname;
	private float Cpopulation;

	public EP(int id, String cname, float cpopulation) {
		super();
		this.id = id;
		Cname = cname;
		Cpopulation = cpopulation;
	}

	public EP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public float getCpopulation() {
		return Cpopulation;
	}

	public void setCpopulation(float f) {
		Cpopulation = f;
	}

	@Override
	public String toString() {
		return "EP [id=" + id + ", Cname=" + Cname + ", Cpopulation=" + Cpopulation + "]";
	}
	

}
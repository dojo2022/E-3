package model;

import java.io.Serializable;

public class Variable implements Serializable{
	private String v_date;
	private String v_category;
	private String v_memo;
	private int v_cost;
	/**
	 * @param v_date
	 * @param v_category
	 * @param v_memo
	 * @param v_cost
	 */
	public Variable(String v_date, String v_category, String v_memo, int v_cost) {
		super();
		this.v_date = v_date;
		this.v_category = v_category;
		this.v_memo = v_memo;
		this.v_cost = v_cost;
	}

	public Variable() {
		super();
		this.v_date = "";
		this.v_category = "";
		this.v_memo = "";
		this.v_cost = 0;
	}

	public String getV_date() {
		return v_date;
	}

	public void setV_date(String v_date) {
		this.v_date = v_date;
	}

	public String getV_category() {
		return v_category;
	}

	public void setV_category(String v_category) {
		this.v_category = v_category;
	}

	public String getV_memo() {
		return v_memo;
	}

	public void setV_memo(String v_memo) {
		this.v_memo = v_memo;
	}

	public int getV_cost() {
		return v_cost;
	}

	public void setV_cost(int v_cost) {
		this.v_cost = v_cost;
	}



}

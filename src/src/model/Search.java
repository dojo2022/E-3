package model;

import java.io.Serializable;

public class Search implements Serializable {
	private String h_date;
	private int user_id;

	/**
	 * @param h_date
	 */
	public Search(String h_date, int user_id) {
		super();
		this.h_date = h_date;
		this.user_id = user_id;
	}

	public Search() {
		super();
		this.h_date = "";
		this.user_id = 0;
	}

	public String getH_date() {
		return h_date;
	}

	public void setH_date(String h_date) {
		this.h_date = h_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



}

package model;

import java.io.Serializable;

public class Search implements Serializable {
	private String h_date;

	/**
	 * @param h_date
	 */
	public Search(String h_date) {
		super();
		this.h_date = h_date;
	}

	public Search() {
		super();
		this.h_date = "";
	}

	public String getH_date() {
		return h_date;
	}

	public void setH_date(String h_date) {
		this.h_date = h_date;
	}



}

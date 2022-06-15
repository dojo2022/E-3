package model;
import java.io.Serializable;

public class Fixed implements Serializable {
	private int f_id;
	private String f_date;
	private String f_category;
	private String f_memo;
	private int f_cost;
	/**
	 * @param f_date
	 * @param f_category
	 * @param f_memo
	 * @param f_cost
	 */
	public Fixed(int f_id, String f_date, String f_category, String f_memo, int f_cost) {
		this.f_id = f_id;
		this.f_date = f_date;
		this.f_category = f_category;
		this.f_memo = f_memo;
		this.f_cost = f_cost;
	}

	public Fixed() {
		this.f_id = 0;
		this.f_date = "";
		this.f_category = "";
		this.f_memo = "";
		this.f_cost = 0;
	}

	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_date() {
		return f_date;
	}

	public void setF_date(String f_date) {
		this.f_date = f_date;
	}

	public String getF_category() {
		return f_category;
	}

	public void setF_category(String f_category) {
		this.f_category = f_category;
	}

	public String getF_memo() {
		return f_memo;
	}

	public void setF_memo(String f_memo) {
		this.f_memo = f_memo;
	}

	public int getF_cost() {
		return f_cost;
	}

	public void setF_cost(int f_cost) {
		this.f_cost = f_cost;
	}


}

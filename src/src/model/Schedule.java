package model;
import java.io.Serializable;

public class Schedule implements Serializable{
	private String s_date;
	private String s_category;
	private String s_memo;
	/**
	 * @param s_date
	 * @param s_category
	 * @param s_memo
*/
	public Schedule(String s_date, String s_category, String s_memo) {
		super();
		this.s_date = s_date;
		this.s_category = s_category;
		this.s_memo = s_memo;
	}
	public Schedule() {
		super();
		this.s_date = "";
		this.s_category = "";
		this.s_memo = "";
	}
	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}

	public String getS_memo() {
		return s_memo;
	}

	public void setS_memo(String s_memo) {
		this.s_memo = s_memo;
	}
}

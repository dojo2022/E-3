package model;
import java.io.Serializable;

public class Result implements Serializable {
	private String title;		// タイトル
//	private String message;	// メッセージ
	private String backTo;		// 戻り先
	private String backToWhere; //どこに戻るか
	private String back;		//戻り先2
	private String backWhere; //どこに戻るか2

	public Result() {
		this(null, null, null, null, null);
	}

	public Result(String title, String backTo, String backToWhere, String back, String backWhere) {
		this.title = title;
		this.backTo = backTo;
		this.backToWhere = backToWhere;
		this.back = back;
		this.backWhere = backWhere;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	*/

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}


	public String getBackToWhere() {
		return backToWhere;
	}

	public void setBackToWhere(String backToWhere) {
		this.backToWhere = backToWhere;
	}


	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.backTo = back;
	}


	public String getBackWhere() {
		return backWhere;
	}

	public void setBackWhere(String backWhere) {
		this.backWhere = backWhere;
	}
}

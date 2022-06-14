package model;

public class Users {
	private String user_id;
	private String reason;
	private int goal;
	private String deadline;
	private int salary;
	private String constitution;

	public Users(String user_id, String reason, int goal, String deadline, int salary, String constitution) {
		super();
		this.user_id = user_id;
		this.reason = reason;
		this.goal = goal;
		this.deadline = deadline;
		this.salary = salary;
		this.constitution = constitution;
	}


	public Users() {
		super();
		this.user_id = "";
		this.reason = "";
		this.goal = 0;
		this.deadline = "";
		this.salary = 0;
		this.constitution = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getConstitution() {
		return constitution;
	}

	public void setConstitution(String constitution) {
		this.constitution = constitution;
	}


}

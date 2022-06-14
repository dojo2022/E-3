package model;

public class Users {
	private String reason;
	private String goal;
	private String deadline;
	private String salary;
	private String constitution;

	public Users(String reason, String goal, String deadline, String salary, String constitution) {
		super();
		this.reason = reason;
		this.goal = goal;
		this.deadline = deadline;
		this.salary = salary;
		this.constitution = constitution;
	}

	public Users() {
		super();
		this.reason = "";
		this.goal = "";
		this.deadline = "";
		this.salary = "";
		this.constitution = "";
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getConstitution() {
		return constitution;
	}

	public void setConstitution(String constitution) {
		this.constitution = constitution;
	}


}

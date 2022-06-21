package model;

public class User {
	private int user_id;
	private String login_id;
	private String password;
	private String reason;
	private int goal;
	private String deadline;
	private int savings;
	private int salary;
	private String constitution;


	//ログインコンストラクタ
	public User(String login_id, String password) {
		super();
		this.login_id = login_id;
		this.password = password;
	}


	//ユーザ新規登録コンストラクタ
	public User(String login_id, String password, String constitution) {
		super();
		this.login_id = login_id;
		this.password = password;
		this.constitution = constitution;
	}

	//ユーザ更新コンストラクタ
	public User(String reason,  String deadline,int goal, int salary, String constitution) {
		super();
		this.reason = reason;
		this.deadline = deadline;
		this.goal = goal;
		this.salary = salary;
		this.constitution = constitution;
	}

	public User(int user_id, String login_id, String password, String reason, int goal, String deadline, int savings,
			int salary,String constitution) {
		super();
		this.user_id = user_id;
		this.login_id = login_id;
		this.password = password;
		this.reason = reason;
		this.goal = goal;
		this.deadline = deadline;
		this.savings = savings;
		this.salary = salary;
		this.constitution = constitution;
	}


	public User() {
		super();
		this.user_id = 0;
		this.login_id = "";
		this.password = "";
		this.reason = "";
		this.goal = 0;
		this.deadline = "";
		this.savings = 0;
		this.salary = 0;
		this.constitution = "";
	}

	//user_id
	public int getUser_id() {
		return user_id;
	}

	public int setUser_id(int i) {
		return this.user_id = i;
	}

	//login_id
	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	//password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
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

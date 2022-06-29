package test;

import java.util.Date;

import dao.UserDao;
import model.User;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao uDao = new UserDao();

		if (uDao.isLoginOK(new User("dojo", "password"))) {
			System.out.println("ログイン成功");
		} else {
			System.out.println("ログイン失敗");
		}

		User user = uDao.display(1);
		System.out.println(user.getUser_id());
		System.out.println(user.getReason());
		System.out.println(user.getGoal());
		System.out.println(user.getDeadline());
		System.out.println(user.getSalary());
		System.out.println(user.getConstitution());

		Date deadline =  uDao.deadline(1);
		System.out.println(deadline);

		String cons = uDao.constitution(1);
		System.out.println(cons);

		User uIns = new User("plusdojo","password2","暑がり");
		if (uDao.insert(uIns)) {
			System.out.println("登録成功");
			User user2 = uDao.display(2);
			System.out.println(user2.getUser_id());
			System.out.println(user2.getReason());
			System.out.println(user2.getGoal());
			System.out.println(user2.getDeadline());
			System.out.println(user2.getSalary());
			System.out.println(user2.getConstitution());
		} else {
			System.out.println("登録失敗");
		}

		User uUp = new User("貯金","2022-07-28",10000,100000,"寒がり");
		if (uDao.update(uUp, 1)) {
			System.out.println("更新成功");
			User user3 = uDao.display(2);
			System.out.println(user3.getUser_id());
			System.out.println(user3.getReason());
			System.out.println(user3.getGoal());
			System.out.println(user3.getDeadline());
			System.out.println(user3.getSalary());
			System.out.println(user3.getConstitution());
		} else {
			System.out.println("更新失敗");
		}

		int user_id = uDao.id("plusdojo", "password2");
		System.out.println(user_id);


	}

}

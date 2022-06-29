package test;

import java.util.List;

import dao.VariableDao;
import model.Variable;

public class VariableDaoTest {

	public static void main(String[] args) {
		VariableDao vDao = new VariableDao();

		List<Variable> variableList = vDao.variable(new Variable(0, "2022-06-27", "", "", 0, 1));
		for (Variable variable : variableList) {
			System.out.println(variable.getV_id());
			System.out.println(variable.getV_date());
			System.out.println(variable.getV_category());
			System.out.println(variable.getV_memo());
		}

		Variable vIns = new Variable(0, "2022-06-27", "食費", "", 1000, 1);
		if (vDao.insert(vIns)) {
			System.out.println("登録成功");
			List<Variable> variableList2 = vDao.variable(vIns);
			for (Variable variable : variableList2) {
				System.out.println(variable.getV_id());
				System.out.println(variable.getV_date());
				System.out.println(variable.getV_category());
				System.out.println(variable.getV_memo());
			}
		} else {
			System.out.println("登録失敗");
		}

		Variable vUp = new Variable(0, "2022-06-30", "食費", "", 1, 1);
		if (vDao.update(vUp)) {
			System.out.println("登録成功");
			List<Variable> variableList2 = vDao.variable(vUp);
			for (Variable variable : variableList2) {
				System.out.println(variable.getV_id());
				System.out.println(variable.getV_date());
				System.out.println(variable.getV_category());
				System.out.println(variable.getV_memo());
			}
		}

		if (vDao.delete(0)) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
		}

	}

}

package test;

import java.util.List;

import dao.FixedDao;
import model.Fixed;

public class FixedDaoTest {
	public static void main(String[] args) {
		FixedDao fDao = new FixedDao();

		List<Fixed> fixedList = fDao.fixed(new Fixed(0, "2022-06-28", "", "", 0, 1));
		for (Fixed fixed : fixedList) {
			System.out.println(fixed.getF_id());
			System.out.println(fixed.getF_date());
			System.out.println(fixed.getF_category());
			System.out.println(fixed.getF_memo());
			System.out.println(fixed.getF_cost());
			System.out.println(fixed.getUser_id());
		}

		List<Fixed> fixedList2 = fDao.select(new Fixed(0, "2022-06-28", "", "", 0, 1));
		for (Fixed fixed : fixedList2) {
			System.out.println(fixed.getF_id());
			System.out.println(fixed.getF_date());
			System.out.println(fixed.getF_category());
			System.out.println(fixed.getF_memo());
			System.out.println(fixed.getF_cost());
			System.out.println(fixed.getUser_id());
		}

		Fixed Ins = new Fixed(0, "2022-06-28", "家賃", "a", 0, 1);
		if (fDao.insert(Ins)) {
			System.out.println("登録成功");
			List<Fixed> fixedList3 = fDao.select(new Fixed(0, "2022-06-28", "", "", 0, 1));
			for (Fixed fixed : fixedList3) {
				System.out.println(fixed.getF_id());
				System.out.println(fixed.getF_date());
				System.out.println(fixed.getF_category());
				System.out.println(fixed.getF_memo());
				System.out.println(fixed.getF_cost());
				System.out.println(fixed.getUser_id());
			}
		} else {
			System.out.println("登録失敗");
		}

		Fixed fIns = new Fixed(0, "2022-06-30", "家賃", "a", 0, 1);
		if (fDao.f_insert(fIns)) {
			System.out.println("登録成功");
			List<Fixed> fixedList4 = fDao.select(new Fixed(0, "2022-06-30", "", "", 0, 1));
			for (Fixed fixed : fixedList4) {
				System.out.println(fixed.getF_id());
				System.out.println(fixed.getF_date());
				System.out.println(fixed.getF_category());
				System.out.println(fixed.getF_memo());
				System.out.println(fixed.getF_cost());
				System.out.println(fixed.getUser_id());
			}
		} else {
			System.out.println("登録失敗");
		}

		Fixed fUp = new Fixed(1,"2022-06-29","家賃","b",100,1);
		if (fDao.update(fUp)) {
			System.out.println("更新成功");
			List<Fixed> fixedList5 = fDao.select(new Fixed(0, "2022-06-29", "", "", 0, 1));
			for (Fixed fixed : fixedList5) {
				System.out.println(fixed.getF_id());
				System.out.println(fixed.getF_date());
				System.out.println(fixed.getF_category());
				System.out.println(fixed.getF_memo());
				System.out.println(fixed.getF_cost());
				System.out.println(fixed.getUser_id());
			}
		}

		if (fDao.delete(0)) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
		}

	}

}

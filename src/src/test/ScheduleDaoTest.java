package test;

import java.util.List;

import dao.ScheduleDao;
import model.Schedule;

public class ScheduleDaoTest {
	public static void main(String[] args) {
		ScheduleDao sDao = new ScheduleDao();

		List<Schedule> scheduleList = sDao.display(new Schedule(0,"","","",1));
		for (Schedule schedule : scheduleList) {
			System.out.println(schedule.getS_id());
			System.out.println(schedule.getS_date());
			System.out.println(schedule.getS_category());
			System.out.println(schedule.getS_memo());
		}

		List<Schedule> scheduleList2 = sDao.display5(1);
		for (Schedule schedule : scheduleList2) {
			System.out.println(schedule.getS_id());
			System.out.println(schedule.getS_date());
			System.out.println(schedule.getS_category());
			System.out.println(schedule.getS_memo());
		}

		List<Schedule> scheduleList3 = sDao.select(new Schedule(0, "2022-06-27", "", "", 1));
		for (Schedule schedule : scheduleList3) {
			System.out.println(schedule.getS_id());
			System.out.println(schedule.getS_date());
			System.out.println(schedule.getS_category());
			System.out.println(schedule.getS_memo());
		}

		Schedule sIns = new Schedule(0,"2022-06-27","遊び","a",1);
		if (sDao.insert(sIns)) {
			System.out.println("登録成功");
			List<Schedule> scheduleList4 = sDao.select(sIns);
			for (Schedule schedule : scheduleList4) {
				System.out.println(schedule.getS_id());
				System.out.println(schedule.getS_date());
				System.out.println(schedule.getS_category());
				System.out.println(schedule.getS_memo());
			}
		} else {
			System.out.println("登録失敗");
		}

		Schedule sUp = new Schedule(8,"2022-06-30","デート","b",1);
		if (sDao.update(sUp)) {
			System.out.println("登録成功");
			List<Schedule> scheduleList5 = sDao.select(sUp);
			for (Schedule schedule : scheduleList5) {
				System.out.println(schedule.getS_id());
				System.out.println(schedule.getS_date());
				System.out.println(schedule.getS_category());
				System.out.println(schedule.getS_memo());
			}
		}

		if (sDao.delete(8)) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
		}

	}

}

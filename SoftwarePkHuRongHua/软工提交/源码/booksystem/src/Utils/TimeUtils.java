package Utils;

import java.sql.Time;
import java.sql.Timestamp;

import org.uml.hotelsystem.dao.TbReserve;

public class TimeUtils {
	public static Timestamp getCurTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 判断两个预约是否冲突
	 * 
	 * @param reserve1
	 * @param reserve2
	 * @return
	 */
	public static boolean judgeTwoReserveIsConflict(TbReserve reserve1,
			TbReserve reserve2) {
		if (reserve1.getReserveStartTime().before(
				reserve2.getReserveStartTime())
				&& reserve1.getReserveEndTime().before(
						reserve2.getReserveStartTime())) {
			return false;
		} else if (reserve1.getReserveStartTime().after(
				reserve2.getReserveEndTime())
				&& reserve1.getReserveEndTime().after(
						reserve2.getReserveEndTime())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断两个时间段是否冲突
	 * 
	 * @param reserve1
	 * @param reserve2
	 * @return
	 */
	public static boolean judgeTwoTimeIsConflict(Timestamp time1Start,
			Timestamp time1End, Timestamp time2Start, Timestamp time2End) {
		if (time1Start.before(time2Start) && time1End.before(time2Start)) {
			return false;
		} else if (time1Start.after(time2End) && time1End.after(time2End)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 获取两个时间戳之间间隔的天数 注意：返回值会被取绝对值 ，starttime应当位于endtime之前
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDaysByTwoTimestamp(Timestamp startTime,
			Timestamp endTime) {
		long ms = Math.abs(endTime.getTime() - startTime.getTime());
		int res = (int) (ms / (3600 * 24 * 1000));
		return res;
	}

	public static String getStrByTwoTime(Timestamp startTime, Timestamp endTime) {
		String res = null;
		long millsec = endTime.getTime() - startTime.getTime();
		int minutes = (int) (millsec / (1000 * 60));
		int hour = minutes / 60;
		int minute = minutes % 60;
		return hour + "小时" + minute + "分钟";
	}

	public static float getLiveInTimeByMills(long mills) {
		float days = Math.abs(mills / (1000 * 60 * 60 * 24));
		int day = (int) (days + 1f);
		float result = (float)day - 0.5f;
		return result;
	}
	
}

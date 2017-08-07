package practice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by Edward Hyunwoo Shin. 
 * Description: Calculate time difference between local time and random time. Converts HH:mm:ss format to second then calculate.
 * 
 */

public class CompareTime {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Random random = new Random();
		String randomTime = LocalTime.of(random.nextInt(23), random.nextInt(59), random.nextInt(59)).format(formatter);
		String curTime = LocalTime.now().format(formatter);

		System.out.println("curTime : " + curTime);
		System.out.println("random Time : " + randomTime);

		int time1Sec = 0;
		int curTimeSec = 0;
		int diff = 0;

		time1Sec = ConvertToSeconds(randomTime);
		curTimeSec = ConvertToSeconds(curTime);

		if (time1Sec > curTimeSec) {
			diff = time1Sec - curTimeSec;
		} else {
			diff = curTimeSec - time1Sec;
		}

		ConvertToTime(diff);

	}

	public static int ConvertToSeconds(String time) {

		int sec = 0;
		int hourToSec = 0;
		int minuteToSec = 0;

		hourToSec = Integer.parseInt(time.substring(0, 2)) * 3600;
		minuteToSec = Integer.parseInt(time.substring(3, 5)) * 60;
		sec = Integer.parseInt(time.substring(6, 8));
		sec = hourToSec + minuteToSec + sec;

		return sec;
	}

	public static void ConvertToTime(int diff) {

		int hour = 0;
		int minute = 0;
		int sec;

		hour = diff / 3600;
		minute = (diff % 3600) / 60;
		sec = (diff % 3600) % 60;

		System.out.println("Time Difference : " + hour + ":" + minute + ":" + sec);
	}
}

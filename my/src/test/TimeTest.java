package test;

public class TimeTest {

	public static String getSeqence(int i) {

		int hour = i / 3600;
		int minute = (i - hour * 3600) / 60;
		int second = i - hour * 3600 - minute * 60;

		String mStr = minute < 10 ? "0" + minute : String.valueOf(minute);
		String sStr = second < 10 ? "0" + second : String.valueOf(second);

		return mStr + sStr;

		/*
		 * String ret = String.valueOf(i); for (int j = 0; j < length -
		 * String.valueOf(i).length(); j++) ret = "0".concat(ret); return ret;
		 */
	}

	public static void main(String[] args) {

		System.out.println(getSeqence(1000));

		System.out.println(getSeqence(200));

		System.out.println(getSeqence(100));
		System.out.println(getSeqence(120));
		System.out.println(getSeqence(121));
		System.out.println(getSeqence(61));
		System.out.println(getSeqence(60));
		System.out.println(getSeqence(59));
		System.out.println(getSeqence(58));
		System.out.println(getSeqence(50));
		System.out.println(getSeqence(0));
		System.out.println(getSeqence(1));
		System.out.println(getSeqence(2));
		System.out.println(getSeqence(3));
		System.out.println(getSeqence(4));

	}

}

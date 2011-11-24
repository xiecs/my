package test;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//R_业务类型编码_Sub_I/A_YYYYMMDD_xxxx_xx.dat
		//YYYYMMDD_xxxx_xx
		
		
		String dName = "C_220012_Sub_A_20111010_0002_00.dat";

		System.out.println(dName.substring(dName.length() - 20, dName.length() - 12));
		
		System.out.println(dName.substring(dName.length() - 11, dName.length() - 4));

		
	}

}

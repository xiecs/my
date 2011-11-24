package com.dust.demo;

public class ShortTest {

	public static void main(String[] args) {

		// 长度类型
		// int
		// 4B
		// -2147483648~2147483647
		//
		// short
		// 2B
		// -32768~32767
		//
		// long
		// 8B
		// -9 233 372 036 854 755 808~9 223 372 036 854 775 807
		//
		// byte
		// 1B
		// -128~-127

		// 会报错，因为int型不能和short进行运算，因为可能溢出
		// short s1 = 1;
		// s1 = s1 + 1;

		// s1 +=a(a为任意数字)的定义为s1=((T)(s1+a)),T为s1的类型，它能进行自动隐式转换

		// Integer i=11112222;
		// System.out.println(Short.valueOf(i.toString()));

		// 自动转型，怎么个转法？int怎么转short？
		short s2 = 1;
		s2 += 11112222;
		System.out.println(s2);

		short s3 = (short) (1 + 11112222);
		System.out.println(s3);

		char c = '转';
		int i = c;
		System.out.println("output:" + i);
		
		
		//16进制转10进制
		int x1=0x2f;
		//00011111
		//2*16的1次方+f的0次方，32+15
		
		//10进制转16进制，10进制转成2进制，每4位2进制转成1位16进制
		
		System.out.println(x1);
		
		
		String s="%3C%3Fxml+version%3D%221.0%22+encoding%3D%22GBK%22%3F%3E%0A%3CMESSAGE%3E%3CHEAD%3E%3CCODE%3E%3C%2FCODE%3E%3CBPID%3E1001%3C%2FBPID%3E%3CSID%3E677311340701%3C%2FSID%3E%3CTIMESTAMP%3E201104131134070820%3C%2FTIMESTAMP%3E%3C%2FHEAD%3E%3CBODY%3E9c6edf29f09151c6617a987646901658456a7ae1e6d233668d0716dcbc138776bd0f42ed9acbce34291ef663b47bd46f49850abf36e3f68265126a7c9d09bcd19ca373ad6ea7652f72503d3d99c502c28ad5815f45bb01fa7d9c8dc7144cff0c7263355de50423eed881999ce7fdc9565f6a7d528e394f395390318747c609ff2fcb63b55b8f5025b82a49622c25c142cb895a411f117cffde76c0589dbd66b50c4457f6ac7b8995af1a117e48bddce880eb59bd8407b4926d8bc1e5800b148a18d484c295da03663936692ac1537888ac4dba80b46e6b99%3C%2FBODY%3E%3C%2FMESSAGE%3E";

		
		System.out.println(Integer.getInteger("0"));
	}

}

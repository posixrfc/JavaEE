package cn.ntv;
import java.io.*;
import sun.misc.BASE64Encoder;
public class BS64 {
	public static void main(String[] args) throws IOException {
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.print("please input user name");
		String un = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println(encoder.encode(un.getBytes()));
		System.out.print("please input password");
		String pw = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println(encoder.encode(pw.getBytes()));
	}
}
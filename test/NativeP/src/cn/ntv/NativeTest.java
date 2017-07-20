package cn.ntv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class NativeTest {
	public native void sayHello();
	public static native void outputDate();
	public Parent p = new Child();
	public int number = 9;
	double max(double n1, double n2) {
		return n1 > n2 ? n1 : n2;
	}
	public final String message = "abc";
	public native void callCppFunction();
	final int arr[] = new int[]{1, 4, 6, 8, 5, 3, 1, 9};
	public native void callCppFunction1();
	public static void main(String[] args) throws IOException {
		System.loadLibrary("NativeCode");
		NativeTest tst = new NativeTest();
		tst.callCppFunction1();
		for (int i : tst.arr)
			System.out.print(i);
	}
}
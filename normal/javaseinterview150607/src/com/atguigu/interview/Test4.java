package com.atguigu.interview;
//创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
//Math.random() 返回值范围是:[0,1)的double型值
//  (int)(Math.random() * 30  + 1 )            [1,31)  [1,30]
//通式：[a,b]     (int)( Math.random() * (b - a + 1) + a) 
public class Test4 {
	public static void main(String[] args) {
		
		int[] arr = new int[6];
		for(int i = 0;i < arr.length;i++){
			
			arr[i] = (int)(Math.random() * 30  + 1 );
			
			for(int j = 0;j < i;j++){
				if(arr[j] == arr[i]){
					i--;
					break;
				}
			}
		}
		
		//遍历
		for(int i = 0;i < arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
}

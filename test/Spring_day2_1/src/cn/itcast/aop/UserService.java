package cn.itcast.aop;

public class UserService {

	public void add(int i){
		System.out.println("add");
		try {
			int s = 1/0;
		} catch (Exception e) {
			
		}
		System.out.println("add================");
	}
	public void delete(){
		System.out.println("delete");
	}
}
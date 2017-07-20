package cn.itcast.bean.xml;

public class Bean2StaticFactory {
	public static Bean2 getInst(){
		//....
		//System.out.println("bean2 factory running......");
		return new Bean2();
	}
}

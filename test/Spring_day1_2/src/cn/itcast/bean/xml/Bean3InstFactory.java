package cn.itcast.bean.xml;

public class Bean3InstFactory {
	public Bean3 getInst(){
		//System.out.println("bean3 instance factory running......");
		return new Bean3();
	}
}

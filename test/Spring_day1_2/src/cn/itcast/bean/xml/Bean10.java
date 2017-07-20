package cn.itcast.bean.xml;

import java.util.List;
import java.util.Properties;
import java.util.Set;

//测试集合注入
public class Bean10 {
	private List<String> country;
	private Set<String> names;
	private Properties likes;
	public void setLikes(Properties likes) {
		this.likes = likes;
	}
	public void setNames(Set<String> names) {
		this.names = names;
	}
	public void setCountry(List<String> country) {
		this.country = country;
	}
	public void test(){
		System.out.println("-----------List-------------");
		for(String name: country){
			System.out.println(name);
		}
		System.out.println("-----------Set-------------");
		for(String name: names){
			System.out.println(name);
		}
		System.out.println("-----------properties-------------");
		Set likesProp = likes.keySet();
		for(Object obj:likesProp){
			System.out.println(obj+","+likes.getProperty(obj.toString()));
		}
	}
}

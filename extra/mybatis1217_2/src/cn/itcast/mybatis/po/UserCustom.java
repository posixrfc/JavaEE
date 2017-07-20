package cn.itcast.mybatis.po;

/**
 * 
 * <p>Title: UserCustom</p>
 * <p>Description:扩展 pojo </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17下午4:51:49
 * @version 1.0
 */
public class UserCustom extends User {
	
	//学生类型,扩展字段
	private String groupid;

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	

}

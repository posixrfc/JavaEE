package cn.itcast.mybatis.po;

/**
 * 
 * <p>Title: QueryVo</p>
 * <p>Description:查询条件的包装对象 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17下午4:50:02
 * @version 1.0
 */
public class QueryVo {
	
	//用户查询条件
	//为了查询条件扩展方便，基于po的基础上自定义的pojo，继承于Po
	private UserCustom userCustom;
	
	private User user;
	
	private int[] ids;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
	//基它的查询条件

}

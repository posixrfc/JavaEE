package cn.itcast.springmvc.pojo;

/**
 * 
 * <p>Title: StudentScore</p>
 * <p>Description: 学生成绩 信息</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15下午5:04:55
 * @version 1.0
 */
public class StudentScore {
	private String coursename;//课程名称
	private Float score;//成绩
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}

}

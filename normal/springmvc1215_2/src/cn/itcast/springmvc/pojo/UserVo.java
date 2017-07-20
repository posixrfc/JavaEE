package cn.itcast.springmvc.pojo;

import java.util.List;



/**
 * 
 * <p>Title: UserVo</p>
 * <p>Description: 包装对象，用于接收页面的参数</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15下午4:31:18
 * @version 1.0
 */
public class UserVo {

	//学生信息包装进来
	private Student student;
	
	//学生成绩 信息
	private List<StudentScore> scores;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<StudentScore> getScores() {
		return scores;
	}

	public void setScores(List<StudentScore> scores) {
		this.scores = scores;
	}
	
	
	
}

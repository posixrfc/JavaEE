package cn.itcast.bean.team;
//子模块对应的Bean
public class Team2 {
	private Team1 team;
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public void setTeam(Team1 team) {
		this.team = team;
	}
	public void test(){
		team.test();
		System.out.println("team2........"+name);
	}
}

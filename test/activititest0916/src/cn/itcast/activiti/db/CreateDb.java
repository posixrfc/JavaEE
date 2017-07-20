package cn.itcast.activiti.db;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class CreateDb {

	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml",
						"processEngineConfiguration");
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println(processEngine);
	}
}
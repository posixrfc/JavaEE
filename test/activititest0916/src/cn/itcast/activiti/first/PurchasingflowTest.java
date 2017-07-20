package cn.itcast.activiti.first;

import java.io.InputStream;
import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class PurchasingflowTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deployProcess() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ClassLoader classLoader = PurchasingflowTest.class.getClassLoader();
		
		InputStream inputStream_bpmn = classLoader.getResourceAsStream("diagram/workflow.bpmn");
		InputStream inputStream_png = classLoader.getResourceAsStream("diagram/workflow.png");
		
		Deployment deployment = repositoryService.createDeployment().addInputStream("1workflow.bpmn", inputStream_bpmn)
				.addInputStream("1workflow.png", inputStream_png).deploy();
		
		System.out.println("部署id：" + deployment.getId());
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}

	@Test
	public void startProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("workflow");

		System.out.println("流程实例id：" + processInstance.getId());
		System.out.println("流程定义id：" + processInstance.getProcessDefinitionId());
	}

	@Test
	public void findPersonalTaskList() {
		TaskService takService = processEngine.getTaskService();
		TaskQuery taskQuery = takService.createTaskQuery();
		
		taskQuery.taskAssignee("financialAuditAssignee");
		taskQuery.processDefinitionKey("workflow");
		
		List<Task> list = taskQuery.list();
		for (Task task : list) {
			System.out.println("任务 id：" + task.getId());
			System.out.println("任务负责人：" + task.getAssignee());
			System.out.println("任务名称：" + task.getName());
		}
	}

	@Test
	public void completeTask() {
		TaskService takService = processEngine.getTaskService();
		String taskId="302";
		takService.complete(taskId);
		System.out.println("完成任务："+taskId);
	}
}
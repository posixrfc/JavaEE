package cn.itcast.activiti.processDefinition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;

public class ProcessDefinitionTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	private ClassLoader classLoader = this.getClass().getClassLoader();

	@Test
	public void deployProcess() {
		RepositoryService repositoryService = processEngine.getRepositoryService();

		InputStream inputStream_bpmn = classLoader.getResourceAsStream("diagram/workflow.bpmn");
		InputStream inputStream_png = classLoader.getResourceAsStream("diagram/workflow.png");

		Deployment deployment = repositoryService.createDeployment().addInputStream("wworkflow.bpmn", inputStream_bpmn)
				.addInputStream("wworkflow.png", inputStream_png).name("pro").deploy();

		System.out.println("部署id：" + deployment.getId());
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}

	@Test
	public void deployProcessByZip() {
		InputStream inputStream = classLoader.getResourceAsStream("diagram/top.zip");
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment()
				.addZipInputStream(zipInputStream).name("nnmm").deploy();
		System.out.println("流程部署id：" + deployment.getId());
		System.out.println("流程部署名称：" + deployment.getName());
	}

	@Test
	public void queryProcessDefinition() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		processDefinitionQuery.processDefinitionKey("workflow");
		List<ProcessDefinition> list = processDefinitionQuery.list();
		// 分页查询
		// processDefinitionQuery.listPage(firstResult, maxResults)
		// 根据流程定义的id查询一条记录
		// processDefinitionQuery.processDefinitionId(definitionId).singleResult();
		for (ProcessDefinition processDefinition : list) {
			System.out.println("================================");
			System.out.println("流程定义id：" + processDefinition.getId());
			System.out.println("流程定义部署id：" + processDefinition.getDeploymentId());
			System.out.println("流程定义的key：" + processDefinition.getKey());
			System.out.println("流程定义的名称：" + processDefinition.getName());
			System.out.println("bpmn资源名称：" + processDefinition.getResourceName());
			System.out.println("png资源名称：" + processDefinition.getDiagramResourceName());
		}
	}

	@Test
	public void deleteProcessDefinition() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId("workflow:1:4").singleResult();
		String deploymentId = processDefinition.getDeploymentId();
		// repositoryService.deleteDeployment(deploymentId);
		// 级联删除
		repositoryService.deleteDeployment(deploymentId, true);
	}

	@Test
	public void queryProcessDefinitionResource() throws IOException {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId("workflow:2:504").singleResult();
		String deploymentId = processDefinition.getDeploymentId();
		
		String resourceName_bpmn = processDefinition.getResourceName();
		//bpmn资源文件输入流
		InputStream inputStream_bpmn = repositoryService.getResourceAsStream(
				deploymentId, resourceName_bpmn);
		
		String resourceName_png = processDefinition.getDiagramResourceName();
		//png资源文件输入流
		InputStream inputStream_png = repositoryService.getResourceAsStream(
				deploymentId, resourceName_png);
		
		//构造输出流
		File file_bpmn = new File("d:/"+resourceName_bpmn);
		File file_png = new File("d:/"+resourceName_png);
		
		FileOutputStream fileOutputStream_bpmn = new FileOutputStream(file_bpmn);
		FileOutputStream fileOutputStream_png = new FileOutputStream(file_png);
		
		byte[] b = new byte[1024];
		int len=-1;
		while((len=inputStream_bpmn.read(b, 0, 1024))!=-1){
			fileOutputStream_bpmn.write(b, 0, len);
		}
		while((len=inputStream_png.read(b, 0, 1024))!=-1){
			fileOutputStream_png.write(b, 0, len);
		}
		inputStream_bpmn.close();
		inputStream_png.close();
		fileOutputStream_bpmn.close();
		fileOutputStream_png.close();
	}
}
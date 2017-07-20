package cn.itcast.purchasing.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.purchasing.util.ResourcesUtil;

/**
 * 
 * <p>
 * Title: FlowAction
 * </p>
 * <p>
 * Description: 流程定义
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-20下午5:39:21
 * @version 1.0
 */
@Controller
@RequestMapping("/flow")
public class FlowAction {

	@Autowired
	private RepositoryService repositoryService;

	// 流程定义部署页面
	@RequestMapping("/deployProcess")
	public String deployProcess(Model model) throws Exception {

		return "flow/deployProcess";
	}

	// 流程定义部署提交
	@RequestMapping("/deployProcessSubmit")
	public String deployProcessSubmit(MultipartFile resource_bpmn,
			MultipartFile resource_png) throws Exception {
		// 第一步：上传文件
		// springmvc通过文件上传的参数解析器将页面提交 的file赋值给形参
		// resource_bpmn和resource_png存储了上传的文件

		// 第二步：调用activiti的service执行流程定义部署
		// 部署bpmn文件和png文件
		// bpmn文件名

		String resourceName_bpmn = resource_bpmn.getOriginalFilename();
		InputStream inputStream_bpmn = resource_bpmn.getInputStream();

		String resourceName_png = resource_png.getOriginalFilename();
		InputStream inputStream_png = resource_png.getInputStream();

		// 部署对象
		Deployment deployment = repositoryService.createDeployment()
				.addInputStream(resourceName_bpmn, inputStream_bpmn)// 部署bpmn文件
				.addInputStream(resourceName_png, inputStream_png)// 部署png文件
				.deploy();

		// 部署对象id
		System.out.println("部署id：" + deployment.getId());

		System.out.println("部署时间：" + deployment.getDeploymentTime());

		// 返回到流程定义的查询页面
		return "redirect:queryProcessDefinition.action";
	}

	// 流程定义查询
	@RequestMapping("/queryProcessDefinition")
	public String queryProcessDefinition(Model model) throws Exception {

		// 流程定义的key
		String processDefinitionKey = ResourcesUtil.getValue(
				"diagram.purchasingflow", "purchasingProcessDefinitionKey");// 采购流程标识
		// 创建查询对象
		ProcessDefinitionQuery processDefinitionQuery = repositoryService
				.createProcessDefinitionQuery();

		// 设置查询条件
		// 只查询采购流程的定义
		processDefinitionQuery.processDefinitionKey(processDefinitionKey);

		// 查询列表
		List<ProcessDefinition> list = processDefinitionQuery.list();
		// 分页查询
		// processDefinitionQuery.listPage(firstResult, maxResults)
		// 根据流程定义的id查询一条记录
		// processDefinitionQuery.processDefinitionId(definitionId).singleResult();

		model.addAttribute("list", list);

		/*
		 * for (ProcessDefinition processDefinition : list) {
		 * System.out.println("================================");
		 * System.out.println("流程定义id：" + processDefinition.getId());
		 * System.out.println("流程定义部署id：" +
		 * processDefinition.getDeploymentId()); System.out.println("流程定义的key："
		 * + processDefinition.getKey()); System.out.println("流程定义的名称：" +
		 * processDefinition.getName()); System.out.println("bpmn资源名称：" +
		 * processDefinition.getResourceName()); System.out.println("png资源名称：" +
		 * processDefinition.getDiagramResourceName()); }
		 */

		return "flow/queryProcessDefinition";
	}

	// 删除流程定义
	@RequestMapping("/deleteProcessDefinition")
	public String deleteProcessDefinition(String processDefinitionId)
			throws Exception {

		// 根据流程定义id查询流程定义对象
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		// 流程定义所属部署id
		String deploymentId = processDefinition.getDeploymentId();

		// 级联删除
		repositoryService.deleteDeployment(deploymentId, true);

		// 返回到流程定义的查询页面
		return "redirect:queryProcessDefinition.action";
	}

	// 流程定义资源文件查看
	@RequestMapping("/queryProcessDefinitionResource")
	/**
	 * 
	 * <p>Title: queryProcessDefinitionResource</p>
	 * <p>Description: </p>
	 * @param response  输出 对象
	 * @param processDefinitionId 流程定义id
	 * @param resourcesType 资源 文件类型（bpmn和png）
	 * @throws Exception
	 */
	public void queryProcessDefinitionResource(HttpServletResponse response,String processDefinitionId,
			String resourceType) throws Exception {

		//根据流程定义id获取流程定义对象
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		// 部署id
		String deploymentId = processDefinition.getDeploymentId();

		// 资源 文件名称
		String resourceName = null;

		if (resourceType.equals("bpmn")) {
			// bpmn资源文件名称
			resourceName = processDefinition.getResourceName();

		} else if (resourceType.equals("png")) {
			// png资源文件名称
			resourceName = processDefinition.getDiagramResourceName();

		}
		// 资源 文件输入流
		InputStream inputStream = repositoryService.getResourceAsStream(
				deploymentId, resourceName);

		// 流复制

		byte[] b = new byte[1024];

		int len = -1;
		while ((len = inputStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}

	}

}

package cn.itcast._a_upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadServlet extends HttpServlet {

	// uploadĿ¼�������ϴ�����Դ
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*********�ļ��ϴ������ �����ļ��ϴ�************/
		
		
		try {
			// 1. �ļ��ϴ�����
			FileItemFactory factory = new DiskFileItemFactory();
			// 2. �����ļ��ϴ����Ĺ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
		
			// һ�����õ����ļ���������Ĵ�С�� 30M
			upload.setFileSizeMax(30*1024*1024);
			// ���������ļ��ϴ���������ܴ�С: 80M
			upload.setSizeMax(80*1024*1024);
			// ���� �����ϴ����ļ����ı���
			// �൱�ڣ�request.setCharacterEncoding("UTF-8");
			upload.setHeaderEncoding("UTF-8");
			
			
			// 3. �жϣ� ��ǰ���Ƿ�Ϊ�ļ��ϴ���
			if (upload.isMultipartContent(request)){
				// 4. ����������ת��Ϊһ����FileItem�������ü��Ϸ�װ
				List<FileItem> list = upload.parseRequest(request);
				// ������ �õ�ÿһ���ϴ�������
				for (FileItem item: list){
					// �жϣ���ͨ�ı�����
					if (item.isFormField()){
						// ��ͨ�ı�����
						String fieldName = item.getFieldName();	// ��Ԫ������
						String content = item.getString();		// ��Ԫ�����ƣ� ��Ӧ������
						//item.getString("UTF-8");  ָ������
						System.out.println(fieldName + " " + content);
					}
					// �ϴ��ļ�(�ļ���) ----> �ϴ���uploadĿ¼��
					else {
						// ��ͨ�ı�����
						String fieldName = item.getFieldName();	// ��Ԫ������
						String name = item.getName();			// �ļ���				
						String content = item.getString();		// ��Ԫ�����ƣ� ��Ӧ������
						String type = item.getContentType();	// �ļ�����
						InputStream in = item.getInputStream(); // �ϴ��ļ���
						
						/*
						 *  �ġ��ļ�������
						 *  ���ڲ�ͬ�û�readme.txt�ļ�����ϣ�����ǣ�
						 *  ��̨���� ���û����һ��Ψһ���!
						 */
						// a. �������һ��Ψһ���
						String id = UUID.randomUUID().toString();
						// b. ���ļ���ƴ��
						name = id +"#"+ name;
						
						// ��ȡ�ϴ���·��
						String path = getServletContext().getRealPath("/upload");
						// ����Ŀ���ļ�
						File file = new File(path,name);
						
						// �����࣬�ļ��ϴ�
						item.write(file);
						item.delete();   //ɾ��ϵͳ��������ʱ�ļ�
						
						System.out.println();
					}
					
				}
				
			}
			else {
				System.out.println("��ǰ�������ļ��ϴ���������ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	// �ֶ�ʵ�ֹ���
	private void upload(HttpServletRequest request) throws IOException,
			UnsupportedEncodingException {
		/*
		request.getParameter(""); // GET/POST
		request.getQueryString(); // ��ȡGET�ύ������ 
		request.getInputStream(); // ��ȡpost�ύ������   */
		
		/***********�ֶ���ȡ�ļ��ϴ�������************/
		
		//1. ��ȡ��������
		InputStream in =  request.getInputStream();
		//2. ת����
		InputStreamReader inStream = new InputStreamReader(in, "UTF-8");
		//3. ������
		BufferedReader reader = new BufferedReader(inStream);
		// �������
		String str = null;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
		
		// �ر�
		reader.close();
		inStream.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

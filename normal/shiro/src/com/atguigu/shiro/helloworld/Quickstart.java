package com.atguigu.shiro.helloworld;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);

    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        // Now that a simple Shiro environment is set up, let's see what you can do:

        // get the currently executing user:
        // *��ȡ��ǰ�û�
        Subject currentUser = SecurityUtils.getSubject();

        // Do some stuff with a Session (no need for a web or EJB container!!!)
        // ��ȡ��ǰ�û���Ӧ�� Session. 
        Session session = currentUser.getSession();
        // �� Session ����Ӽ�ֵ��. 
        session.setAttribute("someKey", "aValue");
        // �� Session ��ȡ������. 
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("--> Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        //* ����û��Ƿ��Ѿ���½!
        if (!currentUser.isAuthenticated()) {
        	//* ��û�е�¼, ��� �û��� �� ���� ��װΪһ�� UsernamePasswordToken ����. 
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {
            	//* ִ�е�½����. ���� Subject#login(UsernamePasswordToken) ����. 
                currentUser.login(token);
            } 
            //����ͨ����׽�쳣�ķ�ʽ���鿴�û�����ε�½ʧ�ܵ�. 
            //�û��������ڡ� 
            catch (UnknownAccountException uae) {
                log.info("--> There is no user with username of " + token.getPrincipal());
            } 
            //�������. 
            catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } 
            //�˻�������
            catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            //��������֤һ��. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("--> User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        //�ж��û��Ƿ���ĳһ����ɫ
        if (currentUser.hasRole("schwartz")) {
            log.info("--> May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level)
        //�ж��û��Ƿ�������ʲô. 
        if (currentUser.isPermitted("user:delete")) {
            log.info("--> You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("customer:update:meizu")) {
            log.info("--> You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        // �ǳ�. 
        currentUser.logout();

        System.exit(0);
    }
}

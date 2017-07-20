
package cn.it.ws.d;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PhoneService", targetNamespace = "http://d.ws.it.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PhoneService {


    /**
     * 
     * @param arg0
     * @return
     *     returns cn.it.ws.d.Phone
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPhoneInfo", targetNamespace = "http://d.ws.it.cn/", className = "cn.it.ws.d.GetPhoneInfo")
    @ResponseWrapper(localName = "getPhoneInfoResponse", targetNamespace = "http://d.ws.it.cn/", className = "cn.it.ws.d.GetPhoneInfoResponse")
    @Action(input = "http://d.ws.it.cn/PhoneService/getPhoneInfoRequest", output = "http://d.ws.it.cn/PhoneService/getPhoneInfoResponse")
    public Phone getPhoneInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}

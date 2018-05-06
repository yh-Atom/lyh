package org.pxxy.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.pxxy.domain.Message;
import org.pxxy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;

@ParentPackage("struts-default")
@Namespace("/")
@Controller("messageAction")  //创建对象
@Scope("prototype")    //多实例方式创建对象
public class MessageAction extends ActionSupport implements ModelDriven<Message>{
	private Message message = new Message();	
		
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Autowired  //注入
	private MessageService messageService;
	private List<Message> list =null;

	public List<Message> getList() {
		return list;
	}

	//后台查询信息类别数据
	@Action(value="/ht/findAllMessage",results={@Result(name="success",location="/ht/message/list.jsp")})
	public String findAllMessage(){
		try {
			list = messageService.findAllMessage();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "success";
	}

	//添加分类
	@Action(value="/ht/addMessage",results={@Result(name="success",location="/ht/findAllMessage",type = "redirect")})
	public String addMessage() {
		try {
			messageService.addMessage(message);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "success";
	}
	
	//删除某个分类 
	@Action(value="/ht/delMessage",results={@Result(name="success",location="/ht/findAllMessage",type = "redirect")})
	public String delMessage(){		
		try {
			messageService.delMessage(message);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "success";
	}

	//根据cid查询指定类别对象
	@Action(value="/ht/editMessage",results={@Result(name="success",location="/ht/message/edit.jsp")})
	public String editMessage(){		
		try {
			message = messageService.findMessageById(message.getId());
			this.setMessage(message);
			//ActionContext.getContext().getValueStack().push(message);			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");//告知浏览器使用什么编码解析文本
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	//更新类别
	@Action(value="/ht/updateMessage",results={@Result(name="success",location="/ht/findAllMessage",type = "redirect")})
	public String updateMessage(){
		try {
			messageService.updateMessage(message);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "success";
	}
	
	@Override
	public Message getModel() {
		return message;
	}
	
	
}

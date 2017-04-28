package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.entity.Message;
import com.my.service.MessageService;

@Controller
@RequestMapping("/talk")
public class TalkController {
	
	private static Logger log = LoggerFactory.getLogger(TalkController.class);
	private MessageService messageService;
	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@RequestMapping(value="/autoReplyMessage")
	public ModelAndView getMessagesByCommand(@RequestParam("content") String command,
			HttpServletResponse response) {
		
		//加上下面一句解决响应的中文乱码问题，包括jsp页面中的乱码，js文件中的中文乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String reply = messageService.getMessagesByCommand(command);
			out.print(reply);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	@RequestMapping(value="/gotoTalk")
	public String gotoTalk() {
		return "talk";
	}
		
}

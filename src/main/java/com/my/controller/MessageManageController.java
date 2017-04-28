package com.my.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.entity.Command;
import com.my.entity.CommandContents;
import com.my.entity.Message;
import com.my.entity.Page;
import com.my.service.CommandContentsService;
import com.my.service.MessageService;
import com.my.util.CONSTANTS;
/**
 * 对命令和回复内容进行管理的控制类
 * @author yun
 *
 */
@Controller
@RequestMapping("/admin")
public class MessageManageController {
	private static Logger log = LoggerFactory.getLogger(MessageManageController.class);

	private MessageService messageService;
	private CommandContentsService commandContentsService;
	@Autowired
	public void setCommandContentsService(CommandContentsService commandContentsService) {
		this.commandContentsService = commandContentsService;
	}
	
	@Autowired
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}


	@RequestMapping(value="/addOneCommandContent", method=RequestMethod.POST)
	public String addOneCommandContent(@ModelAttribute("commandContents") CommandContents commandContents) {
		commandContentsService.addOne(commandContents);
		return "redirect:/admin/message_manage";
		
	}
	
	@RequestMapping("/gotoMessageManage")
	/**
	 * 跳转到命令和内容的管理页面
	 * @return
	 */
	public ModelAndView gotoMessageManage() {

		ModelAndView mav = new ModelAndView();
		Page page = new Page();
		page.setCurrentPage(1);
		page.setPageNumber(CONSTANTS.PAGE_NUMBER);
		List<Command> commandlist = messageService.getCommandListByPage(page);
		if(commandlist !=null && commandlist.size() > 0) {
			for (Command command : commandlist) {
				log.debug(command.getName());
				for (CommandContents commandContents : command.getContentList()) {
					log.debug(commandContents.getContent());
				}
			}
			
		}
	
		mav.addObject("commandlist", commandlist);
		mav.addObject("page", page);
		mav.setViewName("message_manage");
		return mav;

	} 
	
	
	
	@RequestMapping(value="/gotoUpdateCommandContent", method=RequestMethod.GET)
	/**
	 * 跳转到添加新命令页面
	 * @return
	 */
	public ModelAndView gotoUpdateCommandContent(@RequestParam("id") int id, ModelAndView mav) {
		List<CommandContents> contentlist = commandContentsService.queryCommandContentsById(id);
		CommandContents commandContents = contentlist.get(0);
		mav.addObject("commandContents", commandContents);
		mav.setViewName("update_content");
		return mav;
	} 
	
	@RequestMapping(value="/updateCommandContent", method=RequestMethod.POST)
	public ModelAndView updateCommandContent(@ModelAttribute("commandContent") CommandContents commandContents) {
		ModelAndView mav = new ModelAndView();
		commandContentsService.updateOne(commandContents);
		mav.addObject("status", "更新成功");
		mav.setViewName("update_content"); 
		return mav;
	}
	
	@RequestMapping("/gotoAddNewCommand")
	/**
	 * 跳转到添加新命令页面
	 * @return
	 */
	public String gotoAddNewCommand() {
		return "add_command";
	} 
	@RequestMapping(value="/addNewCommand", method=RequestMethod.GET)
	public ModelAndView queryMessageByPage(ModelAndView mav, HttpServletRequest request) {

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String contentdescription = request.getParameter("contentdescription");
		String content = request.getParameter("content");
		Command command = new Command();
		command.setName(name);
		command.setDescription(description);
		CommandContents cc = new CommandContents();
		cc.setName(contentdescription);
		cc.setContent(content);
		messageService.addNewCommandAndContent(
				command, cc);	
		//将表示添加的状态加入到视图中去
		mav.addObject("status", "添加成功");
		mav.setViewName("add_command"); 
		return mav;
	}
	
	@RequestMapping(value="/queryMessageByPage", method=RequestMethod.GET)
	public ModelAndView queryMessageByPage(@RequestParam("currentPage") int currentPage) {
		ModelAndView mav = new ModelAndView();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setPageNumber(CONSTANTS.PAGE_NUMBER);
		List<Command> commandlist = messageService.getCommandListByPage(page);		
		mav.addObject("commandlist", commandlist);
		mav.addObject(page);
		mav.setViewName("message_manage"); 
		return mav;
	}
	
	@RequestMapping(value="/deleteOneCommandContent", method=RequestMethod.GET)
	public String deleteOneCommandContent(@RequestParam("id") int id) {
		commandContentsService.deleteOne(id);
		return "redirect:/admin/gotoMessageManage";
	}
	
	@RequestMapping(value="/queryCommandList", method=RequestMethod.GET)
	public ModelAndView queryMessageByPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String command = request.getParameter("command");
		String description = request.getParameter("description");		
		List<Command> commandlist = messageService.getCommandList(command, description);		
		mav.addObject("commandlist", commandlist);
		mav.setViewName("message_manage"); 
		return mav;
	}
	
	@RequestMapping(value="deleteCommands", method=RequestMethod.GET)
	public String deleteCommands(HttpServletRequest request) {
		
		String[]idarray = request.getParameterValues("commandid");
		log.debug("idarray length: "+idarray.length);
		for(int i = 0; i< idarray.length; i++)
		log.debug("idarray["+i+"] = " + idarray[i]);
		messageService.deleteCommands(idarray);
		return "redirect:/admin/gotoMessageManage";
	}
}

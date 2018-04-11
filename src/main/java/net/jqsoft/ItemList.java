package net.jqsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jqsoft.ssm.domain.User;
import net.jqsoft.ssm.service.IUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ItemList{
	
	@Autowired
	private IUserService userService;
	
	Logger logger = Logger.getLogger(ItemList.class);
	
	@RequestMapping("queryItems")
	public String  queryItems(Model model,Integer[]	love) throws Exception {
			logger.info("调用了方法");
			
			System.out.println(Arrays.toString(love));
			
			List<User> itemList = userService.findLike("");
			
			model.addAttribute("itemList", itemList);
		return "Welcome";
	}

}

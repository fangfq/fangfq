package net.jqsoft.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 404，500等异常处理
 * @author MyPc
 *	@date 2018年4月9日
 */
@Controller
public class ErrorController {
	
	@RequestMapping("/error_404")
	public void handleError404(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("/404.html").forward(request, response);;
	}
	
}

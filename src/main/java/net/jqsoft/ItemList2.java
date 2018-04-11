package net.jqsoft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

public class ItemList2 implements HttpRequestHandler{

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<String> itemList = new ArrayList<String>();
		itemList.add("小米1");
		itemList.add("华为1");
		itemList.add("三星1");
		
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("/WEB-INF/jsp/Welcome.jsp").forward(request, response);
	}

}

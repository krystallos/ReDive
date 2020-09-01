package reDive.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {

	@GetMapping("page.act")
	public ModelAndView page(String page,HttpSession session,HttpServletRequest req, HttpServletResponse resp) {
		session = req.getSession();
//		FrontUser adminBean = (FrontUser)session.getAttribute("frontUser");
//		if(adminBean==null || adminBean==null) {
//			ModelAndView view = new ModelAndView("login");
//			return view;
//		}

//		if(page != null && adminBean != null) {
//			ModelAndView view = new ModelAndView(page);
//			return new ModelAndView("mode");
//		}
//		return new ModelAndView("login");
		if(page==null) {
			return new ModelAndView("login");
		}
		return new ModelAndView(page);
	}
}

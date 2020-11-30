package tw.group4._04_.front.seat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import oracle.net.aso.m;
import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanDAO;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4.util.IdentityFilter;

@Controller
public class SeatCrud {
	
	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Shoppingcart shoppingcart;
	
	//查詢座位
	@RequestMapping(path = "/04/seatSearch.ctrl", method = RequestMethod.GET)
	public String seatSearch(Model model ,HttpSession session,String ticketcategry,Integer ticketnum) {
//		int actid =Integer.parseInt((String) session.getAttribute("actid"));
		session.setAttribute("shoppingcartnum", ticketnum);
		int actid = (int) session.getAttribute("actid");
		shoppingcart.setACT_ID(actid);
		shoppingcart.setTITLE((String)(session.getAttribute("title")));
		shoppingcart.setTICKETCATEGORY(ticketcategry);
		shoppingcart.setTICKET_NUM(ticketnum);
		
		//shoppingcart存入session
		session.setAttribute("shoppingcart",shoppingcart);
		Map<String, Integer>seatMap=seatBeanService.select(actid);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		return IdentityFilter.loginID+"04/front_Seat/Seat";
	}

}

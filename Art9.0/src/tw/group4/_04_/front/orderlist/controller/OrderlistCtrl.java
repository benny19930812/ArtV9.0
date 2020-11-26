package tw.group4._04_.front.orderlist.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.model.ShowBean2;
import tw.group4._04_.front.orderlist.model.Orderlist;
import tw.group4._04_.front.orderlist.model.OrderlistService;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4._04_.front.shopcart.model.ShoppingcartService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.IdentityFilter;

@Controller
public class OrderlistCtrl {

	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Orderlist Orderlist;
	@Autowired
	private OrderlistService orderlistService;

	// 查詢訂單
	@RequestMapping(path = "/04/SearchOrder.ctrl", method = RequestMethod.GET)
	public String booking(Model model, HttpSession session, HttpServletRequest Request) {

		WebsiteMember member = (WebsiteMember) session.getAttribute("member");

		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {
			List<Map> list = new ArrayList<Map>();
			String memberID = Integer.toString(member.getId());
			List<Orderlist> orderlist = orderlistService.searchOrderlist(memberID);
			for (Orderlist orderlist2 : orderlist) {

						Map map = new HashMap();
						map.put("ORDERID",Orderlist.getORDERID());
						map.put("NAME",Orderlist.getNAME());
						map.put("EMAIL",Orderlist.getEMAIL() );
						map.put("TEL",Orderlist.getTEL() );
						map.put("ADDRESS",Orderlist.getADDRESS());
						map.put("TITLE",Orderlist.getTITLE() );
						map.put("TICKETCATEGORY",Orderlist.getTICKETCATEGORY() );
						map.put("TICKET_NUM",Orderlist.getTICKET_NUM() );
						map.put("TOTALPRICE",Orderlist.getTOTALPRICE() );
						map.put("seats",Orderlist.getSeats() );
////						map.put("photo", Photoencode);
//						// 存入map集合中
////						System.out.println(map);
						list.add(map);// 將map集合放入list集合

				model.addAttribute("orderlist", orderlist);
				model.addAttribute("list", list);
				
			}
		}
		return IdentityFilter.loginID + "04/front_Orderlist/ShowOrderlist";


	}

}

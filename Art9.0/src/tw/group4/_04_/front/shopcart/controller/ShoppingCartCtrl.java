package tw.group4._04_.front.shopcart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.front.javaMail.controller.SpringMail;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4._04_.front.shopcart.model.ShoppingcartService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.IdentityFilter;


@Controller
public class ShoppingCartCtrl {

	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Shoppingcart shoppingcart;
	@Autowired
	private ShoppingcartService shoppingcartService;
	//判定是否登入
	@RequestMapping(path = "/04/booking.ctrl", method = RequestMethod.GET)
	public String booking(Model model, HttpSession session, HttpServletRequest Request) {

		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {
			String memberID = Integer.toString(member.getId());
			System.out.println("memberID:" + memberID);
			// 將memberID放入shoppingcart

			if (shoppingcart == null) {
				shoppingcart = new Shoppingcart();
				shoppingcart.setMEMBERID(memberID);
			} else {
			}
			shoppingcart.setMEMBERID(memberID);

			return IdentityFilter.loginID + "04/front_saleTicket/Booking";
		}

	}
	//取得劃位資訊
	@RequestMapping(path = "/04/shoppingcart.ctrl", method = RequestMethod.GET)
	public String shoppingcart(Model model, HttpSession session, HttpServletRequest Request) {
		List<String> seat = new ArrayList<String>();
		String[] seats = Request.getParameterValues("seat");
//			int seatnum=Integer.parseInt(Request.getParameter("seatnum"));
		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		shoppingcart.setSeats(seats);
//			shoppingcart.setSeatnum(seatnum);

		return IdentityFilter.loginID + "04/front_saleTicket/Booking2";
	}
	
	@RequestMapping(path = "/04/shoppingcart2.ctrl", method = RequestMethod.GET)
	public String shoppingcart2(Model model, HttpSession session, HttpServletRequest Request) {

		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		if (shoppingcart == null) {
			return "redirect:/index.html";
		}
		String ticketcategory = shoppingcart.getTICKETCATEGORY();
		System.out.println(ticketcategory);
		if ("全票".equals(ticketcategory)) {
			int Totalprice = shoppingcart.getTICKET_NUM() * 2000;
			shoppingcart.setTOTALPRICE(Totalprice);
		} else {
			int Totalprice = shoppingcart.getTICKET_NUM() * 1000;
			shoppingcart.setTOTALPRICE(Totalprice);
		}

		shoppingcart.setNAME(Request.getParameter("name"));
		shoppingcart.setEMAIL(Request.getParameter("email"));
		shoppingcart.setTEL(Request.getParameter("tel"));
		shoppingcart.setADDRESS(Request.getParameter("add"));

		return IdentityFilter.loginID + "04/front_saleTicket/Booking3";
	}

	@RequestMapping(path = "/04/delectTicket.ctrl", method = RequestMethod.GET)
	public String Ticket(Model model, HttpSession session, HttpServletRequest Request, String seat) {
		System.out.println("seat" + seat);
		String[] seats2 = {};
		List<String> seatlist = new ArrayList<String>();
		// 取得SESSION 中seats
		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		String[] seats = shoppingcart.getSeats();
		for (String s : seats) {
			if (!s.equals(seat)) {
				System.out.println(s);
				seatlist.add(s);
			}
		}
		// 將List<String> seatlist 轉為String[]
		seats2 = new String[seatlist.size()];
		seatlist.toArray(seats2);
		// 塞回shoppingcart
		shoppingcart.setSeats(seats2);
		// 取得座位數
		int TicketNUM = shoppingcart.getTICKET_NUM();
		shoppingcart.setTICKET_NUM(TicketNUM - 1);

		return IdentityFilter.loginID + "04/front_saleTicket/Booking2";
	}

	@RequestMapping(path = "/04/delectCart.ctrl", method = RequestMethod.GET)
	public String delectCart(Model model, HttpSession session, HttpServletRequest Request) {
		// 移除shoppingcart
		session.removeAttribute("shoppingcart");

		return IdentityFilter.loginID + "04/front_saleTicket/Booking2";
	}

	// 儲存訂單
	@RequestMapping(path = "/04/SaveCart.ctrl", method = RequestMethod.GET)
	public String SaveCart(Model model, HttpSession session, HttpServletRequest Request) {

		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		String orderlistID = shoppingcartService.getOrderIdByTime();		
		String[] seats = shoppingcart.getSeats();
		String actno =Integer.toString(shoppingcart.getACT_ID());
		int ticketnum=shoppingcart.getTICKET_NUM();
		System.out.println(ticketnum);
		switch (ticketnum) {
		case 1:
			seatBeanService.insert1Seat(seats,actno);
			break;
		case 2:
			seatBeanService.insert2Seat(seats,actno);
			break;
		case 3:
			seatBeanService.insert3Seat(seats,actno);
			break;
		default:
			seatBeanService.insert4Seat(seats,actno);
			break;
		}
		//將Arry轉為String存入DB
		String seatsString = Arrays.toString(seats);
		System.out.println("seatsString" + seatsString);
		shoppingcart.setSeatstring(seatsString);

		shoppingcart.setORDERID(orderlistID);
		shoppingcartService.insert(shoppingcart);
		System.out.println("訂單已成立");
		model.addAttribute("orderlistID", orderlistID);
		model.addAttribute("email", shoppingcart.getEMAIL());
//		SpringMail.processmailsend(shoppingcart);
		//清空購物車
		session.removeAttribute("shoppingcart");

		return IdentityFilter.loginID + "04/front_Orderlist/ThxOrder";
	}
	
	@RequestMapping(path = "/04/goshoppingcart.ctrl", method = RequestMethod.GET)
	public String goshoppingcart(Model model, HttpSession session, HttpServletRequest Request) {
		
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {	
			return IdentityFilter.loginID + "04/front_saleTicket/Booking2";
		}
	}

}

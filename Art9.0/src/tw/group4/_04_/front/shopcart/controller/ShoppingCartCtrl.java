package tw.group4._04_.front.shopcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
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
		
		@RequestMapping(path = "/04/booking.ctrl", method = RequestMethod.GET)
		public String booking(Model model ,HttpSession session,HttpServletRequest Request) {
			
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			if (member == null) {
				return "redirect:/35/loginEntry";
			}else {
				String memberID = Integer.toString(member.getId());
				System.out.println("memberID:"+memberID);	
				
				//將memberID放入shoppingcart

				if (shoppingcart == null) {
					shoppingcart=new Shoppingcart();
					shoppingcart.setMEMBERID(memberID);					
				}else {
				}
				shoppingcart.setMEMBERID(memberID);					
					
				return IdentityFilter.loginID+"04/front_saleTicket/Booking";
			}	
				
		}

		@RequestMapping(path = "/04/shoppingcart.ctrl", method = RequestMethod.GET)
		public String shoppingcart(Model model ,HttpSession session,HttpServletRequest Request) {
			List<String> seat = new ArrayList<String>();
			String[] seats= Request.getParameterValues("seat");
			shoppingcart=(Shoppingcart) session.getAttribute("shoppingcart");
			shoppingcart.setSeats(seats);
			
			
			return IdentityFilter.loginID+"04/front_saleTicket/Booking2";
		}	
		
		@RequestMapping(path = "/04/shoppingcart2.ctrl", method = RequestMethod.GET)
		public String shoppingcart2(Model model ,HttpSession session,HttpServletRequest Request) {
			
			shoppingcart=(Shoppingcart) session.getAttribute("shoppingcart");
			if (shoppingcart == null) {				
				return "redirect:/04/index";
			}
			shoppingcart.setNAME(Request.getParameter("name"));
			shoppingcart.setEMAIL(Request.getParameter("email"));
			shoppingcart.setTEL(Request.getParameter("tel"));
			shoppingcart.setADDRESS(Request.getParameter("add"));		

			
			return IdentityFilter.loginID+"04/front_saleTicket/Booking3";
		}	

		
		@RequestMapping(path = "/04/delectTicket.ctrl", method = RequestMethod.GET)
		public String Ticket(Model model ,HttpSession session,HttpServletRequest Request, String seat) {
			System.out.println("seat"+seat);
			String[] seats2 = {};
			List<String> seatlist = new ArrayList<String>();
			//取得SESSION 中seats
			shoppingcart=(Shoppingcart) session.getAttribute("shoppingcart");		
			String[] seats = shoppingcart.getSeats();
			 for (String s:seats) {
				 if (!s.equals(seat)) {	
							System.out.println(s);
							seatlist.add(s);
				}	
		     }
			 //將List<String>  seatlist 轉為String[]
			 seats2 = new String[ seatlist.size() ];
			 seatlist.toArray(seats2);
			 //塞回shoppingcart
			 shoppingcart.setSeats(seats2);
			 
			
			return IdentityFilter.loginID+"04/front_saleTicket/Booking2";
		}
		
		@RequestMapping(path = "/04/delectCart.ctrl", method = RequestMethod.GET)
		public String delectCart(Model model ,HttpSession session,HttpServletRequest Request) {
			//移除shoppingcart
			session.removeAttribute("shoppingcart");
			
			return IdentityFilter.loginID+"04/front_saleTicket/Booking2";
		}	
	
	
	
}

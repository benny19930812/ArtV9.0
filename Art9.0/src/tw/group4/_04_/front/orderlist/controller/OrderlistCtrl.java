package tw.group4._04_.front.orderlist.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.model.ShowBean;
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
			String memberID = Integer.toString(member.getId());

			List<Orderlist> orderlists = orderlistService.searchOrderlist(memberID);
			List<Map> list = new ArrayList<Map>();
			for (Orderlist orderlistBean : orderlists) {

				Map map = new HashMap();
				map.put("ORDERID", orderlistBean.getORDERID());
				map.put("NAME", orderlistBean.getNAME());
				map.put("EMAIL", orderlistBean.getEMAIL());
				map.put("TEL", orderlistBean.getTEL());
				map.put("ADDRESS", orderlistBean.getADDRESS());
				map.put("TITLE",orderlistBean.getTITLE());
				map.put("TICKETCATEGORY", orderlistBean.getTICKETCATEGORY());
				map.put("TICKET_NUM", orderlistBean.getTICKET_NUM());
				map.put("TOTALPRICE", orderlistBean.getTOTALPRICE());
				
				//將SeatString轉回STring[]
				String seatString = orderlistBean.getSeatstring();
				System.out.println(seatString);
				String[] seatarray = seatString.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
				for (String s : seatarray) {
					System.out.println(s);
				}
				map.put("seats",seatarray);
				list.add(map);// 將map集合放入list集合

				model.addAttribute("list", list);

			}
			return IdentityFilter.loginID + "04/front_Orderlist/ShowOrderlist";

		}
		
		
	}
	//show detail
//	@RequestMapping(path = "/04/OrderlistDetail.ctrl", method = RequestMethod.GET)
//	public String processOrderDetail(int actid,Model model) {
//		
//		System.out.println("actid="+actid);			
//		ShowBean showBean = showBeanService.select(actid);
//		
//		String title = showBean.getACT_TITLE();
//		String locationName = showBean.getACT_LOCATION_NAME();
//		String description = showBean.getACT_DESCRIPTION();
//		String startdate = showBean.getACT_STARTDATE();
//		String enddate = showBean.getACT_ENDDATE();
//		byte[] photo =showBean.getACT_PHOTO();
////		圖片byteArray透過Base64轉字串，輸出到html
//		String Photoencode = Base64.encodeBase64String(photo);
//		
//		model.addAttribute("actid", actid);
//		model.addAttribute("title", title);
//		model.addAttribute("site", locationName);
//		model.addAttribute("startdate", startdate);
//		model.addAttribute("enddate", enddate);
//		model.addAttribute("description", description);
//		model.addAttribute("photo", Photoencode);
//		
//		return IdentityFilter.loginID+"04/front_saleTicket/showDetail";
//	}

}

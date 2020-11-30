package tw.group4._04_.front.search.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4.util.IdentityFilter;

@Controller
public class Search_JspDirect {
	@RequestMapping(path = "/04/Booking1", method = RequestMethod.GET)
	public String processShowDetail(@ModelAttribute("showitem")ShowBean showBean,Model model ) {
		System.out.println(showBean.getACT_TITLE());
		System.out.println(showBean.getACT_LOCATION_NAME());
		System.out.println(showBean.getACT_NO());
		return IdentityFilter.loginID+"04/front/_04_ST/04_Booking";
	}
	
	@RequestMapping(path = "/04/index", method = RequestMethod.GET)
	public String processShowindex( ) {

		return IdentityFilter.loginID+"04/front_saleTicket/index_front";
	}
	
	@RequestMapping(path = "/04/showDetail", method = RequestMethod.POST)
	public String processShowdetail( ) {

		return IdentityFilter.loginID+"04/front_saleTicket/showDetail";
	}
	
	@RequestMapping(path = "/04/booking", method = RequestMethod.GET)
	public String processbookingnum( ) {

		return IdentityFilter.loginID+"04/front_saleTicket/Booking";
	}
	@RequestMapping(path = "/04/booking2", method = RequestMethod.GET)
	public String processbookingname( ) {

		return IdentityFilter.loginID+"04/front_saleTicket/Booking2";
	}
	@RequestMapping(path = "/04/booking3", method = RequestMethod.GET)
	public String processbookingdetail( ) {

		return IdentityFilter.loginID+"04/front_saleTicket/Booking3";
	}
}

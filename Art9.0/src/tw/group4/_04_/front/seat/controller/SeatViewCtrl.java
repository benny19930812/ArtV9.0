package tw.group4._04_.front.seat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4.util.IdentityFilter;

@Controller
public class SeatViewCtrl {
	
		@RequestMapping(path = "/04/seat", method = RequestMethod.GET)
		public String processShowDetail( ) {
			
			return IdentityFilter.loginID+"04/front/Seat/Seat";
		}
	

}

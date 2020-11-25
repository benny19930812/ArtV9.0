package tw.group4._04_.front.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hpsf.Array;
import org.springframework.ui.Model;

import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4.util.IdentityFilter;

public class arraytest {

	public static void main(String[] args) {
		String[] seats2 = {};
		List<String> seatlist = new ArrayList<String>();
		String[] seats = { "A1", "A2", "A3", "A4" };
		for (String s : seats) {
			if (!s.equals("A1")) {
				System.out.println(s);
				seatlist.add(s);
				
			}
			

		}
		
		for (String s : seatlist) {
			
				System.out.println("s2"+2);
		}
		seats2 = new String[ seatlist.size() ];
		seatlist.toArray(seats2);
		
		for (String s3 :seats2) {		
			System.out.println("s3"+s3);
	}
		
		
	}

}

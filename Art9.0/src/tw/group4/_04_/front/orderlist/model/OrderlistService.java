package tw.group4._04_.front.orderlist.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.model.ShowBeanDAO;

@Service
public class OrderlistService {
	
	private OrderlistDAO orderlistDAO;

	@Autowired
	public OrderlistService(OrderlistDAO orderlistDAO) {
		this.orderlistDAO = orderlistDAO;
	}
	
	public List<Orderlist> searchOrderlist(String memberID) {
		
		return orderlistDAO.searchOrderlist(memberID);
	}

}

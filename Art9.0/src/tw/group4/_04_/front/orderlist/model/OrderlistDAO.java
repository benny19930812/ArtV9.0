package tw.group4._04_.front.orderlist.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._04_.back.model.ShowBean2;

@Repository("OrderlistDAO")
public class OrderlistDAO {

	private SessionFactory sessionFacory;
	private Session session;

//	public SeatBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public OrderlistDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	// 新增
	public Orderlist insert(Orderlist shoppingcart) {
		Session session = sessionFacory.getCurrentSession();
//		SeatBean resultBean = session.get(SeatBean.class, SeatBean.getACT_NO());
//		if (resultBean == null) {
		session.save(shoppingcart);
		return shoppingcart;
//		}
//		return null;
	}


	// 查詢 //先將查詢結果放入MAP
	public Map<String, Integer> select(String memberid) {
		Session session = sessionFacory.getCurrentSession();
		Orderlist shoppingcart = session.get(Orderlist.class, memberid);

		Map<String, Integer> map = null;
		return map;
	}
	
	

	// 修改
	public Orderlist update(String memberid) {

		Session session = sessionFacory.getCurrentSession();
		Orderlist shoppingcart = session.get(Orderlist.class, memberid);

		if (shoppingcart != null) {
//			SeatBean.setACT_TITLE(title);
//			SeatBean.setACT_CATEGORY(category);
//			SeatBean.setACT_LOCATION(locationName);
//			SeatBean.setACT_MAINUNIT(mainunit);
//			SeatBean.setACT_SHOWUNIT(showunit);
//			SeatBean.setACT_DESCRIPTION(description);
//			SeatBean.setACT_STARTDATE(startdate);
//			SeatBean.setACT_ENDDATE(enddate);
		}

		return shoppingcart;
	}

	// 刪除
	public boolean delete(String memberid) {

		Session session = sessionFacory.getCurrentSession();
		Orderlist result = session.get(Orderlist.class, memberid);

		if (result != null) {
			session.delete(result);
			return true;
		}

		return false;
	}

	

	// 查詢會員訂單
	public List<Orderlist> searchOrderlist(String memberID) {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<Orderlist> query = session.createQuery("From Orderlist Odr where Odr.MEMBERID ="+memberID,Orderlist.class);
		List<Orderlist> list = query.list();
		return list;
	}

}

package tw.group4._04_.front.seat.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("SeatBeanDAO")
public class SeatBeanDAO {

	private SessionFactory sessionFacory;
	private Session session;


//	public SeatBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public SeatBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	// 新增
	public SeatBean insert(SeatBean SeatBean) {
		Session session = sessionFacory.getCurrentSession();
//		SeatBean resultBean = session.get(SeatBean.class, SeatBean.getACT_NO());
//		if (resultBean == null) {
			session.save(SeatBean);
			return SeatBean;
//		}
//		return null;
	}

//	// 查詢
//	public SeatBean select(int actno) {
//		Session session = sessionFacory.getCurrentSession();
//		return session.get(SeatBean.class, actno);
//	}
	
	
	// 查詢  //先將查詢結果放入MAP
		public Map<String, Integer> select(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean seatBean =session.get(SeatBean.class, actno);
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("A1",seatBean.getA1());
			SeatMap.put("A2",seatBean.getA2());
			SeatMap.put("A3",seatBean.getA3());
			SeatMap.put("A4",seatBean.getA4());
			SeatMap.put("A5",seatBean.getA5());
			SeatMap.put("A6",seatBean.getA6());
			SeatMap.put("A7",seatBean.getA7());
			SeatMap.put("A8",seatBean.getA8());
			SeatMap.put("A9",seatBean.getA9());
			SeatMap.put("A10",seatBean.getA10());
			SeatMap.put("B1",seatBean.getB1());
			SeatMap.put("B2",seatBean.getB2());
			SeatMap.put("B3",seatBean.getB3());
			SeatMap.put("B4",seatBean.getB4());
			SeatMap.put("B5",seatBean.getB5());
			SeatMap.put("B6",seatBean.getB6());
			SeatMap.put("B7",seatBean.getB7());
			SeatMap.put("B8",seatBean.getB8());
			SeatMap.put("B9",seatBean.getB9());
			SeatMap.put("B10",seatBean.getB10());
			SeatMap.put("C1",seatBean.getC1());
			SeatMap.put("C2",seatBean.getC2());
			SeatMap.put("C3",seatBean.getC3());
			SeatMap.put("C4",seatBean.getC4());
			SeatMap.put("C5",seatBean.getC5());
			SeatMap.put("C6",seatBean.getC6());
			SeatMap.put("C7",seatBean.getC7());
			SeatMap.put("C8",seatBean.getC8());
			SeatMap.put("C9",seatBean.getC9());
			SeatMap.put("C10",seatBean.getC10());
			SeatMap.put("D1",seatBean.getD1());
			SeatMap.put("D2",seatBean.getD2());
			SeatMap.put("D3",seatBean.getD3());
			SeatMap.put("D4",seatBean.getD4());
			SeatMap.put("D5",seatBean.getD5());
			SeatMap.put("D6",seatBean.getD6());
			SeatMap.put("D7",seatBean.getD7());
			SeatMap.put("D8",seatBean.getD8());
			SeatMap.put("D9",seatBean.getD9());
			SeatMap.put("D10",seatBean.getD10());
			SeatMap.put("E1",seatBean.getE1());
			SeatMap.put("E2",seatBean.getE2());
			SeatMap.put("E3",seatBean.getE3());
			SeatMap.put("E4",seatBean.getE4());
			SeatMap.put("E5",seatBean.getE5());
			SeatMap.put("E6",seatBean.getE6());
			SeatMap.put("E7",seatBean.getE7());
			SeatMap.put("E8",seatBean.getE8());
			SeatMap.put("E9",seatBean.getE9());
			SeatMap.put("E10",seatBean.getE10());

			return SeatMap;
		}


	

	// 修改
	public SeatBean update(int actno) {

		Session session = sessionFacory.getCurrentSession();
		SeatBean SeatBean = session.get(SeatBean.class, actno);

		if (SeatBean != null) {
//			SeatBean.setACT_TITLE(title);
//			SeatBean.setACT_CATEGORY(category);
//			SeatBean.setACT_LOCATION(locationName);
//			SeatBean.setACT_MAINUNIT(mainunit);
//			SeatBean.setACT_SHOWUNIT(showunit);
//			SeatBean.setACT_DESCRIPTION(description);
//			SeatBean.setACT_STARTDATE(startdate);
//			SeatBean.setACT_ENDDATE(enddate);
		}

		return SeatBean;
	}

	// 刪除
	public boolean delete(int actno) {

		Session session = sessionFacory.getCurrentSession();
		SeatBean result = session.get(SeatBean.class, actno);

		if (result != null) {
			session.delete(result);
			return true;
		}

		return false;
	}

	
}

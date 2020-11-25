package tw.group4._04_.front.seat.model;

import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.model.ShowBeanDAO;

@Service
public class SeatBeanService {

	private SeatBeanDAO seatBeanDAO;

	@Autowired
	public SeatBeanService(SeatBeanDAO seatBeanDAO) {
		this.seatBeanDAO = seatBeanDAO;
	}

//	// 新增
//	public SeatBean insert(SeatBean SeatBean) {
//		return seatBeanDAO.insert(SeatBean);
//	}

	// 查詢
	public Map<String, Integer> select(int actno) {
		return seatBeanDAO.select(actno);
	}

	// 修改
	public SeatBean update(int actno ) {
		return seatBeanDAO.update(actno);
	}

	// 刪除
	public boolean delete(int actno) {;
		return  seatBeanDAO.delete(actno);
	}

}

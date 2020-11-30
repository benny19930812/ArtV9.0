package tw.group4._04_.front.seat.model;

import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.cmsAct.model.ShowBeanDAO;

@Service
public class SeatBeanService {

	private SeatBeanDAO seatBeanDAO;

	@Autowired
	public SeatBeanService(SeatBeanDAO seatBeanDAO) {
		this.seatBeanDAO = seatBeanDAO;
	}

	// 新增
	public SeatBean insert(SeatBean SeatBean) {
		return seatBeanDAO.insert(SeatBean);
	}

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
	//插入座位
	public Boolean insert4Seat(String[] seats,String actno) {
		
		return seatBeanDAO.insert4Seat(seats,actno);
	}

	public Boolean insert3Seat(String[] seats,String actno) {

		return seatBeanDAO.insert3Seat(seats, actno);
	}

	public Boolean insert2Seat(String[] seats,String actno) {

		return seatBeanDAO.insert2Seat(seats,actno);
	}

	public Boolean insert1Seat(String[] seats,String actno) {
		
		return seatBeanDAO.insert1Seat(seats,actno);
	}
	//刪除座位
	public Boolean delete4Seat(String[] seats,String actno) {
		
		return seatBeanDAO.delete4Seat(seats,actno);
	}

	public Boolean delete3Seat(String[] seats,String actno) {

		return seatBeanDAO.delete3Seat(seats, actno);
	}

	public Boolean delete2Seat(String[] seats,String actno) {

		return seatBeanDAO.delete2Seat(seats,actno);
	}

	public Boolean delete1Seat(String[] seats,String actno) {
		
		return seatBeanDAO.delete1Seat(seats,actno);
	}

}

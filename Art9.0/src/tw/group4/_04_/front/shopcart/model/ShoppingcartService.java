package tw.group4._04_.front.shopcart.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.model.ShowBeanDAO;

@Service
public class ShoppingcartService {

	private ShoppingcartDAO shoppingcartDAO;

	@Autowired
	public ShoppingcartService(ShoppingcartDAO shoppingcartDAO) {
		this.shoppingcartDAO = shoppingcartDAO;
	}

	public Shoppingcart insert(Shoppingcart shoppingcart) {

			return shoppingcartDAO.insert(shoppingcart);

	}
//
//	// 查詢  //先將查詢結果放入MAP
//		public Map<String, Integer> select(String memberid) {
//
//			return shoppingcartDAO.select(memberid) ;
//		}
//			
//
//	// 修改
//	public Shoppingcart update(String memberid) {
//
//		return shoppingcartDAO.update(memberid);
//	}
//
//	// 刪除
//	public boolean delete(String memberid) {
//
//		return shoppingcartDAO.delete(memberid);
//	}
//	
	//訂單編號生成
	public  String getOrderIdByTime() {
			
		return shoppingcartDAO.getOrderIdByTime();
	
	}
//	
//	
//		

}

package tw.group4._14_.front.controller;


import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.OrderItemBeanAP;
import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._14_.front.model.ShoppingCartAP;
import tw.group4._14_.front.model.dao.OrderDaoService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.IdentityFilter;


@Controller
public class ComfirmProductController {
	
	@Autowired
	private OrderDaoService oDaoService;
	
	@RequestMapping(path = "/14/productListDelet.ctrl")
	public String productListDelet(HttpSession session, @RequestParam(name = "productIdAP") String productIdAP) {
		if (session == null) {      // 使用逾時
			
			return "redirect:/14/shopListController.ctrl";
		}
		
		ShoppingCartAP sCartAP = (ShoppingCartAP)session.getAttribute("carList");
		System.out.println("/14/productListDelet.ctrl");
		sCartAP.deleteProduct(productIdAP);
		
		return IdentityFilter.loginID+"14/14_OrderConfirm";
		
	}
	
	
	@RequestMapping(path = "/14/productListModify.ctrl")
	public String productListModify(HttpSession session, @RequestParam(name = "productIdAP") String productIdAP,
			@RequestParam(name = "newQty") int newQty) {
		
		 // 使用逾時
		if (session == null) {     
			return "redirect:/14/shopListController.ctrl";
		}
		
		ShoppingCartAP sCartAP = (ShoppingCartAP)session.getAttribute("carList");
		sCartAP.modifyQty(productIdAP, newQty);
		
		return IdentityFilter.loginID+"14/14_OrderConfirm";
	}
	
	@RequestMapping(path = "/14/AbortCart.ctrl")
	public String AbortCart(HttpSession session) {
		
        ShoppingCartAP cart = (ShoppingCartAP)session.getAttribute("carList");
		if (cart != null) {
			//由session物件中移除ShoppingCart物件
			session.removeAttribute("carList");
		}
		return "redirect:/14/shopListController.ctrl";
	}
	
	@RequestMapping(path = "/14/SubmitAPCart.ctrl")
	public String SubmitAPCart(HttpSession session) {
		if (session == null) {      // 使用逾時
			
			return "redirect:/14/shopListController.ctrl";
			
		}
		ShoppingCartAP sc = (ShoppingCartAP) session.getAttribute("carList");	
		if (sc == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			
			return "redirect:/14/shopListController.ctrl";
		}
		// 結帳
		return IdentityFilter.loginID+"14/14_CheckOrder";
	}
	
	
	@RequestMapping(path = "/14/ProcessOrder.ctrl")
	public String ProcessOrder(HttpSession session, @RequestParam(name = "Address") String Address, @RequestParam(name = "BNO") String BNO, 
			@RequestParam(name = "InvoiceTitle")String InvoiceTitle ) {
		System.out.println("---ProcessOrder.ctrl---");
		ShoppingCartAP sc = (ShoppingCartAP) session.getAttribute("carList");
		if (sc == null) {
			// 處理訂單時如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			
			return "redirect:/14/shopListController.ctrl";
		}
		
		
		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";

		}
		
		
		String memberID = Integer.toString(mb.getId());
//		String memberID = "測試用";
		int totalAmount = sc.getSubtotal();
		Date today = new Date();
		System.out.println("進入 ProcessOrderServlet");
		System.out.println(" memberID=" + memberID + ", addAP=" + Address
				+ ", bnoAP=" + BNO + ", orderTitleAP=" + InvoiceTitle+", date=" + today +", totalAmount="+totalAmount );
		
		OrderListBeamAP olb = new OrderListBeamAP(memberID, Address, BNO, InvoiceTitle,totalAmount, today);
		
		Set<OrderItemBeanAP> items = new HashSet<OrderItemBeanAP>();
		
		Map<String, ARTProduct> cartAP = sc.getCartAP();
		
		Set<String> keySet = cartAP.keySet();
		
		for (String i : keySet) {
			ARTProduct pi = cartAP.get(i);
			
			OrderItemBeanAP oibAP = new OrderItemBeanAP(pi.getProductTitle(), pi.getProductNum(), pi.getProductPrice());
			oibAP.setOrderListBeamAP(olb); //OneToMany
			items.add(oibAP);
			System.out.println("oibAP:"+oibAP);
			
		}
		System.out.println("olb.getOrderTitleAP():"+olb.getOrderTitleAP());
		olb.setItems(items);
		try {
			oDaoService.persistOrder(olb);
			session.removeAttribute("carList");
			return IdentityFilter.loginID+"14/14_Thank";
		} catch(Exception ex){
			
			ex.printStackTrace();
			return "redirect:/14/shopListController.ctrl";
		}
		
		
	}
	
	@RequestMapping(path = "/14/OrderDetial.ctrl")
	public String orderListProcesses(Model m, @RequestParam(name = "orderNo")int orderNo) {
		OrderListBeamAP order = oDaoService.getOrder(orderNo);
		m.addAttribute("OrderBean", order);
		return IdentityFilter.loginID+"14/14_OrderDetail";
		
	}
	

}

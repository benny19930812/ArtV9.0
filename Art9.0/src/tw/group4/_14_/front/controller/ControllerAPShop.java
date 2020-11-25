package tw.group4._14_.front.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.front.model.ShoppingCartAP;
import tw.group4.util.IdentityFilter;



@Controller
public class ControllerAPShop {

	@Autowired
	private ProductBeanDAOService pDaoservice;
	
	@Autowired
	ServletContext ctx;

	@RequestMapping(path = "/14/shopListController.ctrl", method = RequestMethod.GET)
	public String creatShopList(Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query, HttpSession session) {

		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");
		
		// 判斷購物車不存在時的導向
		if (carList == null) {
			carList = new ShoppingCartAP();
	        session.setAttribute("carList", carList);
		}

		// 有無參數判斷
		if (query != "" && query != null) {

			// 有參數起始
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> queryList = pDaoservice.selectQueryAll(pageNo, query);

			int totalPage = pDaoservice.getQueryPages(query);

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			

			m.addAttribute("queryList", queryList);
			m.addAttribute("query", query);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);
			m.addAttribute("pageNo", pageNo);

			// 有參數終了
		} else {

			// 無參數起始點
			if (pageNo == null || pageNo == 0) {
				pageNo = 1;
			}

			List<ARTProduct> pList = pDaoservice.selectAll(pageNo);
			int totalPage = pDaoservice.getTotalPages();

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

			m.addAttribute("pList", pList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);

		}
		
		Map<String, ARTProduct> cartAP = carList.getCartAP();
		int size = cartAP.size();
		session.setAttribute("carSize", size);
//		m.addAttribute("carSize", size);
//		return IdentityFilter.loginID+"14/14_index";
		return IdentityFilter.loginID+"14/14_NewIndex";
	}

	//不用了
	@RequestMapping(path = "/14/showOneProduct.ctrl", method = RequestMethod.GET)
	public String showOneProduct(Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "productID") String productID, @RequestParam(name = "orderPrice") String orderPrice,
			@RequestParam(name = "orderImg") String orderImg, @RequestParam(name = "orderNum") int orderNum,
			@RequestParam(name = "orderDes") String orderDes, @RequestParam(name = "orderTitle") String orderTitle) {

		ARTProduct product = new ARTProduct();

		product.setProductId(productID);
		product.setProductTitle(orderTitle);
		product.setProductNum(orderNum);
		product.setProductPrice(orderPrice);
		product.setProductDes(orderDes);
		product.setProductImg(orderImg);

		List<Integer> stockNum = new ArrayList<Integer>();
		for (int i = 1; i <= orderNum; i++) {
			stockNum.add(i);
		}
		m.addAttribute("stockNum", stockNum);
		m.addAttribute("oneProsuct", product);
		m.addAttribute("query", query);
		return IdentityFilter.loginID+"14/14_showOnePdF";
	}
	
	
	@RequestMapping(path = "/14/showOneProduct2.ctrl", method = RequestMethod.GET)
	public String showOneProduct2(Model m, @RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "productID") String productID) {
		
		ARTProduct ap = pDaoservice.select(productID);
		m.addAttribute("oneProsuct", ap);
		m.addAttribute("query", query);
		
		return IdentityFilter.loginID+"14/14_showOnePdF";
	}

	@RequestMapping(path = "/14/SubmitProcess.ctrl", method = RequestMethod.GET)
	public String SubmitProcess(Model m, HttpSession session, HttpServletRequest request,
			@RequestParam(name = "carSize", required = false) Integer carSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "productID") String productID, @RequestParam(name = "orderPrice") String orderPrice,
			@RequestParam(name = "orderImg") String orderImg, @RequestParam(name = "orderNum") int orderNum,
			@RequestParam(name = "orderTitle") String orderTitle) {
		
		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");

		if (carList == null) {
			carList = new ShoppingCartAP();
			session.setAttribute("carList", carList);
		}

		ARTProduct product = new ARTProduct();

		product.setProductId(productID);
		product.setProductTitle(orderTitle);
		product.setProductNum(orderNum);
		product.setProductPrice(orderPrice);
		product.setProductImg(orderImg);

		synchronized (this) {

			carList.addToCarAP(productID, product);

		}

		Map<String, ARTProduct> cartAP = carList.getCartAP();
		Set set = cartAP.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			ARTProduct value = (ARTProduct) cartAP.get(key);
			System.out.println(key + "====" + value);
		}

		System.out.println("------cartAP.size()------"+cartAP.size());
//		session.setAttribute("carList", carList);
		

		return "redirect:/14/shopListController.ctrl";
	}

	@RequestMapping(path = "/14/gotoCart.ctrl")
	public String gotoCart(HttpSession session) {

		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");
		if (carList == null) {

//			return "redirect:/14/shopListController.ctrl";
			return "14_CRUDPage";
		} else {

			return IdentityFilter.loginID+"14/14_OrderConfirm";

		}

	}
	
	@RequestMapping(path = "/14/getBlobImage/{pdid}.ctrl")
	@ResponseBody
	public ResponseEntity<byte[]> getBlobImage(@PathVariable(name = "pdid") String pdId){
		ResponseEntity<byte[]> re = null;
		ARTProduct pd = pDaoservice.select(pdId);
		
//		byte[] byt = pd.getProductImgBlob();
		String mimeType = ctx.getMimeType("ThisIsFake.jpg");
		MediaType mediaType = MediaType.valueOf(mimeType);
		HttpHeaders headers = new HttpHeaders();
		
		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			InputStream is = blob.getBinaryStream();
//			byte[] b = new byte[81920];
//			int len = 0;
//			while ((len = is.read(b)) != -1) {
//				baos.write(byt, 0, len);
//			}
			headers.setContentType(mediaType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue()); //設定取消 cache
//			re = new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
			re = new ResponseEntity<byte[]>(pd.getProductImgBlob(), headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
		
	}
	
	

}

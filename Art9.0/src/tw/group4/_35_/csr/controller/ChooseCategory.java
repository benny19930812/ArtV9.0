package tw.group4._35_.csr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.csr.model.InterfaceActivityService;
import tw.group4._35_.geo.model.Activity;
import tw.group4.util.IdentityFilter;

@Controller
public class ChooseCategory {
	
	@Autowired
	InterfaceActivityService mtService;
	
	@RequestMapping(path = "/35/chooseCategory.ctrl")
	public String chooseCategory(@RequestParam(name = "activity_category") String actType, Model m) {
		
		int typeCode = Integer.parseInt(actType);
		//控制器先交棒給服務層去查詢
		//把活動代碼傳入service層，service層會再去設定dao層屬性活動代碼的值
		//此時原先空白的service物件，已設定好屬性活動代碼的值
		//服務層內再叫出資料存取層的底層方法去查詢對應值的資料
		List<Activity> list = mtService.selectDBtoActbyCat(typeCode);
		//轉類別代號為中文字串
		String str="";
		switch(typeCode) {
		case 1: str="音樂"; break;
		case 2: str="戲劇"; break;
		case 3: str="舞蹈"; break;
		case 4: str="親子"; break;
		case 5: str="獨立音樂"; break;
		case 6: str="展覽"; break;
		case 7: str="講座"; break;
		case 8: str="電影"; break;
		case 11: str="綜藝"; break;
		case 13: str="競賽"; break;
		case 14: str="徵選"; break;
		case 15: str="其他"; break;
		case 16: str="未知分類"; break;
		case 17: str="演唱會"; break;
		case 19: str="研習課程"; break;
		}
		
		m.addAttribute("categoryList", list);
		m.addAttribute("categoryName", str);
		return IdentityFilter.loginID+"35/csr/listActs";

	}
}
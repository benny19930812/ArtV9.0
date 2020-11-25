//package tw.group4._35_.cms.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import tw.group4._35_.cms.model.EventSpace;
//import tw.group4._35_.cms.model.InterfaceEventSpaceService;
//
//@Controller
//public class Select {
//	
//	@Autowired
//	private InterfaceEventSpaceService esService;
//	
//	@RequestMapping(path = "/35/select.ctrl", method = RequestMethod.GET)
//	public String select(@RequestParam(name="select")String selectStr, Model m) {
//		
//		InterfaceEventSpaceService service = esService;
//		List<EventSpace> list = service.select(selectStr);
//		
//		m.addAttribute("eventSpaceList", list);
//		
//		return "35/cms/eventSpaceSelectResult";	
//	}
//}

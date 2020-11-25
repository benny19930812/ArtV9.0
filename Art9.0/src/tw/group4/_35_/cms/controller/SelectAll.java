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
//public class SelectAll {
//	
//	@Autowired
//	private InterfaceEventSpaceService esService;
//	
//	@RequestMapping(path = "/35/selectAll.ctrl", method = RequestMethod.GET)
//	public String selectAll(Model m) {
//		
//		InterfaceEventSpaceService service = esService;
//		List<EventSpace> list = service.selectAll();
//		m.addAttribute("eventSpaceList",list);
//		return "35/cms/eventSpaceList";
//	}
	
//	@RequestMapping(path = "/35/selectAllAfterDelete.ctrl", method = RequestMethod.GET)
//	public String selectAllAfterDelete(@RequestParam(name = "deleteResult")String deleteStr, Model m) {
//		
//		InterfaceEventSpaceService service = esService;
//		List<EventSpace> list = service.selectAll();
//		m.addAttribute("deleteResult", deleteStr);
//		m.addAttribute("eventSpaceList",list);
//		return "35/cms/eventSpaceList";
//	}
//}

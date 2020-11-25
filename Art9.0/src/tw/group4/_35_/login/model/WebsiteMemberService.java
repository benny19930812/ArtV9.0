package tw.group4._35_.login.model;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WebsiteMemberService {

	private WebsiteMemberDao dao;

	@Autowired
	public WebsiteMemberService(WebsiteMemberDao dao) {
		this.dao = dao;
	}
	
	public WebsiteMember insert(WebsiteMember wmBean) {
		return dao.insert(wmBean);
	}
	
	//按id讀取資料庫內會員的方法
	public WebsiteMember selectById(int id) {
		return dao.selectById(id);
	}
	
	//傳入登入表單輸入會員資料進行驗證的方法
	public Boolean checkLogin(WebsiteMember member) {
		return dao.checkLogin(member);
	}
	
	//傳入登入表單輸入會員名確認無重複的方法
	public Boolean checkNameExsist(String name) {
		return dao.checkNameExsist(name);
	}
	
	//傳入登入表單輸入會員資料，回傳會員完整資料放到session
	public WebsiteMember getMemberFullInfo(WebsiteMember member) {
		return dao.getMemberFullInfo(member);
	}
	
	//傳入登入表單輸入會員資料，回傳會員完整資料+圖片ByteArray放到session
	public byte[] getMemberPicByteArray(WebsiteMember member) {
		WebsiteMember memberResult = dao.getMemberFullInfo(member);
		Blob blob = memberResult.getMemberPic();
		
//		Blob轉byteArray須設定Blob.getBytes(long pos, int length)
		byte[] byteArray = null;
		try {
			byteArray = blob.getBytes(1, (int) blob.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return byteArray;
	}
	
//	查詢會員表格所有資料
	public List<WebsiteMember> selectAllMembers(){

		return dao.selectAllMembers();
	}
	
}

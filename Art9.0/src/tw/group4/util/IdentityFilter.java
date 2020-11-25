package tw.group4.util;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tw.group4._35_.login.model.WebsiteMember;

@WebFilter("/*")
public class IdentityFilter implements Filter {

	public static String loginID;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

//		System.out.println("IdentityFilter Begin: 過濾器尚未判斷, 讀取前次設定的loginID: " + loginID);
		
		String memberType = setLoginID(request);

		System.out.println("IdentityFilter End: 經過濾器判斷, 使用者身份: " + memberType + "; 視角(loginID): " + loginID);
		System.out.println("------------------------------------------------------------------------------");

		chain.doFilter(request, response);

	}
	
	public String setLoginID(ServletRequest request) {
		
//		先取得session和初始化memberType變數
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		String memberType = null;
		
//		如果session內有member屬性，也就是登入狀態，session內有memberType的值
//		取出memberType的值，再switch case設定loginID的值
		if (Objects.nonNull(session.getAttribute("member"))) {
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			memberType = member.getMemberType();
			switch (memberType) {
			case ("user"):
				loginID = "b/";
				break;
			case ("admin"):
				loginID = "c/";
				break;
			case ("userMemberArea"):
				loginID = "d/";
				break;
			case ("adminMemberArea"):
				loginID = "e/";
				break;
			case ("adminBackstage"):
				loginID = "f/";
				break;
//			例外狀況：session有member屬性卻不是上述的memberType值，強制重設為訪客視角
			default:
				loginID = "a/";
			}
//		其餘沒登入狀態，i.e.session內沒有member屬性，給訪客視角
		}else {
			System.out.println("session內沒有member屬性");
			memberType = "visitor";
			loginID = "a/";
		}
		
		return memberType;
	}

}

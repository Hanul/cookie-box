package co.hanul.mr.dev.web.showcase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hanul.mr.dev.web.CookieBox;

@WebServlet("/CookieBoxShowcase")
public class CookieBoxShowcase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAny(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAny(request, response);
	}
	
	private void doAny(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieBox cb = new CookieBox(request);
		String cn = "testCookie";
		
		// 쿠키 존재 유무 확인
		if (cb.exists(cn)) {
			System.out.println("쿠키가 존재합니다.");
			
			// 쿠키 내용 출력
			System.out.println(cb.getValue(cn));
		} else {
			System.out.println("쿠키가 존재하지 않습니다.");
		}
		
		// 쿠키 삽입
		response.addCookie(CookieBox.createCookie(cn, "This is Cookie!"));
	}

}

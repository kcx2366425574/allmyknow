package sso;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 2019-09-04
 * @author kcx
 * @description ͬ单点登录
 */
public class SSOTest {

	public String dologin(HttpServletResponse response,HttpServletRequest request) {
		Cookie cookie = new Cookie("SSOCookie", "sso");
		cookie.setPath("/");
		response.addCookie(cookie);
		return "SUCCESS";
	}
}

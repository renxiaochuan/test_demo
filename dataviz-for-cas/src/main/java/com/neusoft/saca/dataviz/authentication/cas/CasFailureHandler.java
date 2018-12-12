package com.neusoft.saca.dataviz.authentication.cas;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CasFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		this.writePrompt(response);
	}

	/**
	 * @param response
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	protected void writePrompt(final HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<script type=\"text/javascript\">");
		sb.append("alert(\"无该应用访问权限。\");");
		sb.append("</script>");
		sb.append("</body>");
		sb.append("</html>");
		OutputStream os = response.getOutputStream();
		os.write(sb.toString().getBytes("utf-8"));
		os.flush();
	}
}

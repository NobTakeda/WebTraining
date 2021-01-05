package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import model.Person;

@WebServlet("/contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=null;
		String mode=request.getParameter("mode");
		if(mode==null || mode.equals("back")) {
			path="/WEB-INF/view/form.jsp";

		} else {
			HttpSession session = request.getSession();
			Person person = (Person) session.getAttribute("person");
			StringBuilder sb = new StringBuilder();
			sb.append("以下のように受け付けました");
			sb.append(System.lineSeparator());
			sb.append("お名前:" + person.getName());
			sb.append(System.lineSeparator());
			sb.append("email:" + person.getEmail());
			sb.append(System.lineSeparator());
			sb.append("お問い合わせ内容:" + person.getMemo());
			sb.append(System.lineSeparator());

			try {
				Email email = new SimpleEmail();
				email.setHostName("smtp.mail.yahoo.co.jp");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("muzat_yakuzajeep@yahoo.co.jp", "tendon1943"));
				email.setSSLOnConnect(true);
				email.setFrom("muzat_yakuzajeep@yahoo.co.jp");
				email.setSubject("お問い合わせありがとうございます。");
				email.setMsg(sb.toString());
				email.addTo(person.getEmail());
				email.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
			session.invalidate();
			path = "/WEB-INF/view/send.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
		/*
		}else if(mode.equals("send")){
			path="/WEB-INF/view/send.jsp";
			HttpSession session=request.getSession();
			session.invalidate();//セッションスコープ破棄
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String memo=request.getParameter("memo");
		Person person=new Person(name,email,memo);
		HttpSession session=request.getSession();
		session.setAttribute("person", person);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/confirm.jsp");
		rd.forward(request, response);
	}

}

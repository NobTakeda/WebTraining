package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.ItemShop;

@WebServlet("/OpenShop")
public class OpenShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OpenShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/open.jsp");
		dr.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String count=request.getParameter("count");
		int typeNum=Integer.parseInt(type);
		int countNum=Integer.parseInt(count);
		Item item=new Item(name,typeNum);
		ItemShop itemshop=new ItemShop("よろずや");
		itemshop.setItems(item, countNum-1);
		session.setAttribute("ItemShop", itemshop);
		if(countNum<3) {
			RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/open.jsp");
			dr.forward(request, response);
		}
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/enough.jsp");
		dr.forward(request,response);
	}
}

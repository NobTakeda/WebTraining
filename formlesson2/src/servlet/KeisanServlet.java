package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/KeisanServlet")
public class KeisanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KeisanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strA=request.getParameter("a");
		String strB=request.getParameter("b");
		int numA=Integer.parseInt(strA);
		int numB=Integer.parseInt(strB);
		int sum=numA+numB;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>計算結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>("+numA+")+("+numB+")="+(numA+numB)+"</p>");
		out.printf("<p>(%d)+(%d)=%d%n</p>", numA,numB,sum);
		out.print("<a href='formlesson2.jsp'>戻る</a>");
		//out.println("<button type=“button”
		//onclick=\"location.href='http://localhost:8080/formlesson2/formlesson2.jsp'\">戻る</button>");
		out.println("</body>");
		out.println("</html>");
	}
}

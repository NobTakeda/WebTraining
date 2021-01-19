package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Main")
@MultipartConfig//この記述を忘れがちなので注意！
//ファイルをアップロードする時は必ずこのアノテーションが必要となる。
/*
@MultipartConfig(
location="/tmp/files", アップロードファイルを一時的に保存するフォルダパス
maxFileSize=1000000, アップロードファイルの最大サイズ(バイト)
maxRequestSize=1000000, リクエストデータの最大サイズ(バイト)
fileSizeThreshold=1000000 一時保存するファイルサイズの閾値(バイト)
)
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String word=request.getParameter("word");
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=request.getPart("pict");
		//partのファイル名を取得
		String filename=part.getSubmittedFileName();
		//アップロードするフォルダを指定
		String path=getServletContext().getRealPath("/upload");
		//↑はIE非対応の書き方なので、↓で書いた方が安全
		//String filename=Paths.get(part..getSubmittedFileName()).getFileName().toString();
		System.out.println(path);//デバッグとしてパス表示
		//書き込み処理
		part.write(path+File.separator+filename);
		request.setAttribute("name",name);
		request.setAttribute("word", word);
		request.setAttribute("filename",filename);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request,response);
	}

}

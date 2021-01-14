package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Todo;


public class TodoDAO {
	private Connection db;//todoappデータベースに接続されたコネクション
	private PreparedStatement ps;//sql文を保持する変数
	private ResultSet rs;//結果セット(SQL文を実行した結果の集合)を保持

	//接続処理
	private void connect() throws NamingException,SQLException {
		Context context=new InitialContext();
		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/jsp");
		//上の呼び出しでcontextの/jdbc/jspを見に行く(java:comp/env/まではお決まり)
		db=ds.getConnection();
	}
	//切断処理
	private void disconnect() {
		try {
			if(rs !=null) {
				rs.close();
			}if(ps !=null) {
				ps.close();
			}if(db !=null) {
				db.close();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public List<Todo> findAll(){
		List<Todo> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM todos ORDER BY importance DESC");
			rs=ps.executeQuery(); //Query…データベースに対する命令文
			while(rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("title");
				int importance=rs.getInt("importance");
				Todo todo=new Todo(id,title,importance);
				list.add(todo);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	//新しいtodoデータを挿入するメソッド
	public void insertOne(Todo todo) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO todos(title,importance) VALUES(?,?)");
			ps.setString(1, todo.getTitle());
			ps.setInt(2,todo.getImportance());
			ps.executeUpdate(); //sql文を実行してアップデート
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	//idを指定したらその情報を返すメソッド
	public Todo findOne(int id) {
		Todo todo=null;//returnを先に返すためにnullで指定
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM todos WHERE id=?");
			ps.setInt(1, id);//1つめの?にidをいれる
			rs=ps.executeQuery();
			if(rs.next()) {
				String title=rs.getString("title");
				int importance=rs.getInt("importance");
				todo=new Todo(id,title,importance);
				//このtodoを返却する
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return todo;
	}
	public void updateOne(Todo todo) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE todos SET title=?,importance=? WHERE id=?");
			ps.setString(1, todo.getTitle());
			ps.setInt(2, todo.getImportance());
			ps.setInt(3, todo.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM todos WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}
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

import model.Mutter;

public class DocoDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

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
			e.printStackTrace();
		}
	}
	public List<Mutter> findAll(){
		List<Mutter> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM mutters ORDER BY id DESC");
			rs=ps.executeQuery(); //Query…データベースに対する命令文
			while(rs.next()) {
				String text=rs.getString("text");
				String userName=rs.getString("userName");
				Mutter mutter=new Mutter(userName,text);
				list.add(mutter);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	//新しいtodoデータを挿入するメソッド
	public void insertOne(Mutter mutter) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO mutters(userName,text) VALUES(?,?)");
			ps.setString(1, mutter.getUserName());
			ps.setString(2,mutter.getText());
			ps.executeUpdate(); //sql文を実行してアップデート
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	//idを指定したらその情報を返すメソッド
	public Mutter findOne(int id) {
		Mutter mutter=null;//returnを先に返すためにnullで指定
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM mutters WHERE id=?");
			ps.setInt(1, id);//1つめの?にidをいれる
			rs=ps.executeQuery();
			if(rs.next()) {
				String text=rs.getString("text");
				String userName=rs.getString("userName");
				mutter=new Mutter(userName,text);
				//このtodoを返却する
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return mutter;
	}
}

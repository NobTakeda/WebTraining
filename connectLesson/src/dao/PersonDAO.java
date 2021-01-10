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

import model.Person;

public class PersonDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;
	//接続共通処理
	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();//左は　クラス(Listと同じ)、右が実クラス
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");//java:comp/env/まではいつも同じ。context内で設定したjdbc,jsp
		this.db = ds.getConnection();//コンテキストのjdbc,jspの情報を元に、設定したURLへの接続を試みる
	}
	//切断共通処理
	private void disconnect() {//接続と切断はコピペでもよい
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//コピペでよいのはここまで
	}
	public List<Person> findAll(){
		List<Person> list=new ArrayList<>();
		try {
			this.connect();//上で作った接続メソッドを実行
			ps=db.prepareStatement("SELECT * FROM persons");//connect()でDBに接続しているインスタンスをpsに格納 *prepare(準備する)
			//prepareしたdbをPreparedStatementとして返している。
			rs=ps.executeQuery();//executeQuery(結果セット)
			while(rs.next()){//hasnextと同じ。rsが次の要素(今回はPerson)を保持していたらtrue
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				list.add(new Person(id,name,age));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
		return list;
	}
	public void insertOne(Person person) {
		try {
			this.connect();
			//VALUESを?にすることで、文章の入力の手間を抑える。
			//VALUEにSQL文を入れて送信することでデータを改竄する、SQLインジェクション攻撃も防げる
			ps=db.prepareStatement("INSERT INTO persons(name,age) VALUES(?,?)");
			//配列と違い、データベースのVALUEはidは1から始まる。
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			//executeUpdate()で、単純にSQL文を実行する。
			ps.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public Person findOne(int id) {
		Person person=null;//こことreturnを先に記述することで、eclipseの赤線を消せる(推奨
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM persons WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				int age=rs.getInt("age");
				person=new Person(id,name,age);
			}
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return person;
	}
	public void updateOne(Person person) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE persons SET name=?,age=? WHERE id=?");
			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setInt(3, person.getId());
			ps.executeUpdate();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM persons WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

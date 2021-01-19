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

import model.Donut;

public class DonutDAO {

	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException,SQLException{
		Context context=new InitialContext();
		DataSource ds=(DataSource) context.lookup("java:comp/env/donutapp");
		this.db = ds.getConnection();
	}

	private void disconnect()  {
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
		}
	}
	public void ConnectCheck() {
		try {
			this.connect();
			System.out.println("OK");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public void insertOne(Donut donut) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO donuts(name,price,imgname) VALUES(?,?,?)");
			ps.setString(1, donut.getName());
			ps.setInt(2, donut.getPrice());
			ps.setString(3, donut.getImgname());
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public List<Donut> findAll(){
		List<Donut> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM donuts");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("name");
				int price=rs.getInt("price");
				String imgname=rs.getString("imgname");
				list.add(new Donut(id,title,price,imgname));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	public Donut findOne(int id) {
		Donut donut=null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM donuts WHERE id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String imgname=rs.getString("imgname");
				donut=new Donut(id,name,price,imgname);
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return donut;
	}
	public void updateOne(Donut donut) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE donuts SET name=?,price=?,imgname=? WHERE id=?");
			ps.setString(1, donut.getName());
			ps.setInt(2, donut.getPrice());
			ps.setString(3, donut.getImgname());
			ps.setInt(4, donut.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM donuts WHERE id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

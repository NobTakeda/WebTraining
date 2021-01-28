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

import model.Health;

public class CalDAO2 {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/mycalapp");
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
	public void insertOne(Health health) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO users(name,gender,height,weight,bmi,cal,targetCal)"
					+ " VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, health.getName());
			ps.setInt(2, health.getGender());
			ps.setDouble(3, health.getHeight());
			ps.setDouble(4, health.getWeight());
			ps.setDouble(5, health.getBmi());
			ps.setInt(6,health.getCal());
			ps.setInt(7, health.getTargetCal());
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public List<Health> findAll(){
		List<Health> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM users");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int gender=rs.getInt("gender");
				Double height=rs.getDouble("height");
				Double weight=rs.getDouble("weight");
				Double bmi=rs.getDouble("bmi");
				int cal=rs.getInt("cal");
				int targetCal=rs.getInt("targetCal");
				list.add(new Health(id,name,gender,height,weight,bmi,cal,targetCal));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	public void updateOne(Health health) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE users SET name=?,gender=?,height=?,weight=?,bmi=?,cal=?,targetCal=? WHERE id=?");
			ps.setString(1, health.getName());
			ps.setInt(2, health.getGender());
			ps.setDouble(3, health.getHeight());
			ps.setDouble(4, health.getWeight());
			ps.setDouble(5, health.getBmi());
			ps.setInt(6,health.getCal());
			ps.setInt(7, health.getTargetCal());
			ps.setInt(8,health.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}

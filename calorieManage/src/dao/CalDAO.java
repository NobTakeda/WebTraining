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

import model.Food;
import model.FoodOfDay;

public class CalDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/calorieManage");
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
	public void insertOne(Food food) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO foods(name,cal,time_id,updated)"
					+ " VALUES(?,?,?,?)");
			ps.setString(1, food.getName());
			ps.setInt(2, food.getCal());
			ps.setInt(3, food.getTime());
			ps.setString(4, food.getDate());
			System.out.println("insertOne実行"+ps);
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public List<Food> findAll(){
		List<Food> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM foods");
			System.out.println("findAll実行"+ps);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int cal=rs.getInt("cal");
				int time=rs.getInt("time_id");
				String date=rs.getString("updated");
				list.add(new Food(id,name,cal,time,date));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}
	//指定した日付に登録したFoodを全て返すメソッド
	public List<Food> findToday(String date){
		List<Food> list=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM foods WHERE updated=? ORDER BY time_id ASC");
			ps.setString(1, date);
			System.out.println("FindToday実行"+ps);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int cal=rs.getInt("cal");
				int time=rs.getInt("time_id");
				String updated=rs.getString("updated");
				String timeStr="";
				switch(time) {
				case 0:
					timeStr="朝";
					break;
				case 1:
					timeStr="昼";
					break;
				case 2:
					timeStr="晩";
					break;
				}
				list.add(new Food(id,name,cal,time,updated,timeStr));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}
	//1日の朝、昼、晩、合計のカロリーをfodテーブルに登録
	public void insertFOD(FoodOfDay fod) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO fod(breakfastCal,lunchCal,supperCal,totalCal,updated)"
					+ " VALUES(?,?,?,?,?)");
			ps.setInt(1, fod.getBreakfastCal());
			ps.setInt(2, fod.getLunchCal());
			ps.setInt(3, fod.getSupperCal());
			ps.setInt(4, fod.getTotalCal());
			ps.setString(5, fod.getDate());
			System.out.println("insertFOD実行"+ps);
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	public FoodOfDay findOneFOD(String date) {
		FoodOfDay fod=new FoodOfDay();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM fod WHERE updated=?");
			ps.setString(1, date);
			System.out.println("findOneFOD実行"+ps);
			rs=ps.executeQuery();
			while(rs.next()) {
			fod.setId(rs.getInt("id"));
			fod.setBreakfastCal(rs.getInt("breakfastCal"));
			fod.setLunchCal(rs.getInt("lunchCal"));
			fod.setSupperCal(rs.getInt("supperCal"));
			fod.setTotalCal(rs.getInt("totalCal"));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return fod;
	}
	//fodテーブルを返す
	public List<FoodOfDay> findFOD(String showDate){
		List<FoodOfDay> fodList=new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM fod WHERE updated<=? ORDER BY updated DESC LIMIT 7");
			ps.setString(1,showDate);
			System.out.println("findFOD(fodテーブルにデータがあるかチェック)実行"+ps);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				int breakfastCal=rs.getInt("breakfastCal");
				int lunchCal=rs.getInt("lunchCal");
				int supperCal=rs.getInt("supperCal");
				int totalCal=rs.getInt("totalCal");
				String date=rs.getString("updated");
				System.out.printf("id=%d,朝=%d,昼=%d,晩=%d,合計=%d,日付=%s%n",id,breakfastCal,lunchCal,supperCal,totalCal,date);
				fodList.add(new FoodOfDay(id,breakfastCal,lunchCal,supperCal,totalCal,date));
			}
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return fodList;
	}
	public void updateFOD(FoodOfDay fod) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE fod SET breakfastCal=?,lunchCal=?,supperCal=?,totalCal=? WHERE updated=?");
			ps.setInt(1, fod.getBreakfastCal());
			ps.setInt(2, fod.getLunchCal());
			ps.setInt(3, fod.getSupperCal());
			ps.setInt(4, fod.getTotalCal());
			ps.setString(5, fod.getDate());
			System.out.println("updateFOD:fodテーブル更新"+ps);
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void deleteFood(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM foods WHERE id=?");
			ps.setInt(1, id);
			System.out.println("でぇてFood実行"+ps);
			ps.execute();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}
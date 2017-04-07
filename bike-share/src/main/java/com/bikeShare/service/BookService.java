package com.bikeShare.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bikeShare.configuration.DBConnection;

public class BookService implements Serializable {
	private int bk_id;
	private String modelname; // year or brand name fine
	private String type; // for adult or childrens or teens
	private Date share_date; // for additional comments
	private Date booked_date; // for current status ( good/average/bad )
	private String bookingstatus;
	private String firstname;
	private Integer mobileNo;
	private String comments;
	private String conditionstatus;
	private String bikeowner;
	private Integer share_book_id;
	private String notes;

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public int getBk_id() {
		return bk_id;
	}

	public void setBk_id(int bk_id) {
		this.bk_id = bk_id;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getShare_date() {
		return share_date;
	}

	public void setShare_date(Date share_date) {
		this.share_date = share_date;
	}

	public Date getBooked_date() {
		return booked_date;
	}

	public void setBooked_date(Date booked_date) {
		this.booked_date = booked_date;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getShare_book_id() {
		return share_book_id;
	}

	public void setShare_book_id(Integer share_book_id) {
		this.share_book_id = share_book_id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getBikeowner() {
		return bikeowner;
	}

	public void setBikeowner(String bikeowner) {
		this.bikeowner = bikeowner;
	}

	public String getConditionstatus() {
		return conditionstatus;
	}

	public void setConditionstatus(String conditionstatus) {
		this.conditionstatus = conditionstatus;
	}

	public List<BookService> getcurrentBookingsById(Integer userid) {
		List<BookService> currentbookingsbikelist = new ArrayList<BookService>();

		con = DBConnection.getConnection();
		// String sql = "SELECT
		// bk.id,bk.modelname,bk.type,bk.comments,bk.conditionstatus,bk.sharestatus,us.user
		// bikeowner FROM bikes bk,users us where bk.user_id=us.id and
		// bk.sharestatus='on' and bk.deleted='no'";
		String sql = "SELECT sb.id shbid,bk.id bk_id , bk.modelname modelname, bk.type type, sb.share_date share_date,sb.booked_date bkdate,bk.type biketype,sb.bookingstatus bookingstatus ,us.mobileNo mobileNo,us.first_name firstname "
				+ "FROM shares_and_bookings sb,bikes bk,app_user us "
				+ "WHERE bk.id=sb.bike_id and sb.bookingstatus='Booked' and bk.owner_id=us.id ";
		// + "and us.id != '"+userid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				BookService bk = new BookService();
				bk.setBk_id(rs.getInt("bk_id"));
				bk.setShare_book_id(rs.getInt("shbid"));
				bk.setModelname(rs.getString("modelname"));
				bk.setType(rs.getString("type"));
				bk.setShare_date(rs.getDate("share_date"));
				bk.setBooked_date(rs.getDate("bkdate"));
				bk.setBookingstatus(rs.getString("bookingstatus"));
				bk.setFirstname(rs.getString("firstname"));
				bk.setMobileNo(rs.getInt("mobileNo"));

				// store all data into a List
				currentbookingsbikelist.add(bk);
				// All open connection to be closed.
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		////
		return currentbookingsbikelist;

	}

	public List<BookService> getBookBikeList(Integer userid) {
		List<BookService> bookbikelist = new ArrayList<BookService>();

		con = DBConnection.getConnection();

		String sql = "SELECT bk.id,bk.modelname,bk.type,bk.comments,bk.conditionstatus,bk.sharestatus,us.first_name bikeowner FROM bikes bk,app_user us where bk.owner_id=us.id and bk.sharestatus='on' and bk.deletion_status ='no' ";
		// + "and us.id !='"+userid+"'";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				BookService bk = new BookService();
				bk.setBk_id(rs.getInt("id"));
				bk.setModelname(rs.getString("modelname"));
				bk.setType(rs.getString("type"));
				bk.setComments(rs.getString("comments"));
				bk.setConditionstatus(rs.getString("conditionstatus"));
				bk.setBikeowner(rs.getString("bikeowner"));
				// store all data into a List
				bookbikelist.add(bk);
				// All open connection to be closed.
			}
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		////
		return bookbikelist;

	}

	public List<BookService> viewDateSlots(int bike_id_local) {

		List<BookService> viewdateslots = new ArrayList<BookService>();
		con = DBConnection.getConnection();
		String sql = "SELECT id,share_date,bookingstatus,notes from shares_and_bookings where bike_id='" + bike_id_local
				+ "' and bookingstatus in ('NotBooked')";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BookService stb = new BookService();
				stb.setShare_book_id(rs.getInt("id"));
				stb.setShare_date(rs.getDate("share_date"));
				stb.setNotes(rs.getString("notes"));
				stb.setBookingstatus(rs.getString("bookingstatus"));
				stb.setBk_id(bike_id_local);
				// store all data into a List
				viewdateslots.add(stb);
				// All open connection to be closed.
			}
			rs.close();
			ps.close(); // All open connection to be closed.
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return viewdateslots;
	}

	public String updateRideDone(int share_book_id, int bike_id,int userid) throws SQLException {
		int rowupdated = 0;

		con = DBConnection.getConnection();
		String sql = "update app_user a " + "JOIN shares_and_bookings b ON a.id=b.booked_by "
				+ "set a.credits=a.credits+5, b.bookingstatus='RideDone', b.creditstatus='Credited' "
				+ "where b.share_date <= curdate() and b.id=? and b.bike_id=? and a.id=" + userid + "";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, share_book_id);
			ps.setInt(2, bike_id);
			rowupdated = ps.executeUpdate();
			System.out.println("Running from the credit 5");
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// finally{
		// clear();
		// }
		if (rowupdated > 0) {
			String sql1 = "update app_user a " + "JOIN bikes b ON a.id=b.owner_id "
					+ "JOIN shares_and_bookings c ON b.id=c.bike_id " + "set a.credits=a.credits+10 where c.bike_id="
					+ bike_id + " and c.id=" + share_book_id + "";
			ps = con.prepareStatement(sql1);
			ps.executeUpdate();
			System.out.println("Running from the credit 10");
			return "Credits Added";
		} else {

			con = DBConnection.getConnection();
			String sql3 = "update shares_and_bookings set bookingstatus='RideDone', creditstatus='Credited' where id="+share_book_id+" and bike_id="+bike_id+"";
			
			try {
				ps = con.prepareStatement(sql3);
				rowupdated = ps.executeUpdate();
				System.out.println("Running No credit ");
				ps.close(); // All open connection to be closed.
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ps.close(); // All open connection to be closed.
				con.close();
			}
			return "No Credits added. Ride Done Before Share Date";
		}

	}
	
	
	

}

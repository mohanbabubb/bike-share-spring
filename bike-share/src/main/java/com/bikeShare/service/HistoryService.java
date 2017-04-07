package com.bikeShare.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bikeShare.configuration.DBConnection;

public class HistoryService implements Serializable{
	
    private Date sharedate;
    private String modelname;
    private Date booked_date;
    private String shared_by;
	
	public Date getSharedate() {
		return sharedate;
	}

	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public Date getBooked_date() {
		return booked_date;
	}

	public void setBooked_date(Date booked_date) {
		this.booked_date = booked_date;
	}

	public String getShared_by() {
		return shared_by;
	}

	public void setShared_by(String shared_by) {
		this.shared_by = shared_by;
	}

	Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<HistoryService> viewBookHistory(Integer userid) {
        List<HistoryService> viewbookedlist = new ArrayList<HistoryService>();
        con = DBConnection.getConnection();     
        String sql = "SELECT bk.modelname name,sb.share_date share_date,sb.booked_date bkdate,(select first_name from app_user u1 where u1.id=bk.owner_id) shared_by FROM shares_and_bookings sb,bikes bk,app_user us WHERE bk.id=sb.bike_id and sb.bookingstatus in ('RideDone') and us.id=sb.booked_by and us.id='"+userid+"'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
            	HistoryService stb1 = new HistoryService();
                stb1.setModelname(rs.getString("name"));
                stb1.setSharedate(rs.getDate("share_date"));
                stb1.setBooked_date(rs.getDate("bkdate"));
                stb1.setShared_by(rs.getString("shared_by"));
                //store all data into a List
                viewbookedlist.add(stb1);
                // All open connection to be closed.
            }
            rs.close();
            ps.close(); // All open connection to be closed.
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewbookedlist;
    }

}

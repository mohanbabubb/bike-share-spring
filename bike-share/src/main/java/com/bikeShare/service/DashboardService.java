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

public class DashboardService implements Serializable {
	
	private Integer credits;
	private Integer counterbb;
	
	
   	public Integer getCredits() {
		return credits;
	}


	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	

	public Integer getCounterbb() {
		return counterbb;
	}


	public void setCounterbb(Integer counterbb) {
		this.counterbb = counterbb;
	}



	Connection con = null;
   	ResultSet rs = null;
   	PreparedStatement ps = null;
   	
   	
	public int fetchUserCredits(Integer userid)
    {
       int rowfecthed = 0;

         con=DBConnection.getConnection();
	  String sql = "SELECT credits from app_user where id="+userid+"";
         try {
           ps= con.prepareStatement(sql);
           ResultSet rs =  ps.executeQuery();
           
           if(rs.next()){
           this.setCredits(rs.getInt("credits")); 
           }
           rs.close();
           ps.close(); // All open connection to be closed.
           con.close();
         }
         catch(Exception e)
         {
           e.printStackTrace();	
         }
         
       //} // if else        
         if (rowfecthed >= 0) {
             System.out.println("Fetched the credit value.");
             System.out.println(credits);
         }
         return credits;
        
    }

	
	public int fetchBikesDetails(Integer userid, String str){
		int rowfecthed = 0;

        String sql = null;
        con = DBConnection.getConnection();
        if ("a".equals(str)) {
            sql = "SELECT count(*) as justcount from bikes where owner_id='" + userid + "' and sharestatus='on' and deletion_status='no'";
        } else if ("b".equals(str)) {
            sql = "SELECT count(*) as justcount from shares_and_bookings where booked_by = '"+ userid +"' and bookingstatus='Booked' ";
        } else if ("c".equals(str)) {
            sql = "SELECT count(*) as justcount from shares_and_bookings where booked_by='"+ userid +"' and bookingstatus='RideDone' and share_date <= curdate()";
        }
        try {

            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.setCounterbb(rs.getInt("justcount"));
            }
            rs.close();
            ps.close(); // All open connection to be closed.
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //clear();
        }

        //} // if else        
        if (rowfecthed >= 0) {
            System.out.println("Fetched the counterbb value.");
            System.out.println(counterbb);
        }
        return counterbb;
	}
		
}

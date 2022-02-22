package com.bhushan.web.dao;

import com.bhushan.web.model.Alien;
import java.sql.*;

public class AlienDao {

	public AlienDao() {
		
	}
	
	public Alien getAlien(int aid) {
		
		Alien alien = new Alien();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhushan", "root", "qwerty");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from alien where aid=" + aid);
			
			if(rs.next()) {
				alien.setAid(rs.getInt("aid"));
				alien.setAname(rs.getString("aname"));
				alien.setAtech(rs.getString("atech"));
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alien;
		
	}

}

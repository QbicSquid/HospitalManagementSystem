/*package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hosp.model.Medicine;
import com.hosp.model.MedicineQuantity;


public class cartDAO {
	public static List<MedicineQuantity> getTotalPrice(String totalPrice){
		ArrayList<MedicineQuantity> medi = new ArrayList<>();
		
		Connection con;
		ResultSet rs;
		con = Conn.getDBConnection();
		
		String query = ("SELECT * " + 
				"FROM medicine " +
				"WHERE name LIKE '%"+name+"%'");
		
		PreparedStatement preparedstatement = con.prepareStatement(query);
		//preparedstatement.setString(1, name);
		
		rs = preparedstatement.executeQuery();
		
		while(rs.next()) {
			
			String id = rs.getString(1);
			String name = rs.getString(2);
			double cost=rs.getDouble(3);
			double totalPrice =rs.getDouble(4);
		
			MedicineQuantity i = new MedicineQuantity(id,name,cost,totalPrice);
			medi.add(i);
			
		}
		
		return medi;

}
}
*/
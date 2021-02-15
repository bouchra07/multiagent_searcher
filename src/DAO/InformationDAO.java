package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class InformationDAO  {
	
	java.sql.Connection cnx;
	
	java.sql.PreparedStatement prepa;
	ResultSet res ;
	
	public InformationDAO() throws ClassNotFoundException, SQLException{
		cnx = MySqlManager.getConnection();
	}


public Information  FindInformationByNom(String Marque, String Type){
		
		
		Information information = null;
	
		String requette = "select *  from information where Marque ='"+Marque+"' and Type ='"+Type+"'";
	
		try {
			
            Statement stement = this.cnx.createStatement();
            res = 	stement.executeQuery(requette);
			while(res.next()){
			information  = new Information(res.getInt(1), res.getString(2), res.getString(3),res.getString(4));
			
			}
			   
			
		} catch (SQLException e) {e.printStackTrace();}
	
	return information;
	}


	

}
package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class customer{
	
	String[] orderedDishes;
	int[] orderedQuantity;
	
	String Hname;
	int orderWater;
	int count;
	double amt;
	
	customer() throws Exception
	{
		orderWater = 0;
		count = 0;
		amt = 0.0;
		orderedDishes = new String[10];
		orderedQuantity = new int[10];
	}
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void init() throws Exception{
    	try {
    		Class.forName("org.postgresql.Driver");
    		connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel","postgres", "sankar37");
    		statement = connect.createStatement();
    		System.out.println("Connection established");
    	}
    	
    	catch(Exception e) {
    		throw e;
    	}
    }
    
    public void orderDishes(ArrayList<String> dishes, ArrayList<Integer> quan,int waterNo) {
    	for(int i=0;i<dishes.size();i+=2) {
    		orderedDishes[i] = dishes.get(i);
    		orderedQuantity[i] = quan.get(i);
    	}
    		orderWater = waterNo;
    		count += 1;
    }
    
    public double calBill() throws SQLException {	
    	for(int i=0;i<orderedDishes.length;i+=2) {
			resultSet = statement.executeQuery("select price from dish where dname = '" + (String)orderedDishes[i] + "'");
			while(resultSet.next()) {
				amt += (resultSet.getDouble("price")) * (int)orderedQuantity[i];                                    // Added orderedQuantity
			}
		}
    	
    	amt += orderWater * 20;
		
		return amt;
    }
	
	public boolean PayBill() throws Exception {
		try {
			preparedStatement = connect.prepareStatement("UPDATE Hotel SET Revenue = (Revenue + ?) WHERE hname = ?");
	        preparedStatement.setDouble(1,amt);   
	        preparedStatement.setString(2,Hname); 
	        preparedStatement.executeUpdate();
	        return true;
		}
		catch(Exception e) {
			return false;
		}
	}	
}
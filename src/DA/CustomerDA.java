/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import BO.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author snehk_000
 */
public class CustomerDA extends AbstractDao 
{
    static Connection con=getConnection();
        public static void add(Customer customer)
        {
            try 
            {
            PreparedStatement ps=con.prepareStatement("insert into Customer(id,name,mobile_number,address,password,username,email) values (?,?,?,?,?,?,?)");
            ps.setInt(1,customer.getId());
            ps.setLong(3,customer.getMobile_number());
            ps.setString(2,customer.getName());
            ps.setString(4,customer.getAddress());
            ps.setString(6,customer.getUsername());
            ps.setString(5,customer.getPassword());
            ps.setString(7,customer.getEmail());
            ps.execute();  
            } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
            
        }
        public static void update(Customer customer)
        {
            try 
            {
            PreparedStatement ps=con.prepareStatement("update customer set id=?, name=?, mobile_number=?, address=?, password=?, username=?, email=? where id=?");
            ps.setInt(1,customer.getId());
            ps.setLong(3,customer.getMobile_number());
            ps.setString(2,customer.getName());
            ps.setString(4,customer.getAddress());
            ps.setString(6,customer.getUsername());
            ps.setString(5,customer.getPassword());
            ps.setString(7,customer.getEmail());
            ps.setInt(8,customer.getId());
            ps.execute();  
            } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
            
        }
           public static void delete(int id)
    {
        try 
        {
            PreparedStatement ps = con.prepareStatement("delete from customer where id=?");
                   ps.setInt(1,id);
                    ps.execute();
                    } 
        catch (Exception e) 
                    {
                        System.out.println(e);
        }
    }
           public static Customer getById(int id){
        Customer customer = null;
        try {
            PreparedStatement ps=con.prepareStatement("select id,name,mobile_number,address,username,password,email from customer where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                customer=new Customer();
                customer.setId(rs.getInt(1));
                customer.setAddress(rs.getString(4));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(7));
                customer.setMobile_number(rs.getLong(3));
                customer.setPassword(rs.getString(6));
                customer.setUsername(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }
           public static Customer getLogin(String username,String password){
        Customer customer = null;
        try {
            PreparedStatement ps=con.prepareStatement("select id,name,mobile_number,address,username,password,email from customer where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                customer=new Customer();
                customer.setId(rs.getInt(1));
                customer.setAddress(rs.getString(4));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(7));
                customer.setMobile_number(rs.getLong(3));
                customer.setPassword(rs.getString(6));
                customer.setUsername(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }
        
    
}

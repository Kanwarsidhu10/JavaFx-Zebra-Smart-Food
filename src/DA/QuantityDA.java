/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import BO.Quantity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author snehk_000
 */
public class QuantityDA extends AbstractDao 
{
    static Connection con=getConnection();
    
    public static void add(Quantity quantity)
    {
            try
            {
        PreparedStatement ps = con.prepareStatement("insert into quantity (id,p_id,qty) values (?,?,?)");
            ps.setInt(1,quantity.getId());
            ps.setInt(2,quantity.getP_id());
            ps.setInt(3,quantity.getQty());
             ps.execute();
    }
//To change body of generated methods, choose Tools | Templates.
    
    catch(Exception e)
    {
        System.out.println(e);
    
}
    }
    public static void update(Quantity quantity)
    {
            try
            {
        PreparedStatement ps = con.prepareStatement("update quantity set id=?, p_id=?, qty=? where id=?");
            ps.setInt(1,quantity.getId());
            ps.setInt(2,quantity.getP_id());
            ps.setInt(3,quantity.getQty());
            ps.setInt(4,quantity.getId());
             ps.execute();
    }
    
    catch(Exception e)
    {
        System.out.println(e);
    
}
    }
    public static void delete(int id)
    {
        try 
        {
            PreparedStatement ps = con.prepareStatement("delete from quantity where id=?");
                   ps.setInt(1,id);
                    ps.execute();
                    } 
        catch (Exception e) 
                    {
                        System.out.println(e);
        }
    }
    public static Quantity getById(int id){
        Quantity quantity = null;
        try {
            PreparedStatement ps=con.prepareStatement("select id,p_id,qty from quantity where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                quantity=new Quantity();
                quantity.setId(rs.getInt(1));
                quantity.setP_id(rs.getInt(2));
                quantity.setQty(rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantity;
    }
}    


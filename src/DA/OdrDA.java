/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import BO.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author snehk_000
 */
public class OdrDA extends AbstractDao
{
    static Connection con=getConnection();
    public static void add(Order odr)
    {
        try {
            PreparedStatement ps = con.prepareStatement("insert into odr (id,date_of_order,date_of_delievery,p_id,quantity,amount,c_id) values (?,?,?,?,?,?,?)");
            ps.setInt(1,odr.getId());
            ps.setString(2,DateTimeFormatter.ofPattern("dd-MM-yyyy").format(odr.getDate_of_order()));
            ps.setString(3,DateTimeFormatter.ofPattern("dd-MM-yyyy").format(odr.getDate_of_delievery()));
            ps.setInt(4,odr.getP_id());
            ps.setInt(5,odr.getQuantity());
            ps.setInt(6,odr.getAmount());
            ps.setInt(7,odr.getC_id());
            ps.execute();
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }
    public static void update(Order odr)
    {
        try {
            PreparedStatement ps = con.prepareStatement("update odr set id=?,date_of_order=?,date_of_delievery=?,p_id=?,qty=?,amount=?,c_id=? where id=?");
            ps.setInt(1,odr.getId());
            ps.setString(2,DateTimeFormatter.ofPattern("dd-MM-yyyy").format(odr.getDate_of_order()));
            ps.setString(3,DateTimeFormatter.ofPattern("dd-MM-yyyy").format(odr.getDate_of_delievery()));
            ps.setInt(4,odr.getP_id());
            ps.setInt(5,odr.getQuantity());
            ps.setInt(6,odr.getAmount());
            ps.setInt(7,odr.getC_id());
            ps.setInt(8,odr.getId());
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
            PreparedStatement ps = con.prepareStatement("delete from odr where id=?");
                   ps.setInt(1,id);
                    ps.execute();
                    } 
        catch (Exception e) 
                    {
                        System.out.println(e);
        }
    }
    public static Order getById(int id){
        Order order = null;
        try {
            PreparedStatement ps=con.prepareStatement("select id,date_of_order,date_of_delievery,p_id,qty,amount,c_id from odr where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                order=new Order();
                order.setId(rs.getInt(1));
                order.setP_id(rs.getInt(4));
                order.setQuantity(rs.getInt(5));
                order.setC_id(rs.getInt(7));
                order.setAmount(rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return order;
    }
}

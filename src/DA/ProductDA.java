/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import BO.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author snehk_000
 */
public class ProductDA extends AbstractDao
{
    static Connection con=getConnection();
    
    public static void add(Product product)
    {
        try 
        {
            PreparedStatement ps = con.prepareStatement("insert into product(id,code,category,amount,description,name) values (?,?,?,?,?,?)");
                   ps.setInt(1,product.getId());
                   ps.setString(2,product.getCode());
                   ps.setString(3,product.getCategory());
                   ps.setInt(4,product.getAmount());
                   ps.setString(5,product.getDescription());
                   ps.setString(6,product.getName());
                    ps.execute();
                    } 
        catch (Exception e) 
                    {
                        System.out.println(e);
        }
    }
    public static void update(Product product)
    {
        try 
        {
            PreparedStatement ps = con.prepareStatement("update product set id=?, code=?, category=?, amount=?, description=?, name=? where id=?");
                   ps.setInt(1,product.getId());
                   ps.setString(2,product.getCode());
                   ps.setString(3,product.getCategory());
                   ps.setInt(4,product.getAmount());
                   ps.setString(5,product.getDescription());
                   ps.setString(6,product.getName());
                   ps.setInt(7,product.getId());
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
            PreparedStatement ps = con.prepareStatement("delete from product where id=?");
                   ps.setInt(1,id);
                    ps.execute();
                    } 
        catch (Exception e) 
                    {
                        System.out.println(e);
        }
    }
    public static Product getById(int id){
        Product product = null;
        try {
            PreparedStatement ps=con.prepareStatement("select id,code,name,category,amount,description from product where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                product=new Product();
                product.setId(rs.getInt(1));
                product.setCode(rs.getString(2));
                product.setName(rs.getString(3));
                product.setCategory(rs.getString(4));
                product.setAmount(rs.getInt(5));
                product.setDescription(rs.getString(6));   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return product;
    }
    public static ArrayList getAllByCategory(String category){
        ArrayList products = new ArrayList();
        try {
            PreparedStatement ps=con.prepareStatement("select id,code,name,category,amount,description from product where category=?");
            ps.setString(1, category);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                Product product=new Product();
                product.setId(rs.getInt(1));
                product.setCode(rs.getString(2));
                product.setName(rs.getString(3));
                product.setCategory(rs.getString(4));
                product.setAmount(rs.getInt(5));
                product.setDescription(rs.getString(6));  
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }
        public static ArrayList getAll(){
        ArrayList products = new ArrayList();
        try {
            PreparedStatement ps=con.prepareStatement("select id,code,name,category,amount,description from product");
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                Product product=new Product();
                product.setId(rs.getInt(1));
                product.setCode(rs.getString(2));
                product.setName(rs.getString(3));
                product.setCategory(rs.getString(4));
                product.setAmount(rs.getInt(5));
                product.setDescription(rs.getString(6));  
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }
            
    
   
}

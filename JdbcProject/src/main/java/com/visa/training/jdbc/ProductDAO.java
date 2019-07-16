package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//DAO class has CRUD + query methods

public class ProductDAO {
	
	public int save(Product obj){
		int generated_id = 0;
		try(Connection c = JdbcUtil.getConnection()) {
			Statement st = c.createStatement();
			String pSql = "insert into product (product_name, product_price, product_qoh) values(?,?,?)";
			//PreparedStatement s = c.prepareStatement(pSql);
			// to get the generated ID
			PreparedStatement s = c.prepareStatement(pSql, Statement.RETURN_GENERATED_KEYS);
			s.setString(1, obj.getName());
			s.setFloat(2, obj.getPrice());
			s.setInt(3, obj.getQoh());
			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.next();
			generated_id = rs.getInt(1);
			
			return generated_id;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return generated_id;
		
	}
	
	public Product findById(int id){
		
		//rather than null use optional try
		Product p = null;
		try(Connection c = JdbcUtil.getConnection()) {
			Statement st = c.createStatement();
			String query = "select * from product where product_id = "+id;
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
		    if(rs.next()) {
		    	System.out.println(rs.getInt(1)+" "+ rs.getString(2)+ " "+ rs.getInt(3)+ " "+ rs.getInt(4));
		    	p = mapRow(rs);
		    }
		    return p;
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		return p;
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product p;
		p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
		return p;
	}
	
	public List<Product> findAll(){
		
		try(Connection c = JdbcUtil.getConnection()) {
			List<Product> list_of_products = new ArrayList<>();
			Statement st = c.createStatement();
			String query = "select * from product;";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
		    while(rs.next()) {
		    	System.out.println(rs.getInt(1)+" "+ rs.getString(2)+ " "+ rs.getInt(3)+ " "+ rs.getInt(4));
		    	list_of_products.add(mapRow(rs));
		    }
		    return list_of_products;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public void remove(int id){
		//DELETE
		try(Connection c = JdbcUtil.getConnection()) {
			Statement st = c.createStatement();
			String query = "delete from product where product_id = "+id;;
			System.out.println(query);
			st.executeUpdate(query);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Product updated){
		
		try(Connection c = JdbcUtil.getConnection()) {
			Statement st = c.createStatement();
			String query = "update product set product_name = ?, product_price = ?, product_qoh = ? where product_id = "+updated.getId();
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, updated.getName());
			ps.setFloat(2, updated.getPrice());
			ps.setInt(3, updated.getQoh());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

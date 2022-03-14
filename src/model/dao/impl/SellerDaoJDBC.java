package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 * This class is responsible to implement basic DB activities
 * @author Mariana
 *
 */

public class SellerDaoJDBC implements SellerDao{
	
	// Depend�ncia do dao com a conex�o do banco
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {  // construtor para criar a depend�ncia.
		this.conn = conn;
	}

	@Override
	public void insert(Seller seller) {
		
	}

	@Override
	public void update(Seller seller) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			// Criando os objetos da OO
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);				
				Seller seller = instantiateSeller(rs, dep);
				
				return seller;
			}
			return null;  // se o rs n�o retornar nada, o m�todo retornar� nulo.
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}		
	}
	
	/**
	 * M�todo auxiliar para instanciar os vendedores
	 * @param rs
	 * @param dep
	 * @return seller
	 * @throws SQLException
	 */
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setDepartment(dep);
		return seller;
	}

	/**
	 * M�todo auxiliar para instanciar os departamentos
	 * @param rs
	 * @return dep
	 * @throws SQLException
	 */
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
			rs = ps.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			// Criando os objetos da OO
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));  // busca no map se existe um objeto com aquele id, sen�o retorna nulo pro objeto dep.
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);  // se n�o existir, insere no map.
				}				 
							
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
				
			}
			return list;  
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}		
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
			ps.setInt(1, department.getId());
			rs = ps.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			// Criando os objetos da OO
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));  // busca no map se existe um objeto com aquele id, sen�o retorna nulo pro objeto dep.
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);  // se n�o existir, insere no map.
				}				 
							
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
				
			}
			return list;  
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}		
	}
}

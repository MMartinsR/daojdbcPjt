package model.dao;

import model.dao.impl.SellerDaoJDBC;

/**
 * This class is responsible to instantiate DAOs. 
 * It will have static method to instantiate DAOs.
 * @author Mariana
 *
 */
public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();  // macete para n�o expor a implementa��o4
	}

}
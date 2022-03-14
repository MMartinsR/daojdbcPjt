package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		/*
		 * DAO Para cada entidade, haver� um objeto respons�vel por fazer acesso a dados
		 * relacionado a esta entidade. Por exemplo: Cliente: ClienteDAO Produto:
		 * ProdutoDAO Pedido: PedidoDAO
		 * 
		 * Cada DAO ser� definido por uma interface. A inje��o de depend�ncia pode ser
		 * feita por meio do padrao de projeto Factory.
		 */

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
			
		}
		
		System.out.println("\n=== TEST 3: seller findByAll ====");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
			
		}
		
		System.out.println("\n=== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
	}

}

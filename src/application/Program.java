package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		/*
		 * DAO Para cada entidade, haverá um objeto responsável por fazer acesso a dados
		 * relacionado a esta entidade. Por exemplo: Cliente: ClienteDAO Produto:
		 * ProdutoDAO Pedido: PedidoDAO
		 * 
		 * Cada DAO será definido por uma interface. A injeção de dependência pode ser
		 * feita por meio do padrao de projeto Factory.
		 */

		Scanner sc = new Scanner(System.in);
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
		
		
		System.out.println("\n=== TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		
		System.out.println("\n=== TEST 6: seller delete ====");
		System.out.print("Enter id for deletion test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("\nDeletion completed!");
		
		sc.close();
	}

}

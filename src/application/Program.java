package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		/* DAO
		 * Para cada entidade, haverá um objeto responsável por fazer acesso a dados relacionado a esta entidade. Por exemplo:
		 * Cliente: ClienteDAO
		 * Produto: ProdutoDAO
		 * Pedido: PedidoDAO
		 * 
		 * Cada DAO será definido por uma interface.
		 * A injeção de dependência pode ser feita por meio do padrao de projeto Factory.
		 */
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}

}

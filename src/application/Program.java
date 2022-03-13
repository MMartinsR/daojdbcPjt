package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		/* DAO
		 * Para cada entidade, haver� um objeto respons�vel por fazer acesso a dados relacionado a esta entidade. Por exemplo:
		 * Cliente: ClienteDAO
		 * Produto: ProdutoDAO
		 * Pedido: PedidoDAO
		 * 
		 * Cada DAO ser� definido por uma interface.
		 * A inje��o de depend�ncia pode ser feita por meio do padrao de projeto Factory.
		 */
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}

}

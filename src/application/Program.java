package application;

import java.util.Date;

import model.entities.Department;
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
		
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		System.out.println(seller);
	}

}

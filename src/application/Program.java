package application;

import model.entities.Department;

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
		
		System.out.println(obj);
	}

}

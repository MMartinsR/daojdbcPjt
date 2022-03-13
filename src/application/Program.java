package application;

import model.entities.Department;

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
		
		Department obj = new Department(1, "Books");
		
		System.out.println(obj);
	}

}

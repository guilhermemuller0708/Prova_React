/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.superLoja;

import br.edu.ifrs.restinga.dev1.superLoja.modelo.dao.PedidoDAO;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.dao.ProdutoDAO;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Pedido;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Produto;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Inicializador {

    @Autowired
    ProdutoDAO produtoDAO;
    @Autowired
    PedidoDAO pedidoDAO;
    
    public void init() {
        pedidoDAO.deleteAll();
        produtoDAO.deleteAll();
        
        Produto batata = criarProduto("Batata", 3.5f);
        Produto abacate = criarProduto("Avocado", 18.50f);
        Produto maca = criarProduto("Maçã", 5.9f);
        //Abacaxi 
        Produto abacaxi = criarProduto("Abacaxi", 4.6f);
        Produto banana = criarProduto("Banana", 3);

        criarPedido("Rua do exemplo 1", 12, abacate, "aguardando pagamento");
        criarPedido("Rua do exemplo 2", 10, batata, "confirmação pagamento");
        criarPedido("Rua do exemplo 3", 10, banana, "separação");
        criarPedido("Rua do exemplo 4", 10, maca, "enviado");
        criarPedido("Rua do exemplo 5", 10, abacaxi, "cancelado");
        criarPedido("Rua do exemplo 6", 10, batata, "entregue");
    }

    private Produto criarProduto(String nome, float valor) {
        Produto batata = new Produto();
        batata.setNome(nome);
        batata.setValor(valor);
        return produtoDAO.save(batata);
    }

        private Pedido criarPedido(String endereco, float frete,Produto produto, String status) {
        Pedido pedido = new Pedido();
        pedido.setEndereco(endereco);
        pedido.setFrete(frete);
        pedido.setProduto(produto);
        pedido.setStatus(status);
        return pedidoDAO.save(pedido);
    }

}

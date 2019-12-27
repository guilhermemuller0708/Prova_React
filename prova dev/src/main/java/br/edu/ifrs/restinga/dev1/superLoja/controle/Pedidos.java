/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.superLoja.controle;

import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Pedido;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.servico.ProdutoServico;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Produto;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.servico.PedidoServico;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jezer
 */
@RestController
@RequestMapping("/api/pedidos")
public class Pedidos extends CRUDControle<Pedido> {

    @Autowired
    PedidoServico servico;

    @Override
    public Servico<Pedido> getService() {
        return servico;
    }

}

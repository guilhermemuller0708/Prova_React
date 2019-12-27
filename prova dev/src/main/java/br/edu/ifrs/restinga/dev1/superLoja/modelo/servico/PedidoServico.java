/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.superLoja.modelo.servico;

import br.edu.ifrs.restinga.dev1.superLoja.modelo.dao.PedidoDAO;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Pedido;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.rn.PedidoRN;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.rn.RegraNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author jezer
 */
@Component
public class PedidoServico extends Servico<Pedido> {

    @Autowired
    PedidoDAO produtoDAO;
    @Autowired
    PedidoRN produtoRN;


    @Override
    public CrudRepository<Pedido, Integer> getDAO() {
        return produtoDAO;
    }

    @Override
    public RegraNegocio<Pedido> getRegraNegocio() {
        return produtoRN;
    }

}

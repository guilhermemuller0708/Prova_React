/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.superLoja.modelo.rn;

import br.edu.ifrs.restinga.dev1.superLoja.excecoes.QuebraRegraNegocio;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Pedido;
import java.util.Arrays;
import org.springframework.stereotype.Component;

/**
 *
 * @author jezer
 */

@Component
public class PedidoRN implements  RegraNegocio<Pedido> {
    public void validar(Pedido pedido) {
        if(pedido.getFrete() <=0) 
            throw new QuebraRegraNegocio("valor do frete deve ser maior que 0");
        if(pedido.getEndereco()==null||pedido.getEndereco().isEmpty())
            throw new QuebraRegraNegocio("Endereço obrigatório");
        if(pedido.getStatus()==null||pedido.getEndereco().isEmpty())
            throw new QuebraRegraNegocio("Status obrigatório");
        if(pedido.getProduto()==null)
            throw new QuebraRegraNegocio("Produto obrigatório");
        if( ! Arrays.asList(new String[]{"aguardando pagamento","confirmação pagamento","separação","enviado","cancelado","entregue"}).contains(pedido.getStatus()) ) {
            throw new QuebraRegraNegocio("Status só aceita os valores: aguardando pagamento,confirmação pagamento,separação,enviado,cancelado e entregue");
        }
    }

    @Override
    public void validarCadastrar(Pedido entidade) {
        validar(entidade);
        if(!entidade.getStatus().equals("aguardando pagamento"))
            throw new QuebraRegraNegocio("Status inicial deve ser aguardando pagamento");

    }

    @Override
    public void validarAtualizar(Pedido entidadeAtinga, Pedido entidadeNova) {
        validar(entidadeNova);
        
    }

    @Override
    public void validarExcluir(Pedido entidade) {
        if(entidade.getStatus().equals("entregue")
            ||entidade.getStatus().equals("enviado")
                )
            throw new QuebraRegraNegocio("Não é possível excluir um pedido que já foi enviado ou entregue");
        
    }
    
    
}

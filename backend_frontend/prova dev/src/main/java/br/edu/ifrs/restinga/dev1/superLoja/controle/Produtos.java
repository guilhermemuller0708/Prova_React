/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.superLoja.controle;

import br.edu.ifrs.restinga.dev1.superLoja.Inicializador;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.servico.ProdutoServico;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Produto;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.servico.Servico;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jezer
 */
@RestController
@RequestMapping("/api/produtos")
public class Produtos extends CRUDControle<Produto> {

    @Autowired
    ProdutoServico servico;

    @Override
    public Servico<Produto> getService() {
        return servico;
    }

    
     @Autowired
     Inicializador inicializador;
    
    @RequestMapping(path = "/reset", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void reset() {
        
        inicializador.init();
    }

}

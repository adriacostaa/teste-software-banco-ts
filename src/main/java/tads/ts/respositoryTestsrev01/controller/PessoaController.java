package tads.ts.respositoryTestsrev01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tads.ts.respositoryTestsrev01.model.Pessoa;
import tads.ts.respositoryTestsrev01.repository.PessoaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

}

package tads.ts.respositoryTestsrev01.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import tads.ts.respositoryTestsrev01.model.Pessoa;

@DataJpaTest
public class PessoaRepositoryTest {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    @DisplayName("Deve salvar pessoa com cadastro correto")
    public void deveSalvarPessoaComCadastroCorreto(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jedi");
        pessoa.setTelefone("94444-4444");
        pessoa.setEmail("jedi@email.com");

        pessoaRepository.save(pessoa);

        Pessoa pessoaNoBD = pessoaRepository.findOneByEmail(pessoa.getEmail());

        Assertions.assertEquals(pessoa.getEmail(), pessoaNoBD.getEmail());
    }

    public void naoDeveSalvarPessoaJaCadastrada(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Luke");
        pessoa.setTelefone("91111-1111");
        pessoa.setEmail("luke@email.com");

        //pessoaRepository.save(pessoa));
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
             pessoaRepository.save(pessoa);
        });
    }
}

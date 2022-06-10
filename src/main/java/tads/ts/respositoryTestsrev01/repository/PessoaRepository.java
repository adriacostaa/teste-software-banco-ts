package tads.ts.respositoryTestsrev01.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tads.ts.respositoryTestsrev01.model.Pessoa;

import java.util.List;


public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
    @Query("select p from Pessoa p")
    public List<Pessoa> list();

    @Query("select p from Pessoa p where p.email=:parEmail")
    public Pessoa findOneByEmail(String parEmail);
}

package br.unisul.aula.msendereco.repositorio;

import br.unisul.aula.msendereco.modelo.Endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findFirstByCep(Integer cep);

    List<Endereco> findAllByCidade(String cidade);

}

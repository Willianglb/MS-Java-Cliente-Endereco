package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.EnderecoDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("endereco")
public interface EnderecoClient {

    @GetMapping("/end/id/{id}")
    EnderecoDTO buscarPorId(@PathVariable(name = "id")Long id);

    @GetMapping("/end/{cep}")
    EnderecoDTO buscarPorCep(@PathVariable(name = "cep")Integer cep);

    @GetMapping("/end/cidade/{cidade}")
    EnderecoDTO buscarPorCidade(@PathVariable(name = "cidade")String cidade);
}

package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.CidadeClienteDTO;
import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.dto.InfoCidadeDTO;
import br.unisul.aula.mscliente.modelo.Cliente;
import br.unisul.aula.mscliente.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
/*

    @Autowired
    private RestTemplate clienteRaimbow;
*/

    @Autowired
    private EnderecoClient enderecoClient;

    public List<ClienteDTO> listarTodos() {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente: clienteRepository.findAll()){
            EnderecoDTO enderecoDTO = buscarEnderecoPorID(cliente.getEndereco_id());
            ClienteDTO clienteDTO = new ClienteDTO(cliente, enderecoDTO);
            dtos.add(clienteDTO);
        }
        return dtos;
    }
    private EnderecoDTO buscarEnderecoPorID(Long id){
        return enderecoClient.buscarPorId(id);
    }
    private EnderecoDTO buscarEnderecoPorCep(Integer cep){
        return enderecoClient.buscarPorCep(cep);
    }
/*

    private EnderecoDTO buscarEnderecoPorID(Long id) {
        ResponseEntity<EnderecoDTO> exchange = clienteRaimbow.exchange("http://endereco/end/id/" + id,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
    private EnderecoDTO buscarEnderecoPorCep(Integer cep) {
        ResponseEntity<EnderecoDTO> exchange = clienteRaimbow.exchange("http://endereco/end/" + cep,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
*/

    public void registrarCliente(ClienteDTO dto) {
        dto.setEndereco(buscarEnderecoPorCep(dto.getCep()));
        Cliente cliente = dto.converterParaCliente();
        clienteRepository.save(cliente);
    }

	private EnderecoDTO buscarPorCidade(String cidade) {
		return enderecoClient.buscarPorCidade(cidade);
	}

    public InfoCidadeDTO listarClienteDaCidade(String cidade) {

		List<InfoCidadeDTO> clientes = new ArrayList<>();
		List<CidadeClienteDTO> clienteModelo = new ArrayList<>();

		EnderecoDTO enderecoDTO = buscarPorCidade(cidade);

		for (Cliente cliente : clienteRepository.findAll()) {

			if (cliente.getEndereco_id() == enderecoDTO.getId()) {
				String nome = cliente.getNome();
				Long idCliente = cliente.getId();

				CidadeClienteDTO modeloDeClienteDTO = new CidadeClienteDTO(idCliente, nome);
				clienteModelo.add(modeloDeClienteDTO);

				InfoCidadeDTO clientePorCidadeDTO = new InfoCidadeDTO(clienteModelo);
				clientes.add(clientePorCidadeDTO);
			}
		}

		return new InfoCidadeDTO(clienteModelo, enderecoDTO);
	}
}

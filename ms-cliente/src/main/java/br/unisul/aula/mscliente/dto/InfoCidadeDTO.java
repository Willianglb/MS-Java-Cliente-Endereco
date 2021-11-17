package br.unisul.aula.mscliente.dto;

import java.util.List;

public class InfoCidadeDTO {
    private String cidade;
    private String uf;
    private List<CidadeClienteDTO> clientes;

    public InfoCidadeDTO(List<CidadeClienteDTO> clientes, EnderecoDTO enderecoDTO) {
		this.cidade = enderecoDTO.getCidade();
		this.uf = enderecoDTO.getUf();
		this.clientes = clientes;
	}

	public InfoCidadeDTO(List<CidadeClienteDTO> clienteModelo) {
		this.clientes = clienteModelo;
	}

	public List<CidadeClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<CidadeClienteDTO> clientes) {
		this.clientes = clientes;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}

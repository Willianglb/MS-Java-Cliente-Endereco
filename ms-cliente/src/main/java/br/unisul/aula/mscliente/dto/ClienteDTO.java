package br.unisul.aula.mscliente.dto;

import br.unisul.aula.mscliente.modelo.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private Long idEndereco;
    private Integer cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente, EnderecoDTO enderecoDTO) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.idEndereco = cliente.getEndereco_id();
        this.setEndereco(enderecoDTO);
    }

    public Cliente converterParaCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setNumero(this.numero);
        cliente.setComplemento(this.complemento);
        cliente.setEndereco_id(this.idEndereco);
        return cliente;
    }

    public void setEndereco(EnderecoDTO enderecoDTO) {
        this.idEndereco = enderecoDTO.getId();
        this.cep = enderecoDTO.getCep();
        this.logradouro = enderecoDTO.getLogradouro();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.uf = enderecoDTO.getUf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}

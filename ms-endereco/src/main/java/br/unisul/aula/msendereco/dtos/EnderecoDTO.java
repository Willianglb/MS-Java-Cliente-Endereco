package br.unisul.aula.msendereco.dtos;

import br.unisul.aula.msendereco.modelo.Endereco;
import br.unisul.aula.msendereco.modelo.UnidadeFederativa;

public class EnderecoDTO {
    private Long id;
    private String logradouro;
    private Integer cep;
    private String bairro;
    private String cidade;
    private String uf;

    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf().name();
    }

    public EnderecoDTO() {
    }

    public Endereco converterParaEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(this.id);
        endereco.setLogradouro(this.logradouro);
        endereco.setCep(this.cep);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setUf(UnidadeFederativa.valueOf(this.uf));
        return endereco;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
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
}

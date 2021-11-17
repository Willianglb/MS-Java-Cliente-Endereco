package br.unisul.aula.msendereco.dtos;

import br.unisul.aula.msendereco.modelo.Endereco;
import br.unisul.aula.msendereco.modelo.UnidadeFederativa;
/*
DTO criado para simplificar o teste, utilizando o formato do  https://viacep.com.br/ws/88050450/json/
* */
public class EnderecoViaCEPDTO {
    private Long id;
    private String logradouro;
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoViaCEPDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.setCep(endereco.getCep());
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getCidade();
        this.uf = endereco.getUf().name();
    }

    public EnderecoViaCEPDTO() {
    }

    public Endereco converterParaEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(this.id);
        endereco.setLogradouro(this.logradouro);
        endereco.setCep(this.getCepInteger());
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.localidade);
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

    public String getCep() {
        return cep;
    }
    public Integer getCepInteger() {
        return Integer.parseInt(this.cep.replace("-",""));
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setCep(Integer cep) {
        this.cep = String.valueOf(cep);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}

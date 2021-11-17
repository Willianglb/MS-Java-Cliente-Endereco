package br.unisul.aula.msendereco.modelo;

import javax.persistence.*;

@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name="seq_endereco",sequenceName="my_seq_endereco", allocationSize=1)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    private Long id;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false, unique = true)
    private Integer cep;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private UnidadeFederativa uf;


    public Endereco() {
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

    public UnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativa uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", cep=" + cep +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf=" + uf.name() +
                '}';
    }
}

package br.com.livecoding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente extends AbstractModel<Long> {

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "datanascimento", nullable = false, length = 10)
    private Date dataNascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

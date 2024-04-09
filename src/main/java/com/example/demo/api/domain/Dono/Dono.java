package com.example.demo.api.domain.Dono;

import com.example.demo.api.domain.Pessoa.Pessoa;

public class Dono extends Pessoa{
    private String cnpj;
    private String certificacao;
    private String cref;
    private String academia;

    public Dono(int id, String nome, String email, String senha, String cnpj, String certificacao, String cref, String academia) {
        super(id, nome, email, senha);
        this.cnpj = cnpj;
        this.certificacao = certificacao;
        this.cref = cref;
        this.academia = academia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = Dono.this.academia;
    }

    @Override
    public String toString() {
        return "Dono{" +
                "cnpj='" + cnpj + '\'' +
                ", certificacao='" + certificacao + '\'' +
                ", cref=" + cref +
                ", academia='" + academia + '\'' +
                '}';
    }

}

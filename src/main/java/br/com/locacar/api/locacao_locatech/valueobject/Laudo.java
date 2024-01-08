package br.com.locacar.api.locacao_locatech.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.util.Objects;

@Embeddable
public class Laudo {
    @Column
    private Integer qtdeCombustivel;
    @Column
    private Integer quilometragem;
    @Column
    private String vistoria;
    public Laudo() {}

    public Laudo(Integer qtdeCombustivel, Integer quilometragem, String vistoria) {
        this.qtdeCombustivel = qtdeCombustivel;
        this.quilometragem = quilometragem;
        this.vistoria = vistoria;
    }

    public Integer getQtdeCombustivel() {
        return qtdeCombustivel;
    }

    public void setQtdeCombustivel(Integer qtdeCombustivel) {
        this.qtdeCombustivel = qtdeCombustivel;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getVistoria() {
        return vistoria;
    }

    public void setVistoria(String vistoria) {
        this.vistoria = vistoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laudo laudo = (Laudo) o;
        return Objects.equals(qtdeCombustivel, laudo.qtdeCombustivel) && Objects.equals(quilometragem, laudo.quilometragem) && Objects.equals(vistoria, laudo.vistoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtdeCombustivel, quilometragem, vistoria);
    }

    @Override
    public String toString() {
        return "Laudo{" +
                "qtdeCombustivel=" + qtdeCombustivel +
                ", quilometragem=" + quilometragem +
                ", vistoria='" + vistoria + '\'' +
                '}';
    }
}

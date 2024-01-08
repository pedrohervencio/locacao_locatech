package br.com.locacar.api.locacao_locatech.entities;

import br.com.locacar.api.locacao_locatech.valueobject.Cliente;
import br.com.locacar.api.locacao_locatech.valueobject.Laudo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tb_locacao")
public class Locacao {
    @Id
    private Long numero;
    private LocalDate dataInicio;
    private Integer qtdeDiarias;
    private Integer vlrDiaria;
    @ManyToOne
    @JoinColumn(name = "atendente_numero")
    private Atendente atendente;
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Veiculo veiculo;
    private Laudo laudo;

    public Locacao() {}

    public Locacao(Long numero, LocalDate dataInicio, Integer qtdeDiarias, Integer vlrDiaria, Atendente atendente, Cliente cliente, Veiculo veiculo, Laudo laudo) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.qtdeDiarias = qtdeDiarias;
        this.vlrDiaria = vlrDiaria;
        this.atendente = atendente;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.laudo = laudo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getQtdeDiarias() {
        return qtdeDiarias;
    }

    public void setQtdeDiarias(Integer qtdeDiarias) {
        this.qtdeDiarias = qtdeDiarias;
    }

    public Integer getVlrDiaria() {
        return vlrDiaria;
    }

    public void setVlrDiaria(Integer vlrDiaria) {
        this.vlrDiaria = vlrDiaria;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locacao locacao = (Locacao) o;
        return Objects.equals(numero, locacao.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "numero=" + numero +
                ", dataInicio=" + dataInicio +
                ", qtdeDiarias=" + qtdeDiarias +
                ", vlrDiaria=" + vlrDiaria +
                ", atendente=" + atendente +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", laudo=" + laudo +
                '}';
    }
}

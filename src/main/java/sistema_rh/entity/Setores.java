package sistema_rh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "setores")
public class Setores {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitos setores pertencem a uma empresa
    @ManyToOne(fetch = FetchType.LAZY)
    // Coluna empresa_id, obrigatória
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    // Coluna nome, obrigatória, até 80 caracteres
    @Column(nullable = false, length = 80)
    private String nome;

    // Coluna descricao, opcional
    @Column(length = 255)
    private String descricao;

    // Coluna ativo, obrigatória
    @Column(nullable = false)
    private Boolean ativo = true;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

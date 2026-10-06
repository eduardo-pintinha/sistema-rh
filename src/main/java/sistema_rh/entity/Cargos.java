package sistema_rh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;

@Entity

@Table(name = "cargos")
public class Cargos {

    // Chave primária
    @Id
    // O banco gera o id sozinho
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitos cargos pertencem a uma empresa
    @ManyToOne(fetch = FetchType.LAZY)
    // Coluna empresa_id, obrigatória
    @JoinColumn(name = "empresa_id", nullable = false)
    // Esconde a empresa do JSON
    @JsonIgnore
    private Empresa empresa;

    // Nome do cargo, não pode ser vazio
    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    // Descrição do cargo, opcional
    @Column(length = 255)
    private String descricao;

    // Cargo ativo ou não
    @Column(nullable = false)
    private Boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
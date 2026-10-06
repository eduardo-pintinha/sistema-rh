package sistema_rh.entity;

//isso sao um pacote do JPA,que sao um conjunto de regras padroes do java para conectar as tabelas e classe do banco de dados
// cada anotacao dessas sao uma clase dentro do JPA
// o jpa somente define "como conversar" qm faz o real trablho e o hibernate,que o spring usa por de baixo dos panos
//jpa define as regras e o hibernate coloca em pratica
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // isso avisa o jpa\hibernate que a classe e uma tabela do banco de dados
@Table(name = "empresas")

public class Empresa {

    @Id //marca que o id e a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //aqui diz que o banco gera o id de forma automatica
    private long id;

    // @column so mostra que esse nome e uma coluna don canco de dados e faz essa conversao de escrita
    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_Fantasia")

    private String nomeFantasia;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private String status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomefantasia) {
        this.nomeFantasia = nomefantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

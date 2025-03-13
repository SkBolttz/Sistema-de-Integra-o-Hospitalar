package br.com.SistemaSaude.SistemaSaude.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "tb_clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank
    private String nome;

    @Column(nullable = false, unique = true, length = 18)
    @NotBlank
    private String cnpj;

    @Column(nullable = false, length = 15)
    @NotBlank
    private String telefone;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String nomeGerente;

    @Column(nullable = false, length = 15)
    @NotBlank
    private String telefoneGerente;

    @Column(nullable = false)
    @Min(1)
    private Integer capacidadeAtendimento;

    @NotNull
    private LocalDateTime dataCadastro;
    @NotNull
    private LocalDateTime dataAtualizacao;
    @NotNull
    private boolean ativo;
}

package br.com.SistemaSaude.SistemaSaude.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String logradouro;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String numero;

    @Column(length = 50)
    private String complemento;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String bairro;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    private String estado;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String pais;

    @NotNull
    private LocalDateTime dataCadastro;
    @NotNull
    private LocalDateTime dataAtualizacao;
    @NotNull
    private boolean ativo;
}

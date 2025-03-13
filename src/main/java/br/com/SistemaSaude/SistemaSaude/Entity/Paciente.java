package br.com.SistemaSaude.SistemaSaude.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@EqualsAndHashCode(of = "cpf")
@ToString
@Entity
@Table(name = "tb_paciente")
public class Paciente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @Pattern(regexp = "\\d{10,15}", message = "Telefone deve conter entre 10 e 15 dígitos")
    @Column(nullable = false, length = 15)
    private String telefone;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String sexo;

    @NotBlank
    @Column(nullable = false, length = 5)
    private String tipoSanguineo;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(nullable = false)
    private boolean ativo = true;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.name().toUpperCase()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}

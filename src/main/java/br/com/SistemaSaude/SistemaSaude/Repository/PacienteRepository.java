package br.com.SistemaSaude.SistemaSaude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaSaude.SistemaSaude.Entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    Paciente findByEmail(String username);
    
}

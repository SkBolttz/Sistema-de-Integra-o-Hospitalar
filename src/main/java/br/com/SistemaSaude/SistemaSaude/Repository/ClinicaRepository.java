package br.com.SistemaSaude.SistemaSaude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaSaude.SistemaSaude.Entity.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
    
}

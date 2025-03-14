package br.com.SistemaSaude.SistemaSaude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaSaude.SistemaSaude.Entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Medico findByEmail(String username);
    
}

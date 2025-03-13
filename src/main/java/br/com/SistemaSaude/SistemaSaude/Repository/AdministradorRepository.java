package br.com.SistemaSaude.SistemaSaude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaSaude.SistemaSaude.Entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    
}

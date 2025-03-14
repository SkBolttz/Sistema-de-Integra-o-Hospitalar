package br.com.SistemaSaude.SistemaSaude.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.SistemaSaude.SistemaSaude.DTO.LoginDTO;
import br.com.SistemaSaude.SistemaSaude.Entity.Administrador;
import br.com.SistemaSaude.SistemaSaude.Entity.Medico;
import br.com.SistemaSaude.SistemaSaude.Entity.Paciente;
import br.com.SistemaSaude.SistemaSaude.Repository.AdministradorRepository;
import br.com.SistemaSaude.SistemaSaude.Repository.MedicoRepository;
import br.com.SistemaSaude.SistemaSaude.Repository.PacienteRepository;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Paciente paciente = pacienteRepository.findByEmail(username);
        if (paciente != null) {
            return paciente;
        }
        
        Medico medico = medicoRepository.findByEmail(username);
        if (medico != null) {
            return medico;
        }
        
        Administrador administrador = administradorRepository.findByEmail(username);
        if (administrador != null) {
            return administrador;
        }
        
        throw new UsernameNotFoundException("Usuário não encontrado");
    }

    public void login(LoginDTO usuario) {

        }

    public void register(LoginDTO usuario) {

    }
    
}

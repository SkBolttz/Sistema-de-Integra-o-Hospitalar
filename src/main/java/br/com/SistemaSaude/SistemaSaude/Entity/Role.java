package br.com.SistemaSaude.SistemaSaude.Entity;

public enum Role {
    ADMINISTRADOR("Administrador"),
    PACIENTE("Paciente"),
    CLINICA("Clinica"),
    MEDICO("Medico");

    @SuppressWarnings("unused")
    private String name;

    Role(String name) {
        this.name = name;
    }
}

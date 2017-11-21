package com.arboreto.negocio;

import com.arboreto.entidade.Administrador;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IAdministrador {
    
    public void create(Administrador administrador);
    public List<Administrador> consultar();
    public List<Administrador> login(String email, String senha);
    public Administrador selecionar(Long id);
    public boolean remover(Administrador administrador);
}

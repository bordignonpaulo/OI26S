package com.arboreto.modelo;

import com.arboreto.negocio.IAdministrador;
import com.arboreto.entidade.Administrador;
import java.io.Serializable;
import javax.faces.event.ActionEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class AdministradorMB implements Serializable{

    private Administrador administrador = new Administrador();

    @EJB
    private IAdministrador admBean;

    public AdministradorMB() {
        administrador = new Administrador();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Administrador> listAdministrador() {
        return admBean.consultar();
    }

    public String add() {
        try {
            admBean.create(administrador);
            administrador = new Administrador();
            return "adicionado";
        } catch (Exception e) {
            return "erro";
        }

    }

    public String login() {

        try {
            if (admBean.login(administrador.getEmail(), administrador.getSenha()) != null) {
                return "logado";
            } else {
                return "erro";
            }
        } catch (Exception e) {
            return "erro";
        }

    }

    public String selecionar(ActionEvent evento) {
        try {
            Long codigo = (Long) evento.getComponent().getAttributes().get("codigo");
            administrador = admBean.selecionar(codigo); 
            return "adicionar";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public void remover() {
                
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = admBean.remover(administrador);

        if (resultado) {
            administrador = new Administrador();
            context.addMessage(null, new FacesMessage("Cliente removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover cliente!"));
        }
    }
}

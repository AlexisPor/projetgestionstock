package view.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.ClientDaoImpl;
import persistence.entities.TClient;

@ManagedBean
@SessionScoped
public class ClientMBean {

	private ClientDaoImpl cDaoImpl = new ClientDaoImpl();
	private TClient client = new TClient();
	private List<TClient> listCl = new ArrayList<TClient>();
	private TClient selectedClient = new TClient();
	private String valueSearch;
	private String typeSearch;

	public ClientMBean() {
		// TODO Auto-generated constructor stub
		listCl = cDaoImpl.findAll();
	}

	public String getValueSearch() {
		return valueSearch;
	}

	public void setValueSearch(String valueSearch) {
		this.valueSearch = valueSearch;
	}

	public String getTypeSearch() {
		return typeSearch;
	}

	public void setTypeSearch(String typeSearch) {
		this.typeSearch = typeSearch;
	}

	public TClient getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(TClient selectedClient) {
		this.selectedClient = selectedClient;
	}

	public ClientDaoImpl getcDaoImpl() {
		return cDaoImpl;
	}

	public void setcDaoImpl(ClientDaoImpl cDaoImpl) {
		this.cDaoImpl = cDaoImpl;
	}

	public List<TClient> getListCl() {
		return listCl;
	}

	public void setListCl(List<TClient> listCl) {
		this.listCl = listCl;
	}

	public TClient getClient() {
		return client;
	}

	public void setClient(TClient client) {
		this.client = client;
	}

	public void addClient(ActionEvent e) {
		cDaoImpl.add(client);
		client = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajoute à bien été réalisé"));
	}

	public void deleteClient(ActionEvent e) {
		cDaoImpl.delete(selectedClient);
		if (selectedClient == null || selectedClient.getCIdclient() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Veuillez sélectionner un client"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("La suppression à été réalisé avec succés"));
		}

	}

	public void updateClient() {
		cDaoImpl.update(selectedClient);
	}

	public List<TClient> searchClient(ActionEvent e) {
		if (typeSearch.equals("nom")) {
			listCl = cDaoImpl.findByNom(valueSearch);
			
			return listCl;
		} else if (typeSearch.equals("prenom")) {
			listCl = cDaoImpl.findByPrenom(valueSearch);
			return listCl;

		} else if (typeSearch.equals("date")) {
			listCl = cDaoImpl.findByDate(valueSearch);
			return listCl;

		}
		return listCl;
	}
	
	public List<TClient> allSearch() {
        listCl = cDaoImpl.findAll();
        return listCl;
    }

}

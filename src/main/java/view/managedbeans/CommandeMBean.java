package view.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.CommandeDaoImpl;
import persistence.entities.TCommande;

@ManagedBean
@SessionScoped
public class CommandeMBean {
	private TCommande com = new TCommande();
	private CommandeDaoImpl cDaoImpl = new CommandeDaoImpl();
	private List<TCommande> listC = new ArrayList<TCommande>();
	private TCommande selectedcom = new TCommande();
	private String typeSearch;
	private Date dDebut;
	private Date dFin;
	private BigDecimal valueEtat;
	
	
	public String getTypeSearch() {
		return typeSearch;
	}

	public void setTypeSearch(String typeSearch) {
		this.typeSearch = typeSearch;
	}

	public Date getdDebut() {
		return dDebut;
	}

	public void setdDebut(Date dDebut) {
		this.dDebut = dDebut;
	}

	public Date getdFin() {
		return dFin;
	}

	public void setdFin(Date dFin) {
		this.dFin = dFin;
	}

	public BigDecimal getValueEtat() {
		return valueEtat;
	}

	public void setValueEtat(BigDecimal valueEtat) {
		this.valueEtat = valueEtat;
	}

	public CommandeMBean() {
		listC=cDaoImpl.findAll();
	}

	public TCommande getSelectedcom() {
		return selectedcom;
	}

	public void setSelectedcom(TCommande selectedcom) {
		this.selectedcom = selectedcom;
	}

	public TCommande getCom() {
		return com;
	}

	public void setCom(TCommande com) {
		this.com = com;
	}

	public CommandeDaoImpl getcDaoImpl() {
		return cDaoImpl;
	}

	public void setcDaoImpl(CommandeDaoImpl cDaoImpl) {
		this.cDaoImpl = cDaoImpl;
	}

	public List<TCommande> getListC() {
		return listC;
	}

	public void setListC(List<TCommande> listC) {
		this.listC = listC;
	}

	public void addCommande(ActionEvent e) {
		
		cDaoImpl.add(com);
		com=null;
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("La commande à bien été ajouté"));
	}
	
	public void deleteCommande() {
		cDaoImpl.delete(selectedcom);
		if(selectedcom==null || selectedcom.getCIdcommande()==new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Attention","Veuillez sélectionner une commande"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression à bien été réalisé"));
		}
		
	}
	
	public void updateCommande() {
		cDaoImpl.update(selectedcom);
	}
	
	public List<TCommande> searchCommandeByEtat(ActionEvent e) {
			listC = cDaoImpl.findByEtat(valueEtat);
		
		return listC;
	}
	
	public List<TCommande> searchCommandeByDate() {
			listC=cDaoImpl.findByDate(dDebut, dFin);
		
		
		return listC;
		
	}
	
	
	public List<TCommande> allSearch(){
		listC=cDaoImpl.findAll();
		return listC;
	}
	
}

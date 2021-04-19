package view.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.ProduitDaoImpl;
import persistence.entities.TProduit;

@ManagedBean
@SessionScoped
public class ProduitMBean {

	private TProduit prod = new TProduit();
	ProduitDaoImpl pDaoImpl = new ProduitDaoImpl();
	private List<TProduit> listP = new ArrayList<TProduit>();
	TProduit selectedProd = new TProduit();
	private String typeSearch;
	private String valueSearch;
	

	public ProduitMBean() {
		listP = pDaoImpl.findAll();
	}

	public TProduit getSelectedProd() {
		return selectedProd;
	}

	public void setSelectedProd(TProduit selectedProd) {
		this.selectedProd = selectedProd;
	}

	public ProduitDaoImpl getpDaoImpl() {
		return pDaoImpl;
	}

	public void setpDaoImpl(ProduitDaoImpl pDaoImpl) {
		this.pDaoImpl = pDaoImpl;
	}

	public List<TProduit> getListP() {
		return listP;
	}

	public void setListP(List<TProduit> listP) {
		this.listP = listP;
	}

	public TProduit getProd() {
		return prod;
	}

	public void setProd(TProduit prod) {
		this.prod = prod;
	}
	
	public void addProduit(ActionEvent e) {
		pDaoImpl.add(prod);
		prod=null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout à été réalisé avec succés"));
	}
	
	public void deleteProduit(ActionEvent e) {
		pDaoImpl.delete(selectedProd);
		if(selectedProd==null || selectedProd.getPIdproduit()== new BigDecimal(0)) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Attention","Veuillez sélectionner un produit"));
		}
		else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression à bien été réalisé"));
		}
		
	}
	
	public  List<TProduit> allSearch() {
		listP = pDaoImpl.findAll();
		return listP;
	}

	public String getTypeSearch() {
		return typeSearch;
	}

	public void setTypeSearch(String typeSearch) {
		this.typeSearch = typeSearch;
	}

	public String getValueSearch() {
		return valueSearch;
	}

	public void setValueSearch(String valueSearch) {
		this.valueSearch = valueSearch;
	}

	public void updateProduit(ActionEvent e) {
		pDaoImpl.update(selectedProd);
	}
	
	public List<TProduit> searchProduit(ActionEvent e) {
		
		if (typeSearch.equals("design")) {
			listP = pDaoImpl.findByDesign(valueSearch);
			
			return listP;
		} else if (typeSearch.equals("marque")) {
			listP = pDaoImpl.findByMarque(valueSearch);
			return listP;

		}
		return listP;
	
	}
	
}

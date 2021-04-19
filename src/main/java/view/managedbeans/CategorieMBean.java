package view.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.CategorieDaoImpl;
import persistence.entities.TCategorie;

@ManagedBean
@SessionScoped
public class CategorieMBean {
	
	private CategorieDaoImpl cDaoImpl=new CategorieDaoImpl();
	private TCategorie cat = new TCategorie();
	private List<TCategorie> listCa = new ArrayList<TCategorie>();
	private TCategorie selectedCat = new TCategorie();
	
	public CategorieDaoImpl getcDaoImpl() {
		return cDaoImpl;
	}
	
	public void setcDaoImpl(CategorieDaoImpl cDaoImpl) {
		this.cDaoImpl = cDaoImpl;
	}
	
	public TCategorie getCat() {
		return cat;
	}
	
	public void setCat(TCategorie cat) {
		this.cat = cat;
	}
	
	public List<TCategorie> getListCa() {
		listCa=cDaoImpl.findAll();
		return listCa;
	}
	
	public void setListCa(List<TCategorie> listCa) {
		this.listCa = listCa;
	}
	
	public TCategorie getSelectedCat() {
		return selectedCat;
	}
	
	public void setSelectedCat(TCategorie selectedCat) {
		this.selectedCat = selectedCat;
	}
	
	
	public void addCategorie(ActionEvent e) {
		cDaoImpl.add(cat);
		cat=null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La catégorie à bien été ajoutée"));
		
	}
	
	public void deleteCategorie(ActionEvent e) {
		cDaoImpl.delete(selectedCat);
		if(selectedCat==null || selectedCat.getCIdcateg()==new BigDecimal(0)) {
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Attention","Veuillez sélectionner un produit"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression à bien été réalisé"));
		}
		
	}
	
	public void updateCategorie(ActionEvent e) {
		cDaoImpl.update(selectedCat);
	}

}

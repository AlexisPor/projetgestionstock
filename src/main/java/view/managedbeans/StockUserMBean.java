package view.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.dao.StockUserDaoImpl;
import persistence.entities.TStockuser;

@ManagedBean
@SessionScoped
public class StockUserMBean {
	
	StockUserDaoImpl sDaoImpl = new StockUserDaoImpl();
	TStockuser tstock = new TStockuser();
	TStockuser selectTStock = new TStockuser();
	List<TStockuser> listTS = new ArrayList<TStockuser>();
	
	
	
	public TStockuser getSelectTStock() {
		return selectTStock;
	}

	public void setSelectTStock(TStockuser selectTStock) {
		this.selectTStock = selectTStock;
	}

	public List<TStockuser> getListTS() {
		return listTS;
	}

	public void setListTS(List<TStockuser> listTS) {
		this.listTS = listTS;
	}

	public StockUserMBean() {
		listTS = sDaoImpl.findAll();
	}

	public void addUtilisateur(ActionEvent e) {
		sDaoImpl.add(tstock);
		tstock=null;
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("L'ajout à bien été réalisé"));
	}

	public void deleteUtilisateur(ActionEvent e) {
		sDaoImpl.delete(tstock);
		if(selectTStock==null || selectTStock.getSIduser()==new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Attention","Veuillez sélectionner un utilisateur"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression à bien été réalisé"));
		}
	}
	
	public void updateUtilisateur(ActionEvent e) {
		sDaoImpl.update(selectTStock);
	}
	public StockUserDaoImpl getsDaoImpl() {
		return sDaoImpl;
	}

	public void setsDaoImpl(StockUserDaoImpl sDaoImpl) {
		this.sDaoImpl = sDaoImpl;
	}

	public TStockuser getTstock() {
		return tstock;
	}

	public void setTstock(TStockuser tstock) {
		this.tstock = tstock;
	}
	
	public String login() {
      tstock = sDaoImpl.findUserByLoginAndPassword(tstock.getSUsername(), tstock.getSPassword());
      System.out.println(tstock.getSPassword()+tstock.getSUsername());
      if (sDaoImpl.findUserByLoginAndPassword(tstock.getSUsername(), tstock.getSPassword()) != null) {
          return "Acceuil.xhtml";
      } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Utilisateur inexistant"));
          return "login.xhtml";
      }
  }

}

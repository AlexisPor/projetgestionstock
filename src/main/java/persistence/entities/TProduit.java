package persistence.entities;
// Generated 15 avr. 2021 � 15:20:58 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TProduit generated by hbm2java
 */
@Entity
@Table(name = "T_PRODUIT", schema = "TPHIBERNATE")
public class TProduit implements java.io.Serializable {

	private BigDecimal PIdproduit;
	private TCategorie TCategorie;
	private String PDesigproduit;
	private BigDecimal PPuproduit;
	private BigDecimal PQteproduit;
	private String PConfigproduit;
	private String PMarqueproduit;
	private String PModeleproduit;
	private Set<TCommande> TCommandes = new HashSet<TCommande>(0);

	public TProduit() {
	}

	public TProduit(BigDecimal PIdproduit) {
		this.PIdproduit = PIdproduit;
	}

	public TProduit(BigDecimal PIdproduit, TCategorie TCategorie, String PDesigproduit, BigDecimal PPuproduit,
			BigDecimal PQteproduit, String PConfigproduit, String PMarqueproduit, String PModeleproduit,
			Set<TCommande> TCommandes) {
		this.PIdproduit = PIdproduit;
		this.TCategorie = TCategorie;
		this.PDesigproduit = PDesigproduit;
		this.PPuproduit = PPuproduit;
		this.PQteproduit = PQteproduit;
		this.PConfigproduit = PConfigproduit;
		this.PMarqueproduit = PMarqueproduit;
		this.PModeleproduit = PModeleproduit;
		this.TCommandes = TCommandes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TPRODUIT_SEQ", sequenceName = "TPRODUIT_SEQ")
	@Column(name = "P_IDPRODUIT", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPIdproduit() {
		return this.PIdproduit;
	}

	public void setPIdproduit(BigDecimal PIdproduit) {
		this.PIdproduit = PIdproduit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "P_IDCATEGORIE")
	public TCategorie getTCategorie() {
		return this.TCategorie;
	}

	public void setTCategorie(TCategorie TCategorie) {
		this.TCategorie = TCategorie;
	}

	@Column(name = "P_DESIGPRODUIT", length = 254)
	public String getPDesigproduit() {
		return this.PDesigproduit;
	}

	public void setPDesigproduit(String PDesigproduit) {
		this.PDesigproduit = PDesigproduit;
	}

	@Column(name = "P_PUPRODUIT", precision = 22, scale = 0)
	public BigDecimal getPPuproduit() {
		return this.PPuproduit;
	}

	public void setPPuproduit(BigDecimal PPuproduit) {
		this.PPuproduit = PPuproduit;
	}

	@Column(name = "P_QTEPRODUIT", precision = 22, scale = 0)
	public BigDecimal getPQteproduit() {
		return this.PQteproduit;
	}

	public void setPQteproduit(BigDecimal PQteproduit) {
		this.PQteproduit = PQteproduit;
	}

	@Column(name = "P_CONFIGPRODUIT", length = 254)
	public String getPConfigproduit() {
		return this.PConfigproduit;
	}

	public void setPConfigproduit(String PConfigproduit) {
		this.PConfigproduit = PConfigproduit;
	}

	@Column(name = "P_MARQUEPRODUIT", length = 254)
	public String getPMarqueproduit() {
		return this.PMarqueproduit;
	}

	public void setPMarqueproduit(String PMarqueproduit) {
		this.PMarqueproduit = PMarqueproduit;
	}

	@Column(name = "P_MODELEPRODUIT", length = 254)
	public String getPModeleproduit() {
		return this.PModeleproduit;
	}

	public void setPModeleproduit(String PModeleproduit) {
		this.PModeleproduit = PModeleproduit;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProduit")
	public Set<TCommande> getTCommandes() {
		return this.TCommandes;
	}

	public void setTCommandes(Set<TCommande> TCommandes) {
		this.TCommandes = TCommandes;
	}

}
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TClient generated by hbm2java
 */
@Entity
@Table(name = "T_CLIENT", schema = "TPHIBERNATE")
public class TClient implements java.io.Serializable {

	private BigDecimal CIdclient;
	private String CLoginclient;
	private String CMotpasseclient;
	private String CNomclient;
	private String CPrenomclient;
	private String CCiviliteclient;
	private String CDatenaissanceclient;
	private String CNumeroadrclient;
	private String CCommuneadrclient;
	private String CVilleadrclient;
	private String CCpadrclient;
	private String CTelclient;
	private String CFaxclient;
	private String CGsmclient;
	private String CEmailclient;
	private Set<TCommande> TCommandes = new HashSet<TCommande>(0);

	public TClient() {
	}

	public TClient(BigDecimal CIdclient) {
		this.CIdclient = CIdclient;
	}

	public TClient(BigDecimal CIdclient, String CLoginclient, String CMotpasseclient, String CNomclient,
			String CPrenomclient, String CCiviliteclient, String CDatenaissanceclient, String CNumeroadrclient,
			String CCommuneadrclient, String CVilleadrclient, String CCpadrclient, String CTelclient, String CFaxclient,
			String CGsmclient, String CEmailclient, Set<TCommande> TCommandes) {
		this.CIdclient = CIdclient;
		this.CLoginclient = CLoginclient;
		this.CMotpasseclient = CMotpasseclient;
		this.CNomclient = CNomclient;
		this.CPrenomclient = CPrenomclient;
		this.CCiviliteclient = CCiviliteclient;
		this.CDatenaissanceclient = CDatenaissanceclient;
		this.CNumeroadrclient = CNumeroadrclient;
		this.CCommuneadrclient = CCommuneadrclient;
		this.CVilleadrclient = CVilleadrclient;
		this.CCpadrclient = CCpadrclient;
		this.CTelclient = CTelclient;
		this.CFaxclient = CFaxclient;
		this.CGsmclient = CGsmclient;
		this.CEmailclient = CEmailclient;
		this.TCommandes = TCommandes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TCLIENT_SEQ", sequenceName = "TCLIENT_SEQ")
	@Column(name = "C_IDCLIENT", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCIdclient() {
		return this.CIdclient;
	}

	public void setCIdclient(BigDecimal CIdclient) {
		this.CIdclient = CIdclient;
	}

	@Column(name = "C_LOGINCLIENT", length = 254)
	public String getCLoginclient() {
		return this.CLoginclient;
	}

	public void setCLoginclient(String CLoginclient) {
		this.CLoginclient = CLoginclient;
	}

	@Column(name = "C_MOTPASSECLIENT", length = 254)
	public String getCMotpasseclient() {
		return this.CMotpasseclient;
	}

	public void setCMotpasseclient(String CMotpasseclient) {
		this.CMotpasseclient = CMotpasseclient;
	}

	@Column(name = "C_NOMCLIENT", length = 254)
	public String getCNomclient() {
		return this.CNomclient;
	}

	public void setCNomclient(String CNomclient) {
		this.CNomclient = CNomclient;
	}

	@Column(name = "C_PRENOMCLIENT", length = 254)
	public String getCPrenomclient() {
		return this.CPrenomclient;
	}

	public void setCPrenomclient(String CPrenomclient) {
		this.CPrenomclient = CPrenomclient;
	}

	@Column(name = "C_CIVILITECLIENT", length = 254)
	public String getCCiviliteclient() {
		return this.CCiviliteclient;
	}

	public void setCCiviliteclient(String CCiviliteclient) {
		this.CCiviliteclient = CCiviliteclient;
	}

	@Column(name = "C_DATENAISSANCECLIENT", length = 20)
	public String getCDatenaissanceclient() {
		return this.CDatenaissanceclient;
	}

	public void setCDatenaissanceclient(String CDatenaissanceclient) {
		this.CDatenaissanceclient = CDatenaissanceclient;
	}

	@Column(name = "C_NUMEROADRCLIENT", length = 254)
	public String getCNumeroadrclient() {
		return this.CNumeroadrclient;
	}

	public void setCNumeroadrclient(String CNumeroadrclient) {
		this.CNumeroadrclient = CNumeroadrclient;
	}

	@Column(name = "C_COMMUNEADRCLIENT", length = 254)
	public String getCCommuneadrclient() {
		return this.CCommuneadrclient;
	}

	public void setCCommuneadrclient(String CCommuneadrclient) {
		this.CCommuneadrclient = CCommuneadrclient;
	}

	@Column(name = "C_VILLEADRCLIENT", length = 254)
	public String getCVilleadrclient() {
		return this.CVilleadrclient;
	}

	public void setCVilleadrclient(String CVilleadrclient) {
		this.CVilleadrclient = CVilleadrclient;
	}

	@Column(name = "C_CPADRCLIENT", length = 254)
	public String getCCpadrclient() {
		return this.CCpadrclient;
	}

	public void setCCpadrclient(String CCpadrclient) {
		this.CCpadrclient = CCpadrclient;
	}

	@Column(name = "C_TELCLIENT", length = 254)
	public String getCTelclient() {
		return this.CTelclient;
	}

	public void setCTelclient(String CTelclient) {
		this.CTelclient = CTelclient;
	}

	@Column(name = "C_FAXCLIENT", length = 254)
	public String getCFaxclient() {
		return this.CFaxclient;
	}

	public void setCFaxclient(String CFaxclient) {
		this.CFaxclient = CFaxclient;
	}

	@Column(name = "C_GSMCLIENT", length = 254)
	public String getCGsmclient() {
		return this.CGsmclient;
	}

	public void setCGsmclient(String CGsmclient) {
		this.CGsmclient = CGsmclient;
	}

	@Column(name = "C_EMAILCLIENT", length = 254)
	public String getCEmailclient() {
		return this.CEmailclient;
	}

	public void setCEmailclient(String CEmailclient) {
		this.CEmailclient = CEmailclient;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TClient")
	public Set<TCommande> getTCommandes() {
		return this.TCommandes;
	}

	public void setTCommandes(Set<TCommande> TCommandes) {
		this.TCommandes = TCommandes;
	}

}

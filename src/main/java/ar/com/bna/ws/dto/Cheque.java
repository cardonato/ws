package ar.com.bna.ws.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Cheque", description="Objeto Cheque")
public class Cheque implements Serializable {

	private static final long serialVersionUID = -4287876029481275359L;

	private Long id;
	private String idBanco;
	private BigDecimal monto;
	private String dniBeneficiario;
	private String cmc7;
	private Date fechaPago;
	private Boolean modificado;

	public Cheque() {
		super();
		modificado = false;
	}

	public Cheque(Long id, String idBanco, BigDecimal monto, String dniBeneficiario, String cmc7, Date fechaPago) {
		super();
		this.id = id;
		this.idBanco = idBanco;
		this.monto = monto;
		this.dniBeneficiario = dniBeneficiario;
		this.cmc7 = cmc7;
		this.fechaPago = fechaPago;
		modificado = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getDniBeneficiario() {
		return dniBeneficiario;
	}

	public void setDniBeneficiario(String dniBeneficiario) {
		this.dniBeneficiario = dniBeneficiario;
	}

	public String getCmc7() {
		return cmc7;
	}

	public void setCmc7(String cmc7) {
		this.cmc7 = cmc7;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Boolean getModificado() {
		return modificado;
	}

	public void setModificado(Boolean modificado) {
		this.modificado = modificado;
	}

}

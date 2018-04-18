package prova.model;

import java.util.List;

public class Comissionado {

	private Integer id_comissionado;
	private Float totalVenda;
	private Float taxaComissao;
	
	public Integer getId_comissionado() {
		return id_comissionado;
	}
	public void setId_comissionado (Integer id_comissionado) {
		this.id_comissionado = id_comissionado;
	}
	
	public Float getTotalVenda (){
		return totalVenda;
	}
	public void setTotalVenda (Float totalVenda){
		this.totalVenda = totalVenda;
	}
	
	public Float getTaxaComissao (){
		return taxaComissao;
	}
	public void setTaxaComissao (Float taxaComissao){
		this.taxaComissao = taxaComissao;
	}
}

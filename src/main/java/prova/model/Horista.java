package prova.model;


public class Horista {

	private Integer id_horista;
	private Float precoHora;
	private Float horasTrabalhadas;
	
	public Integer getId_horista() {
		return id_horista;
	}
	public void setId_horista(Integer id_horista) {
		this.id_horista = id_horista;
	}
	
	public Float getPrecoHora (){
		return precoHora;
	}
	public void setPrecoHora (Float precoHora){
		this.precoHora = precoHora;
	}
	
	public Float getHorasTrabalhadas (){
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas (Float horasTrabalhadas){
		this.horasTrabalhadas = horasTrabalhadas;
	}
}

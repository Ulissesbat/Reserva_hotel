package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import entities.enums.SituacaoReserva;

public class Hospede extends Reserva {
	
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private Integer cep;
	private String rua;
	private Integer numeroRua;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer documeto;
	
	
	
	public Hospede(String nomeResponsavel, LocalDateTime dataReserva, LocalDate dataEntrada, LocalDate dataSaida,
			SituacaoReserva situcacaoReseva, String nome, Date dataNascimento, String sexo, Integer cep, String rua,
			Integer numeroRua, String bairro, String cidade, String estado, Integer documeto) {
		super(nomeResponsavel, dataReserva, dataEntrada, dataSaida, situcacaoReseva);
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cep = cep;
		this.rua = rua;
		this.numeroRua = numeroRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.documeto = documeto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumeroRua() {
		return numeroRua;
	}
	public void setNumeroRua(Integer numeroRua) {
		this.numeroRua = numeroRua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getDocumeto() {
		return documeto;
	}
	public void setDocumeto(Integer documeto) {
		this.documeto = documeto;
	}
	
}

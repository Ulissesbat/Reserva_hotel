package model.dao;

import java.util.List;

import entities.Hospede;

public interface HospedeDao {

	void insert (Hospede obj);
	void update(Hospede obj);
	void deletById(Integer id);
	Hospede findById(Integer id);
	List<HospedeDao> findAll();
	List<Hospede> findByHospede(Hospede Hospede);
}

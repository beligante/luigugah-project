package com.entity;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.repository.Repository;

public class teste {

	public static void main(String[] args) throws ParseException {
		
		Repository<Obra> repo = new Repository<Obra>();
		
		List<Obra> l;
		
		Obra harry = new Obra();
		
		repo.merge(harry);
		
		
	}
	
}

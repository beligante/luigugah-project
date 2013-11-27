package com.interfaces;

import java.util.Collection;

import com.entity.Entity;

public interface Filter<Entidade extends Entity> {

	Collection<Entidade> searchByName(String name);
}

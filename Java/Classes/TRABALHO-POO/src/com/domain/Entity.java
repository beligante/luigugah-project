package com.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;

@MappedSuperclass
public abstract class Entity implements Comparable<Entity>{
	
        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        @PrimaryKeyJoinColumn
	protected Long id;

	public long getId() {
		return id;
	}

        public void setId(Long id){this.id = id;}
        
	@Override
	public int compareTo(Entity entidade) {
		return this.id.compareTo(entidade.getId());
	}
	
}

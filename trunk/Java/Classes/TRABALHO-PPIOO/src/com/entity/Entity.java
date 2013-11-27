package com.entity;

public class Entity implements Comparable<Entity> {

	protected  Long id;

	protected static long INSTANCE_COUNTING = 0;
	
	public Entity(){
		this.id = INSTANCE_COUNTING++;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public int compareTo(Entity entidade) {
		return this.id.compareTo(entidade.getId());
	}
}

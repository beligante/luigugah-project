package com.domain;

public abstract class Entity implements Comparable<Entity>{
	private static long INSTANCE_COUNT = 0;
	
	protected long id;
	
	public Entity(){
		this.id = INSTANCE_COUNT++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}

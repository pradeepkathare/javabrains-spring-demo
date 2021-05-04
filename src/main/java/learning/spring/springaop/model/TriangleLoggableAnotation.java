package learning.spring.springaop.model;

import learning.spring.springaop.aspects.LoggableCustomAnnotation;

public class TriangleLoggableAnotation {

	private String name;

	@LoggableCustomAnnotation
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

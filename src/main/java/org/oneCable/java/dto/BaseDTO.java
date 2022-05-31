package org.oneCable.java.dto;

import java.io.Serializable;

public interface BaseDTO<B, E> extends Serializable {

	public E convertToEntity();
	public void convertToDTO(E entity, boolean partialFill);
	public B convertToNewDTO(E e, boolean partialFill);

}

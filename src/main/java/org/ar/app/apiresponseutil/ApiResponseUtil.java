package org.ar.app.apiresponseutil;

public class ApiResponseUtil<T> {

	private String mensaje;
	private Integer code;
	private T entity;

	public ApiResponseUtil(String mensaje, Integer code, T entity) {
		super();
		this.mensaje = mensaje;
		this.code = code;
		this.entity = entity;
	}

	public ApiResponseUtil(String mensaje, Integer code) {
		super();
		this.mensaje = mensaje;
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

}

package ar.edu.unlam.pb220202c.eva03;

public class Vehiculo implements Imultable , Comparable<Vehiculo>{

	//Se debe crear contructeres getters y Setters y los que crean convenientes
	private String patente;
	private Integer VelocidadActual;
	private Integer limiteVelocidad;
	
	
	
	public Vehiculo(String patente, Integer velocidadActual, Integer limiteVelocidad) {
		super();
		this.patente = patente;
		VelocidadActual = velocidadActual;
		this.limiteVelocidad = limiteVelocidad;
	}

	

	public void incrmentarVelocidad(Integer Velocidad) {
		this.VelocidadActual++;
	}


	@Override
	public Boolean enInfraccion() {
		if (this.VelocidadActual> this.limiteVelocidad) {
			return true;
		}
		return false;
	}



	public String getPatente() {
		return patente;
	}

	


	public void setPatente(String patente) {
		this.patente = patente;
	}



	public Integer getVelocidadActual() {
		return VelocidadActual;
	}



	public void setVelocidadActual(Integer velocidadActual) {
		VelocidadActual = velocidadActual;
	}



	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}



	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}



	@Override
	public int compareTo(Vehiculo vehiculo) {
		
		return this.patente.compareTo(vehiculo.getPatente());
	}
	
	
}

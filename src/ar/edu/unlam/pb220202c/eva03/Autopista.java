package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	private TreeSet <Vehiculo> vehiculosConExcesoDeVelocidad;
	private String nombre;
	
	
	public Autopista(String nombre) {
		this.nombre = nombre;
		this.telepase = new HashMap <Integer, Vehiculo>();
		this.vehiculosEnCirculacion = new HashSet <Vehiculo>();
		this.vehiculosConExcesoDeVelocidad = new TreeSet <Vehiculo>();
	}
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		telepase.put(numeroTelpase, vehiculo);
		this.vehiculosEnCirculacion.add(vehiculo);
		return true;
				
		
	}
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		if(telepase.containsKey(numeroTelepase)) {
			return true;			
		}
		
		throw new VehiculoNotFounException("vehiculo no registrado");
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if(!vehiculosEnCirculacion.contains(vehiculo)) {
			throw new VehiculoNotFounException("no esta en circulacion");
		}
	}
	
	public Boolean siPasaLimiteVelocidad(Vehiculo vehiculo) {
		Boolean enExceso= false;
		if(vehiculo.enInfraccion()) {
		 vehiculosConExcesoDeVelocidad.add(vehiculo);
		enExceso = true;
		}
		return enExceso;
	}
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){

	return this.vehiculosConExcesoDeVelocidad;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
		return vehiculosEnCirculacion.size();
	
	}
	public Integer cantidadDeVehiculosEnExcesoDeVelocidad() {
		return this.vehiculosConExcesoDeVelocidad.size();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}

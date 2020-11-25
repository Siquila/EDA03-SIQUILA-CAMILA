package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 50, 130);
		
		assertTrue(autopista.registrarTelepase(1465,auto));
	}
	@Test
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 50, 130);
		autopista.registrarTelepase(1465,auto);
		autopista.ingresarAutopista(1465);
		
		autopista.salirAutpista(auto);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 131, 130);
		Automovil auto2 = new Automovil("BBCDF", 131, 130);
		Automovil auto3 = new Automovil("ZBCDF", 131, 130);
		Automovil auto4 = new Automovil("WBCDF", 131, 130);
		
		
		autopista.controlarVehiculoSiPasaLimiteVelocidad(auto);
		autopista.controlarVehiculoSiPasaLimiteVelocidad(auto2);
		autopista.controlarVehiculoSiPasaLimiteVelocidad(auto3);
		autopista.controlarVehiculoSiPasaLimiteVelocidad(auto4);		
		
		
	assertEquals("ABCDF",autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first().getPatente());
	assertEquals("ZBCDF",autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last().getPatente() )	;
	}

	public void generetestAEleccion1() {
		
	}
	
	public void generetestAEleccion2() {
		
	}
	
}

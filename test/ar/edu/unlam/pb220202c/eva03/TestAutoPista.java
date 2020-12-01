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
	@Test (expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 50, 130);
		
		autopista.salirAutpista(auto);
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 131, 130);
		Automovil auto2 = new Automovil("BBCDF", 131, 130);
		Automovil auto3 = new Automovil("ZBCDF", 131, 130);
		Automovil auto4 = new Automovil("WBCDF", 131, 130);
		
		
		autopista.siPasaLimiteVelocidad(auto);
		autopista.siPasaLimiteVelocidad(auto2);
		autopista.siPasaLimiteVelocidad(auto3);
		autopista.siPasaLimiteVelocidad(auto4);
		
	String veFirst = "ABCDF";
	String veLast = "ZBCDF";
	String first = autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first().getPatente();
	String last = autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last().getPatente();
	
	
	assertEquals(veFirst,first);
	assertEquals(veLast ,last);
	}
	
	@Test
	public void siExcedeVelocidadQueEsteEnInfraccion() {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 131, 130);
		assertTrue(auto.enInfraccion());
	
	}
	
	public void queLacantidadDeAutosEnInfraccionSeaCorrecta() {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 131, 130);
		Automovil auto2 = new Automovil("BBCDF", 100, 130);
		Automovil auto3 = new Automovil("ZBCDF", 131, 130);
		Automovil auto4 = new Automovil("WBCDF", 15, 130);
		
		
		autopista.siPasaLimiteVelocidad(auto);
		autopista.siPasaLimiteVelocidad(auto2);
		autopista.siPasaLimiteVelocidad(auto3);
		autopista.siPasaLimiteVelocidad(auto4);
		
		Integer ve= 2;
		assertEquals(ve, autopista.cantidadDeVehiculosEnExcesoDeVelocidad());
	}
	
}

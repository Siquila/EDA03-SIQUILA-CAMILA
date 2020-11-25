package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertTrue;

public class TestAutoPista {
	
	
	public void queSePuedaRegistrarTelepase () {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 50, 130);
		
		assertTrue(autopista.registrarTelepase(1465,auto));
	}

	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista ("autopista de Buenos Aires");
		Automovil auto = new Automovil("ABCDF", 50, 130);
		
		autopista.salirAutpista(auto);
	}
	
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		
	}

	public void generetestAEleccion1() {
		
	}
	
	public void generetestAEleccion2() {
		
	}
	
}

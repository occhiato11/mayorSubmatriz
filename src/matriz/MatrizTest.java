package matriz;

import org.junit.*;


public class MatrizTest {

	Matriz m;
	
	@Before
	public void antes() {
		
		m = new Matriz();
		
	}
	
	@Test
	public void test() {

		m.mostrarMatrices();
		m.hallarMayorSubmatriz();
		
	}

}

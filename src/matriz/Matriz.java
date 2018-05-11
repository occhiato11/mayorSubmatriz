package matriz;

public class Matriz {

	int [][] mat;
	private int [][] aux;
	private int mayor;

	public Matriz() {
		
		mat = new int [4][4];
		aux = new int [4][4];
		

		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++)
				mat[i][j] = (int) (Math.random()*100) -50;
		inicializarMatrizAuxiliar();
	}

	public void mostrarMatrices() {

		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[i].length; j++)
				System.out.printf("(%3d) ",mat[i][j]);
			System.out.println("");
		}
		System.out.println("");
		
		for(int i=0; i<aux.length; i++)
		{
			for(int j=0; j<aux[i].length; j++)
				System.out.printf("(%3d) ",aux[i][j]);
			System.out.println("");
		}
		System.out.println("");
		
		
	}
	
	public void hallarMayorSubmatriz() {

		String pos = procesarMatrizAuxiliar();
			
		System.out.println(pos);
		System.out.println("mayor valor: " + mayor);
		
		
	}
	
	private String procesarMatrizAuxiliar() {

		String pos = null;
		for(int i=(aux.length-1); i>=0; i--)
			for(int j=(aux[i].length-1); j>=0; j--)
				for(int k=0; k<=i; k++)
					for(int l=0; l<=j; l++)
						if(k==i && l==j)
						{
							if(mayor < aux[i][j])
							{
								pos = "Desde: (" + i + "," + j + ") Hasta: (" + i + "," + j + ")";
								mayor = aux[i][j];
							}
						}
						else
						{
							int value = aux[i][j] - aux[k][j] - aux[i][l] + aux[k][l];
							if(mayor < value)
							{
								pos = "Desde: (" + (k+1) + "," + (l+1) + ") Hasta: (" + i + "," + j + ")";
								mayor = value;
							}
						}
		return pos;
	}

	private void inicializarMatrizAuxiliar() {
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++) {
				if(i>0)
					if(j>0)
						aux[i][j] = mat[i][j] + aux[i-1][j] + aux[i][j-1] - aux[i-1][j-1]; 			
					else
						aux[i][0] = mat[i][0] + aux[i-1][0];
				else
					if(j>0)
						aux[0][j] = mat[0][j] + aux[0][j-1];
					else
						aux[0][0] = mat[0][0];
			}
	}

}

package TP4;
/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class Pi 
{
  public static void main(String[] args) throws Exception 
  {
    // 10 workers, 50000 iterations each
	int i=16000;int j=1;
	while(true) {
		if(i==160000000) {
			break;
		}
		else {
		long startTime = System.currentTimeMillis();
		new Master().doRun(i, j); // ((i/j),j) pour le test de scalabilité forte
		long stopTime = System.currentTimeMillis();
		System.out.println("Temps d'excécution : " + (stopTime-startTime) +"ms");
		}
		
		if(j==16) {
			j=1;
			i=10*i;
		}
		else {
			j = 2*j;
		}
		
	}
  }
}

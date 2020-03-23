public class Assignment102 {
	public static void main(String[] args) {
		int i=0;double compteur = 0;
		while(i<10) {
			PiMonteCarlo PiVal = new PiMonteCarlo(16000000);
			long startTime = System.currentTimeMillis();
			double value = PiVal.getPi();
			long stopTime = System.currentTimeMillis();
			System.out.println("Approx value:" + value);
			System.out.println("Difference to exact value of pi: " + (value - Math.PI));
			System.out.println("Error: " + (value - Math.PI) / Math.PI * 100 + " %");
			System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
			System.out.println("Time Duration: " + (stopTime - startTime) + "ms");
			compteur += stopTime - startTime;
			i++;
		}
		compteur = compteur/10;
		System.out.println(compteur);
	}
}

import java.util.Scanner;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import groovy.lang.GroovyShell;


public class App {

	public static GroovyShell createMathShell() {
        GroovyShell shell = new GroovyShell();
        
        shell.evaluate("" +
	        "cos = {double x -> Math.cos(x)}\n" +   // predefine functions as lambda
	        "sin = {double x -> Math.sin(x)}\n" +   // expressions
	        "pi = Math.PI\n" +                      // define pi
	        "sqrt = {double x -> Math.sqrt(x)\n}" 
               
        );
        
        shell.evaluate("" +
	    	"tan = {double x -> Math.tan(x)}\n" +
	    	"atan = {double x -> Math.atan(x)}\n" +
	        "acos = {double x -> Math.acos(x)}\n" +
	        "asin = {double x -> Math.asin(x)}\n" 
	        
        );
        
        shell.evaluate("" +
			"cbrt = {double x -> Math.cbrt(x)}\n" +
			"exp = {double x -> Math.exp(x)}\n" +
			"log = {double x -> Math.log(x)}\n" +
			"log10 = {double x -> Math.log10(x)}\n" 
			
        );
   
        return shell;
        
    }
	
	public static String cin() {
		System.out.println("input:");
		return new Scanner(System.in).nextLine();
	}
	
	public static void main(String[] args) {
		new AppFrame();

		
	}

	public static void makeGraph() {
		PolynomialFunction f = new PolynomialFunction(new double[]{10,2,5,4,5,6,-5});
		Chart chart = new Chart(f.polynomialDerivative().getCoefficients(),-100,100,f.toString());
		
	}
	
	public static void firstSimpson() {
		SimpsonIntegrator simpson = new SimpsonIntegrator();
		double[] vector1 = new double[5];
		vector1[0] = 1;
		vector1[1] = 2;
		vector1[2] = 3;
		PolynomialFunction f = new PolynomialFunction(vector1);

		UnivariateFunction uf = (UnivariateFunction) f;
		
		System.out.println("To String " + uf.toString());
		System.out.println("Degree: " + f.degree());

		double i = simpson.integrate(100000, uf, -Float.MAX_VALUE, Float.MAX_VALUE);
		
		System.out.println("Simpson integral : " + i);
	
		
	}

	
	 
	

}

 package com.example ;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestCases {


 	private static double[] getExpectedArray(double a, double b, double c) {
	double discriminant = b * b - 4 * a * c;
		if (a == 0) {
			 double root =-c/(b);
			 return new double []{root};
		} else if (discriminant < 0) {
			  return new double[0];
		} else if (discriminant == 0) {
			double root = -b / (2 * a);
   			return new double[]{root};
 		} else {
 		double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
   			  double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		return new double[]{root1, root2};
	}
	}


 	public static void saveResultsToCSV(String filePath, double a, double b, double c, double[] solutions) {

 	try (FileWriter writer = new FileWriter(filePath)) {

 	 writer.append("Equation,ResultatX0,ResultatX1\n");

 	for (int i = 0; i < solutions.length; i++) {

 	writer.append("Equation " + (i + 1) + ":" + a + "x2+"+b+"x"+c+ "," + "," + solutions[i] + "\n");

 	}

 	System.out.println("Résultats enregistrés dans le fichier CSV : " + filePath);

 	} catch (IOException e) {

 	e.printStackTrace();

 	}

 	}
	@Test
	public void test_a_null_b_proche_zero_positif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 4.887453068704987, 0.0);
		saveResultsToCSV("resultats_equations.csv", 0.0, 4.887453068704987, 0.0,result);
		assertArrayEquals(getExpectedArray(0.0, 4.887453068704987, 0.0), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_normal_negatif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.1942666876914677E-7, -91.53497994527038, 5.187146669027095E-7);
		saveResultsToCSV("resultats_equations.csv", 2.1942666876914677E-7, -91.53497994527038, 5.187146669027095E-7,result);
		assertArrayEquals(getExpectedArray(2.1942666876914677E-7, -91.53497994527038, 5.187146669027095E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_proche_zero_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.4217645770087076E-7, -1.1075546231146172, 1.0539652129395782);
		saveResultsToCSV("resultats_equations.csv", -4.4217645770087076E-7, -1.1075546231146172, 1.0539652129395782,result);
		assertArrayEquals(getExpectedArray(-4.4217645770087076E-7, -1.1075546231146172, 1.0539652129395782), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_tres_proche_zero_positif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.373873535480235, 4.424164411841631E-7, -6.500181933491209E-7);
		saveResultsToCSV("resultats_equations.csv", 2.373873535480235, 4.424164411841631E-7, -6.500181933491209E-7,result);
		assertArrayEquals(getExpectedArray(2.373873535480235, 4.424164411841631E-7, -6.500181933491209E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_normal_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.2944883454288312, 440.4860335545795, 344.941204477132);
		saveResultsToCSV("resultats_equations.csv", -1.2944883454288312, 440.4860335545795, 344.941204477132,result);
		assertArrayEquals(getExpectedArray(-1.2944883454288312, 440.4860335545795, 344.941204477132), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_negatif_tres_grand_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 145.3274661525006, -1.236794303902551E8, 5.2602792971386755E8);
		saveResultsToCSV("resultats_equations.csv", 145.3274661525006, -1.236794303902551E8, 5.2602792971386755E8,result);
		assertArrayEquals(getExpectedArray(145.3274661525006, -1.236794303902551E8, 5.2602792971386755E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_null_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -326.9678299789971, 0.0, -457.3215820225891);
		saveResultsToCSV("resultats_equations.csv", -326.9678299789971, 0.0, -457.3215820225891,result);
		assertArrayEquals(getExpectedArray(-326.9678299789971, 0.0, -457.3215820225891), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_tres_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.3805176563354957E8, -8.191710984085378E-7, -2.7306889556839518);
		saveResultsToCSV("resultats_equations.csv", 2.3805176563354957E8, -8.191710984085378E-7, -2.7306889556839518,result);
		assertArrayEquals(getExpectedArray(2.3805176563354957E8, -8.191710984085378E-7, -2.7306889556839518), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_positif_tres_grand_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -8.969022802210252E8, 2.5036470854639706E8, -5.9213769856945395E7);
		saveResultsToCSV("resultats_equations.csv", -8.969022802210252E8, 2.5036470854639706E8, -5.9213769856945395E7,result);
		assertArrayEquals(getExpectedArray(-8.969022802210252E8, 2.5036470854639706E8, -5.9213769856945395E7), result, 0.001);
	}
	@Test
	public void test_a_null_b_null_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 0.0, -7.584001348871355E8);
		saveResultsToCSV("resultats_equations.csv", 0.0, 0.0, -7.584001348871355E8,result);
		assertArrayEquals(getExpectedArray(0.0, 0.0, -7.584001348871355E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_null_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.4301084354587424E-7, 0.0, 0.0);
		saveResultsToCSV("resultats_equations.csv", 1.4301084354587424E-7, 0.0, 0.0,result);
		assertArrayEquals(getExpectedArray(1.4301084354587424E-7, 0.0, 0.0), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_null_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -7.535849376525689E-7, 0.0, -2.269587214394722);
		saveResultsToCSV("resultats_equations.csv", -7.535849376525689E-7, 0.0, -2.269587214394722,result);
		assertArrayEquals(getExpectedArray(-7.535849376525689E-7, 0.0, -2.269587214394722), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_null_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.4302122901255365, 0.0, 5.801398688485702E-7);
		saveResultsToCSV("resultats_equations.csv", 2.4302122901255365, 0.0, 5.801398688485702E-7,result);
		assertArrayEquals(getExpectedArray(2.4302122901255365, 0.0, 5.801398688485702E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_null_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.932971590748915, 0.0, 4.618725090665199);
		saveResultsToCSV("resultats_equations.csv", -3.932971590748915, 0.0, 4.618725090665199,result);
		assertArrayEquals(getExpectedArray(-3.932971590748915, 0.0, 4.618725090665199), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_null_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 86.58017099859603, 0.0, 127.42681216469238);
		saveResultsToCSV("resultats_equations.csv", 86.58017099859603, 0.0, 127.42681216469238,result);
		assertArrayEquals(getExpectedArray(86.58017099859603, 0.0, 127.42681216469238), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_tres_proche_zero_positif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -191.7146577409598, 6.651525843042709E-7, -2.4360198625644434);
		saveResultsToCSV("resultats_equations.csv", -191.7146577409598, 6.651525843042709E-7, -2.4360198625644434,result);
		assertArrayEquals(getExpectedArray(-191.7146577409598, 6.651525843042709E-7, -2.4360198625644434), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_null_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4.8796268197340053E8, 0.0, 2.6268992935805517E8);
		saveResultsToCSV("resultats_equations.csv", 4.8796268197340053E8, 0.0, 2.6268992935805517E8,result);
		assertArrayEquals(getExpectedArray(4.8796268197340053E8, 0.0, 2.6268992935805517E8), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_null_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.2167547257991076E8, 0.0, -1.0504687176052646E-7);
		saveResultsToCSV("resultats_equations.csv", -2.2167547257991076E8, 0.0, -1.0504687176052646E-7,result);
		assertArrayEquals(getExpectedArray(-2.2167547257991076E8, 0.0, -1.0504687176052646E-7), result, 0.001);
	}
	@Test
	public void test_a_null_b_tres_proche_zero_negatif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -9.496925384818022E-7, 393.4271106011386);
		saveResultsToCSV("resultats_equations.csv", 0.0, -9.496925384818022E-7, 393.4271106011386,result);
		assertArrayEquals(getExpectedArray(0.0, -9.496925384818022E-7, 393.4271106011386), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_proche_zero_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4.98182807599503E-7, 2.9078383777696954, -1.0530856363789904E8);
		saveResultsToCSV("resultats_equations.csv", 4.98182807599503E-7, 2.9078383777696954, -1.0530856363789904E8,result);
		assertArrayEquals(getExpectedArray(4.98182807599503E-7, 2.9078383777696954, -1.0530856363789904E8), result, 0.001);
	}
	@Test
	public void test_a_null_b_proche_zero_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -3.374396281100391, -5.596320883833161E-7);
		saveResultsToCSV("resultats_equations.csv", 0.0, -3.374396281100391, -5.596320883833161E-7,result);
		assertArrayEquals(getExpectedArray(0.0, -3.374396281100391, -5.596320883833161E-7), result, 0.001);
	}
	@Test
	public void test_a_null_b_normal_positif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 340.71605395589097, 3.8573832121130422);
		saveResultsToCSV("resultats_equations.csv", 0.0, 340.71605395589097, 3.8573832121130422,result);
		assertArrayEquals(getExpectedArray(0.0, 340.71605395589097, 3.8573832121130422), result, 0.001);
	}
	@Test
	public void test_a_null_b_normal_negatif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -396.932453769522, 9.262235325835959E8);
		saveResultsToCSV("resultats_equations.csv", 0.0, -396.932453769522, 9.262235325835959E8,result);
		assertArrayEquals(getExpectedArray(0.0, -396.932453769522, 9.262235325835959E8), result, 0.001);
	}
	@Test
	public void test_a_null_b_positif_tres_grand_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 3.844617591944672E8, -4.7381126812180625);
		saveResultsToCSV("resultats_equations.csv", 0.0, 3.844617591944672E8, -4.7381126812180625,result);
		assertArrayEquals(getExpectedArray(0.0, 3.844617591944672E8, -4.7381126812180625), result, 0.001);
	}
	@Test
	public void test_a_null_b_negatif_tres_grand_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -5.0626877555784476E8, 2.4020289860371434E-7);
		saveResultsToCSV("resultats_equations.csv", 0.0, -5.0626877555784476E8, 2.4020289860371434E-7,result);
		assertArrayEquals(getExpectedArray(0.0, -5.0626877555784476E8, 2.4020289860371434E-7), result, 0.001);
	}
	@Test
	public void test_a_null_b_tres_proche_zero_positif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 1.25746742001059E-7, -415.610558493466);
		saveResultsToCSV("resultats_equations.csv", 0.0, 1.25746742001059E-7, -415.610558493466,result);
		assertArrayEquals(getExpectedArray(0.0, 1.25746742001059E-7, -415.610558493466), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_tres_proche_zero_negatif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.100351423875262E-7, -2.1551730655278162E-7, -7.734568055397708E8);
		saveResultsToCSV("resultats_equations.csv", -9.100351423875262E-7, -2.1551730655278162E-7, -7.734568055397708E8,result);
		assertArrayEquals(getExpectedArray(-9.100351423875262E-7, -2.1551730655278162E-7, -7.734568055397708E8), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_negatif_tres_grand_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4.684976493243175, -3.478662235198345E8, -3.828598143134488E8);
		saveResultsToCSV("resultats_equations.csv", 4.684976493243175, -3.478662235198345E8, -3.828598143134488E8,result);
		assertArrayEquals(getExpectedArray(4.684976493243175, -3.478662235198345E8, -3.828598143134488E8), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_normal_negatif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.7604149711157477, -345.88489891400536, -4.58709097769117E8);
		saveResultsToCSV("resultats_equations.csv", -1.7604149711157477, -345.88489891400536, -4.58709097769117E8,result);
		assertArrayEquals(getExpectedArray(-1.7604149711157477, -345.88489891400536, -4.58709097769117E8), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_tres_proche_zero_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 396.97103517241175, 4.591745099485845E-7, -2.5188976024040616E8);
		saveResultsToCSV("resultats_equations.csv", 396.97103517241175, 4.591745099485845E-7, -2.5188976024040616E8,result);
		assertArrayEquals(getExpectedArray(396.97103517241175, 4.591745099485845E-7, -2.5188976024040616E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_proche_zero_negatif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -159.25735848800974, -1.2982426770559181, -6.210509239277711E8);
		saveResultsToCSV("resultats_equations.csv", -159.25735848800974, -1.2982426770559181, -6.210509239277711E8,result);
		assertArrayEquals(getExpectedArray(-159.25735848800974, -1.2982426770559181, -6.210509239277711E8), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_normal_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 5.182415367906782E8, 437.2049539053134, -7.84838636641738E8);
		saveResultsToCSV("resultats_equations.csv", 5.182415367906782E8, 437.2049539053134, -7.84838636641738E8,result);
		assertArrayEquals(getExpectedArray(5.182415367906782E8, 437.2049539053134, -7.84838636641738E8), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_proche_zero_positif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.81343794706039E8, 4.556104615690339, 4.736756735469676E8);
		saveResultsToCSV("resultats_equations.csv", -4.81343794706039E8, 4.556104615690339, 4.736756735469676E8,result);
		assertArrayEquals(getExpectedArray(-4.81343794706039E8, 4.556104615690339, 4.736756735469676E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_positif_tres_grand_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -15.437748322966797, 8.142246608340655E7, 4.977687012608519E7);
		saveResultsToCSV("resultats_equations.csv", -15.437748322966797, 8.142246608340655E7, 4.977687012608519E7,result);
		assertArrayEquals(getExpectedArray(-15.437748322966797, 8.142246608340655E7, 4.977687012608519E7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_negatif_tres_grand_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.578427656722905, -6.42452438090841E8, 0.0);
		saveResultsToCSV("resultats_equations.csv", -4.578427656722905, -6.42452438090841E8, 0.0,result);
		assertArrayEquals(getExpectedArray(-4.578427656722905, -6.42452438090841E8, 0.0), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_negatif_tres_grand_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -6.688770789501295E8, -4.953593105424439E8, -95.80751496283239);
		saveResultsToCSV("resultats_equations.csv", -6.688770789501295E8, -4.953593105424439E8, -95.80751496283239,result);
		assertArrayEquals(getExpectedArray(-6.688770789501295E8, -4.953593105424439E8, -95.80751496283239), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_proche_zero_negatif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 9.175119534005709E-7, -2.589414605004761, -321.8405901592858);
		saveResultsToCSV("resultats_equations.csv", 9.175119534005709E-7, -2.589414605004761, -321.8405901592858,result);
		assertArrayEquals(getExpectedArray(9.175119534005709E-7, -2.589414605004761, -321.8405901592858), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_negatif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -5.111718146641288E-7, -117.41771331449871, -119.56305348424127);
		saveResultsToCSV("resultats_equations.csv", -5.111718146641288E-7, -117.41771331449871, -119.56305348424127,result);
		assertArrayEquals(getExpectedArray(-5.111718146641288E-7, -117.41771331449871, -119.56305348424127), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_proche_zero_positif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.7899874899010033, 2.648956463803776, -32.189034270526236);
		saveResultsToCSV("resultats_equations.csv", 1.7899874899010033, 2.648956463803776, -32.189034270526236,result);
		assertArrayEquals(getExpectedArray(1.7899874899010033, 2.648956463803776, -32.189034270526236), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_normal_positif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 385.9791308500881, 423.7075264743194, -219.20677497207038);
		saveResultsToCSV("resultats_equations.csv", 385.9791308500881, 423.7075264743194, -219.20677497207038,result);
		assertArrayEquals(getExpectedArray(385.9791308500881, 423.7075264743194, -219.20677497207038), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_positif_tres_grand_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4.372207655646277E7, 4.781848869946795E8, -204.68468580667457);
		saveResultsToCSV("resultats_equations.csv", 4.372207655646277E7, 4.781848869946795E8, -204.68468580667457,result);
		assertArrayEquals(getExpectedArray(4.372207655646277E7, 4.781848869946795E8, -204.68468580667457), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_tres_proche_zero_negatif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.477740028744391, -2.0360295947283559E-7, -421.7164553425056);
		saveResultsToCSV("resultats_equations.csv", -4.477740028744391, -2.0360295947283559E-7, -421.7164553425056,result);
		assertArrayEquals(getExpectedArray(-4.477740028744391, -2.0360295947283559E-7, -421.7164553425056), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_normal_negatif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 41.54956537286902, -105.35484155627933, 0.0);
		saveResultsToCSV("resultats_equations.csv", 41.54956537286902, -105.35484155627933, 0.0,result);
		assertArrayEquals(getExpectedArray(41.54956537286902, -105.35484155627933, 0.0), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_normal_positif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -5.3406787959157294E8, 340.9249998231351, 2.2828014738122177E-7);
		saveResultsToCSV("resultats_equations.csv", -5.3406787959157294E8, 340.9249998231351, 2.2828014738122177E-7,result);
		assertArrayEquals(getExpectedArray(-5.3406787959157294E8, 340.9249998231351, 2.2828014738122177E-7), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_normal_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -198.5931128559206, -262.5390480266342, -5.032870899340237E-7);
		saveResultsToCSV("resultats_equations.csv", -198.5931128559206, -262.5390480266342, -5.032870899340237E-7,result);
		assertArrayEquals(getExpectedArray(-198.5931128559206, -262.5390480266342, -5.032870899340237E-7), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_normal_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -7.359026657132254E8, -115.34513255455994, 1.097918820094443);
		saveResultsToCSV("resultats_equations.csv", -7.359026657132254E8, -115.34513255455994, 1.097918820094443,result);
		assertArrayEquals(getExpectedArray(-7.359026657132254E8, -115.34513255455994, 1.097918820094443), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_normal_negatif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 9.717180950685062E8, -409.7279129944576, 268.75967861334516);
		saveResultsToCSV("resultats_equations.csv", 9.717180950685062E8, -409.7279129944576, 268.75967861334516,result);
		assertArrayEquals(getExpectedArray(9.717180950685062E8, -409.7279129944576, 268.75967861334516), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_negatif_tres_grand_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 8.790823573956635E-7, -5.646146088392613E8, -1.155040043991753);
		saveResultsToCSV("resultats_equations.csv", 8.790823573956635E-7, -5.646146088392613E8, -1.155040043991753,result);
		assertArrayEquals(getExpectedArray(8.790823573956635E-7, -5.646146088392613E8, -1.155040043991753), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_positif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.058776716588894E-7, 445.92288066642794, 7.442405072235987E8);
		saveResultsToCSV("resultats_equations.csv", -9.058776716588894E-7, 445.92288066642794, 7.442405072235987E8,result);
		assertArrayEquals(getExpectedArray(-9.058776716588894E-7, 445.92288066642794, 7.442405072235987E8), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_normal_positif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.5986258964200162, 102.83714647844278, -1.7240257056502335);
		saveResultsToCSV("resultats_equations.csv", 1.5986258964200162, 102.83714647844278, -1.7240257056502335,result);
		assertArrayEquals(getExpectedArray(1.5986258964200162, 102.83714647844278, -1.7240257056502335), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_tres_proche_zero_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.8055496865359156E-7, 8.321540371181441E-7, 378.97089810800134);
		saveResultsToCSV("resultats_equations.csv", 3.8055496865359156E-7, 8.321540371181441E-7, 378.97089810800134,result);
		assertArrayEquals(getExpectedArray(3.8055496865359156E-7, 8.321540371181441E-7, 378.97089810800134), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_tres_proche_zero_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -402.9014817791955, -7.666898457510102E-7, 1.668667527806762);
		saveResultsToCSV("resultats_equations.csv", -402.9014817791955, -7.666898457510102E-7, 1.668667527806762,result);
		assertArrayEquals(getExpectedArray(-402.9014817791955, -7.666898457510102E-7, 1.668667527806762), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_proche_zero_positif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.3400685982664418, 3.5344085411181267, -1.4818473793012852);
		saveResultsToCSV("resultats_equations.csv", -3.3400685982664418, 3.5344085411181267, -1.4818473793012852,result);
		assertArrayEquals(getExpectedArray(-3.3400685982664418, 3.5344085411181267, -1.4818473793012852), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 181.292028950381, -3.358525944400258, -1.842552766484264);
		saveResultsToCSV("resultats_equations.csv", 181.292028950381, -3.358525944400258, -1.842552766484264,result);
		assertArrayEquals(getExpectedArray(181.292028950381, -3.358525944400258, -1.842552766484264), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_positif_tres_grand_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.2499205434312746, 5.2577063550249434E8, 111.8487534821167);
		saveResultsToCSV("resultats_equations.csv", 3.2499205434312746, 5.2577063550249434E8, 111.8487534821167,result);
		assertArrayEquals(getExpectedArray(3.2499205434312746, 5.2577063550249434E8, 111.8487534821167), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_proche_zero_negatif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.7354516832440656, -4.0841197825466775, 0.0);
		saveResultsToCSV("resultats_equations.csv", 1.7354516832440656, -4.0841197825466775, 0.0,result);
		assertArrayEquals(getExpectedArray(1.7354516832440656, -4.0841197825466775, 0.0), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_proche_zero_positif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 123.73355773318278, 3.2696402198989793, 4.205070139611788E-7);
		saveResultsToCSV("resultats_equations.csv", 123.73355773318278, 3.2696402198989793, 4.205070139611788E-7,result);
		assertArrayEquals(getExpectedArray(123.73355773318278, 3.2696402198989793, 4.205070139611788E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_normal_positif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.3073245926651486E-7, 142.5397124602835, -6.584942897611546E-7);
		saveResultsToCSV("resultats_equations.csv", 3.3073245926651486E-7, 142.5397124602835, -6.584942897611546E-7,result);
		assertArrayEquals(getExpectedArray(3.3073245926651486E-7, 142.5397124602835, -6.584942897611546E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_tres_proche_zero_positif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.2694289582639007E-7, 2.9807052125007484E-7, 6.752772216677826E-7);
		saveResultsToCSV("resultats_equations.csv", -4.2694289582639007E-7, 2.9807052125007484E-7, 6.752772216677826E-7,result);
		assertArrayEquals(getExpectedArray(-4.2694289582639007E-7, 2.9807052125007484E-7, 6.752772216677826E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_proche_zero_positif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.8841258369511393E8, 2.2807595400736598, 1.0420486264334183);
		saveResultsToCSV("resultats_equations.csv", 1.8841258369511393E8, 2.2807595400736598, 1.0420486264334183,result);
		assertArrayEquals(getExpectedArray(1.8841258369511393E8, 2.2807595400736598, 1.0420486264334183), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_tres_proche_zero_negatif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.8776498372865, -1.1738041621855518E-7, 4.373284515604318E-7);
		saveResultsToCSV("resultats_equations.csv", -4.8776498372865, -1.1738041621855518E-7, 4.373284515604318E-7,result);
		assertArrayEquals(getExpectedArray(-4.8776498372865, -1.1738041621855518E-7, 4.373284515604318E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_positif_tres_grand_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 7.041076015216391E8, 2.747898794237546E8, 2.72778242237684E-7);
		saveResultsToCSV("resultats_equations.csv", 7.041076015216391E8, 2.747898794237546E8, 2.72778242237684E-7,result);
		assertArrayEquals(getExpectedArray(7.041076015216391E8, 2.747898794237546E8, 2.72778242237684E-7), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_tres_proche_zero_positif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.166894064228299E8, 2.925812310804506E-7, 0.0);
		saveResultsToCSV("resultats_equations.csv", -9.166894064228299E8, 2.925812310804506E-7, 0.0,result);
		assertArrayEquals(getExpectedArray(-9.166894064228299E8, 2.925812310804506E-7, 0.0), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_tres_proche_zero_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 382.055708532736, -9.326343547190159E-7, -4.261592626021881E-7);
		saveResultsToCSV("resultats_equations.csv", 382.055708532736, -9.326343547190159E-7, -4.261592626021881E-7,result);
		assertArrayEquals(getExpectedArray(382.055708532736, -9.326343547190159E-7, -4.261592626021881E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_positif_tres_grand_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.163640540377283, 1.462604716939394E8, -2.211056975968137E-7);
		saveResultsToCSV("resultats_equations.csv", -4.163640540377283, 1.462604716939394E8, -2.211056975968137E-7,result);
		assertArrayEquals(getExpectedArray(-4.163640540377283, 1.462604716939394E8, -2.211056975968137E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_negatif_tres_grand_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -5.011631678551478E-7, -4.661534831772003E8, -4.1271018586976E-7);
		saveResultsToCSV("resultats_equations.csv", -5.011631678551478E-7, -4.661534831772003E8, -4.1271018586976E-7,result);
		assertArrayEquals(getExpectedArray(-5.011631678551478E-7, -4.661534831772003E8, -4.1271018586976E-7), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_proche_zero_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -36.25782108036674, 1.0468737303653026, 22.071213087859405);
		saveResultsToCSV("resultats_equations.csv", -36.25782108036674, 1.0468737303653026, 22.071213087859405,result);
		assertArrayEquals(getExpectedArray(-36.25782108036674, 1.0468737303653026, 22.071213087859405), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_proche_zero_negatif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.150847999055727E8, -3.81281472550823, 3.945314548954901E-7);
		saveResultsToCSV("resultats_equations.csv", -9.150847999055727E8, -3.81281472550823, 3.945314548954901E-7,result);
		assertArrayEquals(getExpectedArray(-9.150847999055727E8, -3.81281472550823, 3.945314548954901E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_tres_proche_zero_negatif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1168861.5772280712, -7.633384431513497E-7, 0.0);
		saveResultsToCSV("resultats_equations.csv", 1168861.5772280712, -7.633384431513497E-7, 0.0,result);
		assertArrayEquals(getExpectedArray(1168861.5772280712, -7.633384431513497E-7, 0.0), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_positif_tres_grand_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.7559797246878007E-7, 2.526398296872124E8, 3.4943188210639464);
		saveResultsToCSV("resultats_equations.csv", 2.7559797246878007E-7, 2.526398296872124E8, 3.4943188210639464,result);
		assertArrayEquals(getExpectedArray(2.7559797246878007E-7, 2.526398296872124E8, 3.4943188210639464), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_tres_proche_zero_negatif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.069287615417982E-7, -5.470983377991412E-7, 8.101946220383257E8);
		saveResultsToCSV("resultats_equations.csv", 3.069287615417982E-7, -5.470983377991412E-7, 8.101946220383257E8,result);
		assertArrayEquals(getExpectedArray(3.069287615417982E-7, -5.470983377991412E-7, 8.101946220383257E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_positif_tres_grand_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -6.534204358762101E-7, 1.1893905595318696E8, 0.0);
		saveResultsToCSV("resultats_equations.csv", -6.534204358762101E-7, 1.1893905595318696E8, 0.0,result);
		assertArrayEquals(getExpectedArray(-6.534204358762101E-7, 1.1893905595318696E8, 0.0), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_proche_zero_negatif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.6287355886393176, -4.4581515945443915, 4.212156938989253E8);
		saveResultsToCSV("resultats_equations.csv", 1.6287355886393176, -4.4581515945443915, 4.212156938989253E8,result);
		assertArrayEquals(getExpectedArray(1.6287355886393176, -4.4581515945443915, 4.212156938989253E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_negatif_tres_grand_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -294.9117401675256, -9.505209855798765E8, 9.091340642277333E-7);
		saveResultsToCSV("resultats_equations.csv", -294.9117401675256, -9.505209855798765E8, 9.091340642277333E-7,result);
		assertArrayEquals(getExpectedArray(-294.9117401675256, -9.505209855798765E8, 9.091340642277333E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_negatif_tres_grand_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 9.049246596641438E8, -6.822731077049313E8, 4.535175356830133);
		saveResultsToCSV("resultats_equations.csv", 9.049246596641438E8, -6.822731077049313E8, 4.535175356830133,result);
		assertArrayEquals(getExpectedArray(9.049246596641438E8, -6.822731077049313E8, 4.535175356830133), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_tres_proche_zero_positif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 390.5799367591561, 5.859985262888625E-7, 1.6510163377537448);
		saveResultsToCSV("resultats_equations.csv", 390.5799367591561, 5.859985262888625E-7, 1.6510163377537448,result);
		assertArrayEquals(getExpectedArray(390.5799367591561, 5.859985262888625E-7, 1.6510163377537448), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_negatif_tres_grand_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -5.1642875302931637E8, -2.5256814751654327E8, 181.72261329265947);
		saveResultsToCSV("resultats_equations.csv", -5.1642875302931637E8, -2.5256814751654327E8, 181.72261329265947,result);
		assertArrayEquals(getExpectedArray(-5.1642875302931637E8, -2.5256814751654327E8, 181.72261329265947), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_normal_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.3655280105684104, -411.60768848651617, 3.0431718346244603);
		saveResultsToCSV("resultats_equations.csv", 1.3655280105684104, -411.60768848651617, 3.0431718346244603,result);
		assertArrayEquals(getExpectedArray(1.3655280105684104, -411.60768848651617, 3.0431718346244603), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_proche_zero_negatif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.259710001103873, -1.381066515894743, 48.85806546390559);
		saveResultsToCSV("resultats_equations.csv", -1.259710001103873, -1.381066515894743, 48.85806546390559,result);
		assertArrayEquals(getExpectedArray(-1.259710001103873, -1.381066515894743, 48.85806546390559), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_proche_zero_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.3116933266640441E8, -1.8713326622198219, -5.189064313343618E-7);
		saveResultsToCSV("resultats_equations.csv", 1.3116933266640441E8, -1.8713326622198219, -5.189064313343618E-7,result);
		assertArrayEquals(getExpectedArray(1.3116933266640441E8, -1.8713326622198219, -5.189064313343618E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_tres_proche_zero_positif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.217495439995984, 1.2593686675733175E-7, 9.459736291213537E8);
		saveResultsToCSV("resultats_equations.csv", -3.217495439995984, 1.2593686675733175E-7, 9.459736291213537E8,result);
		assertArrayEquals(getExpectedArray(-3.217495439995984, 1.2593686675733175E-7, 9.459736291213537E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_proche_zero_positif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -8.457997601653972E-7, 4.643521610047656, -2.2498374304136196E-7);
		saveResultsToCSV("resultats_equations.csv", -8.457997601653972E-7, 4.643521610047656, -2.2498374304136196E-7,result);
		assertArrayEquals(getExpectedArray(-8.457997601653972E-7, 4.643521610047656, -2.2498374304136196E-7), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_normal_positif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -339.59709569846683, 244.94824346551508, 0.0);
		saveResultsToCSV("resultats_equations.csv", -339.59709569846683, 244.94824346551508, 0.0,result);
		assertArrayEquals(getExpectedArray(-339.59709569846683, 244.94824346551508, 0.0), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_tres_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.567942487741841E8, -7.096399447750506E-7, -4.30809884617648);
		saveResultsToCSV("resultats_equations.csv", -4.567942487741841E8, -7.096399447750506E-7, -4.30809884617648,result);
		assertArrayEquals(getExpectedArray(-4.567942487741841E8, -7.096399447750506E-7, -4.30809884617648), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.7004748887559167E-7, 59.089372696881455, 369.9623160274356);
		saveResultsToCSV("resultats_equations.csv", -4.7004748887559167E-7, 59.089372696881455, 369.9623160274356,result);
		assertArrayEquals(getExpectedArray(-4.7004748887559167E-7, 59.089372696881455, 369.9623160274356), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_tres_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.561195057958995, -6.720371199673508E-7, -1.7127809242051355);
		saveResultsToCSV("resultats_equations.csv", 3.561195057958995, -6.720371199673508E-7, -1.7127809242051355,result);
		assertArrayEquals(getExpectedArray(3.561195057958995, -6.720371199673508E-7, -1.7127809242051355), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_positif_tres_grand_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 468.50678141741133, 4.800731381174876E8, 150.0263869363536);
		saveResultsToCSV("resultats_equations.csv", 468.50678141741133, 4.800731381174876E8, 150.0263869363536,result);
		assertArrayEquals(getExpectedArray(468.50678141741133, 4.800731381174876E8, 150.0263869363536), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_tres_proche_zero_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 6.340849289381027E8, 1.8559136500790656E-7, -8.51334097734295E8);
		saveResultsToCSV("resultats_equations.csv", 6.340849289381027E8, 1.8559136500790656E-7, -8.51334097734295E8,result);
		assertArrayEquals(getExpectedArray(6.340849289381027E8, 1.8559136500790656E-7, -8.51334097734295E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.072622031864296E-7, -47.08199197500244, -2.6463443334506116);
		saveResultsToCSV("resultats_equations.csv", -9.072622031864296E-7, -47.08199197500244, -2.6463443334506116,result);
		assertArrayEquals(getExpectedArray(-9.072622031864296E-7, -47.08199197500244, -2.6463443334506116), result, 0.001);
	}
}

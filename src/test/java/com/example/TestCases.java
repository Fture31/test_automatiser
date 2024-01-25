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
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 1.3044780081864213, 0.0);
		saveResultsToCSV("resultats_equations.csv", 0.0, 1.3044780081864213, 0.0,result);
		assertArrayEquals(getExpectedArray(0.0, 1.3044780081864213, 0.0), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_normal_negatif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.976727534670049E-7, -352.8141405196268, 8.413095544235945E-7);
		saveResultsToCSV("resultats_equations.csv", 2.976727534670049E-7, -352.8141405196268, 8.413095544235945E-7,result);
		assertArrayEquals(getExpectedArray(2.976727534670049E-7, -352.8141405196268, 8.413095544235945E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_proche_zero_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.2634106686964042E-7, -1.9192775037559051, 1.4085306612416133);
		saveResultsToCSV("resultats_equations.csv", -1.2634106686964042E-7, -1.9192775037559051, 1.4085306612416133,result);
		assertArrayEquals(getExpectedArray(-1.2634106686964042E-7, -1.9192775037559051, 1.4085306612416133), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_tres_proche_zero_positif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.0512790021531297, 5.3620112421486E-7, -7.929737367557129E-7);
		saveResultsToCSV("resultats_equations.csv", 1.0512790021531297, 5.3620112421486E-7, -7.929737367557129E-7,result);
		assertArrayEquals(getExpectedArray(1.0512790021531297, 5.3620112421486E-7, -7.929737367557129E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_normal_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.0689710895625915, 353.8112510346687, 336.50948918196934);
		saveResultsToCSV("resultats_equations.csv", -4.0689710895625915, 353.8112510346687, 336.50948918196934,result);
		assertArrayEquals(getExpectedArray(-4.0689710895625915, 353.8112510346687, 336.50948918196934), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_negatif_tres_grand_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 428.37543361473644, -4.6404231574676806E8, 2.5802213046142143E8);
		saveResultsToCSV("resultats_equations.csv", 428.37543361473644, -4.6404231574676806E8, 2.5802213046142143E8,result);
		assertArrayEquals(getExpectedArray(428.37543361473644, -4.6404231574676806E8, 2.5802213046142143E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_null_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -305.2926313636173, 0.0, -365.65837803160207);
		saveResultsToCSV("resultats_equations.csv", -305.2926313636173, 0.0, -365.65837803160207,result);
		assertArrayEquals(getExpectedArray(-305.2926313636173, 0.0, -365.65837803160207), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_tres_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4731899.949193296, -4.809407805112925E-7, -4.069710404310804);
		saveResultsToCSV("resultats_equations.csv", 4731899.949193296, -4.809407805112925E-7, -4.069710404310804,result);
		assertArrayEquals(getExpectedArray(4731899.949193296, -4.809407805112925E-7, -4.069710404310804), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_positif_tres_grand_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.8582770674980986E8, 9.08299748803468E8, -4.718585989971767E8);
		saveResultsToCSV("resultats_equations.csv", -1.8582770674980986E8, 9.08299748803468E8, -4.718585989971767E8,result);
		assertArrayEquals(getExpectedArray(-1.8582770674980986E8, 9.08299748803468E8, -4.718585989971767E8), result, 0.001);
	}
	@Test
	public void test_a_null_b_null_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 0.0, -9.871343522820362E8);
		saveResultsToCSV("resultats_equations.csv", 0.0, 0.0, -9.871343522820362E8,result);
		assertArrayEquals(getExpectedArray(0.0, 0.0, -9.871343522820362E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_null_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.0725566136694653E-7, 0.0, 0.0);
		saveResultsToCSV("resultats_equations.csv", 3.0725566136694653E-7, 0.0, 0.0,result);
		assertArrayEquals(getExpectedArray(3.0725566136694653E-7, 0.0, 0.0), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_null_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.950762855915128E-7, 0.0, -3.9779111859654757);
		saveResultsToCSV("resultats_equations.csv", -9.950762855915128E-7, 0.0, -3.9779111859654757,result);
		assertArrayEquals(getExpectedArray(-9.950762855915128E-7, 0.0, -3.9779111859654757), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_null_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.883389574139547, 0.0, 7.028909496632498E-7);
		saveResultsToCSV("resultats_equations.csv", 3.883389574139547, 0.0, 7.028909496632498E-7,result);
		assertArrayEquals(getExpectedArray(3.883389574139547, 0.0, 7.028909496632498E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_null_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.0541077162612806, 0.0, 3.9731597980140663);
		saveResultsToCSV("resultats_equations.csv", -2.0541077162612806, 0.0, 3.9731597980140663,result);
		assertArrayEquals(getExpectedArray(-2.0541077162612806, 0.0, 3.9731597980140663), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_null_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 119.15907492175639, 0.0, 184.72751782372924);
		saveResultsToCSV("resultats_equations.csv", 119.15907492175639, 0.0, 184.72751782372924,result);
		assertArrayEquals(getExpectedArray(119.15907492175639, 0.0, 184.72751782372924), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_tres_proche_zero_positif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -446.69380795293915, 1.399936631668939E-7, -1.6378278486326852);
		saveResultsToCSV("resultats_equations.csv", -446.69380795293915, 1.399936631668939E-7, -1.6378278486326852,result);
		assertArrayEquals(getExpectedArray(-446.69380795293915, 1.399936631668939E-7, -1.6378278486326852), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_null_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 8.976845167317919E8, 0.0, 9.052690130149567E8);
		saveResultsToCSV("resultats_equations.csv", 8.976845167317919E8, 0.0, 9.052690130149567E8,result);
		assertArrayEquals(getExpectedArray(8.976845167317919E8, 0.0, 9.052690130149567E8), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_null_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.502745452426299E8, 0.0, -7.204932536888501E-7);
		saveResultsToCSV("resultats_equations.csv", -2.502745452426299E8, 0.0, -7.204932536888501E-7,result);
		assertArrayEquals(getExpectedArray(-2.502745452426299E8, 0.0, -7.204932536888501E-7), result, 0.001);
	}
	@Test
	public void test_a_null_b_tres_proche_zero_negatif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -5.410544921225984E-7, 120.71159165524833);
		saveResultsToCSV("resultats_equations.csv", 0.0, -5.410544921225984E-7, 120.71159165524833,result);
		assertArrayEquals(getExpectedArray(0.0, -5.410544921225984E-7, 120.71159165524833), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_proche_zero_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 6.276443014217902E-7, 1.9565571276304747, -9.713151220110642E8);
		saveResultsToCSV("resultats_equations.csv", 6.276443014217902E-7, 1.9565571276304747, -9.713151220110642E8,result);
		assertArrayEquals(getExpectedArray(6.276443014217902E-7, 1.9565571276304747, -9.713151220110642E8), result, 0.001);
	}
	@Test
	public void test_a_null_b_proche_zero_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -2.752252275155639, -8.901402131637116E-7);
		saveResultsToCSV("resultats_equations.csv", 0.0, -2.752252275155639, -8.901402131637116E-7,result);
		assertArrayEquals(getExpectedArray(0.0, -2.752252275155639, -8.901402131637116E-7), result, 0.001);
	}
	@Test
	public void test_a_null_b_normal_positif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 433.48678656586463, 2.0107188692925724);
		saveResultsToCSV("resultats_equations.csv", 0.0, 433.48678656586463, 2.0107188692925724,result);
		assertArrayEquals(getExpectedArray(0.0, 433.48678656586463, 2.0107188692925724), result, 0.001);
	}
	@Test
	public void test_a_null_b_normal_negatif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -304.1553581193402, 3.123601890304313E8);
		saveResultsToCSV("resultats_equations.csv", 0.0, -304.1553581193402, 3.123601890304313E8,result);
		assertArrayEquals(getExpectedArray(0.0, -304.1553581193402, 3.123601890304313E8), result, 0.001);
	}
	@Test
	public void test_a_null_b_positif_tres_grand_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 6.546302673981899E8, -1.6016423939060327);
		saveResultsToCSV("resultats_equations.csv", 0.0, 6.546302673981899E8, -1.6016423939060327,result);
		assertArrayEquals(getExpectedArray(0.0, 6.546302673981899E8, -1.6016423939060327), result, 0.001);
	}
	@Test
	public void test_a_null_b_negatif_tres_grand_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, -4.978141912014057E8, 8.366438507315293E-7);
		saveResultsToCSV("resultats_equations.csv", 0.0, -4.978141912014057E8, 8.366438507315293E-7,result);
		assertArrayEquals(getExpectedArray(0.0, -4.978141912014057E8, 8.366438507315293E-7), result, 0.001);
	}
	@Test
	public void test_a_null_b_tres_proche_zero_positif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 0.0, 5.486941513156251E-7, -274.4570235959636);
		saveResultsToCSV("resultats_equations.csv", 0.0, 5.486941513156251E-7, -274.4570235959636,result);
		assertArrayEquals(getExpectedArray(0.0, 5.486941513156251E-7, -274.4570235959636), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_tres_proche_zero_negatif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -7.217258727964687E-7, -4.7024047469764496E-7, -9.40892437623287E8);
		saveResultsToCSV("resultats_equations.csv", -7.217258727964687E-7, -4.7024047469764496E-7, -9.40892437623287E8,result);
		assertArrayEquals(getExpectedArray(-7.217258727964687E-7, -4.7024047469764496E-7, -9.40892437623287E8), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_negatif_tres_grand_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.329974593505379, -3.711902301122688E8, -4.4832759255895734E7);
		saveResultsToCSV("resultats_equations.csv", 2.329974593505379, -3.711902301122688E8, -4.4832759255895734E7,result);
		assertArrayEquals(getExpectedArray(2.329974593505379, -3.711902301122688E8, -4.4832759255895734E7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_normal_negatif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.426154449437813, -322.229987819857, -2.4065560391894555E8);
		saveResultsToCSV("resultats_equations.csv", -4.426154449437813, -322.229987819857, -2.4065560391894555E8,result);
		assertArrayEquals(getExpectedArray(-4.426154449437813, -322.229987819857, -2.4065560391894555E8), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_tres_proche_zero_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 183.43815918888473, 2.001852440100771E-7, -2.920673612336477E8);
		saveResultsToCSV("resultats_equations.csv", 183.43815918888473, 2.001852440100771E-7, -2.920673612336477E8,result);
		assertArrayEquals(getExpectedArray(183.43815918888473, 2.001852440100771E-7, -2.920673612336477E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_proche_zero_negatif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -82.17844231746778, -1.9802392443783017, -8.444065584389544E7);
		saveResultsToCSV("resultats_equations.csv", -82.17844231746778, -1.9802392443783017, -8.444065584389544E7,result);
		assertArrayEquals(getExpectedArray(-82.17844231746778, -1.9802392443783017, -8.444065584389544E7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_normal_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 7.324179574170775E8, 104.68430455115524, -3.7906758267016923E8);
		saveResultsToCSV("resultats_equations.csv", 7.324179574170775E8, 104.68430455115524, -3.7906758267016923E8,result);
		assertArrayEquals(getExpectedArray(7.324179574170775E8, 104.68430455115524, -3.7906758267016923E8), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_proche_zero_positif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.532600793814193E8, 3.789295874402137, 6.144040080991745E8);
		saveResultsToCSV("resultats_equations.csv", -9.532600793814193E8, 3.789295874402137, 6.144040080991745E8,result);
		assertArrayEquals(getExpectedArray(-9.532600793814193E8, 3.789295874402137, 6.144040080991745E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_positif_tres_grand_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -460.3658834376002, 6.389729348854553E8, 9.923119965605452E8);
		saveResultsToCSV("resultats_equations.csv", -460.3658834376002, 6.389729348854553E8, 9.923119965605452E8,result);
		assertArrayEquals(getExpectedArray(-460.3658834376002, 6.389729348854553E8, 9.923119965605452E8), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_negatif_tres_grand_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.0038815968084007, -9.530053879375243E8, 0.0);
		saveResultsToCSV("resultats_equations.csv", -1.0038815968084007, -9.530053879375243E8, 0.0,result);
		assertArrayEquals(getExpectedArray(-1.0038815968084007, -9.530053879375243E8, 0.0), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_negatif_tres_grand_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -8.732932150624069E8, -3.032738637345599E8, -270.71410800937736);
		saveResultsToCSV("resultats_equations.csv", -8.732932150624069E8, -3.032738637345599E8, -270.71410800937736,result);
		assertArrayEquals(getExpectedArray(-8.732932150624069E8, -3.032738637345599E8, -270.71410800937736), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_proche_zero_negatif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 9.086834170166454E-7, -2.791575331492172, -269.4440529506316);
		saveResultsToCSV("resultats_equations.csv", 9.086834170166454E-7, -2.791575331492172, -269.4440529506316,result);
		assertArrayEquals(getExpectedArray(9.086834170166454E-7, -2.791575331492172, -269.4440529506316), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_negatif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.867193764071382E-7, -31.351901175019236, -138.83313649356597);
		saveResultsToCSV("resultats_equations.csv", -4.867193764071382E-7, -31.351901175019236, -138.83313649356597,result);
		assertArrayEquals(getExpectedArray(-4.867193764071382E-7, -31.351901175019236, -138.83313649356597), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_proche_zero_positif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.2846286158316031, 1.9157926409034158, -480.00134620512927);
		saveResultsToCSV("resultats_equations.csv", 1.2846286158316031, 1.9157926409034158, -480.00134620512927,result);
		assertArrayEquals(getExpectedArray(1.2846286158316031, 1.9157926409034158, -480.00134620512927), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_normal_positif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 159.18959279243256, 333.18518886243606, -426.5683458388436);
		saveResultsToCSV("resultats_equations.csv", 159.18959279243256, 333.18518886243606, -426.5683458388436,result);
		assertArrayEquals(getExpectedArray(159.18959279243256, 333.18518886243606, -426.5683458388436), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_positif_tres_grand_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.958400102435572E8, 3.760848151514738E8, -287.75337620309244);
		saveResultsToCSV("resultats_equations.csv", 2.958400102435572E8, 3.760848151514738E8, -287.75337620309244,result);
		assertArrayEquals(getExpectedArray(2.958400102435572E8, 3.760848151514738E8, -287.75337620309244), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_tres_proche_zero_negatif_c_normal_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.0139318296220785, -8.571949081464016E-7, -403.3198554228061);
		saveResultsToCSV("resultats_equations.csv", -3.0139318296220785, -8.571949081464016E-7, -403.3198554228061,result);
		assertArrayEquals(getExpectedArray(-3.0139318296220785, -8.571949081464016E-7, -403.3198554228061), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_normal_negatif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 391.92620112443734, -431.2869804179665, 0.0);
		saveResultsToCSV("resultats_equations.csv", 391.92620112443734, -431.2869804179665, 0.0,result);
		assertArrayEquals(getExpectedArray(391.92620112443734, -431.2869804179665, 0.0), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_normal_positif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.1904153509412014E8, 25.584595039426144, 5.145051945727315E-7);
		saveResultsToCSV("resultats_equations.csv", -2.1904153509412014E8, 25.584595039426144, 5.145051945727315E-7,result);
		assertArrayEquals(getExpectedArray(-2.1904153509412014E8, 25.584595039426144, 5.145051945727315E-7), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_normal_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -469.82078969145743, -207.8024166699094, -4.963930145533587E-7);
		saveResultsToCSV("resultats_equations.csv", -469.82078969145743, -207.8024166699094, -4.963930145533587E-7,result);
		assertArrayEquals(getExpectedArray(-469.82078969145743, -207.8024166699094, -4.963930145533587E-7), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_normal_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.974934438123695E8, -307.8029210335398, 1.9829540132906498);
		saveResultsToCSV("resultats_equations.csv", -9.974934438123695E8, -307.8029210335398, 1.9829540132906498,result);
		assertArrayEquals(getExpectedArray(-9.974934438123695E8, -307.8029210335398, 1.9829540132906498), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_normal_negatif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.1747016563588977E8, -370.8961789826402, 90.84303400659165);
		saveResultsToCSV("resultats_equations.csv", 3.1747016563588977E8, -370.8961789826402, 90.84303400659165,result);
		assertArrayEquals(getExpectedArray(3.1747016563588977E8, -370.8961789826402, 90.84303400659165), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_negatif_tres_grand_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.3683865144438283E-7, -6.074413667302799E8, -2.6519586544158615);
		saveResultsToCSV("resultats_equations.csv", 3.3683865144438283E-7, -6.074413667302799E8, -2.6519586544158615,result);
		assertArrayEquals(getExpectedArray(3.3683865144438283E-7, -6.074413667302799E8, -2.6519586544158615), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_positif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.809520929945373E-7, 103.08909116318847, 2.958323556790334E8);
		saveResultsToCSV("resultats_equations.csv", -2.809520929945373E-7, 103.08909116318847, 2.958323556790334E8,result);
		assertArrayEquals(getExpectedArray(-2.809520929945373E-7, 103.08909116318847, 2.958323556790334E8), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_normal_positif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.7566672322596184, 47.41878959847855, -1.0016532387111106);
		saveResultsToCSV("resultats_equations.csv", 2.7566672322596184, 47.41878959847855, -1.0016532387111106,result);
		assertArrayEquals(getExpectedArray(2.7566672322596184, 47.41878959847855, -1.0016532387111106), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_tres_proche_zero_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.680734290570554E-7, 4.5981811039999545E-7, 298.2206424200964);
		saveResultsToCSV("resultats_equations.csv", 1.680734290570554E-7, 4.5981811039999545E-7, 298.2206424200964,result);
		assertArrayEquals(getExpectedArray(1.680734290570554E-7, 4.5981811039999545E-7, 298.2206424200964), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_tres_proche_zero_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -260.9078408672009, -5.480872682043164E-7, 2.7737062065365343);
		saveResultsToCSV("resultats_equations.csv", -260.9078408672009, -5.480872682043164E-7, 2.7737062065365343,result);
		assertArrayEquals(getExpectedArray(-260.9078408672009, -5.480872682043164E-7, 2.7737062065365343), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_proche_zero_positif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.1236090824050908, 2.0369422641534642, -4.691867903676821);
		saveResultsToCSV("resultats_equations.csv", -1.1236090824050908, 2.0369422641534642, -4.691867903676821,result);
		assertArrayEquals(getExpectedArray(-1.1236090824050908, 2.0369422641534642, -4.691867903676821), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 282.06520379440644, -4.580687213683172, -3.6800444657849547);
		saveResultsToCSV("resultats_equations.csv", 282.06520379440644, -4.580687213683172, -3.6800444657849547,result);
		assertArrayEquals(getExpectedArray(282.06520379440644, -4.580687213683172, -3.6800444657849547), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_positif_tres_grand_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.0283878687033745, 9.203694653765761E8, 238.57842648311154);
		saveResultsToCSV("resultats_equations.csv", 3.0283878687033745, 9.203694653765761E8, 238.57842648311154,result);
		assertArrayEquals(getExpectedArray(3.0283878687033745, 9.203694653765761E8, 238.57842648311154), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_proche_zero_negatif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4.6562986544488405, -2.6164464361102096, 0.0);
		saveResultsToCSV("resultats_equations.csv", 4.6562986544488405, -2.6164464361102096, 0.0,result);
		assertArrayEquals(getExpectedArray(4.6562986544488405, -2.6164464361102096, 0.0), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_proche_zero_positif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 235.3979060383814, 1.4924919021211664, 4.395311560997552E-7);
		saveResultsToCSV("resultats_equations.csv", 235.3979060383814, 1.4924919021211664, 4.395311560997552E-7,result);
		assertArrayEquals(getExpectedArray(235.3979060383814, 1.4924919021211664, 4.395311560997552E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_normal_positif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.9428431162364125E-7, 245.58678649167317, -8.391152634678427E-7);
		saveResultsToCSV("resultats_equations.csv", 1.9428431162364125E-7, 245.58678649167317, -8.391152634678427E-7,result);
		assertArrayEquals(getExpectedArray(1.9428431162364125E-7, 245.58678649167317, -8.391152634678427E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_tres_proche_zero_positif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -8.735474544522426E-7, 2.7536931469334587E-7, 4.6882012464566093E-7);
		saveResultsToCSV("resultats_equations.csv", -8.735474544522426E-7, 2.7536931469334587E-7, 4.6882012464566093E-7,result);
		assertArrayEquals(getExpectedArray(-8.735474544522426E-7, 2.7536931469334587E-7, 4.6882012464566093E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_proche_zero_positif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.3490635442475462E8, 3.2901900267394555, 1.4452827781520643);
		saveResultsToCSV("resultats_equations.csv", 1.3490635442475462E8, 3.2901900267394555, 1.4452827781520643,result);
		assertArrayEquals(getExpectedArray(1.3490635442475462E8, 3.2901900267394555, 1.4452827781520643), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_tres_proche_zero_negatif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.67456830923926, -1.4263396534119693E-7, 7.769717160249094E-7);
		saveResultsToCSV("resultats_equations.csv", -2.67456830923926, -1.4263396534119693E-7, 7.769717160249094E-7,result);
		assertArrayEquals(getExpectedArray(-2.67456830923926, -1.4263396534119693E-7, 7.769717160249094E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_positif_tres_grand_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 8.578189082199123E8, 7.566386727751024E8, 4.099681922277387E-7);
		saveResultsToCSV("resultats_equations.csv", 8.578189082199123E8, 7.566386727751024E8, 4.099681922277387E-7,result);
		assertArrayEquals(getExpectedArray(8.578189082199123E8, 7.566386727751024E8, 4.099681922277387E-7), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_tres_proche_zero_positif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.1494394116908908E7, 8.963569846982638E-7, 0.0);
		saveResultsToCSV("resultats_equations.csv", -3.1494394116908908E7, 8.963569846982638E-7, 0.0,result);
		assertArrayEquals(getExpectedArray(-3.1494394116908908E7, 8.963569846982638E-7, 0.0), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_tres_proche_zero_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 82.26008469603299, -3.7746152817882176E-7, -7.873033892269437E-7);
		saveResultsToCSV("resultats_equations.csv", 82.26008469603299, -3.7746152817882176E-7, -7.873033892269437E-7,result);
		assertArrayEquals(getExpectedArray(82.26008469603299, -3.7746152817882176E-7, -7.873033892269437E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_positif_tres_grand_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.4195706507004444, 6.13438200943307E8, -1.5092939530744344E-7);
		saveResultsToCSV("resultats_equations.csv", -2.4195706507004444, 6.13438200943307E8, -1.5092939530744344E-7,result);
		assertArrayEquals(getExpectedArray(-2.4195706507004444, 6.13438200943307E8, -1.5092939530744344E-7), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_negatif_tres_grand_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -5.567063605715961E-7, -6.266292147273872E8, -5.993262671117647E-7);
		saveResultsToCSV("resultats_equations.csv", -5.567063605715961E-7, -6.266292147273872E8, -5.993262671117647E-7,result);
		assertArrayEquals(getExpectedArray(-5.567063605715961E-7, -6.266292147273872E8, -5.993262671117647E-7), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_proche_zero_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -177.15860532801378, 2.755200777988452, 397.9837573524742);
		saveResultsToCSV("resultats_equations.csv", -177.15860532801378, 2.755200777988452, 397.9837573524742,result);
		assertArrayEquals(getExpectedArray(-177.15860532801378, 2.755200777988452, 397.9837573524742), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_proche_zero_negatif_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -2.30436576476429E8, -1.3979862843030118, 3.3250999814753974E-7);
		saveResultsToCSV("resultats_equations.csv", -2.30436576476429E8, -1.3979862843030118, 3.3250999814753974E-7,result);
		assertArrayEquals(getExpectedArray(-2.30436576476429E8, -1.3979862843030118, 3.3250999814753974E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_tres_proche_zero_negatif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.9232636954727784E8, -8.369678558737083E-7, 0.0);
		saveResultsToCSV("resultats_equations.csv", 1.9232636954727784E8, -8.369678558737083E-7, 0.0,result);
		assertArrayEquals(getExpectedArray(1.9232636954727784E8, -8.369678558737083E-7, 0.0), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_positif_tres_grand_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 6.396078736693731E-7, 7.362565894327694E8, 1.5630432471881064);
		saveResultsToCSV("resultats_equations.csv", 6.396078736693731E-7, 7.362565894327694E8, 1.5630432471881064,result);
		assertArrayEquals(getExpectedArray(6.396078736693731E-7, 7.362565894327694E8, 1.5630432471881064), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_positif_b_tres_proche_zero_negatif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.1056498619573754E-7, -4.847361805465444E-7, 6.87581840716066E8);
		saveResultsToCSV("resultats_equations.csv", 3.1056498619573754E-7, -4.847361805465444E-7, 6.87581840716066E8,result);
		assertArrayEquals(getExpectedArray(3.1056498619573754E-7, -4.847361805465444E-7, 6.87581840716066E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_positif_tres_grand_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.0036198271487174E-7, 6.463876917209796E8, 0.0);
		saveResultsToCSV("resultats_equations.csv", -1.0036198271487174E-7, 6.463876917209796E8, 0.0,result);
		assertArrayEquals(getExpectedArray(-1.0036198271487174E-7, 6.463876917209796E8, 0.0), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_proche_zero_negatif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 4.764017958646381, -3.1468695482545934, 6.692757613732535E8);
		saveResultsToCSV("resultats_equations.csv", 4.764017958646381, -3.1468695482545934, 6.692757613732535E8,result);
		assertArrayEquals(getExpectedArray(4.764017958646381, -3.1468695482545934, 6.692757613732535E8), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_negatif_tres_grand_c_tres_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -364.69799696575967, -5.440474194958916E8, 7.725719181219049E-7);
		saveResultsToCSV("resultats_equations.csv", -364.69799696575967, -5.440474194958916E8, 7.725719181219049E-7,result);
		assertArrayEquals(getExpectedArray(-364.69799696575967, -5.440474194958916E8, 7.725719181219049E-7), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_negatif_tres_grand_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 1.524072839135526E8, -9.492394196034105E8, 2.6524942657789334);
		saveResultsToCSV("resultats_equations.csv", 1.524072839135526E8, -9.492394196034105E8, 2.6524942657789334,result);
		assertArrayEquals(getExpectedArray(1.524072839135526E8, -9.492394196034105E8, 2.6524942657789334), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_tres_proche_zero_positif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 312.2619619241094, 3.265431441737005E-7, 2.9376460434385097);
		saveResultsToCSV("resultats_equations.csv", 312.2619619241094, 3.265431441737005E-7, 2.9376460434385097,result);
		assertArrayEquals(getExpectedArray(312.2619619241094, 3.265431441737005E-7, 2.9376460434385097), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_negatif_tres_grand_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -9.790309812269578E8, -5.00186384144648E8, 222.0814648110246);
		saveResultsToCSV("resultats_equations.csv", -9.790309812269578E8, -5.00186384144648E8, 222.0814648110246,result);
		assertArrayEquals(getExpectedArray(-9.790309812269578E8, -5.00186384144648E8, 222.0814648110246), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_normal_negatif_c_proche_zero_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 2.8246260099910607, -234.64214281459692, 1.568171857640094);
		saveResultsToCSV("resultats_equations.csv", 2.8246260099910607, -234.64214281459692, 1.568171857640094,result);
		assertArrayEquals(getExpectedArray(2.8246260099910607, -234.64214281459692, 1.568171857640094), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_proche_zero_negatif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.6078884688231656, -2.2749402571008215, 410.6559667504174);
		saveResultsToCSV("resultats_equations.csv", -3.6078884688231656, -2.2749402571008215, 410.6559667504174,result);
		assertArrayEquals(getExpectedArray(-3.6078884688231656, -2.2749402571008215, 410.6559667504174), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_proche_zero_negatif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 8.94912868630223E8, -3.727333359524245, -6.440290660717616E-7);
		saveResultsToCSV("resultats_equations.csv", 8.94912868630223E8, -3.727333359524245, -6.440290660717616E-7,result);
		assertArrayEquals(getExpectedArray(8.94912868630223E8, -3.727333359524245, -6.440290660717616E-7), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_negatif_b_tres_proche_zero_positif_c_positif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -3.5037840622485152, 3.0541894206867803E-7, 4.32552871789084E8);
		saveResultsToCSV("resultats_equations.csv", -3.5037840622485152, 3.0541894206867803E-7, 4.32552871789084E8,result);
		assertArrayEquals(getExpectedArray(-3.5037840622485152, 3.0541894206867803E-7, 4.32552871789084E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_proche_zero_positif_c_tres_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -1.0087639127846894E-7, 4.159967578871658, -7.194347464731697E-7);
		saveResultsToCSV("resultats_equations.csv", -1.0087639127846894E-7, 4.159967578871658, -7.194347464731697E-7,result);
		assertArrayEquals(getExpectedArray(-1.0087639127846894E-7, 4.159967578871658, -7.194347464731697E-7), result, 0.001);
	}
	@Test
	public void test_a_normal_negatif_b_normal_positif_c_null() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -198.23753599931234, 312.005567423394, 0.0);
		saveResultsToCSV("resultats_equations.csv", -198.23753599931234, 312.005567423394, 0.0,result);
		assertArrayEquals(getExpectedArray(-198.23753599931234, 312.005567423394, 0.0), result, 0.001);
	}
	@Test
	public void test_a_negatif_tres_grand_b_tres_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -6.239901846992404E8, -4.2857551508066467E-7, -3.069155654666912);
		saveResultsToCSV("resultats_equations.csv", -6.239901846992404E8, -4.2857551508066467E-7, -3.069155654666912,result);
		assertArrayEquals(getExpectedArray(-6.239901846992404E8, -4.2857551508066467E-7, -3.069155654666912), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_positif_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -5.355675930749462E-7, 422.10756472632096, 218.0163035952239);
		saveResultsToCSV("resultats_equations.csv", -5.355675930749462E-7, 422.10756472632096, 218.0163035952239,result);
		assertArrayEquals(getExpectedArray(-5.355675930749462E-7, 422.10756472632096, 218.0163035952239), result, 0.001);
	}
	@Test
	public void test_a_proche_zero_positif_b_tres_proche_zero_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 3.770288574632816, -5.765853404799374E-7, -1.5288535457492425);
		saveResultsToCSV("resultats_equations.csv", 3.770288574632816, -5.765853404799374E-7, -1.5288535457492425,result);
		assertArrayEquals(getExpectedArray(3.770288574632816, -5.765853404799374E-7, -1.5288535457492425), result, 0.001);
	}
	@Test
	public void test_a_normal_positif_b_positif_tres_grand_c_normal_positif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 195.35252828406797, 9.724679961270279E8, 65.72299424011831);
		saveResultsToCSV("resultats_equations.csv", 195.35252828406797, 9.724679961270279E8, 65.72299424011831,result);
		assertArrayEquals(getExpectedArray(195.35252828406797, 9.724679961270279E8, 65.72299424011831), result, 0.001);
	}
	@Test
	public void test_a_positif_tres_grand_b_tres_proche_zero_positif_c_negatif_tres_grand() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, 7.474193420638078E8, 2.959484200213073E-7, -2.5385362893255413E8);
		saveResultsToCSV("resultats_equations.csv", 7.474193420638078E8, 2.959484200213073E-7, -2.5385362893255413E8,result);
		assertArrayEquals(getExpectedArray(7.474193420638078E8, 2.959484200213073E-7, -2.5385362893255413E8), result, 0.001);
	}
	@Test
	public void test_a_tres_proche_zero_negatif_b_normal_negatif_c_proche_zero_negatif() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> dynamicClass = Class.forName("com.example.Equation");
		Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
		double[] result = (double[]) dynamicClass.getMethod("solveQuadratic", double.class, double.class, double.class).invoke(dynamicObject, -4.6776145429937907E-7, -412.40297429855696, -2.276411706671638);
		saveResultsToCSV("resultats_equations.csv", -4.6776145429937907E-7, -412.40297429855696, -2.276411706671638,result);
		assertArrayEquals(getExpectedArray(-4.6776145429937907E-7, -412.40297429855696, -2.276411706671638), result, 0.001);
	}
}

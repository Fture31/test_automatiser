package com.example;
// package dev.djob.id;

// import org.apache.commons.csv.*;
// import org.junit.Test;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.lang.reflect.InvocationTargetException;
// import java.nio.file.Files;
// import java.nio.file.Paths;

// import static org.junit.Assert.assertEquals;
// public class EquationTest {
//     public boolean monAssertion(double expected, double actual, double epsilon) {
//         boolean reussi = Math.abs(expected - actual) <= epsilon;
//         return reussi;
//     }  
      
//     @Test
//     public void testSolve_a_null_b_proche_de_0_positif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = 0.0;
//         double b = 4.764142553129117;
//         double c = 0.0;
//         boolean result1 ;
//         String testName=" testSolve_a_null_b_proche_de_0_positif__c_null";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-20);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }


//     @Test
//     public void testSolve_a_tres_proche_de_zero__b_normal_negatif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = 5.484229000191632E-7;
//         double b = -42.259239334589836;
//         double c = 6.281228668844043E-7;
//         boolean result1 ;
//         String testName=" testSolve_a_tres_proche_de_zero__b_normal_negatif__c_tres_proche_de_zero_";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
        
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
    

//     @Test
//     public void testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = -4.2738240509575013E-7;
//         double b = -4.405388784343381;
//         double c = 4.921108515481011;
//         boolean result1 ;
//         String testName=" testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_negatif__c_proche_de_0_positif_";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }


//     @Test
//     public void testSolve_a_proche_de_0_positif__b_tres_proche_de_zero__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = 3.8652880790685518;
//         double b = 7.080289005940507E-7;
//         double c = -9.931643652073008E-7;
//         boolean result1 ;
//         String testName=" testSolve_a_proche_de_0_positif__b_tres_proche_de_zero__c_tres_proche_de_0_negatif_";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }


//     @Test
//     public void testSolve_a_proche_de_0_negatif__b_normal_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = -2.6749076125113707;
//         double b = 84.44004208840676;
//         double c = 415.1693513298763;
//         boolean result1 ;
//         String testName=" testSolve_a_proche_de_0_negatif__b_normal_positif__c_normal_positif_";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }


//     @Test
//     public void testSolve_a_normal_positif__b_negatif_grand__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = 80.22464053834942;
//         double b = -4.66588078693741E8;
//         double c = 5.956108837126232E8;
//         boolean result1 ;
//         String testName=" testSolve_a_normal_positif__b_negatif_grand__c_grand_positif_";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }


//     @Test
//     public void testSolve_a_normal_negatif__b_null_c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//         double a = -347.9066848220078;
//         double b = 0.0;
//         double c = -426.85135017989126;
//         boolean result1 ;
//         String testName=" testSolve_a_normal_negatif__b_null_c_normal_negatif_";
//         String testValue = " dans la fonction "+testName+"  ";
//         double expectedValue = 0.0;
//         double epsilon = 1e-10;
//         String expectedResult;
//         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

//         Class<?> dynamicClass = Class.forName("dev.djob.id.EquationSolver");
//         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
//         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
//         // V�rifiez combien de racines l'�quation a
//         int numberOfRoots = result.length;
//         if (numberOfRoots == 2) {
//             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
//             // L'�quation a deux racines
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
//             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
//             if (assertionResult1) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult && assertionResult1;
//         } else if (numberOfRoots == 1) {
//             // L'�quation a une racine
//             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
//             expectedResult = " x?="+result[0] ;
//             double actualValue = a * result[0] * result[0] + b * result[0] + c;
//             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de x?  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de x?  a �chou�";
//                 System.out.println("L'assertion a �chou�");
//             }
//             result1 = assertionResult;
//         } else {
//             // Aucune racine r�elle
//             assertEquals(0, result.length, 0);
//             expectedResult =" ensemble vide dans R ";
//             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
//             if (assertionResult) {
//                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
//                 System.out.println("L'assertion a r�ussi");
//             } else {
//                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
//                 System.out.println("L'assertion de l ensemble vide a �chou�");
//             }
//             result1 = assertionResult;
//         }CSVPrinter csvPrinter = null;
//         try {
//             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
//             if (!Files.exists(Paths.get("test_results.csv"))) {
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             else{
//                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
//                 CSVFormat csvFormat = CSVFormat.DEFAULT;
//                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
//             }
//             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
//         } catch (IOException e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (csvPrinter != null) {
//                     csvPrinter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 2.2980485070986536E8;
// //         double b = 9.081140969551424E-9;
// //         double c = -4.519525989466891;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_grand_positif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -4.875258861920728E8;
// //         double b = 2.810128510279703E8;
// //         double c = -9.35835697995933E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_grand_positif__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_null_c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = 0.0;
// //         double c = -2.0657117175548792E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_null_c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_null_c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 9.03181234205041E-7;
// //         double b = 0.0;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_null_c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_null_c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -8.89227612547498E-8;
// //         double b = 0.0;
// //         double c = -4.27208787401868;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_null_c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_null_c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 3.1408956031335715;
// //         double b = 0.0;
// //         double c = 7.884325368826017E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_null_c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_null_c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -3.793371617493924;
// //         double b = 0.0;
// //         double c = 3.9427462068090895;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_null_c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_null_c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 307.4592917714734;
// //         double b = 0.0;
// //         double c = 307.6295874852656;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_null_c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_tres_proche_de_zero__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -285.8476973535011;
// //         double b = 5.897549871404606E-7;
// //         double c = -3.1830493401041404;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_tres_proche_de_zero__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_null_c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 5.12946110096688E8;
// //         double b = 0.0;
// //         double c = 7.51893567577203E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_null_c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_null_c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -3.871146377630775E8;
// //         double b = 0.0;
// //         double c = -5.213382865251161E-9;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_null_c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_tres_proche_de_0_negatif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = -1.7656287313840543E-7;
// //         double c = 466.60556447803447;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_tres_proche_de_0_negatif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_proche_de_0_positif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.073105035692896E-7;
// //         double b = 2.9407346376069547;
// //         double c = -7.830083693626817E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_proche_de_0_positif__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_proche_de_0_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = -4.468679577992036;
// //         double c = -1.9472668668822522E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_proche_de_0_negatif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_normal_positif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = 185.25468478324495;
// //         double c = 3.987189477819326;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_normal_positif__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_normal_negatif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = -31.67321919233973;
// //         double c = 3.0587226508794314E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_normal_negatif__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_grand_positif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = 2.7350255654253167E8;
// //         double c = -3.1976583893648765;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_grand_positif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_negatif_grand__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = -5.705294247729931E8;
// //         double c = 5.530826427890475E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_negatif_grand__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_null_b_tres_proche_de_zero__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 0.0;
// //         double b = 6.086606633611605E-7;
// //         double c = -385.36458688905356;
// //         boolean result1 ;
// //         String testName=" testSolve_a_null_b_tres_proche_de_zero__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -9.255566712094263E-7;
// //         double b = -7.850764699180977E-7;
// //         double c = -1.7046574265635097E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_negatif_grand__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 1.3493623668649462;
// //         double b = -9.77210481880342E8;
// //         double c = -5.421568698746578E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_negatif_grand__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_normal_negatif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.5844301043534843;
// //         double b = -72.38290796497694;
// //         double c = -1.1822186980200279E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_normal_negatif__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_tres_proche_de_zero__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 488.48138938825133;
// //         double b = 3.8000549927773316E-7;
// //         double c = -5.750365984045371E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_tres_proche_de_zero__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_proche_de_0_negatif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -453.9364446850735;
// //         double b = -1.9585038592571844;
// //         double c = -3.055899544141756E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_proche_de_0_negatif__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_normal_positif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 5.0828574523545504E8;
// //         double b = 436.8483613965168;
// //         double c = -8.569473270887208E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_normal_positif__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_proche_de_0_positif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -6.837538425110233E8;
// //         double b = 1.1092785499425095;
// //         double c = 1.3053072063279946E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_proche_de_0_positif__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_grand_positif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -344.98731884087533;
// //         double b = 2.0084516920070755E8;
// //         double c = 1.1326910850893134E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_grand_positif__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_negatif_grand__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.981281953991972;
// //         double b = -9.990466207240984E8;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_negatif_grand__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_negatif_grand__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -8.082237070142101E8;
// //         double b = -2.67467104557788E8;
// //         double c = -368.59687799043854;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_negatif_grand__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_proche_de_0_negatif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 3.471519369356151E-7;
// //         double b = -1.0101974481202367;
// //         double c = -289.5530494981118;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_proche_de_0_negatif__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -6.738587489388444E-7;
// //         double b = -176.25306445359433;
// //         double c = -189.0600799355537;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_proche_de_0_positif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.4302529657312135;
// //         double b = 4.98907586642299;
// //         double c = -71.40133612555309;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_proche_de_0_positif__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_normal_positif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 420.6629811147516;
// //         double b = 203.2125226883913;
// //         double c = -439.01083584025184;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_normal_positif__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_grand_positif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 5.545778506137316E8;
// //         double b = 3.681055251633038E8;
// //         double c = -325.56763985446645;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_grand_positif__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -3.9464967357943075;
// //         double b = -4.7472973923243386E-7;
// //         double c = -456.6922257694525;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_normal_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_normal_negatif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 56.33141557617691;
// //         double b = -198.0968337754981;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_normal_negatif__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_normal_positif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -7.547332448183076E8;
// //         double b = 471.25198614995844;
// //         double c = 2.785844786670669E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_normal_positif__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_normal_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -475.8315948338934;
// //         double b = -31.13761677131049;
// //         double c = -5.512218228075716E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_normal_negatif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_normal_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.254594840011797E8;
// //         double b = -246.53361733873396;
// //         double c = 3.0390467808061112;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_normal_negatif__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_normal_negatif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 5.1283632306465936E8;
// //         double b = -368.08360159370176;
// //         double c = 23.427814354076276;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_normal_negatif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_negatif_grand__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 7.831728512438422E-7;
// //         double b = -1.857045572844249E8;
// //         double c = -2.9286533704426136;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_negatif_grand__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -1.7360686934852436E-7;
// //         double b = 489.7366651119131;
// //         double c = 7.187004420772481E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_normal_positif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.795890058230531;
// //         double b = 176.930193275087;
// //         double c = -2.5289408193225955;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_normal_positif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_tres_proche_de_zero__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.5250301342165113E-7;
// //         double b = 7.333710545597564E-7;
// //         double c = 255.81586853287058;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_tres_proche_de_zero__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_tres_proche_de_0_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -159.4489810023851;
// //         double b = -5.15354699695205E-7;
// //         double c = 1.371220099472911;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_tres_proche_de_0_negatif__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_proche_de_0_positif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.1287689095050744;
// //         double b = 1.462055052539101;
// //         double c = -2.32261092419965;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_proche_de_0_positif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 403.79459289634485;
// //         double b = -3.847510574420142;
// //         double c = -3.2534469843277716;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_proche_de_0_negatif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_grand_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.820382804691774;
// //         double b = 7.053761836169686E8;
// //         double c = 315.5656910793144;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_grand_positif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 2.6441691576025055;
// //         double b = -1.0210847079019456;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_proche_de_0_positif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 310.3622645337111;
// //         double b = 3.838052629936049;
// //         double c = 5.694363641642848E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_proche_de_0_positif__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_normal_positif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 8.52475813853224E-7;
// //         double b = 451.6689388824539;
// //         double c = -5.514904671544088E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_normal_positif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_zero__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.054909837735936E-7;
// //         double b = 6.33236498238155E-7;
// //         double c = 9.277140991140618E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_zero__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_proche_de_0_positif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 9.520882672960453E7;
// //         double b = 3.240228617714481;
// //         double c = 4.9789119405506455;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_proche_de_0_positif__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.494642264953746;
// //         double b = -8.877045714967606E-7;
// //         double c = 1.1889192983609407E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_grand_positif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 8.388533981537688E8;
// //         double b = 9.639804683628547E8;
// //         double c = 8.666476471471041E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_grand_positif__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_tres_proche_de_zero__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -1.6741765711726868E8;
// //         double b = 1.457597012608518E-7;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_tres_proche_de_zero__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_tres_proche_de_0_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 28.265904464586846;
// //         double b = 1.1839040626418336E-8;
// //         double c = -4.1516502128037926E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_tres_proche_de_0_negatif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_grand_positif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -4.604201453836822;
// //         double b = 2.977359577878751E8;
// //         double c = -6.989073951079347E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_grand_positif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_negatif_grand__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.1673192783086283E-7;
// //         double b = -4.2671584099423635E8;
// //         double c = -7.736510813426711E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_negatif_grand__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_proche_de_0_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -292.2404415939631;
// //         double b = 3.3836544867778793;
// //         double c = 414.9694597733321;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_proche_de_0_positif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_proche_de_0_negatif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -5.49420930746937E8;
// //         double b = -3.7111956215551167;
// //         double c = 4.741047330354597E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_proche_de_0_negatif__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 8.243340817668201E8;
// //         double b = 4.8908029474525304E-8;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_grand_positif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 5.641042923573564E-7;
// //         double b = 6.466191209127171E8;
// //         double c = 4.77718810719624;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_grand_positif__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_zero__b_tres_proche_de_0_negatif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 3.93197354117256E-7;
// //         double b = -6.063280648623068E-7;
// //         double c = 5.036951636125927E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_zero__b_tres_proche_de_0_negatif__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_grand_positif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -1.8821040590361719E-7;
// //         double b = 4.049738739672798E8;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_grand_positif__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 1.1403815622229323;
// //         double b = -2.6083461496157936;
// //         double c = 4.220842687338756E7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_negatif_grand__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -202.47581465002895;
// //         double b = -4.682812968644326E8;
// //         double c = 6.457390925474828E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_negatif_grand__c_tres_proche_de_zero_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_negatif_grand__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.433442104165226E7;
// //         double b = -4.3197452054675007E8;
// //         double c = 4.281209472361361;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_negatif_grand__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_tres_proche_de_zero__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 47.004020917554705;
// //         double b = 6.986616282016207E-7;
// //         double c = 2.6671549049152996;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_tres_proche_de_zero__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_negatif_grand__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -7.128021812306497E8;
// //         double b = -1.6138900146030843E8;
// //         double c = 498.7991002869637;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_negatif_grand__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_normal_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 3.3612212187809276;
// //         double b = -279.2365042191326;
// //         double c = 4.102353847383796;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_normal_negatif__c_proche_de_0_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_proche_de_0_negatif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -4.788922635351682;
// //         double b = -3.227932326044986;
// //         double c = 28.092205032501756;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_proche_de_0_negatif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_proche_de_0_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 8.442506715633614E8;
// //         double b = -2.5367034749270108;
// //         double c = -9.194550669841715E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_proche_de_0_negatif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_zero__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.7123448133500005;
// //         double b = 4.973409209421936E-7;
// //         double c = 7.201149972067223E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_negatif__b_tres_proche_de_zero__c_grand_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_positif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -8.617838000247525E-7;
// //         double b = 1.9332533905663252;
// //         double c = -8.078776682323114E-7;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_positif__c_tres_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_negatif__b_normal_positif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -341.6258844241263;
// //         double b = 318.94412807682863;
// //         double c = 0.0;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_negatif__b_normal_positif__c_null";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_negatif_grand__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -7.490611411911082E8;
// //         double b = -1.5926479620284098E-7;
// //         double c = -2.151287500383757;
// //         boolean result1 ;
// //         String testName=" testSolve_a_negatif_grand__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 2.1893975876695842E-8;
// //         double b = 117.994669440498;
// //         double c = 344.8454535371269;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_proche_de_0_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 4.328937068307701;
// //         double b = -3.2995266523579125E-7;
// //         double c = -4.758588866708376;
// //         boolean result1 ;
// //         String testName=" testSolve_a_proche_de_0_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_normal_positif__b_grand_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 130.64201691249318;
// //         double b = 7.19508231282991E8;
// //         double c = 107.0527390604052;
// //         boolean result1 ;
// //         String testName=" testSolve_a_normal_positif__b_grand_positif__c_normal_positif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_grand_positif__b_tres_proche_de_zero__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = 8.002500756474997E7;
// //         double b = 6.168635233318532E-7;
// //         double c = -3.9276889173685896E8;
// //         boolean result1 ;
// //         String testName=" testSolve_a_grand_positif__b_tres_proche_de_zero__c_negatif_grand_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-10;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             assertEquals(0, a * result[1] * result[1] + b * result[1] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// //     @Test
// //     public void testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
// //         double a = -2.0139999995040187E-7;
// //         double b = -14.887538520144233;
// //         double c = -4.281903905757126;
// //         boolean result1 ;
// //         String testName=" testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_proche_de_0_negatif_";
// //         String testValue = " dans la fonction "+testName+"  ";
// //         double expectedValue = 0.0;
// //         double epsilon = 1e-20;
// //         String expectedResult;
// //         String equation = " "+a+"x� + "+ b + "x + "+c+ " = 0";

// //         Class<?> dynamicClass = Class.forName("com.td.equation.EquationSolver");
// //         Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
// //         double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b,c);
// //         // V�rifiez combien de racines l'�quation a
// //         int numberOfRoots = result.length;
// //         if (numberOfRoots == 2) {
// //             expectedResult = " x?="+result[0]+" et  x? = "+result[1] ;
// //             // L'�quation a deux racines
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             double actualValue1 = a * result[1] * result[1] + b * result[1] + c;
// //             boolean assertionResult1 = monAssertion(expectedValue, actualValue1, epsilon);
// //             if (assertionResult1) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult && assertionResult1;
// //         } else if (numberOfRoots == 1) {
// //             // L'�quation a une racine
// //             assertEquals(0, a * result[0] * result[0] + b * result[0] + c, 1e-10);
// //             expectedResult = " x?="+result[0] ;
// //             double actualValue = a * result[0] * result[0] + b * result[0] + c;
// //             boolean assertionResult = monAssertion(expectedValue, actualValue, epsilon);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de x?  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de x?  a �chou�";
// //                 System.out.println("L'assertion a �chou�");
// //             }
// //             result1 = assertionResult;
// //         } else {
// //             // Aucune racine r�elle
// //             assertEquals(0, result.length, 0);
// //             expectedResult =" ensemble vide dans R ";
// //             boolean assertionResult = monAssertion(expectedValue, result.length, 0);
// //             if (assertionResult) {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a r�ussi";
// //                 System.out.println("L'assertion a r�ussi");
// //             } else {
// //                 testValue=testValue+"L'assertion de l ensemble vide  a �chou�";
// //                 System.out.println("L'assertion de l ensemble vide a �chou�");
// //             }
// //             result1 = assertionResult;
// //         }CSVPrinter csvPrinter = null;
// //         try {
// //             // Ajoutez une ligne d'en-t�te avec des descriptions de colonnes
// //             if (!Files.exists(Paths.get("test_results.csv"))) {
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("EQUATION","Test Name", "A Value", "B Value", "C Value", "Expected Result", " RESULTAT DU TEST"," RESULTAT FONCTION");
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             else{
// //                 FileWriter fileWriter = new FileWriter("test_results.csv", true); // Le "true" indique d'ajouter au fichier existant
// //                 CSVFormat csvFormat = CSVFormat.DEFAULT;
// //                 csvPrinter = new CSVPrinter(fileWriter, csvFormat);
// //             }
// //             csvPrinter.printRecord(equation,testName, a, b, c, expectedResult,testValue,result1);
// //         } catch (IOException e) {
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 if (csvPrinter != null) {
// //                     csvPrinter.close();
// //                 }
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //             }
// //         }
// //     }


// // }
// }
package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Generator {
    


   public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/example/test_cases2.txt"));

            String line;

            String testCode = " package com.example ;\n"+
             "import org.junit.Test;\n"+
          
                    "import static org.junit.Assert.*;\n" +
                    "import java.io.FileWriter;\n" +    
                    
                    "import java.io.IOException;\n"+

                    "import java.lang.reflect.InvocationTargetException;\n\n" +
                    "public class TestCases {\n\n" +
        
                    "\n \tprivate static double[] getExpectedArray(double a, double b, double c) {\n" +
                    "\tdouble discriminant = b * b - 4 * a * c;\n" +
                    "\t\tif (a == 0) {\n" +
                    "\t\t\t double root =-c/(b);\n" +
                      "\t\t\t return new double []{root};\n" +
                    "\t\t} else if (discriminant < 0) {\n" +
                    "\t\t\t  return new double[0];\n" +
                    "\t\t} else if (discriminant == 0) {\n" +
                    "\t\t\tdouble root = -b / (2 * a);\n" +
                    "   \t\t\treturn new double[]{root};\n" +
                    " \t\t} else {\n" +
                    " \t\tdouble root1 = (-b + Math.sqrt(discriminant)) / (2 * a);\n" +
                    "   \t\t\t  double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);\n" +
                    "\t\treturn new double[]{root1, root2};\n" +
                    "\t}\n" +
                    "\t}\n\n" +
                    "\n \tpublic static void saveResultsToCSV(String filePath, double a, double b, double c, double[] solutions) {\n" +

                    "\n \ttry (FileWriter writer = new FileWriter(filePath)) {\n" +
                    "\n \t writer.append(\"Equation,ResultatX0,ResultatX1\\n\");\n" +

                    "\n \tfor (int i = 0; i < solutions.length; i++) {\n" +
                    "\n \twriter.append(\"Equation \" + (i + 1) + \":\" + a + \"x2+\"+b+\"x\"+c+ \",\" + \",\" + solutions[i] + \"\\n\");\n"+
                    "\n \t}\n" +

                    "\n \tSystem.out.println(\"Résultats enregistrés dans le fichier CSV : \" + filePath);\n" +
                    "\n \t} catch (IOException e) {\n" +
                    "\n \te.printStackTrace();\n" +
                    "\n \t}\n" +
                    "\n \t}\n";
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");

                // Correspondance avec les classes d'équivalence
                Map<String, Double> classA = getClassEquivalence(values[1], "_a_");
                Map<String, Double> classB = getClassEquivalence(values[2], "_b_");
                Map<String, Double> classC = getClassEquivalence(values[3], "_c_");

                String a = getKeyFromMap(classA);
                String b = getKeyFromMap(classB);
                String c = getKeyFromMap(classC);

                // Générer le code de test
                String fonctCode = generateTestCode(classA.get(a), classB.get(b), classC.get(c), i, a, b, c);
                testCode += fonctCode;
                i++;

                System.out.println("Code de test généré pour les classes d'équivalence : " + classA + ", " + classB
                        + ", " + classC);
            }
            testCode += "}\n";
            // Écrire le code de test dans un fichier
            String fileName = "src/test/java/com/example/TestCases.java";
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(testCode);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getKeyFromMap(Map<String, Double> map) {
        for (String key : map.keySet()) {
            return key;
        }
        return null;
    }

    private static String generateTestCode(double classA, double classB, double classC, int i, String a, String b,
            String c) {
        // Génère le code de test avec les valeurs correspondantes
        // Utilisez String.format pour remplacer les valeurs dans le modèle de test

        String template = "\t@Test\n" +
                "\tpublic void test%s%s%s() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{\n"
                +
                "\t\tClass<?> dynamicClass = Class.forName(\"com.example.Equation\");\n" +
                "\t\tObject dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();\n" +
                "\t\tdouble[] result = (double[]) dynamicClass.getMethod(\"solveQuadratic\", double.class, double.class, double.class).invoke(dynamicObject, %s, %s, %s);\n"
                +
                "\t\tsaveResultsToCSV(\"resultats_equations.csv\", %s, %s, %s,result);\n" +
                "\t\tassertArrayEquals(getExpectedArray(%s, %s, %s), result, 0.001);\n" +
                "\t}\n";

        // Remplace les marqueurs de position dans le modèle de test
        return String.format(template, a, b, c, classA, classB, classC, classA, classB, classC, classA, classB, classC);
    }

   
    private static Map<String, Double> getClassEquivalence(String value, String prefix) {
        // Correspondance avec les classes d'équivalence
        char letter = value.charAt(1); // Récupérer la lettre (a, b, c, ...)
        Map<String, Double> equivalenceMap = new HashMap<>();

        switch (letter) {
            case 'a':
                equivalenceMap.put(prefix + "null", 0.0);
                break;
            case 'b':
                equivalenceMap.put(prefix + "tres_proche_zero_positif", getRandomFloatInRange(1e-7, 1e-6));
                break;
            case 'c':
                equivalenceMap.put(prefix + "tres_proche_zero_negatif", getRandomFloatInRange(-1e-6, -1e-7));
                break;
            case 'd':
                equivalenceMap.put(prefix + "proche_zero_positif", getRandomFloatInRange(1.0, 5.0));
                break;
            case 'e':
                equivalenceMap.put(prefix + "proche_zero_negatif", getRandomFloatInRange(-5.0, -1.0));
                break;
            case 'f':
                equivalenceMap.put(prefix + "normal_positif", getRandomFloatInRange(10.0, 500.0));
                break;
            case 'g':
                equivalenceMap.put(prefix + "normal_negatif", getRandomFloatInRange(-500.0, -10.0));
                break;
            case 'h':
                equivalenceMap.put(prefix + "positif_tres_grand", getRandomFloatInRange(1e6, 1e9));
                break;
            case 'i':
                equivalenceMap.put(prefix + "negatif_tres_grand", getRandomFloatInRange(-1e9, -1e6));
                break;
            default:
                throw new IllegalArgumentException("Invalid letter: " + letter);
        }

        return equivalenceMap;
    }

    private static double getRandomFloatInRange(double min, double max) {
        Random random = new Random();
        return min + random.nextDouble() * (max - min);
    }
}



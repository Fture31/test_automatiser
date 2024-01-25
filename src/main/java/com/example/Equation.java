package com.example;
public class Equation  {
//  pour resolution 
    public static double[] solveQuadratic(double a, double b, double c) {
        // Calcul du discriminant
        final int d = 4; // Declare 'd' as a constant
        double discriminant = b * b - d * a * c;
        // Initialisation du tableau de solutions
        double[] solutions;
        // Cas où le discriminant est positif
        if (a == 0) {
            double root = -b / (c);
            solutions = new double[]{root};
        } else if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            solutions = new double[]{root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            solutions = new double[]{root};
        } else {
            solutions = new double[0];
        }
        return solutions;
    } 
}

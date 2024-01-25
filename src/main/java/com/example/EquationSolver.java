package com.example;


public class EquationSolver implements IEquationSolver {
    @Override
    public double[] solve(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            return new double[] { x };
        } else {
            double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            return new double[] { x1, x2 };
        }
    }
    
}

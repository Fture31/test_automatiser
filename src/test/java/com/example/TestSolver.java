package com.example;
import org.junit.Test;




public class TestSolver {

    @Test
    public void buildTestSolver(){
        cucumber test = new cucumber();
    
        test.l_équation_du_second_degré_avec_coefficients_a_b_c(1,4,3);
        test.je_résous_l_équation();
        test.les_solutions_de_l_équation_sont_x1_et_x2(-3, -1);
         
}


@Test
public void buildTestSolver1(){
    cucumber test = new cucumber();

    test.l_équation_du_second_degré_avec_coefficients_a_b_c(1,3,2);
    test.je_résous_l_équation();
    test.les_solutions_de_l_équation_sont_x1_et_x2(-2, -1);
     
}
  

}
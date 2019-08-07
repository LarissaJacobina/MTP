/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtp;

import java.util.Scanner;

public class Soma {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        
        int km;
        int lt;
        int km_lt;
        int soma_km = 0;
        int soma_lt = 0;
        int total;
        
        for(int i = 0; i <= 3; i++){
        System.out.println("Digite os km rodados");
        km = input.nextInt();
        System.out.println("Digite os litros consumidos");
        lt = input.nextInt();
      
        km_lt = km / lt;  
         
        System.out.printf("Quilometro por litro = %d\n", km_lt);
         
            soma_km = soma_km + km;
            soma_lt = soma_lt + lt;
        }
        System.out.printf("Total de Quilometros rodados = %d\n", soma_km);
        System.out.printf("Total de litros consumidos = %d\n", soma_lt);
    }
}
25
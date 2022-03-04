package lab_1;

import java.util.Scanner;

public class Lab1_Main {

	public static void main(String[] args) {
		float n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите сумму вклада: ");
		n = sc.nextFloat();
		
		int i = 1;
		while(i <= 12) {
			System.out.println(i + " месяц: " + n);
			n += (n / 100) * 0.95;
			i++;
		}
		
		
		sc.close();
		
	}

}
		
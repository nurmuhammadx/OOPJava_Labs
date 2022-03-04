package lab_2;

import java.util.Collections;
import java.util.Scanner;

public class Lab2_Main {

	public static void main(String[] args) {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите число n: ");
		n = sc.nextInt();
		//up
		int t = n;
		while(t > 1) {
			int j = n;
			while(j > (n - t)) {
				System.out.print(j + " ");
				j--;
				}
				System.out.print("\n" + String.join("", Collections.nCopies((n - t) + 1, "  ")));
				t--;				
		}
		
		//down
		int i = 1;
		while(i <= n) {
			int j = n;
			if(i > 1)
				System.out.print("\n" + String.join("", Collections.nCopies((n - i), "  ")));
			while(j > (n - i)) {
				System.out.print(j + " ");
				j--;
				}
			i++;
		}
		
	}
	
}

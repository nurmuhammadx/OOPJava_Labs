import java.util.Collections;
import java.util.Scanner;

public class Lab2DoMain {

	public static void main(String[] args) {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите число n: ");
		n = sc.nextInt();
		
		//up
		int t = n;
		do {
			int j = n;
			do {
				System.out.print(j + " ");
				j--;
			}while(j > (n - t));
			System.out.print("\n" + String.join("", Collections.nCopies((n - t) + 1, "  ")));
			t--;		
		}while(t > 1);
				
		//down
		int i = 1;
		do {
			if(i > 1) 
				System.out.print("\n" + String.join("", Collections.nCopies((n - i), "  ")));
			int j = n;
			do {
				System.out.print(j + " ");
				j--;
			}while(j > (n - i));
			i++;
		}while(i <= n);

	}

}

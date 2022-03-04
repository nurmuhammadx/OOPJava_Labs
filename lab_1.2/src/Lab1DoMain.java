import java.util.Scanner;

public class Lab1DoMain {

	public static void main(String[] args) {
		float n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите сумму вклада: ");
		n = sc.nextFloat();
		
		int i = 1;
		do {
			System.out.println(i + " месяц: " + n);
			n += (n / 100) * 0.95;
			i++;
		}while(i <= 12);
		
		
		sc.close();

	}

}

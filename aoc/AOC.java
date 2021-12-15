package aoc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AOC {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\fire5\\Desktop\\General Gaming\\Advent of C\\1_1.txt");
		try (Scanner sc = new Scanner(file)) {
			int var2 = 999999;
			int var3 = 999999;
			int var4 = 999999;
			int ans = 0;
	
			while (sc.hasNextInt()) {
				int var = sc.nextInt();
				System.out.println(var + "," + var2 + "," + var3 + "," + var4);
				System.out.println((var + var2 + var3) + "," + (var2 + var3 + var4));
				if (var + var2 + var3 > var2 + var3 + var4) {
					ans ++;
				}
				System.out.println(ans);
				var4 = var3;
				var3 = var2;
				var2 = var;
			}
		}
	}
}

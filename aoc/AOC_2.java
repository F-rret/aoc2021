package aoc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AOC_2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\fire5\\Desktop\\General Gaming\\Advent of C\\2_1.txt");
		try (Scanner sc = new Scanner(file)) {
			int hor = 0;
			int depth = 0;
			String forw = "forward ";
			String back = "backward ";
			String up = "up ";
			String down = "down ";
			int val;
			int aim = 0;
			
			while(sc.hasNextLine()) { 
				String str = sc.nextLine();
				if (str.startsWith(forw)) {
					val = Integer.parseInt(str.replace(forw, ""));
					hor = hor + val;
					depth = depth + (aim * val);
					System.out.println(hor + "," + depth + "," + val);
				}
				if (str.startsWith(back)) {
					val = Integer.parseInt(str.replace(back, ""));
					System.out.println(hor + "," + depth + "," + val);
					hor = hor - val;
				}
				if (str.startsWith(up)) {
					val = Integer.parseInt(str.replace(up, ""));
					System.out.println(hor + "," + depth + "," + val);
					aim = aim - val;
				}
				if (str.startsWith(down)) {
					val = Integer.parseInt(str.replace(down, ""));
					System.out.println(hor + "," + depth + "," + val);
					aim = aim + val;
				}
			}
			System.out.println(hor * depth);
		}
	}
}

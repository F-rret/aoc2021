package aoc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AOC_3 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\fire5\\Desktop\\General Gaming\\Advent of C\\3_1.txt");
		
		List<String> li = new ArrayList<String>();
		List<String> liO = new ArrayList<String>();
		List<String> liC = new ArrayList<String>();
		
			Scanner sc = new Scanner(file); 
			while(sc.hasNextLine()) { 
				li.add(sc.nextLine());
				System.out.println(li);
			}
			sc.close();
		System.out.println(li.size());
		
		int c0 = 0;
		char xx = '0';
		char yy = '1';
		char cO;
		char cC;
		
		for (int fo = 0; fo < li.size(); fo++) {
			if(xx == li.get(fo).charAt(0)) {
				c0 ++;
			}
		}
		if(c0 > (li.size() - c0)) {
			cO = xx;
			cC = yy;
		} else {
			cO = yy;
			cC = xx;
		}
		System.out.println(c0 + "," + cO + "," + cC);
			for (int fo = 0; fo < li.size(); fo++) {
				if(cO == li.get(fo).charAt(0)) {
					liO.add(li.get(fo));
				} else {
					liC.add(li.get(fo));
				}
			}
			int now = 0;
			while (liO.size() != 1) {
				c0 = 0;
				now ++;
			System.out.println(liO);
			for (int fo = 0; fo < liO.size(); fo++) {
				if(xx == liO.get(fo).charAt(now)) {
					c0 ++;
				}
			}
			if(c0 > (liO.size() - c0)) {
				cO = xx;
			} else {
				cO = yy;
			}
			System.out.println(c0 + "," + cO);
			for (int fo = 0; fo < liO.size(); fo++) {
				if(cO != liO.get(fo).charAt(now)) {
					liO.remove(fo);
					fo --;
				}
			}
			System.out.println(liO);	
		}
			now = 0;
			while (liC.size() != 1) {
				c0 = 0;
				now ++;
			System.out.println(liC);
			for (int fo = 0; fo < liC.size(); fo++) {
				if(xx == liC.get(fo).charAt(now)) {
					c0 ++;
				}
			}
			if(c0 > (liC.size() - c0)) {
				cO = yy;
			} else {
				cO = xx;
			}
			System.out.println(c0 + "," + cO);
			for (int fo = 0; fo < liC.size(); fo++) {
				if(cO != liC.get(fo).charAt(now)) {
					liC.remove(fo);
					fo --;
				}
			}
			System.out.println(liC);
			}
			System.out.println(Integer.parseInt(liO.get(0), 2) * Integer.parseInt(liC.get(0),2));
	}
}

package aoc;

import java.io.*;
import java.nio.file.*;
import java.util.*;

//makes references for objects 
class Square
{
    public int value;
    public Boolean mark;
    Square(int value, Boolean mark)
    {
        this.value = value;
        this.mark = mark;
    }
}

public class ReadFIle {

	public static void main(String[] args) {
		 // creating path
        Path filePath
            = Paths.get("C:\\Users\\fire5\\eclipse-workspace\\aoc\\src\\inputs\\4_1.txt");
        try
  
        {
        	//reads file from path
            String content = Files.readString(filePath);
            //initializing variables
            String[] call = new String[7];
            String[] tempB = new String[8];
            String balls = "";
            //shuffling values into correct arrays
            call = content.split("\n");
            tempB = content.split(call[0]);
            call = call[0].split(",");
            tempB = tempB[1].split("\n");
            //check in point
            System.out.println();
            System.out.println(tempB.length + " " + tempB[0] + "ok check 1");
            //converts array to individual numbers through a list
            for(int x = 0; x < tempB.length; x ++) {
            	tempB[x] = tempB[x].concat(" ");
            	balls = balls.concat(tempB[x]);
            	System.out.print(tempB[x]);
            }
            tempB = balls.split(" ");
            //uses a string to remove blank squares in the array
            Collection<String> cock = new ArrayList<>(Arrays.asList(tempB));
            ArrayList<String> c = new ArrayList<>(cock);
            c.remove(0);
            for(int x = 0; x < c.size(); x++) {
            	if (c.get(x) == "") {
            		c.remove(x);
            		x --;
            	}
            }
            //returns final array of squares 
            Square[] finalB = new Square[c.size()];
            for(int x = 0; x < c.size(); x ++) {
            	finalB[x] = new Square(Integer.parseInt(c.get(x)), false);
            	System.out.println(finalB[x].value + ", " + finalB[x].mark);
            }
            //tries to test values
            int now;
            int whichB;
            int bPos;
            int bRow;
            int bCollumn;
			boolean bingo = false;
			int fSum = 0;
			List<Integer> semen = new ArrayList<Integer>();
            for (int y = 0; y < call.length; y ++) {
            	now = Integer.parseInt(call[y]);
            	for (int x = 0; x < finalB.length && semen.size() < 100; x ++) {
                	if (now == finalB[x].value) {
                		finalB[x].mark = true;
                		whichB = x/25;
                		bPos = (x - 25 * whichB);
                		bRow = bPos/5;
                		bCollumn = bPos - bRow * 5;
                		//checks for a Horizontal win
                		System.out.println(whichB + ", " + x + ", " + bPos + ", " + bRow + ", " + bCollumn);
                		if (finalB[(whichB * 25 + bRow)].mark && finalB[(whichB * 25 + bRow + 1)].mark && finalB[(whichB * 25 + bRow + 2)].mark && finalB[(whichB * 25 + bRow + 3)].mark && finalB[(whichB * 25 + bRow + 4)].mark) {
                			System.out.println("bingoHoriz");
                			bingo = true;
                			if (semen.contains(whichB) == false) {
                				semen.add(whichB);
                			}
                			fSum = 0;
                			for (int z = 0; z < 25; z ++) {
                				if (finalB[(z + whichB * 25)].mark != true) {
                					System.out.println(z + " " + finalB[(z + whichB * 25)].value + " " + z + whichB * 25);
                					fSum = fSum + finalB[(z + whichB * 25)].value;
                				}
                			}
                			System.out.println(now + " " + fSum + " " + fSum * now);
                		}
                		//checks for a vertical win
                		if (finalB[(whichB * 25 + bCollumn)].mark && finalB[(whichB * 25 + bCollumn + (5 * 1))].mark && finalB[(whichB * 25 + bCollumn + (5 * 2))].mark && finalB[(whichB * 25 + bCollumn + (5 * 3))].mark && finalB[(whichB * 25 + bCollumn + ( 5 * 4))].mark) {
                			System.out.println("bingoVert");
                			bingo = true;
                			if (semen.contains(whichB) == false) {
                				semen.add(whichB);
                				System.out.println(semen);
                			}
                			fSum = 0;
                			System.out.println(fSum);
                			for (int z = 0; z < 25; z ++) {
                				if (finalB[(z + whichB * 25)].mark == false) {
                					fSum = fSum + (finalB[(z + whichB * 25)].value);
                					System.out.println(z + " " + finalB[(z + whichB * 25)].value + " " + (z + whichB * 25) + " " + fSum);
                				}
                			}
                			System.out.println(now + " " + fSum + " " + fSum * now + " " + semen.size() + " " + bPos + " " + whichB);
                		}
                	}
            		
                }
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}

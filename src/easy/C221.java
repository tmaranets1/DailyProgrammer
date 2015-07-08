/*
	/r/dailyprogrammer
	[2015-06-29] Challenge #221 [Easy] Word snake
*/
package easy;

import java.util.ArrayList;
import java.util.Scanner;

public class C221 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input");
		print(in.nextLine());
		in.close();
	}
	public static void print(String ns)
	{
		Scanner sc = new Scanner(ns);
		ArrayList<String> words = new ArrayList<>();
		while (sc.hasNext()) //parses all words from the string and adds them to an array list
			words.add(sc.next());
		char[][] grid = new char[100][100]; //100 is an arbitrary number for a gridsize
		setGrid(grid,words);
		sc.close();
	}
	public static void setGrid(char[][] grid, ArrayList<String> words)
	{
		int r = 0;
		int c = 0;
		for (int i = 0; i < words.size(); i++) 
		{
			if (i == 0 || i % 2 == 0) //horizontal
			{
				if (i == words.size()-1) //makes sure end character for the last word is in the snake
				{
					for (int u = 0; u < words.get(i).length(); c++)
					{
						grid[r][c] = words.get(i).charAt(u);
						u++;
					}
				}
				else
				{
					for (int u = 0; u < words.get(i).length()-1; c++)
					{
						grid[r][c] = words.get(i).charAt(u);
						u++;
					}	
				}
			}
			if (i % 2 != 0) //vertical
			{
				if (i == words.size()-1) 
				{
					for (int u = 0; u < words.get(i).length(); r++)
					{
						grid[r][c] = words.get(i).charAt(u);
						u++;
					}	
				}
				else
				{
					for (int u = 0; u < words.get(i).length()-1; r++)
					{
						grid[r][c] = words.get(i).charAt(u);
						u++;
					}	
				}
				
			}
		}
		printGrid(grid);
	}
	public static void printGrid(char[][] grid)
	{
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
				System.out.print(grid[r][c]);
			System.out.println();
		}
	}
}

/*
	/r/dailyprogrammer
	[2015-06-22] Challenge #220 [Easy] Mangling sentences
*/
package easy;

import java.util.ArrayList;
import java.util.Scanner;

public class C220 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input:");
		System.out.println(mangle(in.nextLine()));
		in.close();
	}
	public static String mangle(String ns)
	{
		Scanner sep = new Scanner(ns);
		String ret = "";
		while (sep.hasNext())
			ret += sortWord(sep.next()) + " ";
		sep.close();
		return ret;
	}
	public static String sortWord(String ns)
	{
		String nslc = ns.toLowerCase(); //better to have all lower case
		ArrayList<Character> chars = new ArrayList<>();
		for (int i = 0; i < nslc.length(); i++) //loop adds all alphabetic characters to the arraylist
		{
			if (Character.isAlphabetic(nslc.charAt(i)))
				chars.add(nslc.charAt(i));
		}
		chars = sort(chars); //array is alphabetically sorted
		String ret = "";
		for (int i = 0; i < ns.length(); i++)
		{
			if (Character.isUpperCase(ns.charAt(i))) //changes to upper case when needed
				chars.set(i, Character.toUpperCase(chars.get(i)));
			if (!Character.isAlphabetic(ns.charAt(i))) //adds puncation and other non-alphabetic characters to the array in the proper places
				chars.add(i,ns.charAt(i));
			ret += chars.get(i);
		}
		return ret;
	}
	public static ArrayList<Character> sort(ArrayList<Character> al) //insertion sort implementation
	{
		for (int i = 1; i < al.size(); i++)
		{
			char t = al.get(i);
			int j;
			for (j = i-1; j >= 0 && t < al.get(j); j--)
				al.set(j+1, al.get(j));
			al.set(j+1, t);
		}
		return al;
	}

}

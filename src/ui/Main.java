package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static ArrayList<String> lines = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		 System.out.println("Ingresa la ruta del archivo: (la ruta por defecto es \"data/text.txt\")");
		 readTxt(sc.next());
	}
	
	public static void readTxt(String path) {
		String result = "";
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			String temp = "";
			String bfRead;
			
			try {
				while ((bfRead = bf.readLine()) != null) {
					lines.add(bfRead);
					temp = temp + "\n" + bfRead;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sortResult();
			saveText(getTextFromArray(lines));
			System.out.println("Archivo ordenado y guardado correctamente");
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getTextFromArray(ArrayList<String> result) {
		String output = "";
		for(String element : result) {
			if(!element.equals(""))
			output += element + "\n";
		}
		return output;
	}
	public static void saveText(String text){
		try {

			File ref = new File("data/sortedText.txt");
			FileWriter fw = new FileWriter("data/sortedText.txt", false);
			fw.write(text);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sortResult () {
		Collections.sort(lines, new Comparator<String>() {
			
			@Override
			public int compare(String A, String B) {
				if(A.replaceAll("[,.\\s]*","").compareTo(B.replaceAll("[,.\\s]*","")) >= 0) {
					return 1;
				}else {
					return -1;
				}
			}
		});
	}
	

}

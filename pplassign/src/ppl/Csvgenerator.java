package ppl;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Csvgenerator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	void csvgen() throws IOException{
		Random b_rand = new Random();
		Random g_rand = new Random();
		FileWriter b_file = new FileWriter("boy.csv");
		FileWriter g_file = new FileWriter("girl.csv");
		FileWriter gift_file = new FileWriter("gift.csv");
		Random gift_rand = new Random();
		int i;
		String[] mystring = {"intelligent","rich","attractive"};
		String[] stg1 = {"essential","luxry","utiltiy"};
		String[] stg2 = {"choosy","normal","desperate"};
		String[] stg3 = {"miser","generous","geeks"};
		for(i=0;i<=15;i++){
			b_file.write("b"+i+","+b_rand.nextInt(10)+","+b_rand.nextInt(1000)+","+b_rand.nextInt(10)+","+b_rand.nextInt(10)+","+","+stg3[b_rand.nextInt(3)]+"\n");
		}
		for(i=0;i<=7;i++){
			g_file.write("g"+i+","+g_rand.nextInt(10)+","+g_rand.nextInt(1000)+","+g_rand.nextInt(10)+","+mystring[g_rand.nextInt(3)]+","+stg2[g_rand.nextInt(3)]+"\n");
		}
		for(i=0;i<10;i++){
			gift_file.write("gift"+i+","+gift_rand.nextInt(1000)+","+stg1[gift_rand.nextInt(3)]+"\n");
		}
		b_file.close();
		g_file.close();
		gift_file.close();
	}

}

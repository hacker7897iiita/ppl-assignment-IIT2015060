package ppl;

import java.util.Scanner;
import java.io.*;
public class Main {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Csvgenerator c= new Csvgenerator();
		c.csvgen();
		int i=0,j=0;
		Boy b[] = new Boy[1000];
		Girl g[] = new Girl[1000];
		Gift gift[] = new Gift[1000];
		String csvfile = "boy.csv";
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		buff = new BufferedReader(new FileReader(csvfile));
		while((line = buff.readLine())!= null ){
			String[] boys_table = line.split(csvSplit); 
			b[i] = new Boy(boys_table[0],Integer.parseInt(boys_table[1]),Integer.parseInt(boys_table[2]),Integer.parseInt(boys_table[3]),Integer.parseInt(boys_table[3]),boys_table[4]);
			i++;
		}
		int n1 = i;
		line ="";
		csvSplit = ",";
		csvfile = "girl.csv";
		buff = new BufferedReader(new FileReader(csvfile));
		while((line = buff.readLine())!= null){
			String[] girls_table = line.split(csvSplit);
			g[j] = new Girl(girls_table[0],Integer.parseInt(girls_table[1]),Integer.parseInt(girls_table[2]),Integer.parseInt(girls_table[3]),girls_table[4],girls_table[4]);
			j++;
		}
		int n2 = j;
		int k=0;
		line ="";
		csvSplit = ",";
		csvfile = "gift.csv";
		buff = new BufferedReader(new FileReader(csvfile));
		while((line = buff.readLine())!= null){
			String[] gift_table = line.split(csvSplit);
			gift[k] = new Gift(gift_table[0],Integer.parseInt(gift_table[1]),gift_table[2]);
			k++;
		}
		int n3 = k;
		Gift dum = new Gift("fd",987,"dwwd");
		for(i=0;i<n3;i++){
			for(j=0;j<n3;j++){
				if(gift[i].value<gift[j].value){
					dum = gift[i];
					gift[i] = gift[j];
					gift[j] = dum;	
				}
			}
		}
		System.out.println("q1. couples formed");
		couple(b,g,n1,n2);
		gifting(b,g,gift,n1,n2,n3);
		valentine(b,g,gift,n1,n2,n3);
		System.out.println();
		System.out.println("q2.");
		Girl dum2 = new Girl("jwd",7,7,7,"ksw","jdw");
		for(i=0;i<n2;i++){
			for(j=0;j<n2;j++){
				if(g[i].happy<g[j].happy){
					dum2 = g[i];
					g[i] = g[j];
					g[j] = dum2;	
				}
			}
		}
		System.out.println("happiest couple");
		j=0;
		for(i=0;i<n2;i++){
			if(g[i].status == "commited"){
				System.out.println(g[i].name+" -> "+g[i].boyfriend);
				j++;
			}
			if(j == 3){
				break;
			}
		}
		for(i=0;i<n2;i++){
			for(j=0;j<n2;j++){
				if(g[i].compat<g[j].compat){
					dum2 = g[i];
					g[i] = g[j];
					g[j] = dum2;	
				}
			}
		}
		System.out.println("compatable couple");
		j=0;
		for(i=0;i<n2;i++){
			if(g[i].status == "commited"){
			System.out.println(g[i].name+" -> "+g[i].boyfriend);
			j++;
			}
			if(j == 3){
				break;
			}
		}
	}
	private static void gifting(Boy[] obj1,Girl[] obj2,Gift[] obj3,int n1,int n2,int n3){
		int i;
		for(i=0;i<n1;i++){
			int j=0;
			if(obj1[i].status == "commited"){	
				int bg = obj1[i].budget;
				if(obj1[i].type == "miser"){
					while(bg >= obj3[j].value && j<n3){
						bg = bg-obj3[j].value;
						if(obj2[i].type == "choosy" && obj3[j].type == "luxry"){
							obj1[i].cost += 2*obj3[j].value;
						}
						else{
							obj1[i].cost += obj3[j].value;
						}
						j++;
						if(obj1[i].cost > obj2[i].maintaince)
							break;
					}
				}
				else{
					while(bg >= obj3[j].value && j<n3){
						bg = bg-obj3[j].value;
						/*if(obj2[i].type == "choosy" && obj3[j].type == "luxry"){
							obj1[i].cost += 2*obj3[j].value;
						}*/
				
							obj1[i].cost += obj3[j].value;
						
						j++;
					}
				}
			}	
		}
	}
	private static void valentine (Boy[] obj1,Girl[] obj2,Gift[] obj3,int n1,int n2,int n3){
		int totalvalue=0;
		int i,j = 0;
		for(i=0;i<n3;i++){
			totalvalue += obj3[i].value;
		}
		double happinessb = 0,happinessg = 0;
		for(i=0;i<n2;i++){
			if(obj2[i].status == "commited"){
				j=0;
				while(obj2[i].boyfriend != obj1[j].name ){					
					j++;
				}
				int k=obj1[j].cost;
				happinessg=0;
				if(obj2[i].type == "choosy"){
					happinessg = Math.log(k);
				}
				else if(obj2[i].type == "normal"){
					happinessg = totalvalue+k;
				}
				else if(obj2[i].type == "desperate"){
					happinessg = Math.exp(k);
				}
				if(obj1[j].type == "miser"){
					happinessb = obj1[i].budget-obj1[i].cost;
				}
				else if(obj1[j].type == "generous"){
					happinessb = happinessg;
				}
				else if(obj1[j].type == "geeks"){
					happinessb =obj2[i].intelligence;
				}
			}
			obj2[i].happy = happinessb + happinessg;
			obj2[i].compat = Math.abs(obj1[j].budget - obj2[i].maintaince) + Math.abs(obj1[j].attractive - obj2[i].attractive) + Math.abs(obj1[j].intelligence - obj2[i].intelligence) ;
		}
	}
	private static void couple(Boy[] obj1, Girl[] obj2,int n1,int n2) {
		// TODO Auto-generated method stub
		int i,j,max=0;
		String b,a="attractive",r="rich",c="intelligent";
		for(i=0;i<n2;i++){
			max=0;
			for(j=0;j<n1;j++){
				if(obj2[i].maintaince < obj1[j].budget && obj2[i].attractive >= obj1[j].minattract && obj1[j].status=="single"){
					b = obj2[i].criteria;
					if(b.equals(a)){
						if(obj1[j].attractive > obj1[max].attractive || max==0){
							obj1[max].status="single";
							max = j;
							obj2[i].status = "commited";
							obj2[i].boyfriend = obj1[j].name;	
							obj1[max].status="commited";
						}
					}
					else if(b.equals(r)){
						if(obj1[j].budget > obj1[max].budget || max==0){
							obj1[max].status="single";
							max = j;
							obj2[i].status = "commited";
							obj2[i].boyfriend = obj1[j].name;
							obj1[max].status="commited";
						}
					}
					else if(b.equals(c)){
						if(obj1[j].intelligence > obj1[max].intelligence || max==0){
							obj1[max].status="single";
							max = j;
							obj2[i].status = "commited";
							obj2[i].boyfriend = obj1[j].name;
							obj1[max].status="commited";
						}
					}
				}
			}
			
		}
		for(i=0;i<n2;i++){
			System.out.println(obj2[i].name+" -> "+obj2[i].status);
		}
		System.out.println();
		for(i=0;i<n1;i++){
			System.out.println(obj1[i].name+" -> "+obj1[i].status);
		}
	}

}

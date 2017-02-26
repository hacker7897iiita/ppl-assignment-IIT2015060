package ppl;

public class Boy {	
	String name,status,type;
	int attractive,budget,intelligence,minattract,cost;
	Boy(String name,int attractive,int budget,int intelligence,int minattract,String type){
		this.name = name;
		this.attractive = attractive;
		this.budget = budget;
		this.intelligence = intelligence;
		this.status = "single";
		this.minattract = minattract;
		this.cost = 0;
		this.type = type;
	}
	public void printer(){
		System.out.println(this.name+" "+this.attractive+" "+this.budget+" "+this.intelligence+" "+this.status);
	}
}

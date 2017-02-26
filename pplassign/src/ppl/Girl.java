package ppl;

public class Girl {
	String name,status,criteria,boyfriend,type;
	int attractive,maintaince,intelligence;
	double happy,compat;
	Girl(String name,int attractive,int maintaince,int intelligence,String criteria,String type){
		this.name = name;
		this.attractive = attractive;
		this.maintaince = maintaince;
		this.intelligence = intelligence;
		this.status = "single";
		this.criteria = criteria;
		this.boyfriend = "";
		this.type = type;
		this.happy = 0;
		this.compat = 0;
	}
	public void printer(){
		System.out.println(this.name+" "+this.attractive+" "+this.maintaince+" "+this.intelligence+" "+this.status);
	}
}

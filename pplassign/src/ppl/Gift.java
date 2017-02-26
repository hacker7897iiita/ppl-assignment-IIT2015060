package ppl;

public class Gift {

	/**
	 * @param args
	 */
	String name,type;
	int value;
	Gift(String name,int value,String type){
		this.name = name;
		this.value = value;
		this.type = type;
	}
	public void printer(){
		System.out.println(this.name+" "+this.value+" "+this.type);
	}
}

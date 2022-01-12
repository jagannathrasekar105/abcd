package study.jdbc;

public class StaticBlockExample {

	public static void main(String[] args) throws ClassNotFoundException {
//not method call not object bnvaychi ahe tr forname kraych tyachyatl static block run hote
		Class.forName("study.jdbc.StaticBlockused");
		
	}

}

class StaticBlockused
{
	static {
		System.out.println("the static block executed...");
	}
	
	public static void m1()
	{
		System.out.println("m1 called");
	}
}
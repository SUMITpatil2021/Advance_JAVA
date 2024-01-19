package apps;

public class MathUtility {

	public static void main(String[] args) {
		System.out.println(checkPrime(7));
	}
	
	public static boolean checkPrime(int no)
	{
		if(no < 2)
			return false;
		boolean check = true;
		for(int i=2;i< no/2;i++)
		{
			if(no%i == 0)
			{
				check=false;
				break;
			}
		}
		return check;
	}
	
	public static boolean isOdd(int no)
	{
		boolean check = true;
		if(no%2 != 0)
			check = false;
		return check;
	}

}

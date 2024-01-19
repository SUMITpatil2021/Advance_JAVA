package apps;
class Solution
{	
	public int maxSubstring(String s) {
		
		int max = 0;
        if(s.length() == 1)
            return 1;
        else
        {            
            for(int i=0;i<s.length()-1;i++)
            {
                for(int j=s.length(); j>i ;j--)
                {
                    String temp = s.substring(i,j);
                    boolean flag = false;
                    outer : for(int k=0;k<temp.length()-1;k++)
                    {
                        for(int l=k+1;l<temp.length();l++)
                        {
                            if(temp.charAt(k) == temp.charAt(l))
                            {
                                flag = true;
                                break outer;
                            }
                        }
                    }
                    if(flag == false)
                    {
                        if(max < temp.length())
                            max = temp.length();
                    }
                }
            }
        }
        return max;
	}
	
}


public class Test {

	public static void main(String[] args) {
		 System.out.println(new Solution().maxSubstring("bbbb"));

	}

}

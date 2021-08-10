


// Print all subsequences

class Ideone
{
	static void printAllSubsequences(String s, String res){
		if(s.length()==0){
			System.out.println(res);
			return;
		}
		
		printAllSubsequences(s.substring(1),res);
		printAllSubsequences(s.substring(1),res + s.charAt(0));
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String s = "abcd";
		printAllSubsequences(s,"");
	}
}




 
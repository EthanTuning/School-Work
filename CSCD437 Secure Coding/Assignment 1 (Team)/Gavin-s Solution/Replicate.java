public class Replicate
{
	public static void main(String[] args)
	{
		char quote = 34;
		char nl = 10;
		char tab = 9;
		String str = "public class Replicate%c{%c%cpublic static void main(String[] args)%c%c{%c%c%cchar quote = 34;%c%c%cchar nl = 10;%c%c%cchar tab = 9;%c%c%cString str = %c%s%c;%c%c%cSystem.out.printf(str,nl,nl,tab,nl,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,quote,str,quote,nl,tab,tab,nl,tab,nl);%c%c}%c}";
		System.out.printf(str,nl,nl,tab,nl,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,quote,str,quote,nl,tab,tab,nl,tab,nl);
	}
}

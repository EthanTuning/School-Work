public class Quine1{
	public static void main(String ... args){
		String str = "public class Quine1{%c%cpublic static void main(String ... args){%c%c%cString str = %c%s%c%c%c%c%cchar quote = 34;%c%c%cchar tab = 9;%c%c%cchar nl = 10;%c%c%cchar semicol = 59;%c%c%cSystem.out.printf(str,nl,tab,nl,tab,tab,quote,str,quote,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,nl);%c%c}%c}";
		char quote = 34;
		char tab = 9;
		char nl = 10;
		char semicol = 59;
		System.out.printf(str,nl,tab,nl,tab,tab,quote,str,quote,semicol,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,tab,nl,tab,nl);
	}
}
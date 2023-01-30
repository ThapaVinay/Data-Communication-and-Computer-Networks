import java.util.Scanner;
public class Bit_Stuffing_Dynamic{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Code : ");
        String str = sc.nextLine();
        int count =0;
        String s = "";
        for(int i =0; i<str.length(); i++)
        {
            s += str.charAt(i);
            if(str.charAt(i) == '1')
            {
                count ++;
            }else{
                count = 0;
            }

            if(count == 5)
            {
                s += '0';
                count = 0;
            }
        }
        System.out.println("After bit stuffing : " + s);
        sc.close();
    }
}
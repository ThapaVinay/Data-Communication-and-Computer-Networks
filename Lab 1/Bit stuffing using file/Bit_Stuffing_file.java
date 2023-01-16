import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Bit_Stuffing_file{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Enter the text to be bit stuffed ..
        System.out.println("Enter the text :");
        String text = sc.next();

        // Enter the file name ..
        System.out.println("Enter file name :");
        String file = sc.next();  
        file += ".txt"; 
        FileWriter obj3 = new FileWriter(file);
        obj3.write(text);
        obj3.close();

        File obj = new File(file);
        Scanner obj1 = new Scanner(obj);
        while(obj1.hasNextLine())
        {
            String s = obj1.nextLine();
            StringBuilder str = new StringBuilder();

            // Convertion of string to bits
            for(char ch : s.toCharArray())
            {
                int temp = ch;
                str.append(Integer.toBinaryString(temp));
            }
            System.out.println("The corresponding code is : " + str);

            // Bit stuffing code 
            int count =0;
            s = "";
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
                    count =0;
                }
            }
            String outfile = "outFile.txt";
            System.out.println("After bit stuffing the code is : " + s);

            // De stuffing code ..
            String st = "";
            count = 0;
            for(int i=0; i<s.length(); i++)
            {
                if(s.charAt(i) == '1')
                {
                    count ++;
                }else{
                    count = 0;
                }

                if(count == 5)
                {
                    st += '1';
                    count = 0;
                    i++;
                    continue;
                }
                st += s.charAt(i);
            }
            System.out.println("After de stuffing : " + st);
            System.out.println("Your output file is : " + outfile);

            // Checking if we get the initial string after de stuffing ..
            if(st.equals(str.toString()))
            {
                System.out.println("Success!, you got it right. Both before and after de stuffing is same.");
            }
            FileWriter writer = new FileWriter(outfile);
            writer.write(s);
            writer.close();
        }
        obj1.close();
        sc.close();
    }
}
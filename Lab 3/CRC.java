
import java.util.Scanner;
public class CRC {

    // function to find the remainder 
    public static int[] remainder(int arr[], int arr1[])
    {
        for(int i=0; i+(arr1.length-1)<arr.length; i++)
        {
            if(arr[i] == 0)
            {
                for(int j=0; j<arr1.length; j++)
                    arr[i+j] = arr[i+j] ^ (arr1[j] * 0);
            }
            else
            {
                for(int j=0; j<arr1.length; j++)
                    arr[i+j] = arr[i+j] ^ arr1[j];
            }
        }
        int [] remainder = new int[arr1.length-1];
        int k = 0;
        for(int i = (arr.length - (arr1.length-1)); i< arr.length ;i++)
        {
            remainder [k] = arr[i];
            k++;
        }
        return remainder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the CRC: \n 1. CRC-8 \n 2. CRC-10 \n 3. ITU-16 \n 4. ITU-32 :");
        int choice = sc.nextInt();
        String divisor = "";

        // to get the divisor using the different CRC polynomial
        switch(choice)
        {
            case 1:
                divisor = "100000111";
                break; 
            case 2:
                divisor = "11000110101";
                break; 
            case 3:
                divisor = "10001000000100001";
                break; 
            case 4:
                divisor = "100000100110000010001110110110111";
                break;
        }

        System.out.println("Enter the stream to be sent :");
        String sent = sc.next();
        for(int i=0; i<divisor.length()-1; i++)
            sent += "0";


        // converting the input strings to array
        int [] arr = new int [sent.length()];
        int [] arr1 = new int [divisor.length()];

        for(int i=0; i<sent.length(); i++)
            arr[i] = sent.charAt(i) - '0';
            
        for(int i=0; i<divisor.length(); i++)
            arr1[i] = divisor.charAt(i) - '0';


        // finding the remainder for the sent stream
        int [] rem = remainder(arr,arr1);
        for(int i=0; i<rem.length; i++)
            System.out.print(rem[i] + "");
        System.out.println();



        System.out.println("Enter the recieved stream :");
        String receive = sc.next();
        

        // adding the reaminder to the recieved data
        for(int i=0; i<rem.length; i++)
            receive += rem[i];


        // converting the received string to array 
        int [] arr2 = new int [receive.length()];
        for(int i=0; i<receive.length(); i++)
            arr2[i] = receive.charAt(i) - '0';


        // finding the final remainder for the received data 
        rem = remainder(arr2,arr1);


        // checking if the data is successfully transmitted 
        for(int i=0;i< rem.length;i++)
        {
            if(rem[i] != 0)
            {
                System.out.println("Error Occured !");
                return;
            }
        }
        System.out.println("Data Transmitted Successfully !");
    }
}

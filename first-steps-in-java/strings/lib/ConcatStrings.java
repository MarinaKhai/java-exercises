// Concatenate two strings taken from a user's input
// Take input from different locales. (?)

// Сложить две строки, введенные пользователем, в одну. Вывести на экран результат.
// (Если строки пустые, вывести пустую в кавычках.)
// (Если на языке с другим алфавитом - учитывать локализацию (locale)).

import java.util.Scanner;

public class ConcatStrings {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuffer sbuff = new StringBuffer("");
        String str;
        do {
            System.out.println("Please enter your message. To exit write \"stop the prog\"");
            str = sc.nextLine();
            if (str.equalsIgnoreCase("stop the prog"))
                break;
            sbuff.append(str);
        } while(true);
    
        // String s3 = s1.concat(s2);  // 1st solution
        // String s3 = s1 + s2;    // 2nd solution (what's the difference ?)
    
        System.out.println("Your message is: " + sbuff.toString());
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string");
        String s1 = sc.nextLine();

        // CaseOfString strcase = new CaseOfString(s1);
        // System.out.println(
        //     '\n' + strcase.toUpper()
        //     + '\n' + strcase.toLower()
        //     + '\n' + strcase.firstLetterInStringCapital()
        //     + '\n' + strcase.onlyFirstLetterInStringCapital()
        //     + '\n' + strcase.firstLettersOfWordsCapital()
        //     + '\n' + strcase.onlyFirstLettersOfWordsCapital()
        //     + '\n' + strcase.reverseCase()
        // );
        
        // SplitString sp = new SplitString(s1);
        // String[] words = sp.splitIt(",");
        // System.out.println(words[0]);
        
        // DigitsInString rmNum = new DigitsInString(s1);
        // System.out.println(rmNum.findNumber());
        
        // StringInfo strinf = new StringInfo(s1);
        // System.out.println("Is substring in given string? - " + strinf.str_contains_c("two"));
        // System.out.println("Is substring in given string? - " + strinf.str_contains_m("two"));
        
        StringConversion strConv = new StringConversion(s1);
        System.out.println(strConv.deleteNotNumbers());
        System.out.println(strConv.reverse_str());
    }
}

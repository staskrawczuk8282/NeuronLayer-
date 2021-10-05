import java.math.BigDecimal;
import java.util.Scanner;

public class CreateNewVector {

    double[] alphabetTable = new double[26];

    public CreateNewVector(){

        for(int i = 0; i<26; i++){
            alphabetTable[i] =0;
        }
    }


    public BigDecimal[] startInterface(){

        return sortSentenceToSignsFrequency(getData());
    }


    public String getData(){

        Scanner userInput = new Scanner(System.in);
        System.out.println("***TRY TYPING A SENTANCE IN ONE OF THE LANGUAGES***\n***[PL,EN,FR,IT,PT,ES]***\n!!!(DON'T USE ANY SPECIAL SIGNS)!!!)");
        return userInput.nextLine();
    }
    public BigDecimal[] sortSentenceToSignsFrequency(String input){

        input = input.replaceAll(" ","");
        input = input.replaceAll("\n","");
        input = input.replaceAll("\t","");
          input = input.replaceAll(",","");
        input = input.replaceAll("-","");

        char [] inputLetters = input.toCharArray();

        for(char x :inputLetters){
            switch (x){
                case 'a': alphabetTable[0]++; break;
                case 'b': alphabetTable[1]++; break;
                case 'c': alphabetTable[2]++; break;
                case 'd': alphabetTable[3]++; break;
                case 'e': alphabetTable[4]++; break;
                case 'f': alphabetTable[5]++; break;
                case 'g': alphabetTable[6]++; break;
                case 'h': alphabetTable[7]++; break;
                case 'i': alphabetTable[8]++; break;
                case 'j': alphabetTable[9]++; break;
                case 'k': alphabetTable[10]++; break;
                case 'l': alphabetTable[11]++; break;
                case 'm': alphabetTable[12]++; break;
                case 'n': alphabetTable[13]++; break;
                case 'o': alphabetTable[14]++; break;
                case 'p': alphabetTable[15]++; break;
                case 'q': alphabetTable[16]++; break;
                case 'r': alphabetTable[17]++; break;
                case 's': alphabetTable[18]++; break;
                case 't': alphabetTable[19]++; break;
                case 'u': alphabetTable[20]++; break;
                case 'v': alphabetTable[21]++; break;
                case 'w': alphabetTable[22]++; break;
                case 'x': alphabetTable[23]++; break;
                case 'y': alphabetTable[24]++; break;
                case 'z': alphabetTable[25]++; break;
                default: break;}}


             BigDecimal[] letterFrequencies = new BigDecimal[26];
                for(int ii=0;ii<26;ii++){
                    letterFrequencies[ii] = new BigDecimal("0");
                }


             for(int i=0; i<26;i++){
                 if(alphabetTable[i] !=0){
                letterFrequencies[i] = BigDecimal.valueOf((alphabetTable[i]/(double)inputLetters.length));}
             }

             return letterFrequencies;
            }

    }





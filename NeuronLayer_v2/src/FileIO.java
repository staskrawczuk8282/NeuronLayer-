import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    private static String PATHTOFILE;
    public static List<LanguageEnum> listOfResults = new ArrayList<>();

    public FileIO(String pathToFile){
        PATHTOFILE = pathToFile;
    }

    public static List<BigDecimal[]> getFromFile(boolean isTrainSet) throws Exception {
        //List<LanguageEnum> languageEnums = new ArrayList<>();
        File file = new File(PATHTOFILE);
        Scanner scan = new Scanner(file);
        List<BigDecimal[]> results = new ArrayList<>();
        while (scan.hasNextLine()) {
            try{
                String[] tmp = scan.nextLine().split(";");
                BigDecimal[] tmp2 = null;
                if(isTrainSet){
                    tmp2 = new BigDecimal[tmp.length-1];
                    for (int i = 0; i < tmp.length-1; i++) {
                        tmp2[i] = new BigDecimal(tmp[i]);
                    }
                    listOfResults.add(LanguageEnum.valueOf(tmp[tmp.length-1].trim()));
                }
                else{
                    tmp2 = new BigDecimal[tmp.length];
                    for (int i = 0; i < tmp.length; i++) {
                        tmp2[i] = new BigDecimal("tmp[i]");
                    }
                }
                results.add(tmp2);}catch (Exception e){
                e.printStackTrace();
            }
        }
        //Collections.shuffle(results);
        return results;
    }
}

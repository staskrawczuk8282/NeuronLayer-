import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;


public class Main {
    static int [][] macierzOmylek = new int[6][6];

    public static void main(String[] args) throws Exception {


        List<LanguageEnum> languageList = Arrays.asList(LanguageEnum.en, LanguageEnum.es, LanguageEnum.fr, LanguageEnum.it, LanguageEnum.pl, LanguageEnum.pt);
        FileIO trainingFileIO = new FileIO("data/train.csv");
        List<BigDecimal[]> listOfTrainingVectors = trainingFileIO.getFromFile(true);
        PerceptronLayer neuronLayer = new PerceptronLayer(languageList);


        double celnosc;
        double iloscPoprawnych = 0;
        int iloscPowtorzen = 10;
        int index = 0;
        for(int i =0; i<iloscPowtorzen;i++){
            index=0;
            iloscPoprawnych=0;

            for(BigDecimal[] trainingVector : listOfTrainingVectors){
                neuronLayer.DeliverData(trainingVector);
                LanguageEnum ourResult = neuronLayer.GetLayerResults();
                if(i == iloscPowtorzen-1){
                returnErrorMartix(ourResult,trainingFileIO.listOfResults.get(index));}
                String ourResultstr = ourResult.toString();
                if(ourResultstr.equals(trainingFileIO.listOfResults.get(index).toString())){iloscPoprawnych++;}

                neuronLayer.TrainLayer(trainingFileIO.listOfResults.get(index));
                index++;
            }
            System.out.println("...COMPUTING... \n");
        }



        System.out.println(" \tES\tEN\tFR\tIT\tPT\tPL\t");
        System.out.println();
        for(int ii = 0; ii<macierzOmylek.length; ii++){
            String lang = "";
            if(ii ==0){lang = "ES\t ";}
            if(ii ==1){lang = "EN\t ";}
            if(ii ==2){lang = "FR\t ";}
            if(ii ==3){lang = "IT\t ";}
            if(ii ==4){lang = "PT\t ";}
            if(ii ==5){lang = "PL\t ";}
            System.out.print(lang);
            for(int iii = 0; iii<macierzOmylek.length; iii++){


                System.out.print(macierzOmylek[ii][iii] + "\t");
            }

            System.out.println();
        }

        celnosc = 100*(iloscPoprawnych/(listOfTrainingVectors.size()));
        System.out.println("SKUTECZNOSC:  "+(int) celnosc +"%");


        CreateNewVector createNewVector = new CreateNewVector();
        neuronLayer.DeliverData(createNewVector.startInterface());
        System.out.println("JEZYK TO: " + neuronLayer.GetLayerResults().toString());


        System.out.println("OSTATECZNE WAGI WEKTOROW TO : ");
        for(int i = 0; i<6; i++){
            System.out.println("JEZYK PERCEPTRONU: " + neuronLayer.perceptronLayer[i].trainedClass.toString());
            for (int j=0; j<neuronLayer.perceptronLayer[i].weights.length;j++){
                System.out.println("WAGA " + j +" "+  neuronLayer.perceptronLayer[i].weights[j].round(new MathContext(2,RoundingMode.CEILING)));
            }

            System.out.println("PROG AKTYWACJI TO : " + neuronLayer.perceptronLayer[i].rangeTheta.round(new MathContext(2,RoundingMode.CEILING)));
        }

    }



    public static void returnErrorMartix (LanguageEnum layerResult, LanguageEnum expectedResult){

        //es =0, en = 1, fr=2, it =3 , pt=4 , pl=5



        if(expectedResult.toString().equals("es")){
            if(layerResult.toString().equals("es")){ macierzOmylek[0][0] ++; }
            else if(layerResult.toString().equals("en")){macierzOmylek[0][1] ++;}
            else if(layerResult.toString().equals("fr")){macierzOmylek[0][2] ++;}
            else if(layerResult.toString().equals("it")){macierzOmylek[0][3] ++;}
            else if(layerResult.toString().equals("pt")){macierzOmylek[0][4] ++;}
            else if(layerResult.toString().equals("pl")){macierzOmylek[0][5] ++;}
        }
        else if(expectedResult.toString().equals("en")){
            if(layerResult.toString().equals("es")){ macierzOmylek[1][0] ++; }
            else if(layerResult.toString().equals("en")){macierzOmylek[1][1] ++;}
            else if(layerResult.toString().equals("fr")){macierzOmylek[1][2] ++;}
            else if(layerResult.toString().equals("it")){macierzOmylek[1][3] ++;}
            else if(layerResult.toString().equals("pt")){macierzOmylek[1][4] ++;}
            else if(layerResult.toString().equals("pl")){macierzOmylek[1][5] ++;}
        }
        else if(expectedResult.toString().equals("fr")){
            if(layerResult.toString().equals("es")){ macierzOmylek[2][0] ++; }
            else if(layerResult.toString().equals("en")){macierzOmylek[2][1] ++;}
            else if(layerResult.toString().equals("fr")){macierzOmylek[2][2] ++;}
            else if(layerResult.toString().equals("it")){macierzOmylek[2][3] ++;}
            else if(layerResult.toString().equals("pt")){macierzOmylek[2][4] ++;}
            else if(layerResult.toString().equals("pl")){macierzOmylek[2][5] ++;}
        }
        else if(expectedResult.toString().equals("it")){
            if(layerResult.toString().equals("es")){ macierzOmylek[3][0] ++; }
            else if(layerResult.toString().equals("en")){macierzOmylek[3][1] ++;}
            else if(layerResult.toString().equals("fr")){macierzOmylek[3][2] ++;}
            else if(layerResult.toString().equals("it")){macierzOmylek[3][3] ++;}
            else if(layerResult.toString().equals("pt")){macierzOmylek[3][4] ++;}
            else if(layerResult.toString().equals("pl")){macierzOmylek[3][5] ++;}
        }
        else if(expectedResult.toString().equals("pt")){
            if(layerResult.toString().equals("es")){ macierzOmylek[4][0] ++; }
            else if(layerResult.toString().equals("en")){macierzOmylek[4][1] ++;}
            else if(layerResult.toString().equals("fr")){macierzOmylek[4][2] ++;}
            else if(layerResult.toString().equals("it")){macierzOmylek[4][3] ++;}
            else if(layerResult.toString().equals("pt")){macierzOmylek[4][4] ++;}
            else if(layerResult.toString().equals("pl")){macierzOmylek[4][5] ++;}}
        else if(expectedResult.toString().equals("pl")){
            if(layerResult.toString().equals("es")){ macierzOmylek[5][0] ++; }
            else if(layerResult.toString().equals("en")){macierzOmylek[5][1] ++;}
            else if(layerResult.toString().equals("fr")){macierzOmylek[5][2] ++;}
            else if(layerResult.toString().equals("it")){macierzOmylek[5][3] ++;}
            else if(layerResult.toString().equals("pt")){macierzOmylek[5][4] ++;}
            else if(layerResult.toString().equals("pl")){macierzOmylek[5][5] ++;}}


    }
}

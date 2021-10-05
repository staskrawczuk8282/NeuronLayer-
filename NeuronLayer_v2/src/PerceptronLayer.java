import java.math.BigDecimal;
import java.util.List;

public class PerceptronLayer {
    Perceptron[] perceptronLayer;
    BigDecimal[] result;
    private int amountOfVectors = 0;

    public PerceptronLayer(List<LanguageEnum> classes){
        int index = 0;
        perceptronLayer = new Perceptron[classes.size()];

        for(LanguageEnum language : classes){
            perceptronLayer[index] = new Perceptron(language);
            index++;
        }
    }

    public void DeliverData(BigDecimal[] dataVector){
        for(Perceptron perceptron:perceptronLayer){
            if(amountOfVectors == 0){
                perceptron.setInMatrix(dataVector,true);}
            else perceptron.setInMatrix(dataVector,false);
        }
        amountOfVectors++;
    }

    public LanguageEnum GetLayerResults() throws Exception {
        BigDecimal [] result = new BigDecimal[6];
        int index = 0;
        for(Perceptron perceptron : perceptronLayer){
            result[index]=perceptron.getResult();
            index++;
        }
        this.result = result;

        int highestValueIndex = 0;
        for(int i = 0; i<result.length; i++){
            if(result[i].compareTo(result[highestValueIndex])>0) highestValueIndex = i;
    }
        LanguageEnum resultLanguage = perceptronLayer[highestValueIndex].trainedClass;

        return resultLanguage;
    }

    public void TrainLayer(LanguageEnum resultFromFile) throws Exception {
        int index = 0;
        for(Perceptron perceptron:perceptronLayer){
            if(perceptron.trainedClass.equals(resultFromFile)){
                perceptron.DeltaRule(result[index],new BigDecimal("1"));
            }
            else perceptron.DeltaRule(result[index],new BigDecimal("-1"));

            index++;
        }
    }
    public BigDecimal[] getResult(){return result;}

}

import java.math.BigDecimal;

public class Perceptron {



    private BigDecimal[] inMatrix;
    public BigDecimal [] weights;
    public BigDecimal rangeTheta;
    private final BigDecimal LEARNINGCONSTANT = new BigDecimal("0.1");
    private final BigDecimal STARTINGWEIGHTS = new BigDecimal("0.1");
    private final BigDecimal STARTINGTHETA = new BigDecimal("0.1");;
    public LanguageEnum trainedClass;


    public Perceptron(LanguageEnum trainedClass){
        rangeTheta = STARTINGTHETA;
        this.trainedClass = trainedClass;
    }

    public void setInMatrix(BigDecimal[]inMatrix,boolean isFirstVector){
        this.inMatrix=inMatrix;
        if(isFirstVector){
            weights = new BigDecimal[inMatrix.length];
            for(int i=0;i<inMatrix.length;i++){
                weights[i] = STARTINGWEIGHTS;
            }}
    }
    public BigDecimal getResult ()  {
        BigDecimal scalarWX= new BigDecimal("0");
        for(int i =0; i<inMatrix.length;i++){
            scalarWX=scalarWX.add(inMatrix[i].multiply(weights[i]));
        }
        BigDecimal result = scalarWX.subtract(rangeTheta);
        return result;
}
    public void DeltaRule(BigDecimal givenResult,BigDecimal expectedResult) throws Exception {

        if(!givenResult.equals(expectedResult)){
            BigDecimal lhConstant = (expectedResult.subtract(givenResult)).multiply(LEARNINGCONSTANT);
            BigDecimal [] lhMatrix = VectorMath.MultiplyVectorByScalar(lhConstant,inMatrix);
            weights = VectorMath.AddVectors(weights,lhMatrix);
            rangeTheta = rangeTheta.subtract(lhConstant);
        }
    }


}

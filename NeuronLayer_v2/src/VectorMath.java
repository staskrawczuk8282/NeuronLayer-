import java.math.BigDecimal;

public class VectorMath {

    public static BigDecimal[] AddVectors(BigDecimal[]v1,BigDecimal[]v2) throws Exception {
        BigDecimal[] result =new BigDecimal[v1.length];
        if(v1.length!=v2.length){
            throw new Exception("Vectors must be of the same size");
        }
        for(int i=0;i<result.length;i++){
            result[i] = v1[i].add(v2[i]);
        }
        return result;
    }

    public static BigDecimal[] MultiplyVectorByScalar (BigDecimal constant, BigDecimal[]v1) {
        BigDecimal[] result = new BigDecimal[v1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = v1[i].multiply(constant);
        }
        return result;
    }
    //TA KLASA NIE JEST UZYWANA PONIEWAZ DZIALANIA NA POTEGACH I PIERWIASTKACH Z KLASA BIG DECIMAL ZNACZACA WPLYWAJA NA
    //ZLOZONOSC CZASOWA TEGO ALGORYTMU, A NIE ZNACZACA WPLYWAJA NA JAKOS UCZENIA SIE SIECI
    public static BigDecimal[] NormalizeVector(BigDecimal[]v1){
        BigDecimal squareSum = new BigDecimal("0");
        for(BigDecimal value : v1){
            squareSum = squareSum.add(value.pow(2));
        }
        BigDecimal vLength = squareSum.pow(1/2);
        BigDecimal [] normalizedVector = new BigDecimal[v1.length];
        for(int i =0; i<v1.length; i++){
            normalizedVector[i] = (v1[i].divide(vLength));
        }
        return  normalizedVector;
    }

}

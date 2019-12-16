public class Enumz {
    public static void main(String[] args) {

        System.out.println("==================normal way");
        //convert to meters
        String chosenUnitString="CENTIMETER";
        double convMeterVal=1.0;
        double convCentiMeterVal=0.011;
        double convInchVal=0.025;
        double convFootVal=0.3;


        switch(chosenUnitString) {
            case "FOOT":
                System.out.println("Foot unit is selected.... use " + convFootVal);
                break;
            case "METER":
                System.out.println("Meter unit is selected.... use " + convMeterVal);
                break;
            case "INCH":
                System.out.println("Inch unit is selected.... use " + convInchVal);
                break;
            case "CENTIMETER":
                System.out.println("Centimeter unit is selected.... use " + convCentiMeterVal);
                break;
        }
        System.out.println("\n================== Enum way");
        LengthUnit chosenUnit =  LengthUnit.valueOf( "CENTIMETER");
        System.out.println(chosenUnit.convertToMeters());
        System.out.println("Multiply: " + chosenUnit.MultiplyBy(15));
        System.out.println("Divide: " + chosenUnit.DivideBy(10));
        System.out.println("Add: " + chosenUnit.Add(12));
        System.out.println("Substract: " + chosenUnit.Substract(4));



        System.out.println("\n================== Iteration");
        for(LengthUnit tempVar: LengthUnit.values()){
            System.out.println(tempVar + ": " + tempVar.convertToMeters());
        }

        System.out.println("\n================== for complex eg.");
        Cryptzz cryptEnumVariable = Cryptzz.valueOf("Pearl");
        String tobeUsed = cryptEnumVariable.getMyCrypt();
        System.out.println(cryptEnumVariable + ": " + cryptEnumVariable.getMyCrypt());
    }


}

enum LengthUnit {
    METER(1),
    CENTIMETER(0.01),           // Always "," and the last one is ";"
    FOOT(0.3),
    INCH(0.025);

    double value;
    LengthUnit(double value) {
        this.value = value;
        System.out.println("Constructor..." + value);
    }

    double convertToMeters() {
        return value;
    }

    double MultiplyBy(int a){
        return( value * a);
    }

    double DivideBy(int a){
        return (value / a);
    }

    double Add(int a ){
        return (a + value);
    }

    double Substract (int a){
        return (value * a);
    }

}

enum Cryptzz {
    Iron("tVxyMEb87CW0ktVxjkdsf"),
    Ozzy("K6s28$vhCAqw4hkjuU$Qxx"),
    Pearl("vhCvfr55Aqw4xynnMEb8o157CW"),
    Audio("cxvWwyoooSkcnzuXgI7R41");

    String value;
    Cryptzz(String value) {
        this.value = value;
    }

    String getMyCrypt() {
        return value;
    }
}



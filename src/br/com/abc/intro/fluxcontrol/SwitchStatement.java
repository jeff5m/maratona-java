package br.com.abc.intro.fluxcontrol;

public class SwitchStatement {
    public static void main(String[] args) {
        byte day = 1;

//        inside a switch, types allowed ar char, int, byte, short, enum and String and 'case' must have the same data type
        switch (day) {
            case 1:
            case 7:    // way of use range of values
                System.out.println("weekends");
                break;

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("weekday");
            default:
                System.out.println("dia invalido");
                break;
        }
    }
}

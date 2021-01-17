package br.com.abc.javacore.Zcollections.classes;

public class Smartphone {
    private String name;
    private String IMEI;

    public Smartphone(String name, String IMEI) {
        this.name = name;
        this.IMEI = IMEI;
    }

    /*
         equals method must be:
          * Reflexive: for any non-null reference values, x.equals(x) must be true.
          * Symmetric: for any non-null reference values, x and y != null, if x.equals(y) == true, then y.equals(x) must
             be true too.
          * Transitivity: for any non-null reference values x, y, z, if x.equals(y) == true and y.equal(z) == true, then
             x.equals(z) must be true too.
          * Consistent: for any non-null reference values, if x.equals(y) == true, doesn't matter how many times that
             invocation has been made.
          * for any non-null reference value x, x.equals(null) == false.
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)  // if this object and the object passed as arg ref to the same memory address
            return true;
        if (this.getClass() != obj.getClass())
            return false;
        Smartphone otherSmartphone = (Smartphone) obj;
        return IMEI != null && IMEI.equals(otherSmartphone.getIMEI());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}

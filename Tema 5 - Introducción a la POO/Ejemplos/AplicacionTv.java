public class AplicacionTv {

    public static void main(String[] args) {

        Televisor tv1 = new Televisor();
        Televisor tv2 = new Televisor();

        tv1.subirVolumen();
        tv1.bajarCanal();
        tv2.bajarVolumen();
        tv2.subirCanal();

    }

}

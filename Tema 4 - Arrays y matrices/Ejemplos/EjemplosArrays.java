public class EjemplosArrays {

    public static void main(String[] args) {

        int[] array = new int[5];

        array[3] = 7;
        array[4] = array[3]*2;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}

public class TorresDeHanoi {

    public static void resolverHanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }
        resolverHanoi(n - 1, origen, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
        resolverHanoi(n - 1, auxiliar, destino, origen);
    }

    public static void main(String[] args) {
        int n = 5   ; // Número de discos
        System.out.println("Resolviendo Torres de Hanoi para " + n + " discos:");
        resolverHanoi(n, 'A', 'C', 'B');
    }
}

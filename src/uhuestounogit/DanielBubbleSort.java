package uhuestounogit;

public class DanielBubbleSort {

    public static void main(String[] args) {
        int vetor[] = { 5, 4, 3, 2, 1 };
        
        for( int i = 1; i < 5; i++ ) {
            for( int j = 0; j < i; j++ ) {
                if( vetor[i] < vetor[j] ) {
                    int temp = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = temp;
                }
            }
        }
        
        for( int i = 0; i < 5; i++ ) {
            System.out.println( vetor[ i ] );
        }
    }
}

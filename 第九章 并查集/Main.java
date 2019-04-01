import java.util.Random;

public class Main {

    private static  double testUF(UF uf,int m){
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static  void main(String [] args){
        int size = 100000;
        int m = 1000000;

        Unionfind1 uf1 = new Unionfind1(size);
        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");


//        Unionfind2 uf2 = new Unionfind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");


        Unionfind3 uf3 = new Unionfind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        Unionfind4 uf4 = new Unionfind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        Unionfind5 uf5 = new Unionfind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");

        Unionfind6 uf6 = new Unionfind6(size);
        System.out.println("UnionFind6 : " + testUF(uf6, m) + " s");


        // o(log*n) < o(lgn)

    }
}

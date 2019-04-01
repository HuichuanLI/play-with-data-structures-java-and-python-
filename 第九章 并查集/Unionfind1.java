public class Unionfind1  implements  UF{

    private int [] id;
    public  Unionfind1(int size){
        id = new int[size];

        for(int i =0;i<id.length;i++){
            id[i] = i;
        }
    }
    @Override
    public  int getSize(){
        return id.length;
    }

    private  int find(int p){
        if(p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return  id[p];
    }

    //quick find
    @Override
    public  boolean isConnected(int p, int q){
        return  find(p) == find(q);
    }
    //o(n)
    // slow connect
    @Override
    public void unionElement(int p,int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return;
        }
        else {
            for(int i=0;i<id.length;i++){
                if(id[i] == pID)
                    id[i] = qID;
            }
        }
    }

}

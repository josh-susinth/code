// "static void main" must be defined in a public class.
class Pair{
        int len;
        int col;
        public Pair(int x,int y){
            this.len=x;
            this.col=y;
        }
    }
public class Main {
    
    public static void main(String[] args) {
        int[][] mat={{9,7,16,5},{1,-6,-7,3},{1,8,7,9},{7,-2,0,10}};
        int n=mat.length;
        int m=mat[0].length;
        
        int startRow=0;
        int startCol=0;
        int endRow=0;
        int endCol=0;
        int maxLen=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            int[] arr=new int[m];
            for(int row=i;row<n;row++){
                for(int col=0;col<m;col++){
                    arr[col]+=mat[row][col];
                }
                Pair val=maxAr(arr);
                
                if(maxLen<val.len){
                    maxLen=val.len;
                    startRow=i;
                    endRow=row;
                    startCol=val.col-val.len+1;
                    endCol=val.col;
                }
            }
        }
        // System.out.println("startRow:"+startRow);
        // System.out.println("endRow:"+endRow);
        // System.out.println("startCol:"+startCol);
        // System.out.println("endCol:"+endCol);
        
        for(int i=startRow;i<=endRow;i++){
            for(int j=startCol;j<=endCol;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static Pair maxAr(int[] arr){
        
        int len=0;
        int index=0;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(arr[i]==0){
                 len=Math.max(len,1);
            }
            if(sum==0){
                len=Math.max(len,i+1);
                index=i;
            }
            if(map.containsKey(sum)){
                int l=map.get(sum);
                if(len<i-l){
                    len=i-l;
                    index=i;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        // System.out.println(len);
        // System.out.println(index);
        return new Pair(len,index);
    }
}

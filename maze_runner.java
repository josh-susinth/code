import java.util.*;
public class Main {
    public static void main(String[] args) {
        char[][] mat={{'.','.','*'},{'*','.','*'},{'.','.','.'}};
        System.out.println(maze(mat,'*'));
    }
    private static int maze(char[][] mat,char obs){
        int row=mat.length;
        int col=mat[0].length;
        boolean[][] bool=new boolean[row][col];
        Queue<Integer> rowQ=new LinkedList<>();
        Queue<Integer> colQ=new LinkedList<>();
        rowQ.add(0);
        colQ.add(0);
        int count=0;
        bool[0][0]=true;
        int size=rowQ.size();
        while(!rowQ.isEmpty()){
            int r=rowQ.remove();
            int c=colQ.remove();
            size--;
            
            if(r==row-1 && c==col-1){
            
                return count;
            }
                
            int[] rowC={0,1,0,-1};
            int[] colC={1,0,-1,0};
            
            for(int i=0;i<4;i++){
                int newR=r+rowC[i];
                int newC=c+colC[i];
                if(newR<0 || newR>=row || newC<0 || newC>=col)
                    continue;
                if(mat[newR][newC]==obs)
                    continue;
                if(bool[newR][newC]==true)
                    continue;
                rowQ.add(newR);
                colQ.add(newC);
                bool[newR][newC]=true;
            }
            
            
            if(size==0){
                count++;
                size=rowQ.size();
            }
        }
        
        return -1;
    }
}

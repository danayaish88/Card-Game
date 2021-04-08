//11715032 Dana Yaish
import java.util.Scanner;
public class cardGame {
    static int[][] v;
    static int[][] c;//define direction of the child's node. 1 is right 0 is left
    static int cards[];
    static int num;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        num=input.nextInt();
        v=new int[num+1][num+1];
        c=new int[num+1][num+1];
        cards=new int[num+1];
        cards[0]=0;
        for(int i=1;i<num+1;i++)
            cards[i]=input.nextInt();
        System.out.print(max_opp(1,num)+"\n");
        print_path(1,num);
        
    }
    public static int max_opp(int f,int b) {
        int front=0;
        int back=0;
        for(int i=0;i<num+1;i++)
            v[i][i]=cards[i];
        for(int i=1;i<num;i++) {
            int j=i+1;
            if(v[i][i]>v[i+1][i+1]) {
                v[i][i+1]=v[i][i];
                c[i][i+1]=1;
            }
            else {
                v[i][i+1]=v[i+1][i+1];
                c[i][i+1]=0;
            }
        }
        for(int x=num-1;x>1;x--) {
            for(int i=1;i<x;i++) {
                int j=num+1-x+i;
                front= c[i+1][j]==1 ? v[i+2][j]+cards[i]: v[i+1][j-1]+cards[i];
                back= c[i][j-1]==1 ? v[i+1][j-1]+cards[j]: v[i][j-2]+cards[j];
                if(front>back) {
                    c[i][j]=1;
                    v[i][j]=front;
                }
                else {
                    c[i][j]=0;
                    v[i][j]=back;
                }
                    
            }
        }
        return v[1][num];
    }
    
    public static void print_path(int f,int b) {
    	int opp1=1;
    	int j=num;
    	int i=1;
    	//System.out.print(i);
    	for(int x=num;x>1;x--) {
    		if(c[i][j]==1) {
    			i++;
    			if(opp1==1) {
    				System.out.print('F');
    				opp1=0;
    			}
    			else {
    				System.out.print('f');
    				opp1=1;
    			}
    		}
    		else {
    			j--;
    			if(opp1==1) {
    				System.out.print('B');
    				opp1=0;
    			}
    			else {
    				System.out.print('b');
    				opp1=1;
    			}
    		}
    	}
    	System.out.print('b');
    }

}

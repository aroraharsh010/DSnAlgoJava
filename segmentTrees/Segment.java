import java.util.*;
public class Main {
    public static void main(String args[]) {
        int[] arr = {1,3,2,4};
        int n = arr.length;
        int[] sarr = new int[2*n+1];
        buildTree(1,0,n-1,arr,sarr);
        System.out.println(Arrays.toString(sarr));
        update(0,6,1,0,n-1,sarr);
        System.out.println(Arrays.toString(sarr));
    }
    static void buildTree(int idx,int si,int ei,int[] arr,int[] sarr){
        if(si>ei)
            return;
        if(si == ei){
            sarr[idx] = arr[si];
            return;
        }
        int mid = si + (ei-si)/2;
        buildTree(2*idx,si,mid,arr,sarr); 
        buildTree(2*idx+1,mid+1,ei,arr,sarr);
        sarr[idx] = Math.min(sarr[2*idx],sarr[2*idx+1]);
    }
    static void update(int index,int val,int idx,int si,int ei,int[] sarr){
        if(si>ei)
            return;
        if(si>index||ei<index)
            return;
        if(si == ei){
            sarr[idx] = val;
            return;
        }
        int mid = si + (ei-si)/2;
        update(index,val,idx*2,si,mid,sarr);
        update(index,val,idx*2+1,mid+1,ei,sarr);
        sarr[idx] = Math.min(sarr[2*idx],sarr[2*idx+1]);
    }
    static int query(int idx,int ql,int qr,int si,int ei,int[] sarr){
        if(ei<ql || si>qr)
            return Integer.MAX_VALUE;
        if(si>=ql && ei<=qr){
            return sarr[idx];
        }
        int mid = si + (ei - si)/2;
        int left = query(idx*2,ql,qr,si,mid,sarr);
        int right = query(idx*2+1,ql,qr,mid+1,ei,sarr);
        return Math.min(left,right);
    }
}
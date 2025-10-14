import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
     class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++)
       {rank.add(0);
        parent.add(i);
        size.add(1);}
    }

    public int findUlp(int node)
    {
        if(node==parent.get(node))
        return node;
        int ulp=findUlp(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void UnionByRank(int u,int v)
    {
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v))
        parent.set(ulp_u,ulp_v);
        else if(rank.get(ulp_v)<rank.get(ulp_u))
        parent.set(ulp_v,ulp_u);
        else{
            parent.set(ulp_v,ulp_u);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
    public void UnionBySize(int u,int v)
    {
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);
        if(ulp_u==ulp_v) return ;
        if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }

    }
}
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(map.containsKey(mail)==false)
                {
                    map.put(mail,i);
                }
                else
                {
                    ds.UnionBySize(i,map.get(mail));
                }
            }
        }
        List<List<String>> ans=new ArrayList<>();
        ArrayList<String> m[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        m[i]=new ArrayList<>();
        for(Map.Entry<String,Integer> element : map.entrySet())
        {
            String mail=element.getKey();
            int node=ds.findUlp(element.getValue());
            m[node].add(mail);
        }
        for(int i=0;i<n;i++)
        {
            if(m[i].size()==0) continue;
            Collections.sort(m[i]);
            ArrayList<String>temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String element: m[i])
            temp.add(element);
            ans.add(temp);
        }
    
        return ans;
    }
}

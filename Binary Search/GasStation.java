import java.util.PriorityQueue;

public class GasStation {
    public class Pair{
        double diff;
        int index;
        Pair(double diff,int index)
        {
            this.diff=diff;
            this.index=index;
        }
    }
    
    //O(n^2) solution (TLE)
    public double Solution1(int arr[],int k) 
    {
        int n=arr.length;
        int howMany[]=new int[n-1];
        
        for(int gas=0;gas<k;gas++)
        {
            int maxInd=-1;
            double maxSection=-1;
            for(int i=0;i<arr.length-1;i++)
            {
                double diff=arr[i+1]-arr[i];
                double section=diff / (double)(howMany[i]+1);
                if(section>maxSection)
                {
                    maxInd=i;
                    maxSection=section;
                }

            }
            howMany[maxInd]++;
        }
        double maxAns=-1;
        for(int i=0;i<n;i++)
        {
            double diff=arr[i+1]-arr[i];
            double section=diff/(double)(howMany[i]+1);
            maxAns=(maxAns>section)?maxAns:section;
        }
        return maxAns;


    }
    //Priority Queue Approach O(nLogn) +O(Klogn)

    public double Solution2(int arr[],int k)
    {
        int n=arr.length;
        int howMany[]=new int[n-1];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length-1;i++)
        {
            pq.add(new Pair((arr[i+1]-arr[i]),i));
        }
            for(int gas=0;gas<k;gas++)
            {
                Pair ob=pq.peek();
                pq.poll();
                int ind=ob.index;
                howMany[ind]++;
                double iniDiff = arr[ind+1]-arr[ind];
                double sectionLength=iniDiff/(double)(howMany[ind]+1);
                pq.add(new Pair(sectionLength,ind));

            }
             return pq.poll().diff;
           

        }
        //Binary Search Approach
        public double Solution3(int arr[],int k)
        {
            int n=arr.length;
            double low=0;
            double high=0;
            for(int i=0;i<n-1;i++)
            {
                high=Math.max(high,(double)(arr[i+1]-arr[i]));
            }
            while(high-low> 1e-6)
            {
                double mid=low+(high-low)/2.0;
                if(count(mid,arr)>k)
                {
                    low=mid;
                }
                else
                high=mid;
            }
            return high;

        }
        public int count(double mid,int arr[])
        {
            int c=0;
            for(int i=0;i<arr.length-1;i++)
            {
                double numberInBetween=(arr[i+1]-arr[i])/mid;
                if((arr[i+1]-arr[i]/mid)==numberInBetween*mid)
                numberInBetween--;
                c+=(int)numberInBetween;
            }
            return c;
        }

    }
 
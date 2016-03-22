package newsyy;

public class havier {
	static int num;
	static int max;
	static int total;
	public static void main(String[] Args )
	{
		total = 0;
	    Comparable[] a = new Comparable[100];
		for (int i = 1; i < 101; i++)
		{
		 a[i-1] = i;
		}
		
		for(int i = 0; i < 10000; i++)
		{
		shuffle(a);
		show(a);
		sort(a);
		show(a);
		total+=num;
		}
		System.out.println(max + " ");
		System.out.println(total/10000);
	}
	
	public static void shuffle(Object[] a) {
		num = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // choose index uniformly in [i, N-1]
            int r = i + (int) (Math.random() * (N - i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }


	
	
	private static boolean less(Comparable v, Comparable w)
	{   num++;
		return v.compareTo(w) < 0;}
	
	private static void exch(Comparable [] a, int i, int j)
	{Comparable t = a[i]; a[i] = a[j]; a[j] = t;}
	
	private static void show(Comparable [] a)
	{
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println(num);
	}
	
	public static void sort(Comparable[] a)
	{
		num = 0;
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3*h+1;
		while(h >=1)
		{
			for(int i = h; i < N; i++)
			{
				for(int j = i; j >=h && less(a[j], a[j-h]); j -=h)
					exch(a,j,j-h);
			}
			h = h/3;
		}
		if(num > max)
	max = num;
		
	}	
}

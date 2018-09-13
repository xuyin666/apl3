public class sommePremiersCarres
{
    public int sommePremiersCarres(int n) throws IllegalArgumentException
    {
        if(n<=0) throw new IllegalArgumentException();
        if(n==1) return 1;
        return n*n+sommePremiersCarres(n-1);
    }
}

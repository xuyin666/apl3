public class sommePositif{
    public int sommePositif(int[] tab, int indice) throws IllegalArgumentException
    {
        int res=-1;
        if(indice<0) throw new IllegalArgumentException();
        if(indice==tab.length)
            res=0;
        else /*indeice>=0 && indice< tab.length*/
        {
            if(tab[indice]>0)
            {
                res=tab[indice]+sommePositif(tab,indice+1);
            }
            else
            {
                res=sommePositif(tab,indice+1);
            }
        }
        return res;
    } 
}

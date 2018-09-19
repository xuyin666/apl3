public class ordreInverse
{
    public void ordreInverse(int[] tab, int index) throws IllegalArgumentException
    {
        int tmp;
        if(index<0 || index>tab.length/2) throw new IllegalArgumentException();
        else if(index<tab.length/2)
        {
            tmp=tab[index];
            tab[index]=tab[tab.length-1-index];
            tab[tab.length-1-index]=tmp;
            ordreInverse(tab,index+1);
        }
    }
}

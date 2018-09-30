package TD1;


public class Test{
    public static void main(String args[])
    {
        sommePositif sp=new sommePositif();
        int[] tab={1,3,-1,7,8,8,7};
        int res=sp.sommePositif(tab,0);

        sommePremiersCarres spc=new sommePremiersCarres();
        int res1=spc.sommePremiersCarres(2);

        Palindrome pal=new Palindrome();
        boolean res2=pal.Palindrome("kyoyooo",0);

        ordreInverse ord=new ordreInverse();
        ord.ordreInverse(tab,0);
        for(int i=0;i<tab.length;i++)
        {
            System.out.println(tab[i]);
        }


    }


}
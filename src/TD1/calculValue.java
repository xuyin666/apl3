package TD1;

public class calculValue{
    public int calculValue(String s,int indice) throws IllegalArgumentException
    {
        int rep=0;
        if(indice<0 || indice>=s.length())
            throw new IllegalArgumentException("Indice a une probleme"+indice);
        else if(indice==0)
        {
            rep=s.charAt(indice)-'0';
        }
        else
        {
            if(s.charAt(indice)>='0'&& s.charAt(indice)<='9')
            {
                rep=s.charAt(indice)-'0';
                rep=calculValue(s,indice-1)*10+rep;
            }
            else
            {
                throw new IllegalArgumentException("le "+indice+"ieme indice a une probleme");
            }
        }
        return rep;
    
    }
   
    public static void main(String[] args)
    {
        String str="1234567";
        calculValue cv=new calculValue();
        int val=cv.calculValue(str,str.length()-1);
        System.out.println(val);
    }
}

package TD1;

public class Palindrome
{
    public boolean Palindrome(String s,int nieme) throws IllegalArgumentException
    {
        boolean rep=false;
        if(nieme<0 || nieme>s.length()/2) throw new IllegalArgumentException("Attention!");
        if(nieme==s.length()/2)
        {
            rep=true;
        }
        else
        {
            if(s.charAt(nieme)==s.charAt(s.length()-1-nieme))
                rep=true && Palindrome(s,nieme+1);
            else
                rep=false;
        }
        return rep;
    }
}
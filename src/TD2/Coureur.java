package TD2;

public class Coureur {

    private String nom;
    private int dossard;
    private Coureur suivant;
    public Coureur(String n, int d, Coureur suiv) {
        this.nom = n;
        this.dossard = d;
        this.suivant = suiv;}

    public String getNom() { return nom; }
    public int getDossard() { return dossard; }
    public Coureur getSuivant() { return suivant; }

    public void afficheClassement(){
        int rang = 1;
        Coureur aux = this;
        while (aux != null){
            System.out.println(rang + ": " + aux.getDossard() + " " + aux.getNom());
            rang++;
            aux = aux.getSuivant();
        }
    }

    public boolean memeClassement(Coureur autre)
    {
        Coureur c1=this;
        Coureur c2=autre;
        boolean different=false;
        while(c1!=null && c2!=null && !different){
            if(c1.getNom().equals(c2.getNom())) {
                c1 = c1.getSuivant();
                c2 = c2.getSuivant();
            }
            else
                different=true;
        }
        if(different)    //coureurs differents a une position
            return false;
        else if(c1!=null)   //plus de coureurs dans this
            return false;
        else if(c2!=null)
            return false;
        else
            return true;

    }

    public boolean memePodium(Coureur autre){
        Coureur c1=this;
        Coureur c2=autre;
        boolean different=false;
        int comp=0;
        while(c1!=null & c2!=null && !different && comp<=2){
            if(c1.getNom().equals(c2.getNom())) {
                c1=c1.getSuivant();
                c2=c2.getSuivant();
                comp=comp+1;
            }
            else{
                different = true;
            }
        }
        if(!different && comp==3)
            return true;
        return false;

    }

    public static void main(String[] args){
        Coureur c1=new Coureur("donald",125,null);
        c1=new Coureur("picsou",103,c1);
        c1=new Coureur("fifi",129,c1);
        c1=new Coureur("loulou",55,c1);
        c1=new Coureur("riri",157,c1);
        c1=new Coureur("dodo",123,c1);

        Coureur c2=new Coureur("fifi",125,null);
        c2=new Coureur("loulou",103,c2);
        c2=new Coureur("riri",129,c2);
        c2=new Coureur("dodo",123,c2);

        Coureur c3=new Coureur("donald",125,null);
        c3=new Coureur("picsou",103,c3);
        c3=new Coureur("fifi",129,c3);
        c3=new Coureur("loulou",55,c3);
        c3=new Coureur("riri",157,c3);

        c3.afficheClassement();



        boolean b2=c1.memePodium(c3);
        System.out.println("b2:"+b2);

    }
}

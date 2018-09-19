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
            if(c1.getNom().equals(c2.getNom()))
                different=true;
            else{
                c1=c1.getSuivant();
                c2=c2.getSuivant();
            }
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
}



    /*public static void main(String[] args){
        Coureur c1=new Coureur("donald",125,null);
        c1=new Coureur("picsou",103,c1);
        c1=new Coureur("fifi",129,c1);
        c1=new Coureur("loulou",55,c1);
        c1=new Coureur("fifi",157,c1);
        Coureur c2=new Coureur("donald",125,null);
        c2=new Coureur("picsou",103,c2);
        c2=new Coureur("fifi",129,c2);
        c1.afficheClassement();

    }*/

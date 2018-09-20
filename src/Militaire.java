public class Militaire {
    String nom;
    String grade;
    Militaire superieur;

    Militaire(String n, Militaire s){
        nom=n;
        superieur=s;
    }
    public Militaire(String n){
        nom=n;
        superieur=null;
    }
    public String getNom(){
        return nom;}
    public Militaire getSuperieur(){
        return superieur;}

    public void affiche1(){
        Militaire tmp=this;
        while(tmp!=null){
            System.out.println("----------"+tmp.getNom());
            tmp=tmp.getSuperieur();
        }
        System.out.println();
    }

    public static void affiche2(Militaire m){
        if(m.getSuperieur()==null){
            System.out.println(m.getNom());
        }
        else{
            System.out.println(m.getNom()+",");
            affiche2(m.getSuperieur());
        }
    }

    public void affiche3(){
        Militaire tmp=this;
        while(tmp!=null){
            if(tmp.getSuperieur()!=null)
                System.out.println(tmp.getNom()+",");
            else
                System.out.println(tmp.getNom());
            tmp=tmp.getSuperieur();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Militaire mil=new Militaire("Foch");
        mil = new Militaire("Fayolle",mil);
        mil = new Militaire("Durand",mil);
        new Militaire("Dubois",mil);

        mil.affiche1();
        affiche2(mil);
        mil.affiche3();
    }
}

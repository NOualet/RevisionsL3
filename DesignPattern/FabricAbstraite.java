//Classe représentant un soldat extraterrestre.
public class SoldatExtraterrestre extends Unite 
{
    // Constructeur pour un soldat extraterrestre.
    public SoldatExtraterrestre()
    {
        this.nom = "Alien";
        this.coutConstruction = 6;
        this.precisionAttaque = 2;
        this.esquiveDefense = 1;
        this.equipements = new ArrayList();
    }
     
    // Equiper un soldat extraterrestre.
    public void equiper()
    {
        this.equipements.add("Acide");
        this.equipements.add("Peau");
        System.out.println("Equipement d'un soldat extraterrestre (Acide, Peau).");
    }
}
 
//Classe représentant un commandant extraterrestre.
public class CommandantExtraterrestre extends Unite 
{
    // Constructeur pour un commandant extraterrestre.
    public CommandantExtraterrestre()
    {
        this.nom = "Prédateur";
        this.coutConstruction = 10;
        this.precisionAttaque = 3;
        this.esquiveDefense = 3;
        this.equipements = new ArrayList();
    }
     
    // Equiper un commandant extraterrestre.
    public void equiper()
    {
        this.equipements.add("Mitraillette à plasma");
        this.equipements.add("Peau");
        System.out.println("Equipement d'un commandant extraterrestre (Mitraillette à plasma, Peau).");
    }
}

// Usine abstraite qui sert de base aux usines concrètes.
public abstract class Usine 
{
    // Méthode qui permet de former les unités.
    public Unite formerUnite(TypeUnite type)
    {
        Unite unite = this.creerUnite(type);
        unite.consommerRessource();
        unite.equiper();
        return unite;
    }
     
    // La création d'une unité est déléguée aux sous classes.
    public abstract Unite creerUnite(TypeUnite type);
}

// Usine humaine.
public class UsineHumain extends Usine
{
    // Méthode qui permet de créer des unités humaines.
    public Unite creerUnite(TypeUnite type)
    {
        Unite unite = null;;
        switch(type)
        {
            case SOLDAT:unite = new SoldatHumain();break;
            case COMMANDANT:unite = new CommandantHumain();break;
        }
        return unite;
    }
}
 
// Usine extraterrestre.
public class UsineExtraterrestre extends Usine
{
    // Méthode qui permet de créer des unités extraterrestres.
    public Unite creerUnite(TypeUnite type)
    {
        Unite unite = null;;
        switch(type)
        {
            case SOLDAT:unite = new SoldatExtraterrestre();break;
            case COMMANDANT:unite = new CommandantExtraterrestre();break;
        }
        return unite;
    }
}

// Classe principale du projet.
public class Main 
{
    // Méthode principale.
    public static void main(String[] args) 
    {
        Usine usineExtraterrestre = new UsineExtraterrestre();
        Unite unite = usineExtraterrestre.formerUnite(TypeUnite.SOLDAT);
        System.out.println(unite);
    }
 
}


package classe;
public class Personne{
    public String login;
    public String mdp;
    public String nom;
    public String prenom;
    public String role;

    public Personne(String login, String mdp,String nom, String prenom, String role){
        maj(login,mdp,nom,prenom,role);
    }

    public void maj(String login, String mdp,String nom, String prenom, String role){
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public void maj(String login, String mdp,String nom, String prenom){
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        // On n'autorise pas a changer le role
    }


}

package classe;

public class DS{

    private String driver = "org.postgresql.Driver";
    private String url= "jdbc:postgresql://localhost/postgres?allowMultiQueries=true";
    private String name = "postgres";
    private String mdp = "moi";

    public DS() {

    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getMdp() {
        return mdp;
    }

}
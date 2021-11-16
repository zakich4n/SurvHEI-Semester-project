package controller.webservices;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class MotDePasseUtils {
  private static final int LONGUEUR_SEL = 128;
  private static final int LONGUEUR_HASH = 128;

  private static final int NOMBRE_ITERATIONS = 5;
  private static final int MEMOIRE = 65536;
  private static final int PARALLELISME = 1;

  private static Argon2 instancierArgon2() {
    return Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i, LONGUEUR_SEL, LONGUEUR_HASH);
  }

  public static String genererMotDePasse(String motDePasse) {
    return instancierArgon2().hash(NOMBRE_ITERATIONS, MEMOIRE, PARALLELISME, motDePasse);
  }

  public static boolean validerMotDePasse(String motDePasse, String hashCorrect) {
    return instancierArgon2().verify(hashCorrect, motDePasse);
  }

  public static void main(String[] args) {
    System.out.println("Le nouveau mdp est "+genererMotDePasse("Gouizi"));
    System.out.println(validerMotDePasse("pas", "$argon2i$v=19$m=65536,t=5,p=1$tpE3Uf8LaIT/qKWTFa/sDhqmCBIf1DvSoeG/sX9kAOR1ku9Btz1sTnUafQ84jPqAMvgNh4g0iv4FOfAmjvDTfs0CkjInCRdVVA49ehVFETpegwf4fHIagKLsoUMAHQzGw7fFKFVDinTumrl3/fgvaoQAtlTbil9+8JIjN6U/VXE$qLuHVatFPVbKtpHhsU3jP53u9SWKabigXTX+24OVyK112r3vYK0T5zCz3ZLP+0dcM1uvk9/laM6N6tnp03k5aloqARpfB8MNSz38EKCeQUZGvk1t9nDF/QkcgOE1chpvQCHt0Sjx9k/kkSiWWMNBJFbgRbdKkxBWuMlgTz0iF5M"));


  }

}
/***********************************************************************
 * Module:  SpoljniKorisnik.java
 * Author:  evaje
 * Purpose: Defines the Class SpoljniKorisnik
 ***********************************************************************/

import java.util.*;

/** @pdOid 4e2852fc-b95c-45bf-9339-19c135ed70e6 */
public class SpoljniKorisnik {
   /** @pdOid 13b34e10-4667-461c-8225-ba0c368405bd */
   private int idKompanije;
   /** @pdOid 7f33b47e-b940-4783-ac3d-49c99683d101 */
   private String imeKompanije;
   
   /** @pdRoleInfo migr=no name=Adresa assc=spoljniKorisnikAdresa mult=1..1 */
   public Adresa adresa;

}
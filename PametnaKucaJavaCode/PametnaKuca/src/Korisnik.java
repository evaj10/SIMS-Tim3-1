/***********************************************************************
 * Module:  Korisnik.java
 * Author:  evaje
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.util.*;

/** @pdOid 62406f84-3d05-43d8-8467-6b659940b643 */
public class Korisnik {
   /** @pdOid e7905b52-3414-49ef-83a9-aa52d4bf99c3 */
   private int id;
   /** @pdOid d9c69924-6481-45dc-895d-99f162203f66 */
   private String ime;
   /** @pdOid 7b091bf1-f8a3-4014-9c18-36d7e9f12bab */
   private String prezime;
   /** @pdOid 643b8fb7-14f8-4a58-b809-b3dc239da170 */
   private Date datumRodjenja;
   /** @pdOid a84eb861-4ae2-45c6-a8bb-ccc978cf99fd */
   private Pol pol;
   /** @pdOid 311e6143-42c4-42fe-8fd1-580f7ed9b69a */
   private TipKorisnika tipKorisnika;
   
   /** @pdRoleInfo migr=no name=Adresa assc=association1 mult=1..1 */
   public Adresa adresa;
   /** @pdRoleInfo migr=no name=Nalog assc=korisnikNalog mult=1..1 */
   public Nalog nalog;

}
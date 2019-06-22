/***********************************************************************
 * Module:  Nalog.java
 * Author:  evaje
 * Purpose: Defines the Class Nalog
 ***********************************************************************/

import java.util.*;

/** @pdOid 79de8376-2074-4fcf-8d60-0d37659da740 */
public class Nalog {
   /** @pdOid adb2899f-ac1f-4ec0-8e23-9640e2b9ac55 */
   private String korisnickoIme;
   /** @pdOid 2741ec19-a000-455e-b915-d97e36a07d3d */
   private String sifra;
   /** @pdOid e26a3147-b4a7-4008-a328-1ba6a728f027 */
   private String fileTlocrt;
   
   /** @pdRoleInfo migr=no name=Korisnik assc=korisnikNalog mult=1..1 side=A */
   public Korisnik korisnik;

}
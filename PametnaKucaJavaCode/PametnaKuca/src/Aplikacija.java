/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  evaje
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/

import java.util.*;

/** @pdOid c0bc6f72-72e7-4b53-95bc-662d961885f3 */
public class Aplikacija {
   /** @pdRoleInfo migr=no name=Tlocrt assc=aplikacijaTlocrt mult=0..1 */
   public Tlocrt tlocrt;
   /** @pdRoleInfo migr=no name=Nalog assc=nalogAplikacija coll=java.util.List impl=java.util.ArrayList mult=0..* side=A */
   public java.util.List<Nalog> nalozi;
   /** @pdRoleInfo migr=no name=Stanje assc=aktivnoStanje mult=1..1 side=A */
   public Stanje stanje;
   
   /** @param tipIzvestaja
    * @pdOid fb679610-b46e-439e-9e24-a6698e07b968 */
   public void kreirajIzvestaj(TipIzvestaja tipIzvestaja) {
      // TODO: implement
   }
   
   /** @pdOid ef0b39a7-799a-41a3-8ddd-9ed47821906f */
   public boolean logIn() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid d40db490-c682-42a5-b634-80c68147d5f0 */
   public void logOut() {
      // TODO: implement
   }
   
   /** @param r
    * @pdOid 9408acab-c258-43eb-bedb-1e72ae7bf29a */
   public void upgradeKorisnik(TipKorisnika r) {
      // TODO: implement
   }
   
   /** @param k 
    * @param novaVrednost
    * @pdOid e5e271f8-bc97-492d-9aab-12ec93a25eeb */
   public void ukljuciIskljuci(Komponenta k, int novaVrednost) {
      // TODO: implement
   }
   
   /** @param k 
    * @param novaVrednost
    * @pdOid ea02bf10-7e6a-49a7-8cf2-b4737abf5b33 */
   public void promeniVrijednost(Komponenta k, int novaVrednost) {
      // TODO: implement
   }
   
   /** @pdOid ede38a0d-f82f-450e-820c-da0fb50bcef0 */
   public void izmenaSopstvenihPodataka() {
      // TODO: implement
   }
   
   /** @param r
    * @pdOid f694a136-9de3-4960-8d0b-019ed57df3aa */
   public void izmenaPodataka(TipKorisnika r) {
      // TODO: implement
   }
   
   /** @pdOid ada5aef1-0df7-4da1-915f-78b0578957f0 */
   public void ucitavanjeTlocrta() {
      // TODO: implement
   }
   
   /** @param lozinka
    * @pdOid cb822dbd-00c8-452d-88f3-b44ee9d68009 */
   public boolean validnostLozinke(String lozinka) {
      // TODO: implement
      return false;
   }
   
   /** @param k
    * @pdOid a8c41e93-a24e-48f7-9f13-c86afb224219 */
   public void osveziPrikaz(Komponenta k) {
      // TODO: implement
   }
   
   /** @param s
    * @pdOid 14309e92-8637-49a5-aa4a-aa5e0c5234e1 */
   public void promeniStanje(Stanje s) {
      // TODO: implement
   }
   
   /** @pdOid d65cc1df-c0b9-4f2b-b99e-58177b1f4e3b */
   public boolean logovanjeSpoljnig() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 1092b97d-ea6e-4209-b298-1638951baaa9 */
   public void odabirIzvjestaja() {
      // TODO: implement
   }
   
   /** @pdOid 16757b33-5db3-446d-9f5c-9009e6ee717d */
   public void pritisnutoDugmeIzvjestaji() {
      // TODO: implement
   }
   
   /** @pdOid 49d9e481-53d5-4524-b6e2-9ba29e021718 */
   public void pritisnutoDugmePovratak() {
      // TODO: implement
   }
   
   /** @pdOid 75020a2e-64fc-48d2-af97-cb6c10a35091 */
   public void prikaziFormuZaLogovanje() {
      // TODO: implement
   }
   
   /** @pdOid 6bf0a642-21bc-4696-86a4-2f5ade0047be */
   public void prikaziPorukuGreske() {
      // TODO: implement
   }
   
   /** @pdOid 9019a172-1590-456f-a709-5856cae80795 */
   public void prikaziTlocrt() {
      // TODO: implement
   }
   
   /** @pdOid 8b9ca7f8-eb2f-4f24-87be-46ac874500f3 */
   public void prikaziFormuZaLogovanjeSpoljnog() {
      // TODO: implement
   }
   
   /** @pdOid 64e435c8-a5fb-429a-abae-0240b75e42ce */
   public void prikaziFormuZaIzborIzvjestaja() {
      // TODO: implement
   }
   
   /** @pdOid 82f9b39c-0436-411f-b644-34cde96d72e8 */
   public void posaljiIzvjestaj() {
      // TODO: implement
   }
   
   /** @pdOid 194b5d0a-2b48-4a6c-b0c6-1f065f9124bb */
   public void pritisnutoDugmeZaOdustajanje() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Nalog> getNalozi() {
      if (nalozi == null)
         nalozi = new java.util.ArrayList<Nalog>();
      return nalozi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNalozi() {
      if (nalozi == null)
         nalozi = new java.util.ArrayList<Nalog>();
      return nalozi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNalozi */
   public void setNalozi(java.util.List<Nalog> newNalozi) {
      removeAllNalozi();
      for (java.util.Iterator iter = newNalozi.iterator(); iter.hasNext();)
         addNalozi((Nalog)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNalog */
   public void addNalozi(Nalog newNalog) {
      if (newNalog == null)
         return;
      if (this.nalozi == null)
         this.nalozi = new java.util.ArrayList<Nalog>();
      if (!this.nalozi.contains(newNalog))
         this.nalozi.add(newNalog);
   }
   
   /** @pdGenerated default remove
     * @param oldNalog */
   public void removeNalozi(Nalog oldNalog) {
      if (oldNalog == null)
         return;
      if (this.nalozi != null)
         if (this.nalozi.contains(oldNalog))
            this.nalozi.remove(oldNalog);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNalozi() {
      if (nalozi != null)
         nalozi.clear();
   }

}
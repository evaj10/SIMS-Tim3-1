/***********************************************************************
 * Module:  Tlocrt.java
 * Author:  evaje
 * Purpose: Defines the Class Tlocrt
 ***********************************************************************/

import java.util.*;

/** @pdOid bf4baa47-bcca-47c6-89fe-717e3aa81bfe */
public class Tlocrt {
   /** @pdOid cd35bb06-4bbe-4c22-b4c1-2a23f1144b73 */
   private int id;
   /** @pdOid 98fe33a6-57f6-45be-885c-e80674d5dcd4 */
   private String slika;
   /** @pdOid d62ca54f-1e85-4e1d-b584-e8fd80f8e79c */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=Soba assc=tlocrtSoba coll=java.util.List impl=java.util.ArrayList mult=1..* */
   public java.util.List<Soba> sobe;
   /** @pdRoleInfo migr=no name=Komponenta assc=tlocrtKomponenta coll=java.util.Collection impl=java.util.ArrayList mult=0..* */
   public java.util.Collection<Komponenta> komponente;
   /** @pdRoleInfo migr=no name=Nalog assc=nalogTlocrt coll=java.util.List impl=java.util.ArrayList mult=0..* side=A */
   public java.util.List<Nalog> nalozi;
   
   /** @pdOid ceb514b2-0101-4b47-8d2e-22f39b6497de */
   public void iscrtajTlocrt() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Soba> getSobe() {
      if (sobe == null)
         sobe = new java.util.ArrayList<Soba>();
      return sobe;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSobe() {
      if (sobe == null)
         sobe = new java.util.ArrayList<Soba>();
      return sobe.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSobe */
   public void setSobe(java.util.List<Soba> newSobe) {
      removeAllSobe();
      for (java.util.Iterator iter = newSobe.iterator(); iter.hasNext();)
         addSobe((Soba)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSoba */
   public void addSobe(Soba newSoba) {
      if (newSoba == null)
         return;
      if (this.sobe == null)
         this.sobe = new java.util.ArrayList<Soba>();
      if (!this.sobe.contains(newSoba))
         this.sobe.add(newSoba);
   }
   
   /** @pdGenerated default remove
     * @param oldSoba */
   public void removeSobe(Soba oldSoba) {
      if (oldSoba == null)
         return;
      if (this.sobe != null)
         if (this.sobe.contains(oldSoba))
            this.sobe.remove(oldSoba);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSobe() {
      if (sobe != null)
         sobe.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Komponenta> getKomponente() {
      if (komponente == null)
         komponente = new java.util.ArrayList<Komponenta>();
      return komponente;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKomponente() {
      if (komponente == null)
         komponente = new java.util.ArrayList<Komponenta>();
      return komponente.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKomponente */
   public void setKomponente(java.util.Collection<Komponenta> newKomponente) {
      removeAllKomponente();
      for (java.util.Iterator iter = newKomponente.iterator(); iter.hasNext();)
         addKomponente((Komponenta)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKomponenta */
   public void addKomponente(Komponenta newKomponenta) {
      if (newKomponenta == null)
         return;
      if (this.komponente == null)
         this.komponente = new java.util.ArrayList<Komponenta>();
      if (!this.komponente.contains(newKomponenta))
         this.komponente.add(newKomponenta);
   }
   
   /** @pdGenerated default remove
     * @param oldKomponenta */
   public void removeKomponente(Komponenta oldKomponenta) {
      if (oldKomponenta == null)
         return;
      if (this.komponente != null)
         if (this.komponente.contains(oldKomponenta))
            this.komponente.remove(oldKomponenta);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKomponente() {
      if (komponente != null)
         komponente.clear();
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
/***********************************************************************
 * Module:  TipKomponente.java
 * Author:  evaje
 * Purpose: Defines the Class TipKomponente
 ***********************************************************************/

import java.util.*;

/** @pdOid 19826428-f62c-40f8-8fea-bd44dd12c15f */
public abstract class TipKomponente {
   /** @pdRoleInfo migr=no name=Komponenta assc=tipKomponenteKomponenta coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Komponenta> komponente;
   /** @pdRoleInfo migr=no name=Povecaj assc=tipKomponentePovecaj mult=0..1 */
   public Povecaj povecaj;
   /** @pdRoleInfo migr=no name=Smanji assc=tipKomponenteSmanji mult=0..1 */
   public Smanji smanji;
   /** @pdRoleInfo migr=no name=Ukljuci_Iskljuci assc=ukljuciIskljuciTipKomponente mult=0..1 side=A */
   public Ukljuci_Iskljuci ukljuciIskljuci;
   
   
   /** @pdGenerated default getter */
   public java.util.List<Komponenta> getKomponente() {
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
   public void setKomponente(java.util.List<Komponenta> newKomponente) {
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
      {
         this.komponente.add(newKomponenta);
         newKomponenta.setTipKomponente(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldKomponenta */
   public void removeKomponente(Komponenta oldKomponenta) {
      if (oldKomponenta == null)
         return;
      if (this.komponente != null)
         if (this.komponente.contains(oldKomponenta))
         {
            this.komponente.remove(oldKomponenta);
            oldKomponenta.setTipKomponente((TipKomponente)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKomponente() {
      if (komponente != null)
      {
         Komponenta oldKomponenta;
         for (java.util.Iterator iter = getIteratorKomponente(); iter.hasNext();)
         {
            oldKomponenta = (Komponenta)iter.next();
            iter.remove();
            oldKomponenta.setTipKomponente((TipKomponente)null);
         }
      }
   }

}
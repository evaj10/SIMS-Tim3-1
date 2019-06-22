/***********************************************************************
 * Module:  Soba.java
 * Author:  evaje
 * Purpose: Defines the Class Soba
 ***********************************************************************/

import java.util.*;

/** @pdOid d6afdd43-6d5c-4455-bcb7-cae1955eba97 */
public class Soba {
   /** @pdOid 5ed4d3ce-288c-47cd-bb31-e8b0cce2d4a4 */
   private int id;
   /** @pdOid 81bcc4d2-1864-40ce-b446-5ffa85238302 */
   private double temperatura;
   /** @pdOid 0a09aa8b-e2d0-46c6-a39a-f67c17b85b00 */
   private double vlaznost;
   
   /** @pdRoleInfo migr=no name=Komponenta assc=sobaKomponenta coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Komponenta> komponente;
   
   /** @pdOid 9ac77da6-fe4d-4bbe-b3ec-6a13a5e697a8 */
   public void iscrtajSobu() {
      // TODO: implement
   }
   
   
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
         newKomponenta.setSoba(this);      
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
            oldKomponenta.setSoba((Soba)null);
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
            oldKomponenta.setSoba((Soba)null);
         }
      }
   }

}
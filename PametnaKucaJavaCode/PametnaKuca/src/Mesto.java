/***********************************************************************
 * Module:  Mesto.java
 * Author:  evaje
 * Purpose: Defines the Class Mesto
 ***********************************************************************/

import java.util.*;

/** @pdOid 085f53ee-0fee-4c54-b703-54455fd449d3 */
public class Mesto {
   /** @pdOid 4b612989-1b0c-4587-917b-728c1829b362 */
   private int postanskiBr;
   /** @pdOid 911964db-6595-44a6-8a6e-5ddf0d060e52 */
   private String grad;
   
   /** @pdRoleInfo migr=no name=Adresa assc=association2 coll=java.util.List impl=java.util.ArrayList mult=1..* side=A */
   public java.util.List<Adresa> adrese;
   
   
   /** @pdGenerated default getter */
   public java.util.List<Adresa> getAdrese() {
      if (adrese == null)
         adrese = new java.util.ArrayList<Adresa>();
      return adrese;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdrese() {
      if (adrese == null)
         adrese = new java.util.ArrayList<Adresa>();
      return adrese.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdrese */
   public void setAdrese(java.util.List<Adresa> newAdrese) {
      removeAllAdrese();
      for (java.util.Iterator iter = newAdrese.iterator(); iter.hasNext();)
         addAdrese((Adresa)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdresa */
   public void addAdrese(Adresa newAdresa) {
      if (newAdresa == null)
         return;
      if (this.adrese == null)
         this.adrese = new java.util.ArrayList<Adresa>();
      if (!this.adrese.contains(newAdresa))
      {
         this.adrese.add(newAdresa);
         newAdresa.setMesto(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAdresa */
   public void removeAdrese(Adresa oldAdresa) {
      if (oldAdresa == null)
         return;
      if (this.adrese != null)
         if (this.adrese.contains(oldAdresa))
         {
            this.adrese.remove(oldAdresa);
            oldAdresa.setMesto((Mesto)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdrese() {
      if (adrese != null)
      {
         Adresa oldAdresa;
         for (java.util.Iterator iter = getIteratorAdrese(); iter.hasNext();)
         {
            oldAdresa = (Adresa)iter.next();
            iter.remove();
            oldAdresa.setMesto((Mesto)null);
         }
      }
   }

}
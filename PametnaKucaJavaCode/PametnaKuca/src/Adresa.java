/***********************************************************************
 * Module:  Adresa.java
 * Author:  evaje
 * Purpose: Defines the Class Adresa
 ***********************************************************************/

import java.util.*;

/** @pdOid 078f371d-9677-4d0b-9024-8da4fc8f0ba3 */
public class Adresa {
   /** @pdOid 14dc1724-ae67-450f-9d58-ef52f6954469 */
   private int id;
   /** @pdOid 22ec187d-c6c1-44ab-99df-cbaac103a9b3 */
   private String ulica;
   /** @pdOid d11cee80-cd4a-4db7-9861-5e852d9ab042 */
   private int broj;
   
   /** @pdRoleInfo migr=no name=Mesto assc=association2 mult=1..1 */
   public Mesto mesto;
   
   
   /** @pdGenerated default parent getter */
   public Mesto getMesto() {
      return mesto;
   }
   
   /** @pdGenerated default parent setter
     * @param newMesto */
   public void setMesto(Mesto newMesto) {
      if (this.mesto == null || !this.mesto.equals(newMesto))
      {
         if (this.mesto != null)
         {
            Mesto oldMesto = this.mesto;
            this.mesto = null;
            oldMesto.removeAdrese(this);
         }
         if (newMesto != null)
         {
            this.mesto = newMesto;
            this.mesto.addAdrese(this);
         }
      }
   }

}
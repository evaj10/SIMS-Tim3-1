/***********************************************************************
 * Module:  Komponenta.java
 * Author:  evaje
 * Purpose: Defines the Class Komponenta
 ***********************************************************************/

import java.util.*;

/** @pdOid 9f2eddb7-b4ef-412b-9905-f8eac768d0f2 */
public class Komponenta {
   /** @pdOid be01225f-57bf-460c-a1c6-7302af56ab1a */
   private int id;
   /** @pdOid d3c88b8e-a2b0-4774-9195-77feba9e7254 */
   private String naziv;
   /** @pdOid ae9bdbdb-0c99-46db-822f-870a845d6269 */
   private int vrednost;
   
   /** @pdRoleInfo migr=no name=Soba assc=sobaKomponenta mult=1..1 side=A */
   public Soba soba;
   /** @pdRoleInfo migr=no name=TipKomponente assc=tipKomponenteKomponenta mult=1..1 side=A */
   public TipKomponente tipKomponente;
   
   /** @pdOid 38ebdb2e-e934-4148-bd5b-d80262d4daf3 */
   public void iscrtajKomponentu() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default parent getter */
   public Soba getSoba() {
      return soba;
   }
   
   /** @pdGenerated default parent setter
     * @param newSoba */
   public void setSoba(Soba newSoba) {
      if (this.soba == null || !this.soba.equals(newSoba))
      {
         if (this.soba != null)
         {
            Soba oldSoba = this.soba;
            this.soba = null;
            oldSoba.removeKomponente(this);
         }
         if (newSoba != null)
         {
            this.soba = newSoba;
            this.soba.addKomponente(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TipKomponente getTipKomponente() {
      return tipKomponente;
   }
   
   /** @pdGenerated default parent setter
     * @param newTipKomponente */
   public void setTipKomponente(TipKomponente newTipKomponente) {
      if (this.tipKomponente == null || !this.tipKomponente.equals(newTipKomponente))
      {
         if (this.tipKomponente != null)
         {
            TipKomponente oldTipKomponente = this.tipKomponente;
            this.tipKomponente = null;
            oldTipKomponente.removeKomponente(this);
         }
         if (newTipKomponente != null)
         {
            this.tipKomponente = newTipKomponente;
            this.tipKomponente.addKomponente(this);
         }
      }
   }

}
/***********************************************************************
 * Module:  Stanje.java
 * Author:  evaje
 * Purpose: Defines the Class Stanje
 ***********************************************************************/

import java.util.*;

/** @pdOid c60baf73-39a2-4470-9d30-5c444605a061 */
public abstract class Stanje {
   /** @pdRoleInfo migr=no name=Aplikacija assc=aktivnoStanje mult=0..1 */
   public Aplikacija aplikacija;
   
   /** @pdOid 53238fd4-dd38-4db2-b5c3-7deb4db5a9c5 */
   public boolean logIn() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid f3c5dda4-c227-4af1-80a1-23368bea4788 */
   public void logOut() {
      // TODO: implement
   }
   
   /** @pdOid 1495cf9c-680d-4030-bd86-0ba9aa8fd862 */
   public boolean logovanjeSpoljnog() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 683e5d33-2805-42ce-9d9d-f17fafec04e1 */
   public void odabirIzvjestaja() {
      // TODO: implement
   }
   
   /** @pdOid 5d945c35-9d90-4a25-aa1a-dd78ae00cc4c */
   public void pritisnutoDugmeIzvjestaji() {
      // TODO: implement
   }
   
   /** @pdOid 974fe04d-da19-4d57-a732-b06018f73386 */
   public void pritisnutoDugmePovratak() {
      // TODO: implement
   }
   
   /** @pdOid 2f3cccd5-54f2-4024-8970-117c8b64fcb6 */
   public void entry() {
      // TODO: implement
   }
   
   /** @pdOid 37c0dd8d-84d3-4272-9065-1646ff9da231 */
   public void pritisnutoDugmeZaOdustajanje() {
      // TODO: implement
   }

}
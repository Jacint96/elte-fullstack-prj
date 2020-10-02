# elte-fullstack-prj
Ruházati webáruház

Nem funkcionális követelmények:

Az admin accountok plusz opciókkal rendelkeznek a megjelenő frontend felületen. Így tudják a rendeléseket, illetve raktárkészleteket adminisztrálni.

Használat:

• Az alkalmazás listázza kategóriánként a termékeket (márka, típus, leírás,
nettó/bruttó ár, illetve raktárkészlet), és lehetőség van a raktárkészlet
növelésére a termékeknél.

• Az alkalmazás listázza a rendeléseket (dátum, név, cím, telefonszám, e-mail
cím, termékek listája). Ha egy rendelés teljesített, a rendszer megerősítés után ennek megfelelően módosítja a raktárkészletet.
A rendelések szűrhetőek a rendelő
név(részlet), dátum, valamint teljesítettség állapota szerint.

Elérhetőség: 

Az alkalmazásnak 0-24ben működőképesnek kell lennie, hogy a beérkező rendeléseket fel tudja dolgozni.

Az adatbázis az alábbi adatokat tárolja:
• kategóriák (név);
• termékek (márka, leírás, kategória, nettó ár, raktárkészlet, aktív-e);
• rendelések (név, cím, telefonszám, e-mail cím, termékek listája, teljesítettség).

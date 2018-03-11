# Refactoring - autorendifirma hinnakalkulaator

Ülesandeks on refaktoreerida programmikood selliselt, et see vastaks clean code standarditele, oleks testitud ja väikestes osades.

# Töö käik

Ülesande lahendamiseks toimige järgnevalt:
1. Fork'ige githubis see repositoorium enda kontole
2. kloonige `git clone URL` abil fork'itud repo enda arvutisse
3. Tehke kõik vajalikud muudatused ja commitige
4. Tehke githubis originaalrepo jaoks pull request
5. Hinde (2p) saavad tudengid, kes:  
 -- praktikumis kaasa töötasid  
 -- kelle tiim tegi pull requesti korraliku koodiga

# Analüütiku/projektijuhi roll

Kui tiimis on analüütik, kes ei programmeeri, siis tuleb tal hinde saamiseks koostada testiplaan, kus on kirjeldatud kõik juhtumid, mida tuleb testida. Näiteks:

Ärinõue: autot saab rentida alates 18. eluaastast
Vajalikud testid:
1. 17-aastane ei saa autot rentida  
-- sisendite kombinatsioon: vanus: 17, [...]  
-- oodatav väljund: Exception  
2. 18-aastane saab autot rentida  
-- sisendite kombinatsioon: vanus: 18, [...]  
-- oodatav väljund: hind 18-aastasele XXX EUR  

NB! Oodatavad väljundid sõltuvad ka teie programmi struktuurist. Kui originaalprogramm väljastab Exceptioni lõppkasutajale, siis teie võite vanusekontrolli viia eraldi meetodiks, mis tagastab vaid TRUE/FALSE

Testiplaan tuleb commitida MD (readme) formaadis failina reposse.

# Ärinõuded, millest lähtuda


**Taust**

Rendiautod jagunevad klassidesse 1-5, kus 1 on kõige odavam kategooria ja 5 kõige kallim.

**Ärireeglid autorendi ühe ööpäeva hinna arvutamiseks**

Alla 18 aastane ei saa autot rentida
18-21-aastane saab rentida ainult klassi 1 kuuluvaid autosid

Maksimaalne rendi hind on 1000 eurot päevas.

Minimaalne rendi hind võrdub juhi vanusega.

Klassides 4 ja 5 on hind 50% kallim kui juht on 25-aastane või noorem (välja arvatud madalhooajal).

Rentida ei saa isikud, kellel on juhiluba olnud alla aasta. Kui juhiluba on olnud alla kolme aasta, siis on rendi hind 30% suurem.

Kui isik on põhjustanud viimase aasta jooksul liiklusõnnestusi ja isik on alla 30 aasta vana, siis lisandub rendi ööpäevahinnale 15 eurot.

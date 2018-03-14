Rendiautod jagunevad klassidesse 1-5, kus 1 on kõige odavam kategooria ja 5 kõige kallim.
Ärireeglid autorendi ühe ööpäeva hinna arvutamiseks
Alla 18 aastane ei saa autot rentida 18-21-aastane saab rentida ainult klassi 1 kuuluvaid autosid
Maksimaalne rendi hind on 1000 eurot päevas.
Minimaalne rendi hind võrdub juhi vanusega.
Klassides 4 ja 5 on hind 50% kallim kui juht on 25-aastane või noorem (välja arvatud madalhooajal).
Rentida ei saa isikud, kellel on juhiluba olnud alla aasta. Kui juhiluba on olnud alla kolme aasta, siis on rendi hind 30% suurem.
Kui isik on põhjustanud viimase aasta jooksul liiklusõnnestusi ja isik on alla 30 aasta vana, siis lisandub rendi ööpäevahinnale 15 eurot.

Ärinõue: autot saab rentida alates 18. eluaastast Vajalikud testid:
1. 17-aastane ei saa autot rentida
-- sisendite kombinatsioon: vanus: 17, [...]
-- oodatav väljund: Exception
2. 18-aastane saab autot rentida
-- sisendite kombinatsioon: vanus: 18, [...]
-- oodatav väljund: hind 18-aastasele XXX EUR
Ärinõue: Maksimaalne rendi hind on 1000 eurot päevas. Vajalikud testid:
1.Maksimaalne rendi hind on >1000eurot
-- sisendite kombinatsioon: rendiHind>1000, [...]
-- oodatav väljund: Exception
2.Maksimaalne rendi hind on =<1000eurot
-- sisendite kombinatsioon: rendiHind=<1000, [...]
-- oodatav väljund: hind XXX EUR
Ärinõue: Minimaalne rendi hind võrdub juhi vanusega. Vajalikud testid:
1.Minimaalne rendi ei saa olla väiksem kui juhi vanus
--sisendite kombinatsioon: Hind < Vanus
--oodatav väljund: Exception
2.Kui hind suurem  või sama kui vanus saab
--sisendite kombinatsioon: Hind => Vanus
--oodatav väljund: Hind XXX
Ärinõue: Rentida ei saa isikud, kellel on juhiluba olnud alla aasta. Vajalikud testid:
1. Kui juhiluba olnud alla aasta ei saa autot rentida
--sisendite kombinatsioon: juhilubaAeg <1, […]
--oodatav väljund: Exception
2. Kui juhiluba on olnud kauem kui 1 aasta siis saab autot rentida
– sisendite kombinatsioon: juhilubaAeg =>1, […]
--oodatav väljund: hind XXX EUR
Ärinõue: Kui juhiluba on olnud alla 3 aasta, on rendi hind 30% suurem. Vajalikud testid:
1. Kui juhiluba olnud alla 3 aasta siis on rendi hind 30% suurem
--sisendite kombinatsioon: juhilubaAeg <3, […]
--oodatav väljund: hind 1,3 XXX EUR
2. Kui juhiluba on olnud kauem kui 1 aasta siis saab autot rentida
– sisendite kombinatsioon: juhilubaAeg => 3, […]
--oodatav väljund: hind XXX EUR
Ärinõue: Kui isik on põhjustanud viimase aasta jooksul liiklusõnnestusi ja isik on alla 30 aasta vana, siis lisandub rendi ööpäevahinnale 15 eurot. Vajalikud testid:
1. Kui isik on põhjustanud viimase aasta jooksul liiklusõnnetusi ja on alla 30 aasta vana, siis lisandub rendi ööpäevahinnale 15 eurot.
--sisendite kombinatsioon: vanus <30, liiklusonnetusiPohjustanud=true, […]
--oodatav väljund: hind XXX+15 EUR
2. Kui isik on põhjustanud viimase aasta jooksul liiklusõnnetusi ja on vähemalt 30 aasta vana, siis ei lisandu rendi ööpäevahinnale midagi.
--sisendite kombinatsioon: vanus =<30, liiklusonnetusiPohjustanud=true, […]
--oodatav väljund: hind XXX EUR
3. Kui isik ei ole põhjustanud viimase aasta jooksul liiklusõnnetusi ja on alla 30 aasta vana, siis ei lisandu rendi ööpäevahinnale midagi.
--sisendite kombinatsioon: vanus >30, liiklusonnetusiPohjustanud=false, […]
--oodatav väljund: hind XXX EUR
4. Kui isik ei ole põhjustanud viimase aasta jooksul liiklusõnnetusi ja on vähemalt 30 aasta vana, siis ei lisandu rendi ööpäevahinnale midagi.
--sisendite kombinatsioon: vanus =<30, liiklusonnetusiPohjustanud=false, […]
--oodatav väljund: hind XXX EUR

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<meta charset="UTF-8">

<html>
<head>
    <title>INepal</title>
    <link rel="stylesheet" type="text/css" href="../../resources/crud.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>

<div id="header">
    <div class="menu">
        <a href="/#intro">INTRODUCERE</a>
        <a href="/#first">DETALII</a>
        <a href="/#second">APLICATII</a>
        <a href="/#voluntar">FII VOLUNTAR!</a>
        <a href="/#third">FINAL</a>
    </div>
</div>

<div id="main-app">

    <div align="center">
        <section id="intro">
            <div class="article-intro">

                <h2>Modifica tabelele</h2>
                <div id="view" style="background: transparent;"><a href="/updateChart">UPDATE CHART</a></div>
                <div id="view" style="background: transparent;"><a href="/updateGraph">UPDATE GRAPH</a></div>

                <table>
                    <tr>
                        <td><h3> Population </h3>
                            <p> <h4> Datele despre fiecare municipiu in parte sunt in acest tabel,
                                cu date despre populatie: numar de oameni, gospodarii si densitatea populatiei</h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewPopulation">GO TO</a>
                                <a href="/updateTables">UPDATE</a>
                            </div>
                        </td>

                        <td><h3> Clusters </h3>
                            <p> <h4> Acest tabel contine grupurile de organizatii guvernamentale si
                                non-guvernamentale care au ajutat dupa dezastrul din Nepal</h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewCluster">GO TO</a>
                            </div>
                        </td>

                        <td><h3> Damages </h3>
                            <p> <h4> Aici sunt datele cu numarul de victime si cladiri daunate dupa,
                                fiecare impartite pe districte </h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewDamage">GO TO</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><h3> Districts </h3>
                            <p> <h4> Tabela cu toate districtele cu numele si ID-urile </h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewDistrict">GO TO</a>
                            </div>
                        </td>
                        <td><h3> Earthquakes </h3>
                            <p> <h4> Toate zonele afectate de cutremure, cu data, ora si gravitatea acestuia </h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewEarthquake">GO TO</a>
                            </div>
                        </td>
                        <td><h3> Municipalities </h3>
                            <p> <h4> Aici sunt toate municipalitatile (parte a unui district)</h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewMunicipality">GO TO</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><h3> Organisations </h3>
                            <p> <h4> Toate organizatiile guvernamentale si non-guvernamentale sunt aici, fiecare
                                cu acronimul sau si ID-ul Clusterului din care face parte</h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewOrganisation">GO TO</a>
                            </div>
                        </td>
                        <td><h3> Projects </h3>
                            <p> <h4> Toate proiectele care au avut loc/au loc si zonele, plus cate persoane au ajutat
                                si cu ce</h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewProject">GO TO</a>
                            </div>
                        </td>
                        <td><h3> Villages </h3>
                            <p> <h4> O asezare este o parte a unui municipiu, mai multe asezari formand un municipiu</h4> </p>
                            <div id="view" style="background: transparent;">
                                <a href="/viewVillage">GO TO</a>
                            </div>
                        </td>
                    </tr>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>


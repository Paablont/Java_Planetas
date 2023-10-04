<h1>Java_AccDatosProyecto</h1>

Clases: Planeta, Satelite, Asteroides?

<b>Archivos: </b>

<li>
  <ul>Planetas.txt: Guardará los ids y nombres de los planetas</ul>
  <ul>PlanetasInfo.dat: Guardará en binario las propiedades de un planeta (radio,distanciaSolar,gravedad,tieneVida)</ul>
  <ul>Satelites.dat: Guardará en binario la información de un satélite de cada planeta RELACIONADO por su id con ese planeta (idPlaneta,nombreSatelite,densidad,anioDescubrimiento)</ul>
</li>

Miguel y Ramon se encargan de lectura y escritura de ficheros binarios y XML <br>
Pablo y Jose se encargan de lectura y escritura de ficheros de texto y de acceso aleatorio

TAMAÑO DE LOS REGISTROS

<li>
  <ul>Long: 8 bytes</ul>
  <ul>Integer: 4 bytes</ul>
  <ul>Short: 2 bytes</ul>
  <ul>Byte: 1 byte</ul>
  <ul>Double: 8 bytes</ul>
  <ul>Float: 4 bytes</ul>
  <ul>Boolean: 1 byte</ul>
  <ul>Char: 2 bytes</ul>
  <ul>String: 2 bytes por cada caracter.</ul>

</li>

Podemos crear 2 clases: Una que tenga los datos(Planeta) y otro que indiique que puedes hacer con ese dato (PlanetaCRUD)
Planeta(id,nombre...)
PlanetaCRUD (static guardar(Planeta),static recuperarTodos() List<Planeta>, static agregarPlaneta(Planeta), static buscarPlaneta(Planeta id)). En realidad cada JFrame es una clase y los botones nos pueden servir de acciones










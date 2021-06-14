package src.Sistema;

import java.util.*;

import src.Cliente.*;
import src.Pelicula.*;
import src.Prestamo.*;

public class Sistema {

    private Cliente[] clientes;
    private Pelicula[] peliculas;
    private Prestamo[] prestamos;
    private String[] categoriaPelicula;
    private int contador [];
    Scanner scanner = new Scanner(System.in);


    public Sistema(){
        clientes = new Cliente[0];
        peliculas = new Pelicula[0];
        prestamos = new Prestamo[0];
        llenarCategorias();
        llenarPeliculas();
        llenarClientes();
    }

    public void mostrarMenu(){
        System.out.println("");
        boolean salir = true;
        int opcion = 0;
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("Bienvenido a “Memorabilia”");
            System.out.println("Seleccione la accion que desea hacer: ");
            System.out.println("1. Prestamo de peliculas");
            System.out.println("2. Devolucion de peliculas");
            System.out.println("3. Mostrar peliculas");
            System.out.println("4. Ingreso de Peliculas");
            System.out.println("5. Ordenar Peliculas (Ascendente)");
            System.out.println("6. Ingresar nuevo Cliente");
            System.out.println("7. Mostrar Clientes");
            System.out.println("8. Reportes");
            System.out.println("9. Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    prestarPelicula();
                    break;
                case 2:
                    devolverPelicula();
                    break;
                case 3:
                    mostrarPelicula();
                    break;
                case 4:
                    ingresarPelicula();
                    break;
                case 5:
                    ordenarPeliculas();
                    break;
                case 6:
                    ingresarCliente();
                    break;
                case 7:
                    mostrarClientes();
                    break;
                case 8:
                    mostrarMenuReportes();
                    break;
                case 9:
                    System.out.println("Gracias por usar nuestro servicios");
                    salir = false;
                    break;
                default:
                    System.out.println("Error opcion incorrecta");
                    break;
            }

        } while (salir);
        
    }

    public void mostrarMenuReportes(){
        boolean salir = true;
        int opcion = 0;
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("Reportes");
            System.out.println("Ingrese el reporte que desea generar");
            System.out.println("1. Peliculas por categoria");
            System.out.println("2. Pelicula por Categoria en especifico");
            System.out.println("3. Películas y la numero de veces prestada");
            System.out.println("4. Pelicula mas prestada");
            System.out.println("5. Pelicula menos prestada");
            System.out.println("6. Regresar al menu principal");
        opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    crarReporte1();
                    break;
                case 2:
                    crarReporte2();
                    break;
                case 3:
                    crarReporte3();
                    break;
                case 4:
                    crarReporte4();
                    break;
                case 5:
                    crarReporte5();
                    break;
                case 6:
                    System.out.println("Regresando al menu principal");
                    salir = false;
                    break;
                default:
                    System.out.println("Error opcion incorrecta");
                    break;
            }

        } while (salir);
    }

    public void prestarPelicula(){
        int idCliente;
        int idPelicula;
        int diasPrestamo;
        int indicePelicula;
        System.out.println("-----------------------------------------------");
        System.out.println("Prestamo de peliculas");
        System.out.println("Ingrese el id del cliente");
        idCliente = scanner.nextInt();
        if(!validarIdRepetidoCliente(idCliente)){
            System.out.println("Cliente incexistente, Ingrese el cliente en el munu anterior opcion 6");
        } else if (!validarDisponibilidadCliente(idCliente)) {
            System.out.println("El cliente no puede prestar mas de 1 pelicula");
            System.out.println("Devuelva la pelicula en el menu anterior opcion 2");
        } else {
            Cliente auxCliente = buscarClientePorId(idCliente);
            mostrarPeliculaDisponibles();
            System.out.println("Cliente: " + auxCliente.getNombre());
            System.out.println("Ingrese el numero de pelicula que desea rentar");
            indicePelicula = scanner.nextInt();
            System.out.println("Ingrese cuantos dias va alquilar la pelicula: " + peliculas[indicePelicula-1].getNombre());
            diasPrestamo = scanner.nextInt();
            peliculas[indicePelicula - 1].cambiarEstado();
            auxCliente.cambiarEstado();
            System.out.println(auxCliente.getNombre() + " Ha alquilado la pelicula " + peliculas[indicePelicula - 1].getNombre() +
                                " , ID: " + peliculas[indicePelicula - 1].getId());
            System.out.println("por, "+ diasPrestamo + " dias, Con Exito");

            Prestamo auxPrestamo = new Prestamo(peliculas[indicePelicula-1].getId(), idCliente, diasPrestamo);
            agregarPrestamo(auxPrestamo);
        }

    }

    public boolean validarDisponibilidadCliente(int idCliente){
        for (int i = 0;i < clientes.length ; i++ ) {
            if (clientes[i].getId()==idCliente) {
                return clientes[i].getTienePrestado();
            }
        }
        return false;
    }

    public Cliente buscarClientePorId(int idCliente){
        for (int i = 0;i < clientes.length ; i++ ) {
            if (clientes[i].getId()==idCliente) {
                return clientes[i];
            }
        }
        return null;
    }

    public void mostrarPeliculaDisponibles(){
        if (peliculas.length==0) {
            System.out.println("No hay peliculas que mostrar");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println("Las peliculas disponibles en Memorabilia son:");
            System.out.println("ID--Nombre--Anio--Categoria--Disponibilidad");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            for (int i = 0;i<peliculas.length ;i++ ) {
                if (peliculas[i].getDisponible()) {
                    System.out.println( (i+1) + ". " + peliculas[i].mostrarDatos());               
                }
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void agregarPrestamo (Prestamo prestamo){
        Prestamo aux [] = new Prestamo[prestamos.length + 1];
        for (int i = 0; i < prestamos.length ; i++ ) {
            aux[i] = prestamos[i];
        }
        aux[prestamos.length] = prestamo;
        prestamos = aux;
    }

    
    public void devolverPelicula(){
        int indiceCliente;
        int idPelicula;
        int indicePelicula;
        System.out.println("-----------------------------------------------");
        System.out.println("Devolucion de pelicula");
        if (validarExistenciaDePrestamosEnCurso()) {
             mostrarClientesConLibros();
            System.out.println("-----------------------------------------------");
            System.out.println("Ingrese el indice del cliente que devolvera la pelicula " + "");
            indiceCliente = scanner.nextInt();
            idPelicula = buscarIDPeliculaPrestada(clientes[indiceCliente -1 ].getId());
            indicePelicula = buscarIndicePelicula(idPelicula);
            clientes[indiceCliente -1].cambiarEstado();
            peliculas[indicePelicula].cambiarEstado();
        } else {
            System.out.println("No existen prestamos en curso");
        }
       
    }
    public boolean validarExistenciaDePrestamosEnCurso(){
        for (int i = 0; i < clientes.length ; i++) {
            if (!clientes[i].getTienePrestado()) {
                return true;   
            }
        }
        return false;
    }

    public int buscarIDPeliculaPrestada(int idCliente){
        for (int i = prestamos.length - 1; i >= 0 ; i-- ) {
            if (prestamos[i].getIdCliente()==idCliente) {
                return prestamos[i].getIdPelicula();
            }
        }
        return 0;
    }
    public int buscarIndicePelicula(int idPelicula){
        for (int i = 0; i < peliculas.length ; i++ ) {
            if (idPelicula == peliculas[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarClientesConLibros(){
        if (clientes.length == 0) {
            System.out.println("No hay clientes que mostrar");
            
        }else {
            System.out.println("Listado de Clientes");
            System.out.println("-----------------------------------------------");
            System.out.println("Las Clientes pendiente de devolucion son:");
            System.out.println("Nombre--ID--Telefono--Disponivilidad Para prestar");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            for (int i = 0; i < clientes.length ; i++ ) {
                if (!clientes[i].getTienePrestado()) {
                    System.out.println( ( i + 1 ) + ". " + clientes[i].mostrarDatos());
                }
            }

        }
        
    }

    public void mostrarPelicula(){
        if (peliculas.length==0) {
            System.out.println("No hay peliculas que mostrar");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println("Las peliculas de Memorabilia son:");
            System.out.println("ID--Nombre--Anio--Categoria--Disponibilidad");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            for (int i = 0;i<peliculas.length ;i++ ) {
                System.out.println( (i+1) + ". " + peliculas[i].mostrarDatos());
            }
        }
    }

    public void ingresarPelicula(){
        int idPelicula = -1;
        String nombrePelicula;
        int anioPelicula;
        String categoriaPelicula;
        //disponibilidad = true;

        System.out.println("Ingreso de una nueva pelicula");
        System.out.println("--------------------------------");
        do {
            System.out.println("Ingrese el Id de la pelicula");
            idPelicula = scanner.nextInt();
            if (validarIdRepetidoPeliculas(idPelicula)) {
                System.out.println("Ya existe una pelicula con ese Id (" + idPelicula+")");
                System.out.println("Cambie de id");
            }
        } while (validarIdRepetidoPeliculas(idPelicula));
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la pelicula");
        nombrePelicula = scanner.nextLine();
        System.out.println("Ingrese el anio de la pelicula");
        anioPelicula = scanner.nextInt();
        categoriaPelicula = seleccionarCategoriaPelicula();
        agregarPelicula(new Pelicula(idPelicula,nombrePelicula,anioPelicula,categoriaPelicula,true));
        System.out.println("Pelicula Agregada con exito");
    }

    public boolean validarIdRepetidoPeliculas(int idPelicula){
        for (int i = 0;i < peliculas.length ; i++ ) {
            if (peliculas[i].getId()==idPelicula) {
                return true;
            }
        }
        return false;
    }

    public String seleccionarCategoriaPelicula(){
        boolean salir = true;
        int opcion = 0;
        String categoria = "";
        do {
            System.out.println("Seleccione la categoria de la pelicula");
            for (int i = 0; i < categoriaPelicula.length ; i++ ) {
                System.out.println((i+1) + ". " + categoriaPelicula[i]);
            }

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= categoriaPelicula.length) {
                categoria = categoriaPelicula[opcion-1];
                salir = false;
            } else {
                System.out.println("Opcion incorrecta");
            }
        } while (salir);
        return categoria;
    }

    public void agregarPelicula (Pelicula pelicula){
        Pelicula aux [] = new Pelicula[peliculas.length + 1];
        for (int i = 0; i < peliculas.length ; i++ ) {
            aux[i] = peliculas[i];
        }
        aux[peliculas.length] = pelicula;
        peliculas = aux;
    }

    public void ordenarPeliculas(){
        if (peliculas.length == 0 || peliculas.length == 1) {
            System.out.println("No hay suficientes peliculas para ordenar");
        }else {
            System.out.println("Ordenar peliculas");
            System.out.println("......................................");
            for (int i = 1; i < peliculas.length; i++ ) {
                for (int j = 0; j< peliculas.length-i;j++ ) {
                    if (peliculas[j].getNombre().compareTo(peliculas[j+1].getNombre()) > 0) {
                        Pelicula aux = peliculas[j];
                        peliculas[j] = peliculas[j + 1];
                        peliculas[j+1] = aux;
                    }
                }
            }
            System.out.println("Las peliculas han sido ordenadas de manera Ascendente");
        }
        
    }

    public void ingresarCliente(){
        String nombreCliente;
        int idCliente;
        int telefonoCliente;
        scanner.nextLine();
        System.out.println("Ingreso de un nuevo Cliente");
        System.out.println("--------------------------------");
        System.out.println("Ingrese el nombre del cliente:");
        nombreCliente = scanner.nextLine();
        do {
            System.out.println("Ingrese el Id del cliente");
            idCliente = scanner.nextInt();
            if (validarIdRepetidoCliente(idCliente)) {
                System.out.println("Ya existe un cliente con ese Id (" + idCliente+")");
                System.out.println("Cambie de id");
            }
        } while (validarIdRepetidoCliente(idCliente));
        System.out.println("Ingrese el telefono del cliente:");
        telefonoCliente = scanner.nextInt();
        agregarCliente ( new Cliente(nombreCliente,idCliente,telefonoCliente,true));
    }

    public boolean validarIdRepetidoCliente(int idCliente){
        for (int i = 0;i < clientes.length ; i++ ) {
            if (clientes[i].getId()==idCliente) {
                return true;
            }
        }
        return false;
    }

    public void agregarCliente (Cliente cliente){
        Cliente aux [] = new Cliente[clientes.length + 1];
        for (int i = 0; i < clientes.length ; i++ ) {
            aux[i] = clientes[i];
        }
        aux[clientes.length] = cliente;
        clientes = aux;
    }

    public void mostrarClientes(){
        if (clientes.length == 0) {
            System.out.println("No hay clientes que mostrar");
            
        }else {
            System.out.println("Listado de Clientes");
            System.out.println("-----------------------------------------------");
            System.out.println("Las Clientes de Memorabilia son:");
            System.out.println("Nombre--ID--Telefono--Disponivilidad Para prestar");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            for (int i = 0; i < clientes.length ; i++ ) {
                System.out.println( ( i + 1 ) + ". " + clientes[i].mostrarDatos());
            }
        }
        
    }

    public void mostrarPrestamos(){
        if (prestamos.length == 0) {
            System.out.println("No hay prestamos que mostrar");
            
        }else {
            System.out.println("Listado de Prestamos");
            System.out.println("-----------------------------------------------");
            System.out.println("Los Prestamos de Memorabilia son:");
            System.out.println("IDPeli--IDCliente--Dias");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            for (int i = 0; i < prestamos.length ; i++ ) {
                System.out.println( ( i + 1 ) + ". " + prestamos[i].mostrarDatos());
            }
        }
        
    }

    public void crarReporte1(){
        System.out.println("Peliculas por categoria");
        for (int i = 0; i < categoriaPelicula.length ; i++ ) {
            System.out.println("Hay " + peliculasPorCategoria(categoriaPelicula[i]) + " peliculas de " + categoriaPelicula[i]);

        }
    }

    public int peliculasPorCategoria(String categoria){
        int contador = 0;
        for (int i = 0; i < peliculas.length ; i++ ) {
            if (peliculas[i].getCategoria().equalsIgnoreCase(categoria)) {
                contador++;
            }
        }
        return contador;
    }

    public void crarReporte2(){
        System.out.println("-----------------------------------------------");
        System.out.println("Peliculas de categoria en especifico");
        String categoria = seleccionarCategoriaPelicula();
        int contador = 1;
        System.out.println("ID--Nombre--Anio--Categoria--Disponibilidad");
        for (int i = 0; i < peliculas.length ; i++ ) {
            if (categoria.equalsIgnoreCase(peliculas[i].getCategoria())) {
                System.out.println(contador + ". " + peliculas[i].mostrarDatos());
                contador++;
            }
        }
    }

    public void crarReporte3(){
        System.out.println("-----------------------------------------------");
        if (prestamos.length==0) {
            System.out.println("No hay prestamos, ninguna pelicula ha sido prestada");
        } else {
            System.out.println("Peliculas y veces prestada");
            contarPrestamosDePeliculas();
            System.out.println("Nombre Pelicula--No. veces prestada");
            for (int i = 0; i < peliculas.length ; i++) {
                System.out.println(( i + 1 )+ ". " + peliculas[i].getNombre() + "--" + contador[i]);
            }
        }
        System.out.println("-----------------------------------------------");
    }

    public void contarPrestamosDePeliculas(){
        contador = new int [peliculas.length];
        for (int i = 0; i < prestamos.length ; i++ ) {
            contador[buscarIndicePelicula(prestamos[i].getIdPelicula())]++;
        }
    }

    public void crarReporte4(){
        if (prestamos.length == 0) {
            System.out.println("No hay prestamos, ninguna pelicula ha sido prestada");
        } else {
            contarPrestamosDePeliculas();
            int indicePeliculaMasPrestada = buscarNumeroMayor(contador);
            System.out.println("Pelicula mas prestada es: ");
            System.out.println(peliculas[indicePeliculaMasPrestada].getNombre() + ", con " 
                + contador[indicePeliculaMasPrestada] + " veces prestada");     
        }
        

    }

    public int buscarNumeroMayor(int arreglo[]){
        int indice = 0;
        int numeroMayor = arreglo[0];
        for (int i = 0; i < arreglo.length ; i++) {
            if (numeroMayor < arreglo[i]) {
                numeroMayor = arreglo[i];
                indice = i;
            }
        }
        return indice;
    }

    public void crarReporte5(){
        if (prestamos.length == 0) {
            System.out.println("No hay prestamos, ninguna pelicula ha sido prestada");
        } else {
            contarPrestamosDePeliculas();
            if(buscarCeros()) {
                System.out.println("Las peliculas menos prestadas son: ");
                for (int i = 0; i < contador.length ; i++ ) {
                    if (contador[i] == 0) {
                        System.out.println(peliculas[i].getNombre() + ", con " 
                    + contador[i] + " veces prestada");
                    }
                }
            } else {
            int indicePeliculaMasPrestada = buscarNumeroMenor(contador);
            System.out.println("Pelicula menos prestada es: ");
            System.out.println(peliculas[indicePeliculaMasPrestada].getNombre() + ", con " 
                + contador[indicePeliculaMasPrestada] + " veces prestada");
            }
        }
    }

    public boolean buscarCeros(){
        int count = 0;
        for (int i = 0; i < contador.length ;i++ ) {
            if (contador[i]==0) {
                count++;
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
    public int buscarNumeroMenor(int arreglo[]){
        int indice = 0;
        int numeroMenor = arreglo[0];
        for (int i = 0; i < arreglo.length ; i++) {
            if (numeroMenor > arreglo[i]) {
                numeroMenor = arreglo[i];
                indice = i;
            }
        }
        return indice;
    }

    public void llenarPeliculas(){
        peliculas = new Pelicula[30];
        peliculas[0] = new Pelicula(7018,"La red social", 2010, "Drama", true);
        peliculas[1] = new Pelicula(5439,"Toy Story 3", 2010, "Infantil", true);
        peliculas[2] = new Pelicula(3998,"Ejército de los muertos",2021, "Accion", true);
        peliculas[3] = new Pelicula(1909,"Shrek",2001,"Infantil", true);
        peliculas[4] = new Pelicula(1840,"Brawl in the cell block 99",2017, "Accion", true);
        peliculas[5] = new Pelicula(7279,"El club de la lucha", 1999, "Drama", true);
        peliculas[6] = new Pelicula(5361,"Zoolander", 2001, "Comedia", true);
        peliculas[7] = new Pelicula(6671,"Objetivo: La Casa Blanca",2013, "Accion", true);
        peliculas[8] = new Pelicula(4493,"Dragon Ball Super: Broly",2019,"Infantil", true);
        peliculas[9] = new Pelicula(1984,"Como Dios", 2003, "Comedia", true);
        peliculas[10] = new Pelicula(8950,"El padrino", 1972, "Drama", true);
        peliculas[11] = new Pelicula(1234,"Birdman", 2014, "Comedia", true);
        peliculas[12] = new Pelicula(5356,"Titanic",1997, "Romance", true);
        peliculas[13] = new Pelicula(2369,"Pacific Rim",2013, "Accion", true);
        peliculas[14] = new Pelicula(1048,"Sonic. La película",2020,"Infantil", true);
        peliculas[15] = new Pelicula(6670,"Love Story", 1970, "Romance", true);
        peliculas[16] = new Pelicula(2648,"El pianista", 2002, "Drama", true);
        peliculas[17] = new Pelicula(6218,"La vida es bella", 1997, "Drama", true);
        peliculas[18] = new Pelicula(5739,"Coco",2017,"Infantil", true);
        peliculas[19] = new Pelicula(9731,"Terminator 2: El juicio final",1991, "Accion", true);
        peliculas[20] = new Pelicula(1398,"El viaje de Chihiro",2002,"Infantil", true);
        peliculas[21] = new Pelicula(9874,"500 dias con ella",2009, "Romance", true);
        peliculas[22] = new Pelicula(3764,"Crash", 2005, "Drama", true);
        peliculas[23] = new Pelicula(1364,"Olvídate de mí", 2004 , "Romance", true);
        peliculas[24] = new Pelicula(2985,"Lucy", 2014, "Accion", true);
        peliculas[25] = new Pelicula(8669,"Playtime",1967, "Comedia", true);
        peliculas[26] = new Pelicula(8651,"American History X", 1998,"Drama", true);
        peliculas[27] = new Pelicula(5363,"La princesa prometida", 1987, "Comedia", true);
        peliculas[28] = new Pelicula(7163,"Solo en casa", 1990, "Comedia", true);
        peliculas[29] = new Pelicula(5156,"La familia Addams",2019,"Infantil", true);
    }

    public void llenarClientes(){
        clientes = new Cliente[30];
        clientes[0] = new Cliente("Mateo",44,3080299,true);
        clientes[1] = new Cliente("Adriana",93,4582106,true);
        clientes[2] = new Cliente("Carolina",89,7313802,true);
        clientes[3] = new Cliente("Alejandro",92,7226760,true);
        clientes[4] = new Cliente("Alexander",39,7243001,true);
        clientes[5] = new Cliente("Felipe",77,1926295,true);
        clientes[6] = new Cliente("Marcela",11,8766157,true);
        clientes[7] = new Cliente("Carol",34,7605706,true);
        clientes[8] = new Cliente("Liliana",22,7605706,true);
        clientes[9] = new Cliente("Catalina",59,1667315,true);
        clientes[10] = new Cliente("Angel",68,1135125,true);
        clientes[11] = new Cliente("Maria",75,8280562,true);
        clientes[12] = new Cliente("Claudia",17,8123562,true);
        clientes[13] = new Cliente("Daniel",61,5647895,true);
        clientes[14] = new Cliente("Cristina",71,1590685,true);
        clientes[15] = new Cliente("Andres",57,5162419,true);
        clientes[16] = new Cliente("Daniela",26,2525466,true);
        clientes[17] = new Cliente("Diana",90,5218788,true);
        clientes[18] = new Cliente("Carlos",81,6213725,true);
        clientes[19] = new Cliente("Gabriel",94,6743273,true);
        clientes[20] = new Cliente("Gloria",73,3626053,true);
        clientes[21] = new Cliente("Hugo",43,8013543,true);
        clientes[22] = new Cliente("Ingrid",45,1089049,true);
        clientes[23] = new Cliente("Jenny",38,5162341,true);
        clientes[24] = new Cliente("Ivan",70,9406264,true);
        clientes[25] = new Cliente("Mario",14,3193882,true);
        clientes[26] = new Cliente("Esteban",82,8642650,true);
        clientes[27] = new Cliente("Rocio",35,9305623,true);
        clientes[28] = new Cliente("July",42,2189894,true);
        clientes[29] = new Cliente("Oliver",15,67458756,true);
    }

    public void llenarCategorias(){
        categoriaPelicula = new String[5];
        categoriaPelicula[0] = "Drama";
        categoriaPelicula[1] = "Infantil";
        categoriaPelicula[2] = "Accion";
        categoriaPelicula[3] = "Comedia";
        categoriaPelicula[4] = "Romance";
    }

}

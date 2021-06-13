package src.Sistema;

import java.util.*;

import src.Cliente.*;
import src.Pelicula.*;
import src.Prestamo.*;

public class Sistema {

    private Cliente[] clientes;
    private Pelicula[] peliculas;
    private Prestamo[] prestamos;

    public Sistema(){
        llenarPeliculas();
        llenarClientes();      
    }

    public void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("Prestamo de peliculas");
    }
    
    public void devolverPelicula(){
        System.out.println("Devolucion de pelicula");
    }

    public void mostrarPelicula(){
        System.out.println("-----------------------------------------------");
        System.out.println("Las peliculas de Memorabilia son:");
        System.out.println("ID--Nombre--Anio--Categoria--Disponibilidad");
        System.out.println("-----------------------------------------------");
        System.out.println(" ");
        for (int i = 0;i<peliculas.length ;i++ ) {
            System.out.println( (i+1) + ". " + peliculas[i].mostrarDatos());
        }
    }

    public void ingresarPelicula(){
        System.out.println("Ingreso de una nueva pelicula");
    }

    public void ordenarPeliculas(){
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

    public void ingresarCliente(){
        System.out.println("Ingresar Cliente");
    }

    public void mostrarClientes(){
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

    public void crarReporte1(){
        System.out.println("Peliculas por categoria");
    }

    public void crarReporte2(){
        System.out.println("Peliculas de categoria en especifico");
    }

    public void crarReporte3(){
        System.out.println("Peliculas y veces prestada");
    }

    public void crarReporte4(){
        System.out.println("Pelicula mas prestada");
    }

    public void crarReporte5(){
        System.out.println("Pelicula menos prestada");
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

}

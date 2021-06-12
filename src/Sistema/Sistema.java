package src.Sistema;

import java.util.*;

public class Sistema {

    public Sistema(){
        
    }

    public void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        boolean salir = true;
        int opcion = 0;
        do {
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
        System.out.println("Mostar peliculas");
    }

    public void ingresarPelicula(){
        System.out.println("Ingreso de una nueva pelicula");
    }

    public void ordenarPeliculas(){
        System.out.println("Ordenar peliculas");
    }

    public void ingresarCliente(){
        System.out.println("Ingresar Cliente");
    }

    public void mostrarClientes(){
        System.out.println("Listado de Clientes");
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

}

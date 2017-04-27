package cat.torralbo.biblioteca;

import java.util.Scanner;

/**
 * Creat per davidtorralbo el 25/4/17.
 */
public class Menu {

    public static Usuari user = new Usuari();
    public static Llibres llibres = new Llibres();
    public static Editorial editorial = new Editorial();
    public static Autor autor = new Autor();
    public static Tema tema = new Tema();

    public static Scanner sc = new Scanner(System.in);

    /*
        Inicialitza el programa creant objectes predeterminats
     */

    public void inicialitzaPrograma() {
        user.creaAdministrador();
        editorial.creaEditorial();
        tema.creaTema();
        autor.creaAutor();
        llibres.crearLlibre();
    }

    /*
        Inicia el menú d'usuaris i des d'on es podràn consultar els llibres.
     */
    public void iniciaMenuUsuari(){

        int seleccio = 0;

        System.out.println("\nMENÚ USUARI\n-------------------\n");
        System.out.println("(1) Consultar Llibres\n\n(2) Tanca la sessió\n");

        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            iniciaMenuUsuari();
        }

        switch(seleccio){
            case 1:
                llibres.consultar();
                break;
            case 2:
                System.out.println("Fins aviat!");
                Principal principal = new Principal();
                principal.iniciaSessio();
                break;
            default:
                System.out.println("Seleccioni una opció del menú\n");
                //Utilitzem recursivitat per a tornar a mostrar el menú
                iniciaMenuUsuari();
                break;
        }

        //Utilitzem recursivitat per a tornar a mostrar el menú un cop acabada la tasca
        iniciaMenuUsuari();

    }

    /*
        Inicia el menú d'administrador i des d'on cridarà tots els submenús als quals pot entrar un administrador.
     */
    public void iniciaMenuAdmin(){

        int seleccio = 0;

        System.out.println("\nMENÚ ADMINISTRADOR\n-------------------\n");
        System.out.println("(1) Usuaris\n(2) Llibres\n(3) Editorials\n(4) Autors\n(5) Temes\n\n(6) Tanca la sessió\n");

        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            iniciaMenuAdmin();
        }

        switch(seleccio){
            case 1:
                gestiousuaris();
                break;
            case 2:
                gestiollibres();
                break;
            case 3:
                gestioEditorials();
                break;
            case 4:
                gestioAutors();
                break;
            case 5:
                gestioTemes();
                break;
            case 6:
                System.out.println("Fins aviat!");
                Principal principal = new Principal();
                principal.iniciaSessio();
                break;
            default:
                System.out.println("Seleccioni una opció del menú\n");
                //Utilitzem recursivitat per a tornar a mostrar el menú
                iniciaMenuAdmin();
                break;
        }

    }

    /*
        Submenú per a gestionar els usuaris.
     */
    public void gestiousuaris(){
        Principal principal = new Principal();

        int seleccio = 0;

        System.out.println("\nMenú d'usuaris");
        System.out.println("(1) Crear\n(2) Modificar\n(3) Eliminar\n(4) Consultar\n(5) Tornar enrere\n");


        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            gestiousuaris();
        }

        switch(seleccio){
            case 1:
                user.crear();
                break;
            case 2:
                user.modificar();
                break;
            case 3:
                user.eliminar();
                break;
            case 4:
                user.consultar();
                break;
            case 5:
                iniciaMenuAdmin();
                break;

            default:
                System.out.println("Seleccioni una opció del menú\n");
                gestiousuaris();
                break;
        }

        //Utilitzem recursivitat per a tornar a mostrar el menú un cop acabada la tasca
        gestiousuaris();


    }

    /*
        Submenú per a gestionar els llibres.
     */
    public void gestiollibres(){

        int seleccio = 0;

        System.out.println("\nMenú de llibres");
        System.out.println("(1) Crear\n(2) Modificar\n(3) Eliminar\n(4) Consultar\n(5) Tornar enrere\n");


        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            gestiollibres();
        }

        switch(seleccio){
            case 1:
                llibres.crear();
                break;
            case 2:
                llibres.modificar();
                break;
            case 3:
                llibres.eliminar();
                break;
            case 4:
                llibres.consultar();
                break;
            case 5:
                iniciaMenuAdmin();
                break;

            default:
                System.out.println("Seleccioni una opció del menú\n");
                //Utilitzem recursivitat per a tornar a mostrar el menú
                gestiollibres();
                break;
        }

        //Utilitzem recursivitat per a tornar a mostrar el menú un cop acabada la tasca
         gestiollibres();


    }

    /*
        Submenú per a gestionar les editorials.
     */
    public void gestioEditorials(){

        int seleccio = 0;

        System.out.println("\nMenú d'editorials");
        System.out.println("(1) Crear\n(2) Modificar\n(3) Eliminar\n(4) Consultar\n(5) Tornar enrere\n");

        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            gestioEditorials();
        }

        switch(seleccio){
            case 1:
                editorial.crear();
                break;
            case 2:
                editorial.modificar();
                break;
            case 3:
                editorial.eliminar();
                break;
            case 4:
                editorial.consultar();
                break;
            case 5:
                iniciaMenuAdmin();
                break;

            default:
                System.out.println("Seleccioni una opció del menú\n");
                //Utilitzem recursivitat per a tornar a mostrar el menú
                gestioEditorials();
                break;
        }

        //Utilitzem recursivitat per a tornar a mostrar el menú un cop acabada la tasca
        gestioEditorials();


    }

    /*
        Submenú per a gestionar els autors.
     */
    public void gestioAutors(){

        int seleccio = 0;

        System.out.println("\nMenú d'autors");
        System.out.println("(1) Crear\n(2) Modificar\n(3) Eliminar\n(4) Consultar\n(5) Tornar enrere\n");

        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            gestioAutors();
        }

        switch(seleccio){
            case 1:
                autor.crear();
                break;
            case 2:
                autor.modificar();
                break;
            case 3:
                autor.eliminar();
                break;
            case 4:
                autor.consultar();
                break;
            case 5:
                iniciaMenuAdmin();
                break;

            default:
                System.out.println("Seleccioni una opció del menú\n");
                //Utilitzem recursivitat per a tornar a mostrar el menú
                gestioAutors();
                break;
        }

        //Utilitzem recursivitat per a tornar a mostrar el menú un cop acabada la tasca
        gestioAutors();


    }

    /*
        Submenú per a gestionar els temes.
     */
    public void gestioTemes(){

        int seleccio = 0;

        System.out.println("\nMenú de temes");
        System.out.println("(1) Crear\n(2) Modificar\n(3) Eliminar\n(4) Consultar\n(5) Tornar enrere\n");

        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Ha succeït un error a l'hora de processar la seva opció");
            //Utilitzem recursivitat per a tornar a mostrar el menú
            gestioTemes();
        }

        switch(seleccio){
            case 1:
                tema.crear();
                break;
            case 2:
                tema.modificar();
                break;
            case 3:
                tema.eliminar();
                break;
            case 4:
                tema.consultar();
                break;
            case 5:
                iniciaMenuAdmin();
                break;

            default:
                System.out.println("Seleccioni una opció del menú\n");
                //Utilitzem recursivitat per a tornar a mostrar el menú
                gestioTemes();
                break;
        }

        //Utilitzem recursivitat per a tornar a mostrar el menú un cop acabada la tasca
        gestioTemes();


    }

}
package cat.torralbo.biblioteca;

import java.util.Scanner;

/**
 * Creat per davidtorralbo el 5/4/17.
 */
public class Principal {

    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        iniciaSessio();
    }


    /*
        Amb aquest mètode iniciarem sessió al sistema de la biblioteca.
     */
    public static void iniciaSessio(){

        Menu menu = new Menu();

        menu.inicialitzaPrograma();

        String nomUsuari = null, contrasenya = null;
        boolean segueix;

        System.out.println("Benvinguts a la Biblioteca!\n------------------------");

        do {
            try {
                //Ingressem el nom d'usuari
                do {
                    try {
                        System.out.print("\nINICI DE SESSIÓ\n------------------------\nEntri el nom d'usuari: ");
                        nomUsuari = sc.nextLine();
                        segueix = false;
                    } catch (Exception e) {
                        System.out.print("Hi ha hagut un problema.\n");
                        segueix = true;
                    }
                } while (segueix);

                //Ingressem la contrassenya
                do {
                    try {
                        System.out.print("Entri la contrasenya: ");
                        contrasenya = sc.nextLine();
                        segueix = false;
                    } catch (Exception e) {
                        System.out.print("Hi ha hagut un problema.\n");
                        segueix = true;
                    }
                } while (segueix);

                //Comprovem l'usuari i la contrasenya
                if (menu.user.comprovarUsuari(nomUsuari, contrasenya)[0]) {
                    //Redirigim al menú d'usuari o d'administrador depenent de la categoria
                    redirigeixmenu(menu.user.comprovarUsuari(nomUsuari, contrasenya)[1]);
                } else {
                    throw new Exception();
                }
            }catch (Exception e){
                segueix = true;
                System.out.println("\nNo s'han trobat resultats amb aquestes credencials.");
            }
        }while(segueix);
    }

    /*
        Redireccions de menú depenent de si l'usuari és administrador(true) o no(false)
     */
    public static void redirigeixmenu(boolean categoria){

        if(categoria){
            Menu menuAdmin = new Menu();
            menuAdmin.iniciaMenuAdmin();
        } else {
            Menu menuUser = new Menu();
            menuUser.iniciaMenuUsuari();
        }

    }



}

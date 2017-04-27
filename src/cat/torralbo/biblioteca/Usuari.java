package cat.torralbo.biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Max on 30/03/2017.
 */
public class Usuari {

    public ArrayList<Usuari> use = new ArrayList<Usuari>();

    Scanner sc = new Scanner(System.in);

    private int id;
    private String nom;
    private String usuari;
    private String contrasenya;
    private int categoria;
    private String adreça;
    private String telefon;
    private java.util.Date dataVinculacio;
    private boolean segueix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getDataVinculacio() {
        return dataVinculacio;
    }

    public void setDataVinculacio(Date dataVinculacio) {
        this.dataVinculacio = dataVinculacio;
    }

    public void creaAdministrador(){
        //Comprovem que no hi hagi usuaris
        if(use.size() == 0) {
            Usuari usuari = new Usuari();
            Date data = new Date();

            usuari.setId(1);
            usuari.setNom("Administrador");
            usuari.setUsuari("admin");
            usuari.setContrasenya("admin");
            usuari.setCategoria(1);
            usuari.setAdreça("Adreça predeterminada");
            usuari.setTelefon("666666666");
            usuari.setDataVinculacio(data);
            use.add(usuari);
        }
    }

    public void crear() {

        //creació objecte
        Usuari usuari = new Usuari();
        Date data = new Date();
        String alias = null;
        int categoria = 0;

        //id automatica segons la posicio en l'array list
        usuari.setId(use.size() + 1);

        do {
            try {
                System.out.print("Entra el teu nom: ");
                usuari.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra el teu àlias: ");
                alias = sc.nextLine();

                //si l'àlias entrat ja existeix, registrem una excepció
                if(existeixAlias(alias)){
                    throw new Exception();
                } else {
                    usuari.setUsuari(alias);
                    segueix = false;
                }
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        System.out.print("Entra la contrasenya: ");
        usuari.setContrasenya(sc.nextLine());

        do {
            try {
                System.out.print("Teclegi (1) si l'usuari és Administrador. (0) si no ho és: ");
                categoria = Integer.parseInt(sc.nextLine());

                if(categoria == 0 || categoria == 1) {
                    usuari.setCategoria(categoria);
                    segueix = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra direcció: ");
                usuari.setAdreça(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);


        do {
            try {
                System.out.print("Entre el teu telèfon: ");
                usuari.setTelefon(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        usuari.setDataVinculacio(data);

        use.add(usuari);


    }

    public void modificar() {
        //creació objecte
        Usuari usuari = new Usuari();
        String nomModificar = null;
        String alias = null;
        int categoria = 0;


        //Comprovem que existeixi l'usuari
        do {
            try {
                System.out.print("Quin és el nom d'usuari que vols modificar?: ");
                nomModificar = sc.nextLine();

                if(!existeixUsuari(nomModificar)){
                    throw new Exception();
                }

                segueix = false;
            } catch (Exception e) {
                System.out.print("Aquest usuari no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default:
                        System.out.println();
                        Menu menu = new Menu();
                        menu.gestiousuaris(); break;
                }
            }
        } while (segueix);


            int idModificar = 0;
            for (Usuari objecte : use) {

                if (nomModificar.equals(objecte.getNom())) {
                    idModificar = objecte.getId();
                    usuari.setDataVinculacio(objecte.getDataVinculacio());

                }

            }

            usuari.setId(idModificar);

        do {
            try {
                System.out.print("Entra el teu nom: ");
                usuari.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra el teu àlias: ");
                alias = sc.nextLine();

                //si l'àlias entrat ja existeix, registrem una excepció
                if(existeixAlias(alias) && nombreUsuaris(alias) != 1){
                    throw new Exception();
                } else {
                    usuari.setUsuari(alias);
                    segueix = false;
                }
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        System.out.print("Entra la contrasenya: ");
        usuari.setContrasenya(sc.nextLine());

        do {
            try {
                System.out.print("Teclegi (1) si l'usuari és Administrador. (0) si no ho és: ");
                categoria = Integer.parseInt(sc.nextLine());

                if(categoria == 0 || categoria == 1) {
                    usuari.setCategoria(categoria);
                    segueix = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra direcció: ");
                usuari.setAdreça(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);


        do {
            try {
                System.out.print("Entre el teu telèfon: ");
                usuari.setTelefon(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);


            //modifiquem l'objecte amb la id anterior
            use.set(idModificar - 1, usuari);

    }

    public void eliminar() {
        //creació objecte
        Usuari usuari = new Usuari();
        String nomEliminar = null;

        //Comprovem que existeixi l'usuari
        do {
            try {
                System.out.println("Quin és el nom de l'usuari que vols eliminar? ");
                nomEliminar = sc.nextLine();

                if(!existeixUsuari(nomEliminar)){
                    throw new Exception();
                }

                segueix = false;
            } catch (Exception e) {
                System.out.print("Aquest usuari no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }
        } while (segueix);

        int indexEliminar = 0;
        for (Usuari objecte : use) {

            if(nomEliminar.equals(objecte.getNom())){

                indexEliminar = (objecte.getId()-1);
            }

        }

        //eliminem el llibre de la posicio de l'array que s'ha establert anteriorment
        use.remove(indexEliminar);

    }

    public void consultar() {
        String nomConsultar = null;

        //Comprovem que existeixi l'usuari
        do {
            try {
                System.out.print("Quin usuari vols consultar?: ");
                nomConsultar = sc.nextLine();

                if(!existeixUsuari(nomConsultar)){
                    throw new Exception();
                }

                segueix = false;
            } catch (Exception e) {
                System.out.print("Aquest usuari no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }

            }
        } while (segueix);



        for (Usuari objecte : use) {

            if(nomConsultar.equals(objecte.getNom())){
                System.out.println("\nLa id de l'usuari és: "+ objecte.getId());
                System.out.println("El nom de l'usuari és: "+ objecte.getNom());
                System.out.println("L'àlies de l'usuari és: "+ objecte.getUsuari());

                //contrasenya oculta
                System.out.print("La contrasenya de l'usuari és: ");
                    for (int i = 0; i<objecte.getContrasenya().length(); i++) {
                         System.out.print("*");
                    }
                System.out.println();

                System.out.println("La categoria és "+ objecte.getCategoria());
                System.out.println("L'adreça és: "+ objecte.getAdreça());
                System.out.println("El telèfon de l'usuari és: "+ objecte.getTelefon());
                System.out.println("La data de vinculació és: "+ objecte.getDataVinculacio());
            }

        }
    }

    /*
        Comprova si existeix un usuari al iniciar sessió, i si existeix, també comprova la categoria.
     */

    public boolean[] comprovarUsuari(String usuari, String contrasenya) {

        boolean existeix = false, categoria = false;

        for (Usuari objecte : use) {

            //Comprovem que l'usuari i la contrasenya que s'han entrat en el login estiguin dins l'ArrayList.
            if(objecte.getUsuari().equals(usuari) && objecte.getContrasenya().equals(contrasenya)){
                existeix = true;

                //Si l'usuari té categoria 0, serà false, si té categoria 1, serà true.
                if(objecte.getCategoria() == 1){
                    categoria = true;
                } else {
                    categoria = false;
                }
            }


        }

        return new boolean[] {existeix, categoria};
    }

    /*
        Comprova si existeix un nom d'usuari
     */

    public boolean existeixUsuari(String nom){

        boolean existeix = false;

        //recorre tots els usuaris
        for (Usuari objecte : use) {
            if(nom.equals(objecte.getNom())){
                existeix = true;
            }

        }

        return existeix;
    }

    /*
        Comprova si existeix un àlias d'usuari
     */

    public boolean existeixAlias(String alias){

        boolean existeix = false;

        //recorre tots els usuaris
        for (Usuari objecte : use) {
            if(alias.equals(objecte.getUsuari())){
                existeix = true;
            }

        }

        return existeix;
    }

    /*
        Calcula el nombre d'usuaris amb el mateix àlias
     */
    public int nombreUsuaris(String alias){
        int nombreUsuaris = 0;

        //recorre tots els usuaris
        for (Usuari objecte : use) {
            if(alias.equals(objecte.getUsuari())){
                nombreUsuaris += 1;
            }

        }

        return nombreUsuaris;
    }



}

package cat.torralbo.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creat per davidtorralbo on 30/3/17.
 */
public class Editorial {

    ArrayList<Editorial> use = new ArrayList<Editorial>();
    Scanner sc = new Scanner(System.in);

    private Integer id;
    private String nom;
    private String adreca;
    private String telefon;
    private boolean segueix;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void creaEditorial(){
        //Comprovem que no hi hagi editorials i en creem una per defecte.
        if(use.size() == 0) {
            Editorial editorial = new Editorial();

            editorial.setId(1);
            editorial.setNom("Barballum");
            editorial.setAdreca("info@barballum.cat");
            editorial.setTelefon("123456789");

            use.add(editorial);
        }
    }

    public void crear(){

        Editorial editorial = new Editorial();

        //Afegim l'id agafant l'última posició de l'arraylist i li sumem 1 (per a evitar que el primer tingui id 0)
        editorial.setId(use.size()+1);

        do {
            try {
                System.out.print("Ingressi un nom: ");
                editorial.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Ingressi una direcció: ");
                editorial.setAdreca(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Ingressi un número de telèfon: ");
                editorial.setTelefon(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //afegim l'objecte
        use.add(editorial);
    }

    public void modificar(){

        Editorial editorial = new Editorial();
        String nomModificar = null;

        //farem servir aquest arraylist per a fer una llista d'objectes amb nom duplicat.
        ArrayList<Editorial> modificarTemporal = new ArrayList<Editorial>();

        //comprovem que existeixi l'editorial
        do{
            try{
                System.out.print("Quin és el nom de l'editorial que vols modificar?: ");
                nomModificar = sc.nextLine();

                if(!existeixeditorial(nomModificar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest editorial no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default:
                        System.out.println();
                        Menu menu = new Menu();
                        menu.gestioEditorials(); break;
                }
            }

        }while (segueix);


        int idModificar = 0;
        int nombreObjectes = 0;
        int nombreObjectesTemporals = 0;

        //Recorrem l'arraylist fins a trobar un objecte amb el nom que busquem
        for (Editorial objecte : use) {


            nombreObjectes += 1;

            if(nomModificar.equals(objecte.getNom())){
                modificarTemporal.add(objecte);
            }


            if(nomModificar.equals(objecte.getNom()) && nombreObjectes == 1){
                idModificar = objecte.getId();
            } else if(nomModificar.equals(objecte.getNom()) && nombreObjectes != 1 && nombreObjectes > 0) {
                System.out.println("Hi han hagut varis resultats. Seleccioni l'ID que més li escaigui");


                for (Editorial objecteTemporal : modificarTemporal) {

                        nombreObjectesTemporals += 1;

                        System.out.println("\nResultat "+nombreObjectesTemporals);
                        System.out.println("La id de la editorial és: "+ objecteTemporal.getId());
                        System.out.println("El nom de la editorial és: "+ objecteTemporal.getNom());
                        System.out.println("L'adreça de la editorial és: "+ objecteTemporal.getAdreca());
                        System.out.println("El telèfon de la editorial és: "+ objecteTemporal.getTelefon());

                }

                System.out.print("\nEntri l'ID corresponent a l'editorial a modificar: ");
                idModificar = Integer.parseInt(sc.nextLine());

            }

        }

        editorial.setId(idModificar);
        //buidem l'arraylist temporal
        modificarTemporal.clear();

        do {
            try {
                System.out.print("Ingressi un nom: ");
                editorial.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Ingressi una direcció: ");
                editorial.setAdreca(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Ingressi un número de telèfon: ");
                editorial.setTelefon(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //afegim l'objecte a la mateixa posició
        use.set(idModificar-1, editorial);
    }

    public void eliminar() {
        String nomEliminar = null;
        //farem servir aquest arraylist per a fer una llista d'objectes amb nom duplicat.
        ArrayList<Editorial> eliminarTemporal = new ArrayList<Editorial>();


        //comprovem que existeixi l'editorial
        do{
            try{
                System.out.print("Quina editorial vols eliminar?: ");
                nomEliminar = sc.nextLine();

                if(!existeixeditorial(nomEliminar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest editorial no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }

        }while (segueix);

        int idEliminar = 0;
        int nombreObjectes = 0;
        int nombreObjectesTemporals = 0;

        //Recorrem l'arraylist fins a trobar un objecte amb el nom que busquem
        for (Editorial objecte : use) {


            nombreObjectes += 1;

            if(nomEliminar.equals(objecte.getNom())){
                eliminarTemporal.add(objecte);
            }


            if(nomEliminar.equals(objecte.getNom()) && nombreObjectes == 1){
                idEliminar = objecte.getId();
            } else if(nomEliminar.equals(objecte.getNom()) && nombreObjectes != 1 && nombreObjectes > 0) {
                System.out.println("Hi han hagut varis resultats. Seleccioni l'ID que més li escaigui");


                for (Editorial objecteTemporal : eliminarTemporal) {

                    nombreObjectesTemporals += 1;

                    System.out.println("\nResultat "+nombreObjectesTemporals);
                    System.out.println("La id de la editorial és: "+ objecteTemporal.getId());
                    System.out.println("El nom de la editorial és: "+ objecteTemporal.getNom());
                    System.out.println("L'adreça de la editorial és: "+ objecteTemporal.getAdreca());
                    System.out.println("El telèfon de la editorial és: "+ objecteTemporal.getTelefon());

                }

                System.out.print("\nEntri l'ID corresponent a l'editorial a eliminar: ");
                idEliminar = Integer.parseInt(sc.nextLine());

            }

        }

        use.remove(idEliminar-1);
        //buidem l'arraylist temporal
        eliminarTemporal.clear();

    }

    public void consultar() {

        String nomConsultar = null;

        //comprovem que existeixi l'editorial
        do{
            try{
                System.out.print("Quina editorial vols consultar?: ");
                nomConsultar = sc.nextLine();

                if(!existeixeditorial(nomConsultar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest editorial no existeix.");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }

        }while (segueix);

        for (Editorial objecte : use) {

            if(nomConsultar.equals(objecte.getNom())){
                System.out.println("\nLa id de la editorial és: "+ objecte.getId());
                System.out.println("El nom de la editorial és: "+ objecte.getNom());
                System.out.println("L'adreça de la editorial és: "+ objecte.getAdreca());
                System.out.println("El telèfon de la editorial és: "+ objecte.getTelefon());
            }

        }

    }

    /*
        Comprovem si existeix l'editorial
     */
    public boolean existeixeditorial(String nom){

        boolean existeix = false;

        //recorre tots els editorials fins que coincideix el nom
        for (Editorial objecte : use){
            if(nom.equals(objecte.getNom())){
                existeix = true;
            }
        }
        return existeix;
    }

    /*
        Comprovem el nom de l'editorial a partir de l'id
     */
    public String nomPerId(int id){

        String nom = null;

        for (Editorial objecte : use) {

            if(id == objecte.getId()){
                nom = objecte.getNom();
            }

        }

        return nom;
    }

}
package cat.torralbo.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creat per davidtorralbo el 30/3/17.
 */

public class Autor {
    ArrayList<Autor> use = new ArrayList<Autor>();
    Scanner sc = new Scanner(System.in);

    private Integer id;
    private String nom;
    private String nacionalitat;
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

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public void creaAutor(){
        //Comprovem que no hi hagi autors i en creem un per defecte.
        if(use.size() == 0) {
            Autor autor = new Autor();


            autor.setId(1);
            autor.setNom("Joan Coll Teixidor");
            autor.setNacionalitat("Catalana");

            use.add(autor);
        }
    }

    public void crear() {
        Autor autor = new Autor();

        //Afegim l'id agafant l'última posició de l'arraylist i li sumem 1 (per a evitar que el primer tingui id 0)
        autor.setId(use.size()+1);

        do {
            try {
                System.out.print("Ingressi un nom: ");
                autor.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Ingressi una nacionalitat:");
                autor.setNacionalitat(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //afegim l'objecte
        use.add(autor);
    }

    public void modificar() {
        Autor autor = new Autor();
        String nomModificar = null;

        //comprovem que existeixi l'autor
        do{
            try{
                System.out.print("Quin és el nom de l'autor a modificar?: ");
                nomModificar = sc.nextLine();

                if(!existeixAutor(nomModificar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest Autor no existeix.");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default:
                        System.out.println();
                        Menu menu = new Menu();
                        menu.gestioAutors(); break;
                }
            }

        }while (segueix);

        int idModificar = 0;

        //Recorrem l'arraylist fins a trobar un objecte amb el nom que busquem
        for (Autor objecte : use) {

            if(nomModificar.equals(objecte.getNom())){
                idModificar = objecte.getId();
            }

        }

        autor.setId(idModificar);

        do {
            try {
                System.out.print("Ingressi un nom:");
                autor.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Ingressi una nacionalitat:");
                autor.setNacionalitat(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //afegim l'objecte a la mateixa posició
        use.set(idModificar-1, autor);
    }

    public void eliminar() {
        Autor autor = new Autor();
        String nomEliminar = null;

        //comprovem que existeixi l'autor
        do{
            try{

                System.out.print("Quin autor vols eliminar?: ");
                 nomEliminar = sc.nextLine();

                if(!existeixAutor(nomEliminar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest autor no existeix.");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }

        }while (segueix);

        int indexEliminar = 0;
        for (Autor objecte : use) {

            if(nomEliminar.equals(objecte.getNom())){

                indexEliminar = (objecte.getId()-1);
            }

        }

        use.remove(indexEliminar);
    }

    public void consultar() {
        Autor autor = new Autor();

        String nomConsultar = null;

        //comprovem que existeixi l'autor
        do{
            try{
                System.out.print("Quin autor vols consultar?: ");
                nomConsultar = sc.nextLine();


                if(!existeixAutor(nomConsultar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest autor no existeix.");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }

        }while (segueix);


        for (Autor objecte : use) {

            if(nomConsultar.equals(objecte.getNom())){
                System.out.println("La id de l'autor és: "+ objecte.getId());
                System.out.println("El nom de l'autor és: "+ objecte.getNom());
                System.out.println("L'adreça de l'autor és: "+ objecte.getNacionalitat());
            }

        }
    }

    /*
       Comprovem si existeix l'autor
    */
    public boolean existeixAutor(String nom){

        boolean existeix = false;

        //recorre tots els autors fins que coincideix el nom
        for (Autor objecte : use){
            if(nom.equals(objecte.getNom())){
                existeix = true;
            }
        }
        return existeix;
    }

    /*
        Comprovem el nom del tema a partir de l'id
     */
    public String nomPerId(int id){

        String nom = null;

        for (Autor objecte : use) {

            if(id == objecte.getId()){
                nom = objecte.getNom();
            }

        }

        return nom;
    }
}

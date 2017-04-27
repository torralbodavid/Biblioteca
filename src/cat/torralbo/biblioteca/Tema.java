package cat.torralbo.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creat per davidtorralbo el 30/3/17.
 */

public class Tema {
    ArrayList<Tema> use = new ArrayList<Tema>();
    Scanner sc = new Scanner(System.in);

    private Integer id;
    private String nom;
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

    public void creaTema(){
        //Comprovem que no hi hagi temes i en creem un per defecte.
        if(use.size() == 0) {
            Tema tema = new Tema();


            tema.setId(1);
            tema.setNom("Autoajuda i desenvolupament personal");

            use.add(tema);
        }
    }

    public void crear() {
        Tema tema = new Tema();

        //Afegim l'id agafant l'última posició de l'arraylist i li sumem 1 (per a evitar que el primer tingui id 0)
        tema.setId(use.size()+1);

        do {
            try {
                System.out.print("Ingressi un nom:");
                tema.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //afegim l'objecte
        use.add(tema);
    }

    public void modificar() {
        Tema tema = new Tema();
        String nomModificar = null;

        //comprovem que existeixi el tema
        do{
            try{
                System.out.print("Quin és el nom del Tema?: ");
                nomModificar = sc.nextLine();

                if(!existeixTema(nomModificar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest tema no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default:
                        System.out.println();
                        Menu menu = new Menu();
                        menu.gestioTemes(); break;
                }
            }

        }while (segueix);

        int idModificar = 0;

        //Recorrem l'arraylist fins a trobar un objecte amb el nom que busquem
        for (Tema objecte : use) {

            if(nomModificar.equals(objecte.getNom())){
                idModificar = objecte.getId();
            }

        }

        tema.setId(idModificar);

        do {
            try {
                System.out.print("Ingressi un nom:");
                tema.setNom(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //afegim l'objecte a la mateixa posició
        use.set(idModificar-1, tema);
    }

    public void eliminar() {
        String nomEliminar = null;

        //comprovem que existeixi el tema
        do{
            try{

                System.out.println("Quin tema vols eliminar? ");
                nomEliminar = sc.nextLine();

                if(!existeixTema(nomEliminar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest tema no existeix.\n");
                segueix = true;
            }

        }while (segueix);

        int indexEliminar = 0;
        for (Tema objecte : use) {

            if(nomEliminar.equals(objecte.getNom())){

                indexEliminar = objecte.getId()-1;
            }

        }

        use.remove(indexEliminar);
    }

    public void consultar() {
        String nomConsultar = null;

        //comprovem que existeixi el tema
        do{
            try{

                System.out.print("Quina tema vols consultar?: ");
                nomConsultar = sc.nextLine();

                if(!existeixTema(nomConsultar)){
                    throw  new Exception();
                }
                segueix = false;
            }catch (Exception e){
                System.out.println("Aquest tema no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }

        }while (segueix);


        for (Tema objecte : use) {

            if(nomConsultar.equals(objecte.getNom())){
                System.out.println("La id del tema és: "+ objecte.getId());
                System.out.println("El nom del tema és: "+ objecte.getNom());
            }

        }
    }

    /*
        Comprovem si existeix el tema
     */
    public boolean existeixTema(String nom){

        boolean existeix = false;

        //recorre tots els temes fins que coincideix el nom
        for (Tema objecte : use){
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

        for (Tema objecte : use) {

            if(id == objecte.getId()){
                nom = objecte.getNom();
            }

        }

        return nom;
    }

}